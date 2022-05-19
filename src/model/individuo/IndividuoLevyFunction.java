package model.individuo;

import java.util.List;

public class IndividuoLevyFunction extends IndividuoGaussiano {

    public IndividuoLevyFunction(int nDimensoes, Double limInferior, Double limSuperior) {
        super(nDimensoes, limInferior, limSuperior);
    }

    public IndividuoLevyFunction(int nDimensoes, Double limInferior, Double limSuperior, List<Double> genes) {
        super(nDimensoes, limInferior, limSuperior, genes);
    }


    @Override
    public Double avaliar() {
        return null;
    }

    @Override
    public Individuo getNewInstance(List<Double> genes) {
        return new IndividuoLevyFunction(this.nDimensoes, limInferior, limSuperior, genes);
    }
}
