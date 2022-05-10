package app;

import domain.Ag;
import domain.factory.IndividuoFactory;
import domain.factory.IndividuoNRainhasFactory;
import domain.individuo.Individuo;
import domain.individuo.IndividuoNRainhas;

import java.util.List;

import static java.math.BigDecimal.ONE;

public class AgRunner {

    public static void main(String[] args) {
        final int N_POP = 20;
        final int N_RAINHAS = 8;
        final int N_ELITE = 4;
        final int N_GER = 1000;
        final boolean IS_MAX = false;

        IndividuoFactory indFactory = new IndividuoNRainhasFactory(N_RAINHAS);
        Ag ag = new Ag();
        Individuo ind = ag.executar(N_POP, indFactory, N_ELITE, IS_MAX, N_GER);

        printInd(ind, N_GER, IS_MAX);

    }

    private static void printInd(Individuo indMelhor, int nGer, boolean isMax) {
        IndividuoNRainhas individuoNRainhas = (IndividuoNRainhas) indMelhor;
        List<Integer> genes = individuoNRainhas.getGenes();

        System.out.println("Geração  --  Avaliação  -- Genes indivíduo");
        System.out.print(nGer + "\t\t");
        Double avaliacao = isMax ? individuoNRainhas.getAvaliacao() : (ONE.doubleValue() / individuoNRainhas.getAvaliacao());
        System.out.printf("  %1.4f\t", avaliacao);

        for(Integer gene : genes) {
            System.out.print(gene + "\t");
        }
    }
}
