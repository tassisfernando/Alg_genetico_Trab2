package model.individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.shuffle;

public abstract class IndividuoGaussiano extends Individuo {

    protected final int nDimensoes;
    protected final Double limInferior, limSuperior;
    protected List<Double> genes;

    protected final Random random;


    public IndividuoGaussiano(int nDimensoes, Double limInferior, Double limSuperior) {
        this.random = new Random();
        this.nDimensoes = nDimensoes;
        this.limInferior = limInferior;
        this.limSuperior = limSuperior;
        this.genes = geraGenes(nDimensoes);
    }

    public IndividuoGaussiano(int nDimensoes, Double limInferior, Double limSuperior, List<Double> genes) {
        this.random = new Random();
        this.nDimensoes = nDimensoes;
        this.limInferior = limInferior;
        this.limSuperior = limSuperior;
        this.genes = genes;
    }

    private List<Double> geraGenes(int nGenes) {
        List<Double> genes = new ArrayList<>(nGenes);
        for (int i = 0; i < nGenes; i++) {
            double valor = random.nextDouble() * nGenes;
            while (genes.contains(valor)) {
                valor = random.nextInt(nGenes);
            }
            genes.add(valor);
        }

        shuffle(genes);
        return genes;
    }

    @Override
    public List<Individuo> getFilhos(Individuo ind) {
        if(ind instanceof IndividuoGaussiano) {
            Double alfa;
            List<Double> genesFilho1 = new ArrayList<>(this.nDimensoes);
            List<Double> genesFilho2 = new ArrayList<>(this.nDimensoes);
            List<Individuo> filhos = new ArrayList<>();

            for(int i = 0; i < this.nDimensoes; i++) {

            }
        }
        return null;
    }

    @Override
    public Individuo getMutante() {
        return null;
    }

    @Override
    public abstract Double avaliar();

    @Override
    public String toString() {
        return String.format("nDimensoes: %s \nAvaliação: %s", nDimensoes, avaliacao);
    }

    public abstract Individuo getNewInstance(List<Double> genes);
}
