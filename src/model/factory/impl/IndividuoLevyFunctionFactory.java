package model.factory.impl;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.IndividuoLevyFunction;

public class IndividuoLevyFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;
    private final Double limInferior, limSuperior;

    public IndividuoLevyFunctionFactory(int nDimensoes, Double limInferior, Double limSuperior) {
        this.nDimensoes = nDimensoes;
        this.limInferior = limInferior;
        this.limSuperior = limSuperior;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoLevyFunction(nDimensoes, limInferior, limSuperior);
    }
}
