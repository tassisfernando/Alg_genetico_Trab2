package app;

import domain.Ag;
import domain.Individuo;
import domain.factory.IndividuoFactory;
import domain.factory.IndividuoNRainhasFactory;

public class AgRunner {

    public static void main(String[] args) {
        final int N_POP = 20;
        final int N_RAINHAS = 8;
        final int N_ELITE = 4;
        final int N_GER = 1000;

        IndividuoFactory indFactory = new IndividuoNRainhasFactory(N_RAINHAS);
        Ag ag = new Ag();
        Individuo ind = ag.executar(N_POP, indFactory, N_ELITE, false, N_GER);

        System.out.println(ind);

    }
}
