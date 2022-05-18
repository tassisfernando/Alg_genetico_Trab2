package model.individuo;

import java.util.List;
import java.util.Random;

public abstract class IndividuoGaussiano extends Individuo {

    protected final Random random;
    protected final int nDimensoes;
    protected final Double chanceMutacao;

    public IndividuoGaussiano(int nDimensoes, Double chanceMutacao) {
        this.random = new Random();
        this.nDimensoes = nDimensoes;
        this.chanceMutacao = chanceMutacao;
    }

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
        return String.format("nDimensoes: %s \nAvaliação: %s", nDimensoes, avaliacao);
    }
}
