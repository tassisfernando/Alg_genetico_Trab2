package domain.factory;

import domain.individuo.Individuo;
import domain.individuo.IndividuoNRainhas;

public class IndividuoNRainhasFactory implements IndividuoFactory {

    private final int nRainhas;

    @Override
    public Individuo getIndividuo() {
        return new IndividuoNRainhas(nRainhas);
    }

    public IndividuoNRainhasFactory(int nRainhas) {
        this.nRainhas = nRainhas;
    }
}
