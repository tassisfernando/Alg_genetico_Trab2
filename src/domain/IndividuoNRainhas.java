package domain;

import java.util.List;

public class IndividuoNRainhas extends Individuo {

    private int nRainhas;

    public IndividuoNRainhas(int nRainhas) {
        this.nRainhas = nRainhas;
    }

    //TODO implementar os métodos da classe

    @Override
    public Double avaliar() {
        return null;
    }

    @Override
    public List<Individuo> getFilhos(Individuo ind) {
        return null;
    }

    @Override
    public Individuo getMutante() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("nRainhas: %s \nAvaliação: %s", nRainhas, avaliacao);
    }
}
