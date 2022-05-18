package model.individuo;

import static java.lang.Math.*;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static utils.Utils.SCHWEFEL_CONST;

public class IndividuoSchwefelFunction extends IndividuoGaussiano {

    public IndividuoSchwefelFunction(int nDimensoes, Double chanceMutacao) {
        super(nDimensoes, chanceMutacao);
    }

    @Override
    public Double avaliar() {
        Double avaliacaoPrimeira = SCHWEFEL_CONST * nDimensoes;
        Double avaliacaoSegunda = getSomatorioSchwefel();

        return avaliacaoPrimeira - avaliacaoSegunda;
    }

    // TODO alterar o somatório: utilizar os genes
    private Double getSomatorioSchwefel() {
        double avaliacao = ZERO.doubleValue();
        for(int x = ONE.intValue(); x <= nDimensoes; x++) {
            avaliacao = avaliacao + x * sin(sqrt(abs(x)));
        }

        return avaliacao;
    }
}
