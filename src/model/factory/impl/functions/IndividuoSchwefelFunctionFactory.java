package model.factory.impl.functions;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.functions.IndividuoSchwefelFunction;

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
