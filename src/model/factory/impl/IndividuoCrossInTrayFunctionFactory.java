package model.factory.impl;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.IndividuoCrossInTrayFunction;
import model.individuo.IndividuoLevyFunction;

public class IndividuoCrossInTrayFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;
    private final Double chanceMutacao;

    public IndividuoCrossInTrayFunctionFactory(int nDimensoes, Double chanceMutacao) {
        this.nDimensoes = nDimensoes;
        this.chanceMutacao = chanceMutacao;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoCrossInTrayFunction(nDimensoes, chanceMutacao);
    }
}
