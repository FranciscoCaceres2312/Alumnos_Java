import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Alumno {

    public String nombre;
    public String dni;
    public int edad;

    public Alumno(String nombre, String dni, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                '}';
    }

    public String guardarAlumno() {
        String mensaje = "";
        try (
                Connection con = Conexion.getInstance()) {
            PreparedStatement pst = con.prepareStatement("INSERT INTO alumno VALUES(?,?,?)");
            pst.setString(1, nombre);
            pst.setString(2,dni);
            pst.setInt(3, edad);
            pst.executeUpdate();
            mensaje = " Alumno guardado con exito";
        }
        catch (SQLException e) {
            mensaje = e.toString();
        }
        return mensaje;
    }
    public static ArrayList<Alumno> getAllAlumnos(){
        ArrayList<Alumno> alum = new ArrayList<>();
        try (Connection con = Conexion.getInstance()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM alumno");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Alumno a = new Alumno(rs.getString("nombre"), rs.getString("dni"), rs.getInt("edad"));
                alum.add(a);
            }

        } catch (SQLException e) {
            System.out.println(" Error de SQLException");
            System.out.println(e);
        }

        return alum;
    }
}
