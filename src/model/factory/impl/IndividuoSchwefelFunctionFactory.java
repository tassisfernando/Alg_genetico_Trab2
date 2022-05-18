package model.factory.impl;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.IndividuoLevyFunction;
import model.individuo.IndividuoSchwefelFunction;

public class IndividuoSchwefelFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;
    private final Double chanceMutacao;

    public IndividuoSchwefelFunctionFactory(int nDimensoes, Double chanceMutacao) {
        this.nDimensoes = nDimensoes;
        this.chanceMutacao = chanceMutacao;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoSchwefelFunction(nDimensoes, chanceMutacao);
    }
}
