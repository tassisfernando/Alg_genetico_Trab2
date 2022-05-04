package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static utils.ListUtil.createPosicoes;

public class IndividuoNRainhas extends Individuo {

    private List<Integer> genes;
    private int nRainhas;
    private final Random random;

    public IndividuoNRainhas(int nRainhas) {
        this.random = new Random();
        this.nRainhas = nRainhas;
        this.genes = geraGenes();
    }

    public IndividuoNRainhas(int nRainhas, List<Integer> genes) {
        this.random = new Random();
        this.nRainhas = nRainhas;
        this.genes = genes;
    }

    private List<Integer> geraGenes() {
        final int maxGenes = this.nRainhas;
        List<Integer> genes = new ArrayList<>(maxGenes);
        List<Integer> posicoes = createPosicoes(maxGenes);

        for(int i = 0; i < maxGenes; i++) {
            int pos = random.nextInt(posicoes.size());
            genes.add(pos, i);
            posicoes.remove(pos);
        }

        return genes;
    }

    /**
     * Retorna o fitness do indivíduo pelo número de colisões
     * @return fitness
     */
    @Override
    public Double avaliar() {
        Double nColisoes = 0d;
        for(int i = 0; i < this.nRainhas; i++) {
            for (int j = 0; j < this.nRainhas; j++) {
                int diag1 = this.genes.get(j) - Math.abs(j-i);
                int diag2 = this.genes.get(j) + Math.abs(j-i);
                if(this.genes.get(i).equals(diag1) || this.genes.get(i).equals(diag2)) {
                    nColisoes++;
                }
            }
        }

        return nColisoes;
    }

    /**
     * Retorna dois indivíduos após ser feita a permutação
     * @param p2: pai 2
     * @return uma lista com dois filhos
     */
    @Override
    public List<Individuo> getFilhos(Individuo p2) {
        if(p2 instanceof IndividuoNRainhas) {
            IndividuoNRainhas pai2 = (IndividuoNRainhas) p2;
            int posCorte = random.nextInt(this.nRainhas);

            List<Integer> genesP1Filho1 = this.genes.subList(ZERO.intValue(), posCorte);
            List<Integer> genesP2Filho1 = pai2.getGenes().subList(posCorte, this.genes.size());
            //TODO fazer o controle de numeros repetidos e preencher com os que estão faltando

            List<Integer> genesFilho1 = Stream.concat(genesP1Filho1.stream(), genesP2Filho1.stream())
                    .collect(Collectors.toList());
            Individuo filho1 = new IndividuoNRainhas(this.nRainhas, genesFilho1);

            List<Integer> genesP2Filho2 = pai2.getGenes().subList(ZERO.intValue(), posCorte);
            List<Integer> genesP1Filho2 = this.genes.subList(posCorte, this.genes.size());
            //TODO fazer o controle de numeros repetidos e preencher com os que estão faltando

            List<Integer> genesFilho2 = Stream.concat(genesP2Filho2.stream(), genesP1Filho2.stream())
                    .collect(Collectors.toList());
            Individuo filho2 = new IndividuoNRainhas(this.nRainhas, genesFilho2);


            return Arrays.asList(filho1, filho2);
        }

        return null;
    }

    /**
     * Retorna um indivíduo com duas posições aleatórias dos genes trocadas entre si
     * @return individuo mutante
     */
    @Override
    public Individuo getMutante() {
        List<Integer> posicoes = createPosicoes(nRainhas);
        int pos1 =  random.nextInt(posicoes.size());
        posicoes.remove(pos1);
        int pos2 =  random.nextInt(posicoes.size());
        posicoes.remove(pos2);

        return new IndividuoNRainhas(nRainhas, trocaGenes(pos1, pos2));
    }

    private List<Integer> trocaGenes(int pos1, int pos2) {
        List<Integer> genesMut = new ArrayList<>(this.genes);
        Integer genPos1 = genesMut.get(pos1);
        genesMut.add(pos1, genesMut.get(pos2));
        genesMut.add(pos2, genPos1);
        return genesMut;
    }

    @Override
    public String toString() {
        return String.format("nRainhas: %s \nAvaliação: %s", nRainhas, avaliacao);
    }

    public List<Integer> getGenes() {
        return this.genes;
    }
}
