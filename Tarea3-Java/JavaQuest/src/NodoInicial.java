import java.util.Scanner;

public class NodoInicial extends Nodo{
    /**
     * Constructor del nodo inicial
     * @Integer id: id del nodo inicial
     */
    public NodoInicial(Integer id) {
        super(id);
    }
    /**
     * Funcion donde el usuario interactúa con el nodo inicial
     * @Jugador usuario: usuario que interactúa
     */
    public void interactuar(Jugador usuario) {
        Scanner entrada = new Scanner (System.in);
        String continuar;
        String opcion1 = "1: Ver Lore";
        String opcion2 = "2: Llegar al jefe sin ver nada";
        System.out.println("************************************************************************");
        System.out.println("****************************                  **************************");
        System.out.println("****************************    EL DESTINO    **************************");
        System.out.println("****************************                  **************************");
        System.out.println("************************************************************************:\n");
        System.out.println("                   Presiona enter para empezar\n");

        entrada.nextLine();


        System.out.println("¿Quieres ver el lore del juego? ¿o prefieres ser la típica persona que llega al jefe final sin entender nada?\n");
        System.out.println(opcion1);
        System.out.println(opcion2);
        continuar = entrada.nextLine();
        if (continuar.equals("1")){
            System.out.println("********************************************************************************************************************");
            System.out.println("Lore de 'EL DESTINO': \n");
            System.out.println("En un futuro lejano, fuiste revivido por un alma de un ser antiguo,");
            System.out.println("esta alma sin nombre, te seguirá hasta la eternidad, y te da habilidades sobre humanas, entre ellas la inmortalidad.");
            System.out.println("********************************************************************************************************************\n");
            System.out.println("(Presiona enter para continuar)");

            entrada.nextLine();

            System.out.println("******************************************************************************************************************************************************");
            System.out.println("La razón de tu resurección es debido a que tienes las capacidades físicas para derrotar al enemigo más poderoso de la humanidad... o bueno, se supone.");
            System.out.println("******************************************************************************************************************************************************\n");
            System.out.println("(Presiona enter para continuar)");

            entrada.nextLine();

            System.out.println("*****************************************************************************************************************************************************************************************");
            System.out.println("Este enemigo es conocido como 'El testigo', un ser lleno de oscuridad y maldad que busca la muerte de todo ser, incluyendo los humanos.");
            System.out.println("Lamentablemente, las incontables guerras entre la humanidad han destrozado civilizaciones y datos/recuerdos de ellas, involucionando a la sociedad.");
            System.out.println("Esto llegó hasta un punto tan drástico que la humanidad regresó a una época similar a la medieval, negándoles la posibilidad de siquiera enfrentar a este ser, por eso te necesitan a tí.");
            System.out.println("*****************************************************************************************************************************************************************************************\n");
            System.out.println("(Presiona enter para continuar)");

            entrada.nextLine();

            System.out.println("***************************************************************************************************************************************************************");
            System.out.println("En tu camino a tu enfrentamiento, te podrías cruzar con enemigos, algunos no tan peligrosos, algunos poderosos, pero los peores son los Discípulos del Testigo,");
            System.out.println("espero que puedas cruzarte con una tienda, ya que con tus condiciones actuales es difícil que puedas hacerle daño al desgraciado.");
            System.out.println("Aún así creo que podrás derrotarlo, eres el más apto y el único, es por esto que matarlo es tú destino, y no cualquiera, es EL DESTINO.");
            System.out.println("***************************************************************************************************************************************************************\n");
            System.out.println("(Presiona enter para continuar)");

            entrada.nextLine();
        }
        else if (continuar.equals("2")){
            System.out.println("Como quieras, vamos con las instrucciones\n");
        }
        System.out.println("INSTRUCCIONES:");
        System.out.println("Si no te saltaste el tutorial, te habrás fijado que para leer el Lore de vez en cuando debías presionar enter.");
        System.out.println("Bueno, esta dinámica estará presente en todo el juego. Hay otra dinámica, la cual será responder con un número, el cual representa una opción,");
        System.out.println("esta la usaste en el inicio también, a la hora de decidir si deseabas leer o no leer el Lore. Bueno, disfruta el juego.\n");
        System.out.println("Ya sabes que hacer...");

        entrada.nextLine();

        
    }
}
