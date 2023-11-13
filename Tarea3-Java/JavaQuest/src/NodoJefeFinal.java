import java.util.Scanner;

public class NodoJefeFinal extends Nodo {
    /**
     * Constructor del nodo jefe final
     * @Integer id: id del nodo tienda
     */
    public NodoJefeFinal(Integer id){
        super (id);
        this.jefe = new Personaje("El Testigo",1000000,30,30,7,4);

    }
    private Personaje jefe;

    /**
     * Funcion donde el usuario interactúa con el nodo jefe final
     * @Jugador usuario: usuario que interactúa
     */
    public void interactuar(Jugador usuario){
        System.out.println("El Testigo: Así que finalmente llegaste, pero no podrás derrotarme, ya no hay más piezas que mover del ajedrez.");
        System.out.println("Sufieciente muerte, suficiente vida");
        System.out.println("Aprecio tu esfuerzo, pero será en vano");
        Scanner entrada = new Scanner (System.in);
        entrada.nextLine();
        System.out.println(usuario.getNombre()+": Eso lo veremos");
        entrada.nextLine();
        System.out.println("El Testigo: Así me gusta");
        entrada.nextLine();
        usuario.combate(jefe);
        
    }
}
