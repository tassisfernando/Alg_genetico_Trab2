package app;

import engine.Ag;
import model.factory.IndividuoFactory;
import model.factory.impl.IndividuoCrossInTrayFunctionFactory;
import model.factory.impl.IndividuoLevyFunctionFactory;
import model.factory.impl.IndividuoSchwefelFunctionFactory;
import model.individuo.Individuo;

import static utils.Utils.printInd;

public class AgRunner {

    public static void main(String[] args) {
        final int N_POP = 20;
        final int N_DIMENSOES = 2;
        final int N_ELITE = 4;
        final int N_GER = 1000;
        final boolean IS_MAX = false;
        final double DESLOC = 0d, DESLOC_CROSS = -2.1D;

        IndividuoFactory indFactory = new IndividuoCrossInTrayFunctionFactory(N_DIMENSOES);
        Ag ag = new Ag();
        Individuo ind = ag.executar(N_POP, indFactory, N_ELITE, IS_MAX, N_GER, DESLOC_CROSS);

        printInd(ind, N_GER);
    }
}
