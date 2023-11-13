import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class NodoTienda extends Nodo {
    private ArrayList<Item> items_en_venta = new ArrayList<>();

    public void setItems_en_venta(ArrayList<Item> items_en_venta) {
        this.items_en_venta = items_en_venta;
    }

    public ArrayList<Item> getItems_en_venta() {
        return items_en_venta;
    }

    /**
     * Constructor del nodo tienda
     * @Integer id: id del nodo tienda
     */
    public NodoTienda(Integer id) {
        super(id);
    }

    /**
     * Funcion que al darle una lista, en ella se agregan items entre 5 y 8 al azar
     * @List<Item> items: lista de items que se alterará
     */
    public void elementos(List<Item> items) {
        Item recuperacion = new Item("Mini-kit de curación", 100, 5, 0, 0, 0);
        Item s_recuperacion = new Item("Kit completo de curación", 250, 10, 0, 0, 0);
        Item aumento = new Item("Aumento de energía vital", 75, 0, 10, 0, 0);
        Item s_aumento = new Item("Súper aumento de energía vital", 150, 0, 20, 0, 0);
        Item danio_plus = new Item("Arma legendaria", 150, 0, 0, 2, 0);
        Item s_danio_plus = new Item("Arma excepcional", 300, 0, 0, 5, 0);
        Item armadura = new Item("Armadura legendaria", 150, 0, 0, 0, 2);
        Item s_armadura = new Item("Armadura excepcional", 300, 0, 0, 0, 5);
        Item supremo = new Item("Poder Supremo", 500, 40, 20, 3, 8);

        Random azar = new Random();
        int entra1 = azar.nextInt(5, 9);

        int x = 0;
        while (x < entra1) {
            int entre2 = azar.nextInt(1, 10);
            switch (entre2) {
                case 1:
                    if (!items.contains(recuperacion)) {
                        items.add(recuperacion);
                        x++;
                    }
                    break;
                case 2:
                    if (!items.contains(s_recuperacion)) {
                        items.add(s_recuperacion);
                        x++;
                    }
                    break;
                case 3:
                    if (!items.contains(aumento)) {
                        items.add(aumento);
                        x++;
                    }
                    break;
                case 4:
                    if (!items.contains(s_aumento)) {
                        items.add(s_aumento);
                        x++;
                    }
                    break;
                case 5:
                    if (!items.contains(danio_plus)) {
                        items.add(danio_plus);
                        x++;
                    }
                    break;
                case 6:
                    if (!items.contains(s_danio_plus)) {
                        items.add(s_danio_plus);
                        x++;
                    }
                    break;
                case 7:
                    if (!items.contains(armadura)) {
                        items.add(armadura);
                        x++;
                    }
                    break;
                case 8:
                    if (!items.contains(s_armadura)) {
                        items.add(s_armadura);
                        x++;
                    }
                    break;
                case 9:
                    if (!items.contains(supremo)) {
                        items.add(supremo);
                        x++;
                    }
                    break;
            }
        }
    }

    /**
     * Funcion que le da al jugador el Item comprado
     * List<Item> lista: lista con los items disponibles para comprar
     * @Integer  pos: posicion en la lista de los items
     * @Jugador usuario: usuario al que se le agrega el item
     */
    public void comprar(List<Item> lista, int pos, Jugador usuario) {
        lista.get(pos - 1).aplicar(usuario);
    }

    /**
     * Funcion donde el usuario interactúa con el nodo tienda
     * @Jugador usuario: usuario que interactúa
     */
    public void interactuar(Jugador usuario) {
        Scanner entrada = new Scanner(System.in);
        int eleccion;
        elementos(items_en_venta);
        System.out.println(usuario.getNombre() + ": ¿Eso es... una tienda?");
        System.out.println("(se acerca a la caravana sospechosamente abandonada)\n");
        System.out.println("No olvides presionar enter para continuar");
        entrada.nextLine();
        System.out.println("Cayde: ¡SALUDOS!\n\n       Me llamo Cayde, y esta es mi tienda.\n       Acá podrás comprar el Item que tu quieras, bueno, el que puedas comprar jeje.");
        entrada.nextLine();

        System.out.println("Cayde: Te ofrezco lo siguiente:\n");
        for (int x = 0; x < items_en_venta.size(); x++) {
            System.out.println("ITEM " + (x + 1));
            System.out.println("Nombre: " + items_en_venta.get(x).getNombre());
            System.out.println("Precio: " + items_en_venta.get(x).getPrecio());
            System.out.println("Recuperación de HP actual: " + items_en_venta.get(x).getRecuperar_hp());
            System.out.println("Aumento de HP total: " + items_en_venta.get(x).getAumentar_hp_total());
            System.out.println("Aumento de daño: " + items_en_venta.get(x).getAumentar_danio());
            System.out.println("Aumento de defensa: " + items_en_venta.get(x).getAumentar_defensa());
            entrada.nextLine();
        }
        System.out.println("\nCayde: Bueno, ¿cual escoges?, recuerda: sólo puede ser 1 Item a la vez (escoje a través del número asignado).");
        System.out.println("       Si no quieres comprar nada presiona 0.");
        System.out.println("\nCayde: ADVERTENCIA, yo soy muy enojón y no me gusta que me tomen el pelo, así que más te vale elegir algo que te alcance, de lo contrario no te venderé nada más, al menos en este nodo jeje.");
        System.out.println("\nRECUERDA: Tu dinero actual es: " + usuario.getDinero() + "$");
        System.out.println("Elige");
        eleccion = entrada.nextInt();
        if (eleccion == 0) {
            System.out.println("Cayde: Bueno, adiós");
        } else {
            if (items_en_venta.get(eleccion - 1).getPrecio() > usuario.getDinero()) {
                System.out.println("Cayde: ¡TE DIJE QUE ODIO QUE ME TOMEN EL PELO!");
                System.out.println("       Buenas noches");
            } else {
                comprar(items_en_venta, eleccion, usuario);
                items_en_venta.remove(eleccion - 1);
                System.out.println("Cayde: Buena elección");
                System.out.println("Ahora tu estado e Items son:\n");
                usuario.verEstado();
                System.out.println();
                usuario.verItems();
                boolean seguir = true;
                while (seguir) {
                    System.out.println("\nCayde: ¿Deseas comprar más ítems?");
                    System.out.println("1: Sí");
                    System.out.println("2: No");
                    eleccion = entrada.nextInt();
                    if (eleccion == 2) {
                        System.out.println("Cayde: !Que tengas un buen día!");
                        seguir = false;
                    } else {
                        System.out.println("Lo que puedes comprar es: \n");
                        for (int k = 0; k < items_en_venta.size(); k++) {
                            System.out.println("ITEM " + (k + 1));
                            System.out.println("Nombre: " + items_en_venta.get(k).getNombre());
                            System.out.println("Precio: " + items_en_venta.get(k).getPrecio());
                            System.out.println("Recuperación de HP actual: " + items_en_venta.get(k).getRecuperar_hp());
                            System.out.println("Aumento de HP total: " + items_en_venta.get(k).getAumentar_hp_total());
                            System.out.println("Aumento de daño: " + items_en_venta.get(k).getAumentar_danio());
                            System.out.println("Aumento de defensa: " + items_en_venta.get(k).getAumentar_defensa());
                            entrada.nextLine();
                        }
                        System.out.println("Cayde: Indica el Item a comprar (el número).");
                        System.out.println("\nRECUERDA: Tu dinero actual es: " + usuario.getDinero() + "$");
                        eleccion = entrada.nextInt();
                        if (items_en_venta.get(eleccion - 1).getPrecio() > usuario.getDinero()) {
                            System.out.println("Cayde: ¡TE DIJE QUE ODIO QUE ME TOMEN EL PELO!");
                            System.out.println("       Buenas noches");
                            seguir = false;
                        } else {
                            comprar(items_en_venta, eleccion, usuario);
                            items_en_venta.remove(eleccion - 1);
                            System.out.println("Cayde: Buena elección");
                            System.out.println("Ahora tu estado e Items son:\n");
                            usuario.verEstado();
                            System.out.println();
                            usuario.verItems();
                        }
                    }
                }
            }
            
        }
    }
}