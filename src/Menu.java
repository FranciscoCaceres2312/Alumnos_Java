import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public String[] ingresarAlumno(){
        Scanner scaner = new Scanner(System.in);
        String [] datos = new String[3];
        System.out.println(" Ingrese el nombre del Alumno");
        datos[0] = scaner.next();
        System.out.println(" Ingrese el dni del Alumno");
        datos[1] = scaner.next();
        System.out.println(" Ingrese la edad del alumno");
        datos[2] = scaner.next();
        return datos;
    }

    public int menuPrincipal(){
        Scanner scan = new Scanner(System.in);
        int result = 0;
        System.out.println(" 1- Agregar Alumno ");
        System.out.println(" 2- Mostrar Alumnos ");
        System.out.println(" 2- Terminar Programa ");
        result = Integer.parseInt(scan.next());
        return result;
    }
    public void mostrarAlumnos(ArrayList<Alumno> alumnos){
        for(int i = 0; i < alumnos.size(); i++){
            alumnos.get(i).toString();
        }
    }
}
