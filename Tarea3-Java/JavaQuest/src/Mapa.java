import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;

public class Mapa {
    private Integer profundidad;
    private NodoInicial nodo_inicial;
    private Nodo nodo_actual;

    /**
     * Constructor de Mapa
     * @Integer profundidad: profundidad del mapa
     * @NodoInicial nodo_inicial: Nodo inicial del mapa
     */
    public Mapa(Integer profundidad, NodoInicial nodo_inicial) {
        this.profundidad = profundidad;
        this.nodo_inicial = nodo_inicial;

        SortedSet<Edge> edges = GraphGenerator.Generar(5);

        List<Nodo> all_nodo = new  ArrayList<Nodo>();

        int tamano = edges.last().y+1;

        all_nodo.add(nodo_inicial);

        for (int x = 1; x < tamano-1; x++){
            Random azar = new Random();
            int n = azar.nextInt(1, 101);
            if (n <= 30){
                NodoEvento evento = new NodoEvento(x);
                all_nodo.add(evento);
            }
            else if (n <= 90){
                NodoCombate pelea = new NodoCombate(x);
                all_nodo.add(pelea);
            }
            else{
                NodoTienda tienda = new NodoTienda(x);
                all_nodo.add(tienda);
            }
        }
        NodoJefeFinal boss = new NodoJefeFinal(tamano-1);
        all_nodo.add(boss);

        for (Edge e : edges) {
            Nodo nodo = all_nodo.get(e.x);
            nodo.agregarNodo(all_nodo.get(e.y));
        }
    }


    public Integer getProfundidad() {
        return profundidad;
    }

    public NodoInicial getNodo_inicial() {
        return nodo_inicial;
    }

    public Nodo getNodo_actual() {
        return nodo_actual;
    }

    public void setNodo_actual(Nodo nodo_actual) {
        this.nodo_actual = nodo_actual;
    }


    public void verMapa(){
        System.out.println("Mapa:");

    }

    public void avanzar(){


    }
}
