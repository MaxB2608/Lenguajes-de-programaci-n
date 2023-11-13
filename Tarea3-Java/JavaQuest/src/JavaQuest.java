
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;





public class JavaQuest {
    public static void main(String[] args){
        Scanner entrada = new Scanner (System.in);
        String name;
        int profundidad;
        int respuesta;
        int x = 0;
        System.out.println("Hola, ¿cual es tu nombre? ");
        name = entrada.nextLine();
        List<Item> inventario = new ArrayList<>();
        Jugador usuario = new Jugador(name,500,20,20,5,1,inventario);

        System.out.println("'" + usuario.getNombre() + "', que lindo nombre" );
        System.out.println("Lamentablemente el juego estará terminado en 2023, así que esta será una versión demo. Disfruta");
        System.out.println("Bueno, para empezar el juego presiona enter :)");

        entrada.nextLine();


        System.out.println("Ahora, inserta la cantidad de nodos que quieras visitar, esto no incluye el inicial y el final, así que la cantidad de nodos totales es n + 2.");
        System.out.println("Sería preferible que escojas una cantidad muy por encima para poder visitar los 3 tipos de nodos, ya que las probabilidades son:");
        System.out.println("10%: Nodo tienda");
        System.out.println("30%: Nodo evento");
        System.out.println("60%: Nodo combate");
        System.out.println("Bueno, inserte su n° de nodos");
        profundidad = entrada.nextInt();
        NodoInicial inicio = new NodoInicial(0);


        NodoJefeFinal boss = new NodoJefeFinal((profundidad+5));

        //Mapa mapa = new Mapa (profundidad,inicio);

        inicio.interactuar(usuario);
        while (usuario.getHp_actual() > 0 && x < profundidad){
            Random azar = new Random();
            int k = azar.nextInt(1,101);
            if(k <= 60){
                NodoCombate pelea = new NodoCombate((x+1));
                pelea.interactuar(usuario);

                if (usuario.getHp_actual() > 0){
                    x++;
                }
                else{
                    x = profundidad;
                }

            }
            if(k >= 61 && k<= 90){
                NodoEvento evento = new NodoEvento(x+1);
                evento.interactuar(usuario);
                if (usuario.getHp_actual() > 0){
                    System.out.println("¿Deseas ver tu estado e Items actuales?\n");
                    System.out.println("1: Sí");
                    System.out.println("2: No\n");
                    respuesta = entrada.nextInt();
                    if (respuesta == 1){
                        usuario.verEstado();
                        System.out.println();
                        usuario.verItems();
                    }
                    else{
                        System.out.println("Como quieras");
                    }

                    x++;
                }
                else{
                    x = profundidad;
                }

            }
            if(k >= 91 && k<= 100){
                NodoTienda tienda = new NodoTienda(x+1);
                tienda.interactuar(usuario);
                if (usuario.getHp_actual() > 0){
                    System.out.println("¿Deseas ver tu estado e Items actuales?\n");
                    System.out.println("1: Sí");
                    System.out.println("2: No\n");
                    respuesta = entrada.nextInt();
                    if (respuesta == 1){
                        usuario.verEstado();
                        System.out.println();
                        usuario.verItems();
                    }
                    else{
                        System.out.println("Como quieras");
                    }

                    x++;
                }
                else{
                    x = profundidad;
                }

            }
        }
        boss.interactuar(usuario);
       
    }

}