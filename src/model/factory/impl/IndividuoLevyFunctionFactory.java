package model.factory.impl;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.IndividuoLevyFunction;

public class IndividuoLevyFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;
    private final Double chanceMutacao;

    public IndividuoLevyFunctionFactory(int nDimensoes, Double chanceMutacao) {
        this.nDimensoes = nDimensoes;
        this.chanceMutacao = chanceMutacao;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoLevyFunction(nDimensoes, chanceMutacao);
    }
}
