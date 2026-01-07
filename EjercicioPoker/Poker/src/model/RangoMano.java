package model;

public enum RangoMano {
    ESCALERA_COLOR("Escalera Color"),
    POKER("Poker"),
    FULL("Full"),
    COLOR("Color"),
    ESCALERA("Escalera"),
    TRIO("Trio"),
    PAR_DOBLE("Par doble"),
    PAR("Par"),
    CARTA_ALTA("Carta Alta");

    private final String nombre;

    RangoMano(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}
