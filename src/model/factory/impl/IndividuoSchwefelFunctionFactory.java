package model.factory.impl;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.IndividuoLevyFunction;
import model.individuo.IndividuoSchwefelFunction;

public class IndividuoSchwefelFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;

    public IndividuoSchwefelFunctionFactory(int nDimensoes) {
        this.nDimensoes = nDimensoes;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoSchwefelFunction(nDimensoes);
    }
}
