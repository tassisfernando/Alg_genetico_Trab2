package model.factory.impl.functions;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.functions.IndividuoLevyFunction;

public class IndividuoLevyFunctionFactory implements IndividuoFactory {

    private final int nDimensoes;

    public IndividuoLevyFunctionFactory(int nDimensoes) {
        this.nDimensoes = nDimensoes;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoLevyFunction(nDimensoes);
    }
}
