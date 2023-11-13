import java.util.ArrayList;
import java.util.List;




public class Jugador extends Personaje {
    //Lista con los items aplicados al jugador
    private ArrayList<Item> items_aplicados = new ArrayList<>();
    /**
     * Constructor de Jugador
     * @String nombre: nombre del jugador
     * @Integer dinero: cantidad de dinero que tiene el jugador
     * @Integer  hp_actual: HP actual del jugador
     * @Integer hp_total: HP total del jugador
     * @Integer danio: danio que es capaz de hacer el jugador
     * @Integer defensa: defensa que es capaz de hacer el jugadr
     * @List<Item> items_aplicados: lista con los items encontrados por el jugador en el juego
     */

    public Jugador(String nombre, Integer dinero, Integer hp_actual, Integer hp_total, Integer danio, Integer defensa, List<Item> items_aplicados){
        super(nombre,dinero,hp_actual,hp_total,danio,defensa);
    }

    public void setItems_aplicados(Item objeto) {
        this.items_aplicados.add(objeto);
    }

    /**
     * Función que muestra por pantalla el estado del usuario.
     *
     */

    public void verEstado(){
        System.out.println("Estado de " + getNombre() +":\n");
        System.out.println("Dinero: " + Jugador.super.getDinero());
        System.out.println("HP actual: " + Jugador.super.getHp_actual());
        System.out.println("HP total: " + Jugador.super.getHp_total());
        System.out.println("Daño actual: " + (Jugador.super.getDanio()));
        System.out.println("Defensa actual: " + Jugador.super.getDefensa());
    }

    /**
     * Función que muestra por pantalla los items del usuario
     *
     */

    public void verItems(){
        System.out.println("Items actuales:\n");
        if (items_aplicados.size() == 0){
            System.out.println("Todavía no has adquirido items");
        }
        else {
            for (int x=0; x < items_aplicados.size(); x++){
                System.out.println((x+1) +": " + items_aplicados.get(x).getNombre());
            }
        }
    }

}
