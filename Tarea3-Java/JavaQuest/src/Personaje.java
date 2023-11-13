import java.util.Random;
import java.util.Scanner;

public class Personaje {
    private String nombre;
    private Integer dinero;
    private Integer hp_actual;
    private Integer hp_total;
    private Integer danio;
    private Integer defensa;

    /**
     * Constructor de Personaje
     * @String nombre: nombre del personaje
     * @Integer dinero: cantidad de dinero que el jugador podría recibir del personaje
     * @Integer  hp_actual: HP actual del personaje
     * @Integer hp_total: HP total del personaje
     * @Integer danio: danio que es capaz de hacer el personaje
     * @Integer defensa: defensa que es capaz de hacer el personaje
     */
    public Personaje(String nombre, Integer dinero, Integer hp_actual, Integer hp_total, Integer danio, Integer defensa) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.hp_actual = hp_actual;
        this.hp_total = hp_total;
        this.danio = danio;
        this.defensa = defensa;
    }

    //sets y gets de los elementos
    public String getNombre() {
        return nombre;
    }

    public Integer getDinero() {
        return dinero;
    }

    public Integer getHp_actual() {
        return hp_actual;
    }

    public Integer getHp_total() {
        return hp_total;
    }

    public Integer getDanio() {
        return danio;
    }

    public Integer getDefensa() {
        return defensa;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public void setHp_actual(Integer hp_actual) {
        this.hp_actual = hp_actual;
    }

    public void setHp_total(Integer hp_total) {
        this.hp_total = hp_total;
    }

    public void setDanio(Integer danio) {
        this.danio = danio;
    }

    public void setDefensa(Integer defensa) {
        this.defensa = defensa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Genera el combate entre el usuario y el enemigo.
     * @Personaje enemigo: enemigo a derrotar por parte del usuario
     */


    public void combate (Personaje enemigo){
        Random azar = new Random();
        int turno = azar.nextInt(2);
        Scanner entrada = new Scanner (System.in);

        // Le toca empezar al jugador
        if(turno == 0){

            if (enemigo.getNombre().equals("El Testigo")){
                System.out.println("\"*************************************   BATALLA FINAL VS EL TESTIGO     *************************************\"");
                entrada.nextLine();
                System.out.println("Tú atacas primero, ¡vamos que se puede!");
                System.out.println("Consejo: presiona enter cada vez que se realiza un ataque (y uno ahora para empezar el combate).");
            }
            else{
                System.out.println("Oh no, hay un "+ enemigo.getNombre()+". Tú atacas primero.");
                System.out.println("Tu puedes.");
                System.out.println("Consejo: presiona enter cada vez que se realiza un ataque (y uno ahora para empezar el combate).");
                entrada.nextLine();
                System.out.println("*************************************   COMIENZA EL COMBATE     *************************************");
            }
            entrada.nextLine();

            while (hp_actual > 0 && enemigo.getHp_actual() > 0){

                // danio del usuario es mayor a la defensa enemiga y el danio enemigo es mayor a la defensa del usuario
                if (danio > enemigo.getDefensa() && enemigo.getDanio() > defensa){
                    enemigo.setHp_actual(enemigo.getHp_actual()-(getDanio() - enemigo.getDefensa()));
                    System.out.println("(lo golpea)");
                    if (enemigo.getNombre().equals("El Testigo")){
                        System.out.println("¡VAMOS!, muy bien\n");
                    }
                    else{
                        System.out.println("¡BUEN ATAQUE!\n");
                    }
                    System.out.println("HP actual de " + getNombre()+": " + getHp_actual());
                    System.out.println("HP actual de " + enemigo.getNombre()+": " + enemigo.getHp_actual());
                    entrada.nextLine();
                    if (enemigo.getHp_actual() <= 0){
                        setDinero(getDinero() + enemigo.getDinero());
                        if (enemigo.getNombre().equals("El Testigo")){
                            System.out.println("¡El Testigo fue asesinado!\n");
                            System.out.println("CUMPLISTE TU DESTINO");
                        }
                        else{
                            System.out.println("¡Enemigo asesinado!\n");
                            System.out.println("Como recompensa, adquieres su dinero, en este caso " + enemigo.getDinero());
                            System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                        }
                    }
                    else{
                        setHp_actual(getHp_actual()-(enemigo.getDanio() - getDefensa()));
                        System.out.println("(recibe daño)");
                        if (enemigo.getNombre().equals("El Testigo")){
                            System.out.println("Vamos, levántate.\n¡NO TE RINDAS!\n");
                        }
                        else{
                            System.out.println("Uy, ¡eso tuvo que doler!\n");
                        }
                        System.out.println("HP actual de " + getNombre()+": " + getHp_actual());
                        System.out.println("HP actual de " + enemigo.getNombre()+": " + enemigo.getHp_actual());
                        entrada.nextLine();
                    }
                    if (hp_actual <= 0){
                        if (enemigo.getNombre().equals("El Testigo")){
                            System.out.println("El Testigo te mató\n");
                            System.out.println("No cumpliste tu Destino... :(");
                        }
                        else{
                            System.out.println("El enemigo te derrotó");
                            System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                        }
                        System.out.println("*************************************    YOU DIED    *************************************");
                    }
                }

                // danio del usuario es mayor a la defensa enemiga y el danio enemigo es menor o igual a la defensa del usuario
                else if (danio > enemigo.getDefensa() && enemigo.getDanio() <= defensa){
                    setDinero(getDinero()+ enemigo.getDinero());
                    enemigo.setHp_actual(0);

                    if (enemigo.getNombre().equals("El Testigo")) {
                        System.out.println("¡El Testigo fue asesinado!\n");
                        System.out.println("CUMPLISTE TU DESTINO");
                    }
                    else{
                        System.out.println("Enemigo asesinado con alta facilidad debido a la diferencias entre ataque/defensa.\n");
                        System.out.println("El HP se mantiene.");
                        System.out.println("Como recompensa, adquieres su dinero, en este caso " + enemigo.getDinero());
                        System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                    }
                }

                // danio del usuario es menor o igual a la defensa enemiga y el danio enemigo es mayor a la defensa del usuario
                else if (danio <= enemigo.getDefensa() && enemigo.getDanio() >= defensa){
                    setHp_actual(0);
                    if (enemigo.getNombre().equals("El Testigo")) {
                        System.out.println("El Testigo te mató\n");
                        System.out.println("No cumpliste tu Destino... :(");
                    }
                    else {
                        System.out.println(enemigo.getNombre() + " es demasiado poderoso para tí");
                        System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                        System.out.println("*************************************    YOU DIED    *************************************");
                    }
                }

                // danio del usuario es menor o igual a la defensa enemiga y el danio enemigo es menor o igual a la defensa del usuario
                else if (enemigo.getDefensa() >= danio && enemigo.getDanio() <= defensa){
                    enemigo.setHp_actual(0);
                    if (enemigo.getNombre().equals("El Testigo")) {
                        System.out.println("Tú y El Testigo están igualados, por ende lucharán eternamente\n");
                        System.out.println("De cierta forma, cumpliste con Destino :)");
                    }
                    else {
                        System.out.println("El enemigo escapó por acto de cobardía\n");
                        System.out.println("El HP se mantiene.");
                        System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                    }
                }
            }
        }

        //Le toca empezar al enemigo
        else {
            if (enemigo.getNombre().equals("El Testigo")){
                System.out.println("\"*************************************   BATALLA FINAL VS EL TESTIGO     *************************************\"");
                entrada.nextLine();
                System.out.println("Él ataca primero, ¡vamos que se puede!");
                System.out.println("Consejo: presiona enter cada vez que se realiza un ataque (y uno ahora para empezar el combate).");
            }
            else{
                System.out.println("Oh no, hay un "+ enemigo.getNombre()+". Él ataca primero.");
                System.out.println("Mucha suerte.");
                System.out.println("Consejo: presiona enter cada vez que se realiza un ataque (y uno ahora para empezar el combate).");
                entrada.nextLine();
                System.out.println("*************************************   COMIENZA EL COMBATE     *************************************");
            }
            entrada.nextLine();
            while (hp_actual > 0 && enemigo.getHp_actual() > 0){

                // danio del usuario es mayor a la defensa enemiga y el danio enemigo es mayor a la defensa del usuario
                if (danio > enemigo.getDefensa() && enemigo.getDanio() > defensa){
                    setHp_actual(getHp_actual()-(enemigo.getDanio() - getDefensa()));
                    System.out.println("(recibe daño)");
                    if (enemigo.getNombre().equals("El Testigo")){
                        System.out.println("Vamos, levántate.\n¡NO TE RINDAS!\n");
                    }
                    else{
                        System.out.println("¡AUCH!\n");
                    }
                    System.out.println("HP actual de " + getNombre()+": " + getHp_actual());
                    System.out.println("HP actual de " + enemigo.getNombre()+": " + enemigo.getHp_actual());
                    entrada.nextLine();

                    if (hp_actual <= 0){
                        if (enemigo.getNombre().equals("El Testigo")){
                            System.out.println("El Testigo te mató\n");
                            System.out.println("No cumpliste tu Destino... :(");
                        }
                        else{
                            System.out.println("El enemigo te derrotó");
                            System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                            System.out.println("*************************************    YOU DIED    *************************************");
                        }
                    }
                    else{
                        enemigo.setHp_actual(enemigo.getHp_actual()-(getDanio() - enemigo.getDefensa()));
                        System.out.println("(lo golpea)");
                        if (enemigo.getNombre().equals("El Testigo")){
                            System.out.println("¡VAMOS!, muy bien");
                        }
                        else{
                            System.out.println("¡MUY BIEN!\n");
                        }
                        System.out.println("HP actual de " + getNombre()+": " + getHp_actual());
                        System.out.println("HP actual de " + enemigo.getNombre()+": " + enemigo.getHp_actual());
                        entrada.nextLine();
                    }
                    if (enemigo.hp_actual <= 0){
                        if (enemigo.getNombre().equals("El Testigo")){
                            setDinero(getDinero()+ enemigo.getDinero());
                            System.out.println("¡El Testigo fue asesinado!\n");
                            System.out.println("CUMPLISTE TU DESTINO");
                        }
                        else{
                            setDinero(getDinero()+ enemigo.getDinero());
                            System.out.println("¡Enemigo asesinado!\n");
                            System.out.println("Como recompensa, adquieres su dinero, en este caso " + enemigo.getDinero());
                            System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                        }
                    }
                }

                // danio del usuario es mayor a la defensa enemiga y el danio enemigo es menor o igual a la defensa del usuario
                else if (danio > enemigo.getDefensa() && enemigo.getDanio() <= defensa){
                    setDinero(getDinero()+ enemigo.getDinero());
                    enemigo.setHp_actual(0);
                    if (enemigo.getNombre().equals("El Testigo")) {
                        System.out.println("¡El Testigo fue asesinado!\n");
                        System.out.println("CUMPLISTE TU DESTINO");
                    }
                    else{
                        System.out.println("El enemigo es incapaz de hacer daño debido a la diferencias entre ataque/defensa, por lo que es asesinado con alta facilidad.\n");
                        System.out.println("El HP se mantiene.");
                        System.out.println("Como recompensa, adquieres su dinero, en este caso " + enemigo.getDinero());
                        System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                    }
                }

                // danio del usuario es menor o igual a la defensa enemiga y el danio enemigo es mayor a la defensa del usuario
                else if (danio <= enemigo.getDefensa() && enemigo.getDanio() >= defensa){
                    if (enemigo.getNombre().equals("El Testigo")) {
                        System.out.println("El Testigo te mató\n");
                        System.out.println("No cumpliste tu Destino... :(");
                        setHp_actual(0);
                    }
                    else{
                        System.out.println(enemigo.getNombre() + " es demasiado poderoso para tí");
                        setHp_actual(0);
                        System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                        System.out.println("*************************************    YOU DIED    *************************************");
                    }
                }

                // danio del usuario es menor o igual a la defensa enemiga y el danio enemigo es menor o igual a la defensa del usuario
                else if (enemigo.getDefensa() >= danio && enemigo.getDanio() <= defensa){

                    if (enemigo.getNombre().equals("El Testigo")) {
                        enemigo.setHp_actual(0);
                        System.out.println("Tú y El Testigo están igualados, por ende lucharán eternamente\n");
                        System.out.println("De cierta forma, cumpliste con Destino :)");
                    }
                    else{
                        enemigo.setHp_actual(0);
                        System.out.println("El enemigo escapó por acto de cobardía\n");
                        System.out.println("El HP se mantiene.");
                        System.out.println("*************************************     FIN DEL COMBATE     *************************************\n");
                    }
                }
            }
            

        }
    }
}
