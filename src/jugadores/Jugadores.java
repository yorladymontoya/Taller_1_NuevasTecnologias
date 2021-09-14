
package jugadores;

public class Jugadores {
    
     //ATRIBUTO
 private String camisa;
 private  String nombre;
 private  String apellidos;
 private  String posicion;
   
 private int edad;

 private  String equipo;

  //Metodos=accion=funcion especial

    public String getCamisa() {
        return camisa;
    }

    public void setCamisa(String camisa) {
        
        if(camisa.isEmpty()){
            System.out.print("Debe ingresar un numero de camisa valido");
        }
 
            this.camisa = camisa;
    }

    public String getNombre() {
            
           return nombre; 
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
 
      
        return edad;
    }

    public void setEdad(int edad) {

 
        this.edad = edad;
        
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
 
  //constructor
    public Jugadores() {
    }
 
  @Override
    public String toString() {
        StringBuilder arregloJugadores = new StringBuilder();           
        arregloJugadores.append("\nCamisa: ");
        arregloJugadores.append(camisa + ",");
        arregloJugadores.append("\nNombre: ");
        arregloJugadores.append(nombre + ",");
        arregloJugadores.append("\nApellido: ");
        arregloJugadores.append(apellidos + ","); 
        arregloJugadores.append("\nEdad: ");
        arregloJugadores.append(edad  + ",");    
        arregloJugadores.append("\nPosicion: ");
        arregloJugadores.append(posicion + ","); 
        arregloJugadores.append("\nEquipo: ");
        arregloJugadores.append(equipo + ",");    
        
        return arregloJugadores.toString();
    }   
    
}
