package utils;

import model.individuo.Individuo;
import model.individuo.functions.IndividuoGaussiano;

import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class Utils {

    public final static int MENOS_UM = -1;
    public final static int DOIS = 2;
    public final static Double QUATRO = 4D;
    public final static Double DEZ = 10D;
    public final static int CEM = 100;

    public final static Double CHANCE_MUTACAO = 0.1D;
    public final static Double SCHWEFEL_CONST = 418.9829D;


    public static void printInd(Individuo indMelhor, int nGer) {
        IndividuoGaussiano individuoGaussiano = (IndividuoGaussiano) indMelhor;
        List<Double> genes = individuoGaussiano.getGenes();

        System.out.println("\nGeração  --  Avaliação  -- Genes indivíduo");
        System.out.print(nGer + "\t\t\t");
        System.out.printf("  %1.4f\t\t", individuoGaussiano.getAvaliacao());

        for(Double gene : genes) {
            System.out.print(gene + "\t");
        }
    }
}
