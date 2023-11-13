import java.util.Random;
import java.util.Scanner;

public class NodoEvento extends Nodo{
    private String descripcion;
    private String alternativa1;
    private String alternativa2;
    private Item resultado1;
    private Item resultado2;

    /**
     * Constructor del nodo evento
     * @Integer id: id del nodo evento
     */
    public NodoEvento(Integer id){
        super (id);
        this.descripcion = "Elegir la puerta";
        this.alternativa1 = "Puerta 1";
        this.alternativa2 = "Puerta 2";
        this.resultado1 = new Item("Beneficio", 0,5,0,2,1);
        this.resultado2 = new Item("Maleficio", 0,-3,0,-1,0);
    }



    /**
     * Funcion que retorna el n° de puerta correcto a cruzar
     * @return azar.nextInt(2): returna el número de la puerta correcta
     */

    public Integer Puerta_azar(){
        Random azar = new Random();
        return azar.nextInt(2);
    }
    /**
     * Funcion donde el usuario interactúa con el nodo evento
     * @Jugador usuario: usuario que interactúa
     */
    public void interactuar(Jugador usuario){
        Scanner entrada = new Scanner (System.in);
        String respuesta;


        System.out.println(usuario.getNombre() + ": Wow, que lugar tan peculiar.\n"+usuario.getNombre() +": ¿Y esas puertas?");
        entrada.nextLine();
        System.out.println("(aparece un hombre delgado y sucio, posiblemente un informático)\n\nVagabundo: Saludos, yo soy el Vagabundo, y te tengo una propuesta");
        entrada.nextLine();
        System.out.println(usuario.getNombre() + ": ¿Una propuesta? ¿De que tipo?");
        entrada.nextLine();
        System.out.println("Vagabundo: Bueno, realmente no es una propuesta jeje, es una obligación.\n           Si quieres avanzar, tendrás que... (sonidos de tambor): '"+descripcion+"', y cruzarla");
        entrada.nextLine();
        System.out.println(usuario.getNombre() + ": ¿Que gano con todo esto?");
        entrada.nextLine();
        System.out.println("Vagabundo: Bueno, si escojes la puerta correcta recibirás beneficios que te servirán para tu enfrentamiento contra El Testigo, pero el otro te da un maleficio.\n           Tienes que escoger sabiamente.");
        entrada.nextLine();
        System.out.println("Vagabundo: ¿Cual será? ¿1 o 2?\n");
        System.out.println("1: "+ alternativa1);
        System.out.println("2: "+ alternativa2);
        System.out.println("\n(Escribe '1' si quieres escoger la puerta 1 y escribe '2' si quieres escoger la puerta 2)");
        respuesta = entrada.nextLine();
        Integer compara = Integer.parseInt(respuesta) - 1;
        Integer compara2 = Puerta_azar();
        if (compara.equals(compara2)){
            System.out.println("Vagabundo: Eligiste sabiamente, como recompensa tu HP y Daño aumentarán 5 y 1 puntos respectivamente,");
            System.out.println("           obviamente si la diferencia entre tu HP total y el HP actual es menor a 5, sólo te sube hasta tu HP Total.");
            resultado1.aplicar(usuario);
            entrada.nextLine();
            System.out.println("Beneficio aplicado, ahora tu estado.\n");
            usuario.verEstado();
        }
        else {
            System.out.println("Vagabundo: Eligiste mal, como recompensa tu HP y Daño bajarán 3 y 1 puntos respectivamente, lo lamento.");
            System.out.println("           Espero que tu HP actual esté por encima de 3...");
            resultado2.aplicar(usuario);
            entrada.nextLine();
            if (usuario.getHp_actual() <= 0){
                System.out.println("*************************************    YOU DIED    *************************************");
            }
            else{
                System.out.println("Maleficio aplicado, ahora tu estado:\n");
                usuario.verEstado();
            }
        }
        
    }

}


