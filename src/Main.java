

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        int m;
        do {
            m = menu.menuPrincipal();
            if (m == 1) {
                String[] data = new String[3];
                data = menu.ingresarAlumno();
                Alumno alum = new Alumno(data[0], data[1], Integer.parseInt(data[2]));
                String mensaje = alum.guardarAlumno();
                System.out.println(mensaje);
            }
            if (m == 2) {
                menu.mostrarAlumnos(Alumno.getAllAlumnos());
            }
        }while(m != 3);
    }
}
