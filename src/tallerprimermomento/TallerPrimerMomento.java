package tallerprimermomento;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import jugadores.Jugadores;

public class TallerPrimerMomento {

    static ArrayList<Jugadores> jugadores = new ArrayList();
    static Scanner entrada = new Scanner(System.in);
    static String camisa;
    static String nombre;
    static String apellidos;
    static String posicion;
    static int edad;
    static String equipo;
    static int opcion;
    static int contador = 1;
    static int n;
    static Jugadores nuevo;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[42m";

    public static void main(String[] args) {

        generarMenu();
        agregarJugadores();
        buscarJugador();
        modificarJugador();
        mostrarTodosJugadores();

    }

    public static void generarMenu() {

        do {
            System.out.println(ANSI_BLACK_BACKGROUND + ANSI_GREEN + "    ++++++++++++++++++++++++++++++CLUB ATLETICO NACIONAL++++++++++++++++++++++++++++++");

            System.out.println("    *                                                                                         *");
            System.out.println(ANSI_BLUE + "    *    ---------------------------MENU REGISTRO FUTBOLISTAS------------------------------   *");

            System.out.println(ANSI_BLUE + "    *                                                                                                                                                                           *");
            System.out.println(ANSI_BLUE + "    *                                                                                                                                                                           *");
            System.out.println(ANSI_BLUE + "    *     1.AGREGAR JUGADOR.                                                                                                                                  *");
            System.out.println(ANSI_BLUE + "    *     2.BUSCAR JUGADOR.                                                                                                                                     *");
            System.out.println(ANSI_BLUE + "    *     3.EDITAR JUGADORES.                                                                                                                                  *");
            System.out.println(ANSI_BLUE + "    *     4.MOSTRAR TODOS LOS JUGADORES.                                                                                                          *");
            System.out.println(ANSI_BLUE + "    *     5.SALIR.                                                                                                                                                         *");
            System.out.println(ANSI_BLUE + "    *                                                                                                                                                                           *");
            System.out.print(ANSI_BLUE + "    *    --------------------------------DIGITE UNA OPCION: ->  ");
            System.out.println("");
            System.out.println(ANSI_BLUE + "    *                                                                                                                                                                            *");
            System.out.println(ANSI_GREEN + "    ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    agregarJugadores();
                    break;
                case 2:
                    buscarJugador();
                    break;
                case 3:
                    modificarJugador();
                    break;
                case 4:
                    mostrarTodosJugadores();
                    break;
                case 5:
                    System.out.println(jugadores.size());
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (opcion != 5);
    }

    public static void agregarJugadores() {
        do {
            System.out.println("Cuantos jugadores desea ingresar : ");
            n = entrada.nextInt();
        } while (n < 0);

        for (int i = 0; i < n; i++) {
            System.out.println("-----------------------------Registre el nuevo jugador: -------------------------");
            System.out.println("");
            System.out.print("Digite el numero de la camiseta: ");
            camisa = String.valueOf(validarNumero());

            int encontro = 1;

                for (int ii = 0; ii < jugadores.size(); ii++) {
                   
                    if (jugadores.get(ii).getCamisa().equals(camisa)) {
                        encontro = 0;
                        System.out.println("El numero de camisa  " + camisa + " ya esta en uso y pertenece al jugador :  " + jugadores.get(ii).getNombre() + "  " + jugadores.get(ii).getApellidos());
                        break;
                    }
                }  //Cierra ciclo for i

                if (encontro == 1) {
                        System.out.print("Nombre del jugador: ");
                        nombre = entrada.next();
                        System.out.print("Apellido del jugador: ");
                        apellidos = entrada.next();
                        System.out.print("Digite la edad: ");
                        edad = validarNumero();
                        System.out.print("Posicion en la que juega del jugador: ");
                        posicion = entrada.next();
                        System.out.print("Equipo del jugador: ");
                        equipo = entrada.next();
                    
                    nuevo = new Jugadores();
                    nuevo.setCamisa(camisa);
                    nuevo.setNombre(nombre);
                    nuevo.setApellidos(apellidos);
                    nuevo.setEdad(edad);
                    nuevo.setPosicion(posicion);
                    nuevo.setEquipo(equipo);

                    jugadores.add(nuevo);
                 }
                
                } // Cierra ciclo for ii
            }

    public static void buscarJugador() {

        System.out.print("Introduce el numero de la camiseta a buscar: ");
        camisa = entrada.next();

        int encontro = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCamisa().equalsIgnoreCase(camisa)) {
                encontro = 1;
                System.out.println("El numero de camisa  " + camisa + " Si se encuentra convocado y pertenece al jugador :  " + jugadores.get(i).getNombre() + "  " + jugadores.get(i).getApellidos());
                break;
            }
        }

        if (encontro == 0) {
            System.out.println("El numero de camiseta no existe");
        }
    }

    public static void mostrarTodosJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println(jugadores.get(i));
        }
    }

    public static void modificarJugador() {
        int tipo;
        int i;
        int indice = -1;
        int encontro = 0;
        System.out.print("Introduce el numero de la camiseta del jugador a editar: ");
        camisa = entrada.next();
        for (i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCamisa().equalsIgnoreCase(camisa)) {
                encontro = 1;
                indice = i;
                System.out.println("Nombre: " + jugadores.get(i).getNombre() + " Apellido: " + jugadores.get(i).getApellidos() + " Edad: " + jugadores.get(i).getEdad() + " Posicion:  " + jugadores.get(i).getPosicion() + " Equipo:  " + jugadores.get(i).getEquipo());
                System.out.println("Que dato desea modificar:  digite 1 para Nombre , 2 para Apellido, 3 para Edad, 4 para Equipo ,  5 para Posicion  o 0 para salir de la edicion:?");
                break;
            }
        }

        if (encontro == 0) {
            System.out.println("El numero de camiseta no existe");
        } else {
            while (encontro == 1) {

                tipo = entrada.nextInt();
                if (tipo == 0) {
                    encontro = 0;
                } else {

                    switch (tipo) {
                        case 1:
                            System.out.println("Digite el nombre: ");
                            jugadores.get(indice).setNombre(entrada.next());
                            System.out.println("Nombre: " + jugadores.get(indice).getNombre() + " Apellido: " + jugadores.get(indice).getApellidos() + " Edad: " + jugadores.get(indice).getEdad() + " Posicion:  " + jugadores.get(indice).getPosicion() + " Equipo:  " + jugadores.get(indice).getEquipo());
                            System.out.println("Que dato desea modificar:  digite 1 para Nombre , 2 para Apellido, 3 para Edad, 4 para Equipo ,  5 para Posicion  o 0 para salir de la edicion:?");
                            break;
                        case 2:
                            System.out.println("Digite el apellido: ");
                            jugadores.get(indice).setApellidos(entrada.next());
                            System.out.println("Nombre: " + jugadores.get(indice).getNombre() + " Apellido: " + jugadores.get(indice).getApellidos() + " Edad: " + jugadores.get(indice).getEdad() + " Posicion:  " + jugadores.get(indice).getPosicion() + " Equipo:  " + jugadores.get(indice).getEquipo());
                            System.out.println("Que dato desea modificar:  digite 1 para Nombre , 2 para Apellido, 3 para Edad, 4 para Equipo ,  5 para Posicion  o 0 para salir de la edicion:?");
                            break;
                        case 3:
                            System.out.println("Digite la edad: ");
                            jugadores.get(indice).setEdad(entrada.nextInt());
                            System.out.println("Nombre: " + jugadores.get(indice).getNombre() + " Apellido: " + jugadores.get(indice).getApellidos() + " Edad: " + jugadores.get(indice).getEdad() + " Posicion:  " + jugadores.get(indice).getPosicion() + " Equipo:  " + jugadores.get(indice).getEquipo());
                            break;
                        case 4:
                            System.out.println("Digite el equipo: ");
                            jugadores.get(indice).setEquipo(entrada.next());
                            System.out.println("Nombre: " + jugadores.get(indice).getNombre() + " Apellido: " + jugadores.get(indice).getApellidos() + " Edad: " + jugadores.get(indice).getEdad() + " Posicion:  " + jugadores.get(indice).getPosicion() + " Equipo:  " + jugadores.get(indice).getEquipo());
                            break;
                        case 5:
                            System.out.println("Digite la posici??n: ");
                            jugadores.get(indice).setPosicion(entrada.next());
                            System.out.println("Nombre: " + jugadores.get(indice).getNombre() + " Apellido: " + jugadores.get(indice).getApellidos() + " Edad: " + jugadores.get(indice).getEdad() + " Posicion:  " + jugadores.get(indice).getPosicion() + " Equipo:  " + jugadores.get(indice).getEquipo());
                            break;
                        case 0:
                            break;
                    }
                }
            }
        }
    }

    public static int validarNumero() {
        int dato = -1;
        do {
            //   System.out.print("Introduce un n??mero entero positivo: ");
            while (!entrada.hasNextInt()) {
                System.out.println("Valor no v??lido");
                entrada.next();
                System.out.print("Introduce un n??mero entero positivo: ");
            }

            dato = entrada.nextInt();
            if (dato <= 0) {
                System.out.println("El n??mero debe ser positivo");
            }
        } while (dato <= 0);

        return dato;
    }

    public static void validarCamisa() {
        int encontro = 0;
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getCamisa().equalsIgnoreCase(camisa)) {
                encontro = 1;
                System.out.println("El numero de camisa  " + camisa + " Si se encuentra convocado y pertenece al jugador :  " + jugadores.get(i).getNombre() + "  " + jugadores.get(i).getApellidos());
            }
        }

        if (encontro == 0) {
            System.out.println("El numero de camiseta no existe");
        }

    }
}
