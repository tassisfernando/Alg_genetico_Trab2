package model.individuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.util.Arrays.asList;
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
            IndividuoGaussiano pai2 = (IndividuoGaussiano) ind;

            double alfa;
            List<Double> genesFilho1 = new ArrayList<>(this.nDimensoes);
            List<Double> genesFilho2 = new ArrayList<>(this.nDimensoes);

            for(int i = 0; i < this.nDimensoes; i++) {
                alfa = random.nextGaussian();
                double valorF1 = this.genes.get(i) + alfa * abs(this.genes.get(i) - pai2.genes.get(i));
                valorF1 = validaValorGene(valorF1);

                alfa = random.nextGaussian();
                double valorF2 = pai2.genes.get(i) + alfa * abs(this.genes.get(i) - pai2.genes.get(i));
                valorF2 = validaValorGene(valorF2);

                genesFilho1.set(i,valorF1);
                genesFilho2.set(i,valorF2);
            }
            Individuo filho1 = this.getNewInstance(genesFilho1);
            Individuo filho2 = this.getNewInstance(genesFilho2);

            return asList(filho1, filho2);
        }

        return null;
    }

    private Double validaValorGene(Double valor) {
        Double novoValor = valor;
        if (valor < this.limInferior) {
            novoValor = this.limInferior;
        }
        else if (valor > this.limSuperior) {
            novoValor = this.limSuperior;
        }

        return novoValor;
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
