

public class Item {
    private final String nombre;
    private final Integer precio;
    private final Integer recuperar_hp;
    private final Integer aumentar_hp_total;
    private final Integer aumentar_danio;
    private final Integer aumentar_defensa;

    /**
     * Constructor de Item
     * @String nombre: nombre del Item
     * @Integer precio: precio que cuesta el item
     * @Integer aumentar_hp_actual: Aumento del HP actual del personaje
     * @Integer aumentar_hp_total: Aumento del HP total del personaje
     * @Integer aumentar_danio: danio aumentado que es capaz de hacer el personaje
     * @Integer aumentar_defensa: defensa aumentada que es capaz de hacer el personaje
     */
    public Item(String nombre, Integer precio, Integer recuperar_hp, Integer aumentar_hp_total, Integer aumentar_danio, Integer aumentar_defensa) {
        this.nombre = nombre;
        this.precio = precio;
        this.recuperar_hp = recuperar_hp;
        this.aumentar_hp_total = aumentar_hp_total;
        this.aumentar_danio = aumentar_danio;
        this.aumentar_defensa = aumentar_defensa;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Integer getRecuperar_hp() {
        return recuperar_hp;
    }

    public Integer getAumentar_hp_total() {
        return aumentar_hp_total;
    }

    public Integer getAumentar_danio() {
        return aumentar_danio;
    }

    public Integer getAumentar_defensa() {
        return aumentar_defensa;
    }


    public String getNombre() {
        return nombre;
    }

    /**
     * Aplica el item en el usuario y en la lista de items encontrados por el usuario
     *
     * @Jugador usuario: usuario al que se le aplica el item
     *
     */
    public void aplicar(Jugador usuario){
        Item aux = new Item(getNombre(),getPrecio(),getRecuperar_hp(),getAumentar_hp_total(),getAumentar_danio(),getAumentar_defensa());
        usuario.setItems_aplicados(aux);
        usuario.setHp_total(usuario.getHp_total() + getAumentar_hp_total());
        usuario.setDinero(usuario.getDinero() - getPrecio());
        if ((usuario.getHp_actual() + getRecuperar_hp()) >= usuario.getHp_total()){
            usuario.setHp_actual(usuario.getHp_total());
        }
        else {
            usuario.setHp_actual(usuario.getHp_actual() + getRecuperar_hp());
        }
        usuario.setDanio(usuario.getDanio() + getAumentar_danio());
        usuario.setDefensa(usuario.getDefensa() + getAumentar_defensa());
    }
}
