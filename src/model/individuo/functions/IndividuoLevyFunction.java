package model.individuo.functions;

import model.individuo.Individuo;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static utils.Utils.*;

public class IndividuoLevyFunction extends IndividuoGaussiano {

    private static final Double LIM_INFERIOR_LEVY = -10D;
    private static final Double LIM_SUPERIOR_LEVY = 10D;

    public IndividuoLevyFunction(int nDimensoes) {
        super(nDimensoes, LIM_INFERIOR_LEVY, LIM_SUPERIOR_LEVY);
    }

    public IndividuoLevyFunction(int nDimensoes, List<Double> genes) {
        super(nDimensoes, LIM_INFERIOR_LEVY, LIM_SUPERIOR_LEVY, genes);
    }

    @Override
    public Double avaliar() {
        List<Double> wFunction = getWFunction();
        Double termo1 = pow(sin(PI * wFunction.get(ONE.intValue())), DOIS);
        Double wd = wFunction.get(nDimensoes - ONE.intValue());
        Double termo3 = pow(wd - ONE.doubleValue(), DOIS)
                * pow(ONE.doubleValue() + (sin(2*PI*wd)), DOIS);

        double somatorio = ZERO.doubleValue();

        for (int i = ZERO.intValue(); i < nDimensoes; i++) {
            Double wi = wFunction.get(i);
            somatorio += pow(wi - ONE.doubleValue(), DOIS) *
                    (ONE.doubleValue() + DEZ * pow(sin(PI * wi + ONE.doubleValue()), DOIS));
        }

        return termo1 + somatorio + termo3;
    }

    private List<Double> getWFunction() {
        List<Double> wFunction = new ArrayList<>(nDimensoes);
        for(int i = ZERO.intValue(); i < nDimensoes; i++) {
            Double wValue = ONE.doubleValue() + (this.genes.get(i) - ONE.doubleValue()) / QUATRO;
            wFunction.add(wValue);
        }
        return wFunction;
    }

    @Override
    public Individuo getNewInstance(List<Double> genes) {
        return new IndividuoLevyFunction(this.nDimensoes, genes);
    }
}
