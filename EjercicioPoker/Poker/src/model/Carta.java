package model;
import java.util.Objects;

public final class Carta {
    private final Valor valor;
    private final Palo palo;

    public Carta(Valor valor, Palo palo){
        this.valor = valor;
        this.palo = palo;
    }

    public Valor getValor() {
        return valor;
    }

    public Palo getPalo() {
        return palo;
    }

    public int getNumeroValor(){
        return valor.getNumero();
    }

    public String getCodigo() {
        return "" + valor.getCodigo() + palo.getCodigo();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Carta other)) return false;
        return valor == other.valor && palo == other.palo;
    }

    @Override
    public int hashCode(){
        return Objects.hash(valor, palo);
    }

    @Override
    public String toString() {
        return "" + valor.getCodigo() + palo.getCodigo();
    }
}
