package model.factory.impl;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.functions.IndividuoCrossInTrayFunction;

public class IndividuoCrossInTrayFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;

    public IndividuoCrossInTrayFunctionFactory(int nDimensoes) {
        this.nDimensoes = nDimensoes;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoCrossInTrayFunction(nDimensoes);
    }
}
