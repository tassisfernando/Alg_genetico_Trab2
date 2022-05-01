package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Individuo {

    protected List<Integer> genes;
    protected Double avaliacao;
    private Random random;

    public Individuo(int maxGenes) {
        this.genes = geraGenes(maxGenes);
        this.random = new Random();
    }

    private List<Integer> geraGenes(int maxGenes) {
        List<Integer> genes = new ArrayList<>(maxGenes);
        List<Integer> posicoes = createPosicoes(maxGenes);

        for(int i = 0; i < maxGenes; i++) {
            int pos = random.nextInt(posicoes.size());
            genes.add(pos, i);
            posicoes.remove(pos);
        }

        return genes;
    }

    private List<Integer> createPosicoes(int max) {
        List<Integer> posicoes = new ArrayList<>(max);
        for(int i = 0; i < max; i++) {
            posicoes.add(i);
        }
        return posicoes;
    }

    public abstract Double avaliar();

    public abstract List<Individuo> getFilhos(Individuo ind);

    public abstract Individuo getMutante();

    public Double getAvaliacao() {
        if(this.avaliacao == null) {
            this.avaliacao = this.avaliar();
        }
        return this.avaliacao;
    }

    public abstract String toString();
}
