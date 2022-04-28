package domain;

import java.util.List;

public abstract class Individuo {

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

    public abstract String toString();
}
