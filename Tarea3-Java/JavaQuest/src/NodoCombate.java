import java.util.Random;
import java.util.Scanner;

public class NodoCombate extends Nodo {
    /**
     * Constructor del nodo combate
     * @Integer id: id del nodo combate
     */
    public NodoCombate(Integer id){
        super (id);
        this.enemigo = new Personaje("",0,0,0,0,0);
        enemigo = enemigo(enemigo);
    }

    private Personaje enemigo;

    public Personaje getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(Personaje enemigo) {
        this.enemigo = enemigo;
    }

    /**
     * Función que entrega el enemigo a combatir en el nodo combate
     *
     * @param x: Personaje 'en blanco' que a traves de la funcion adquiere las estadísticas del enemigo
     *
     * @return x: Personaje 'en blanco' que ya tiene las estadísticas y combatirá con el usuario
     */
    public Personaje enemigo(Personaje x){
        Random azar = new Random();
        int enemigoselec = azar.nextInt(9);

        if (enemigoselec==0){
            x.setNombre("Invasor");
            x.setDinero(50);
            x.setHp_actual(15);
            x.setHp_total(15);
            x.setDanio(2);
            x.setDefensa(1);
        }
        else if(enemigoselec == 1){
            x.setNombre("miembro de la Colmena");
            x.setDinero(50);
            x.setHp_actual(15);
            x.setHp_total(15);
            x.setDanio(2);
            x.setDefensa(1);
        }
        else if (enemigoselec == 2){
            x.setNombre("Caido");
            x.setDinero(50);
            x.setHp_actual(15);
            x.setHp_total(15);
            x.setDanio(2);
            x.setDefensa(1);
        }
        else if (enemigoselec== 3){
            x.setNombre("Caballero");
            x.setDinero(50);
            x.setHp_actual(15);
            x.setHp_total(15);
            x.setDanio(2);
            x.setDefensa(1);
        }
        else if (enemigoselec == 4){
            x.setNombre("Jardinero");
            x.setDinero(60);
            x.setHp_actual(20);
            x.setHp_total(20);
            x.setDanio(3);
            x.setDefensa(2);
        }
        else if (enemigoselec == 5){
            x.setNombre("Mago");
            x.setDinero(60);
            x.setHp_actual(20);
            x.setHp_total(20);
            x.setDanio(3);
            x.setDefensa(2);
        }
        else if (enemigoselec == 6){
            x.setNombre("Capitán");
            x.setDinero(60);
            x.setHp_actual(20);
            x.setHp_total(20);
            x.setDanio(3);
            x.setDefensa(2);
        }
        else if (enemigoselec == 7){
            x.setNombre("Coloso");
            x.setDinero(60);
            x.setHp_actual(20);
            x.setHp_total(20);
            x.setDanio(3);
            x.setDefensa(2);
        }
        else {
            x.setNombre("Discípulo");
            x.setDinero(75);
            x.setHp_actual(25);
            x.setHp_total(25);
            x.setDanio(5);
            x.setDefensa(3);
        }

        return x;
    }

    /**
     * Funcion utilizada en el usuario para interactuar respecto al Nodo Combate
     * @param usuario: usuario que interactúa
     */

    public void interactuar(Jugador usuario){
        Scanner entrada = new Scanner (System.in);
        String ver;

        System.out.println("mmm... está bastante silencioso este sector, espero no equivocar...");
        System.out.println("(aparece un enemigo)");
        usuario.combate(enemigo);

        if (usuario.getHp_actual() > 0){
            System.out.println("\n¿Deseas ver tu estado?\n");
            System.out.println("1: Sí");
            System.out.println("2: No");
            ver = entrada.nextLine();
            if (ver.equals("1")){
                usuario.verEstado();
            }
            else if (ver.equals("2")) {
                System.out.println("Como quieras");
            }
            System.out.println("\n¿Deseas ver tus items?\n");
            System.out.println("1: Sí");
            System.out.println("2: No");
            ver = entrada.nextLine();
            if (ver.equals("1")){
                usuario.verItems();
            }
            else if (ver.equals("2")){
                System.out.println("Como quieras");
            }
        }
      

    }
}
