package app;

import domain.Ag;
import domain.factory.IndividuoFactory;
import domain.factory.IndividuoNRainhasFactory;
import domain.individuo.Individuo;
import domain.individuo.IndividuoNRainhas;

import java.util.List;

public class AgRunner {

    public static void main(String[] args) {
        final int N_POP = 30;
        final int N_RAINHAS = 50;
        final int N_ELITE = 4;
        final int N_GER = 2000;
        final boolean IS_MAX = false;

        IndividuoFactory indFactory = new IndividuoNRainhasFactory(N_RAINHAS);
        Ag ag = new Ag();
        Individuo ind = ag.executar(N_POP, indFactory, N_ELITE, IS_MAX, N_GER);

        printInd(ind, N_GER);
    }

    private static void printInd(Individuo indMelhor, int nGer) {
        IndividuoNRainhas individuoNRainhas = (IndividuoNRainhas) indMelhor;
        List<Integer> genes = individuoNRainhas.getGenes();

        System.out.println("Geração  --  Colisões  -- Genes indivíduo");
        System.out.print(nGer + "\t\t");
        System.out.printf("  %1.4f\t", individuoNRainhas.getAvaliacao());

        for(Integer gene : genes) {
            System.out.print(gene + "\t");
        }
    }
}
