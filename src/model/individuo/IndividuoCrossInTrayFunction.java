package model.individuo;

import java.util.List;

import static java.lang.Math.*;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static utils.Utils.CEM;
import static utils.Utils.DOIS;

public class IndividuoCrossInTrayFunction extends IndividuoGaussiano {

    private static final Double LIM_INFERIOR_CROSS = -10D;
    private static final Double LIM_SUPERIOR_CROSS = 10D;

    public IndividuoCrossInTrayFunction(int nDimensoes) {
        super(nDimensoes, LIM_INFERIOR_CROSS, LIM_SUPERIOR_CROSS);
    }

    public IndividuoCrossInTrayFunction(int nDimensoes, List<Double> genes) {
        super(nDimensoes, LIM_INFERIOR_CROSS, LIM_SUPERIOR_CROSS, genes);
    }

    @Override
    public Double avaliar() {
        Double genPosZero = this.genes.get(ZERO.intValue());
        Double genPosUm = this.genes.get(ONE.intValue());

        double parte1 = sin(genPosZero) * sin(genPosUm);
        double parte2 = exp(Math.abs(CEM - ((sqrt(pow(genPosZero, DOIS) + pow(genPosUm, DOIS))) / PI)));
        double parte3 = Math.abs(parte1 * parte2) + ONE.intValue();

        return -0.0001 * pow(parte3, 0.1);
    }

    @Override
    public Individuo getNewInstance(List<Double> genes) {
        return new IndividuoCrossInTrayFunction(nDimensoes, genes);
    }
}
