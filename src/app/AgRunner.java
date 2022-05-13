package app;

import engine.Ag;
import model.factory.IndividuoFactory;
import model.factory.IndividuoNRainhasFactory;
import model.individuo.Individuo;

import static utils.Utils.printInd;

public class AgRunner {

    public static void main(String[] args) {
        final int N_POP = 30;
        final int N_RAINHAS = 300;
        final int N_ELITE = 6;
        final int N_GER = 2000;
        final boolean IS_MAX = false;

        IndividuoFactory indFactory = new IndividuoNRainhasFactory(N_RAINHAS);
        Ag ag = new Ag();
        Individuo ind = ag.executar(N_POP, indFactory, N_ELITE, IS_MAX, N_GER);

        printInd(ind, N_GER);
    }
}
