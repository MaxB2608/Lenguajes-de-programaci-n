import java.util.ArrayList;
import java.util.List;

public abstract class Nodo {
    private Integer id;
    private List<Nodo> siguientes_nodos = new ArrayList<>();

    /**
     * Constructor de Nodo
     * @Integer id: id del Nodo
     */
    public Nodo(Integer id) {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSiguientes_nodos(Nodo sig) {
        this.siguientes_nodos.add(sig);
    }

    public List<Nodo> getSiguientes_nodos() {
        return siguientes_nodos;
    }

    /**
     * Funcion que agrega nodos
     * @Nodo agregar: Nodo a agregar
     */
    public void agregarNodo(Nodo agregar){
        setSiguientes_nodos(agregar);
    }

    /**
     * Funcion interactuar abstracta utilizada en otros nodos
     * @Jugador usuario: usuario que va a interactuar en los nodos
     */
    public abstract void interactuar(Jugador usuario);
}
