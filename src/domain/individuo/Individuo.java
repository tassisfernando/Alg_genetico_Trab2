package domain.individuo;

import java.util.List;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static utils.Utils.MENOS_UM;

public abstract class Individuo implements Comparable<Individuo> {

    protected Double avaliacao;

    public abstract Double avaliar();

    public abstract List<Individuo> getFilhos(Individuo ind);

    public abstract Individuo getMutante();

    public Double getAvaliacao() {
        if(this.avaliacao == null) {
            this.avaliacao = this.avaliar();
        }
        return this.avaliacao;
    }

    @Override
    public int compareTo(Individuo individuo) {
        if(this.getAvaliacao() > individuo.getAvaliacao()) {
            return MENOS_UM;
        }
        if(this.getAvaliacao() < individuo.getAvaliacao()) {
            return ONE.intValue();
        }
        return ZERO.intValue();
    }

    public abstract String toString();
}
