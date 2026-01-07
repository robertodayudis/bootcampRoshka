package model;

public enum Palo {
    PICAS('S'),
    TREBOLES('C'),
    CORAZONES('H'),
    DIAMANTES('D');

    private final char codigo;

    Palo(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo(){
        return codigo;
    }

}
