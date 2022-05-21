package model.factory.impl.nrainhas;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;
import model.individuo.nrainhas.IndividuoNRainhas;

public class IndividuoNRainhasFactory implements IndividuoFactory {

    private final int nRainhas;

    public IndividuoNRainhasFactory(int nRainhas) {
        this.nRainhas = nRainhas;
    }

    @Override
    public Individuo getIndividuo() {
        return new IndividuoNRainhas(nRainhas);
    }
}
