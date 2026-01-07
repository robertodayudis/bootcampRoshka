package model;

public enum Valor {
    DOS(2, '2'),
    TRES(3, '3'),
    CUATRO(4, '4'),
    CINCO(5, '5'),
    SEIS(6, '6'),
    SIETE(7, '7'),
    OCHO(8, '8'),
    NUEVE(9, '9'),
    DIEZ(10, 'T'),
    JOTA(11, 'J'),
    REINA(12, 'Q'),
    REY(13, 'K'),
    AS(14, 'A');

    private final int numero;
    private final char codigo;

    Valor(int numero, char codigo){
        this.numero = numero;
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public char getCodigo() {
        return codigo;
    }

}
