package utils;

import model.individuo.Individuo;
import model.individuo.nrainhas.IndividuoNRainhas;

import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class Utils {

    public final static int MENOS_UM = -1;
    public final static int DOIS = 2;
    public final static int CEM = 100;

    public final static Double SCHWEFEL_CONST = 418.9829D;

    public static List<Integer> criarPosicoes(int max) {
        List<Integer> posicoes = new ArrayList<>(max);
        for(int i = ZERO.intValue(); i < max; i++) {
            posicoes.add(i);
        }
        return posicoes;
    }

    public static void printInd(Individuo indMelhor, int nGer) {
        IndividuoNRainhas individuoNRainhas = (IndividuoNRainhas) indMelhor;
        List<Integer> genes = individuoNRainhas.getGenes();

        System.out.println("\nGeração  --  Avaliação  -- Genes indivíduo");
        System.out.print(nGer + "\t\t\t");
        System.out.printf("  %1.4f\t\t", individuoNRainhas.getAvaliacao());

        for(Integer gene : genes) {
            System.out.print(gene + "\t");
        }
    }
}
