package model.individuo.functions;

import model.individuo.Individuo;

import java.util.List;

import static java.lang.Math.*;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static utils.Utils.SCHWEFEL_CONST;

public class IndividuoSchwefelFunction extends IndividuoGaussiano {

    private static final Double LIM_INFERIOR_SCHWEFEL = -500D;
    private static final Double LIM_SUPERIOR_SCHWEFEL = 500D;

    public IndividuoSchwefelFunction(int nDimensoes) {
        super(nDimensoes, LIM_INFERIOR_SCHWEFEL, LIM_SUPERIOR_SCHWEFEL);
    }

    public IndividuoSchwefelFunction(int nDimensoes, List<Double> genes) {
        super(nDimensoes, LIM_INFERIOR_SCHWEFEL, LIM_SUPERIOR_SCHWEFEL, genes);
    }

    @Override
    public Double avaliar() {
        Double avaliacaoPrimeira = SCHWEFEL_CONST * nDimensoes;
        Double avaliacaoSegunda = getSomatorioSchwefel();

        return avaliacaoPrimeira - avaliacaoSegunda;
    }

    private Double getSomatorioSchwefel() {
        double avaliacao = ZERO.doubleValue();
        for(int i = ONE.intValue(); i <= nDimensoes; i++) {
            double xi = this.genes.get(i);
            avaliacao = avaliacao + xi * sin(sqrt(abs(xi)));
        }

        return avaliacao;
    }

    @Override
    public Individuo getNewInstance(List<Double> genes) {
        return new IndividuoSchwefelFunction(nDimensoes, genes);
    }
}
