package domain;

import java.util.List;

public class IndividuoNRainhas extends Individuo {

    private int nRainhas;

    public IndividuoNRainhas(int nRainhas) {
        super(nRainhas);
        this.nRainhas = nRainhas;
    }

    //TODO implementar os métodos da classe

    /**
     * Retorna o fitness do indivíduo pelo número de colisões
     * @return fitness
     */
    @Override
    public Double avaliar() {
        return null;
    }

    /**
     * Retorna dois indivíduos após ser feita a permutação
     * @param p2
     * @return
     */
    @Override
    public List<Individuo> getFilhos(Individuo p2) {
        return null;
    }

    @Override
    public Individuo getMutante() {
        return null;
    }

    @Override
    public String toString() {
        return String.format("nRainhas: %s \nAvaliação: %s", nRainhas, avaliacao);
    }
}
