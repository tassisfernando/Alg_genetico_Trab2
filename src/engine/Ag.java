package engine;

import model.factory.IndividuoFactory;
import model.individuo.Individuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.util.Collections.shuffle;
import static java.util.Comparator.reverseOrder;
import static utils.Utils.printInd;

public class Ag {

    private Random random;

    public Ag() {
        random = new Random();
    }

    public Individuo executar(int nPop, IndividuoFactory indFactory, int nElite, boolean isMax, int nGer, double desloc) {
        List<Individuo> popPais = new ArrayList<>();
        List<Individuo> popFilhos;
        List<Individuo> popMutantes;
        List<Individuo> popJoin = new ArrayList<>();
        List<Individuo> popNova = new ArrayList<>();
        List<Individuo> popElite;

        // Laço para criar nPop individuos em uma lista
        for(int i = 0; i < nPop; i++) {
            popPais.add(indFactory.getIndividuo());
        }

        for(int i = 0; i < nGer; i++) {
            // Embaralha os pais
            shuffle(popPais);

            // Faz o crossover
            popFilhos = crossOver(popPais);

            // Faz a mutação
            popMutantes = getMutantes(popPais);

            // Faz o join de toda a população
            popJoin.addAll(popPais);
            popJoin.addAll(popFilhos);
            popJoin.addAll(popMutantes);

            // Avalia todos os indivíduos
            popJoin.forEach(Individuo::getAvaliacao);

            // Seleciona os nElite melhores
            popElite = selecionaElite(popJoin, isMax, nElite);
            popNova.addAll(popElite);
            popJoin.removeAll(popElite);

            // Seleciona pela roleta o restante
            List<Individuo> restanteList = this.selecao(popJoin, nPop - nElite, isMax, desloc);
            popNova.addAll(restanteList);

            popNova = isMax ?
                    popNova.stream().sorted(reverseOrder()).collect(Collectors.toList()) :
                    popNova.stream().sorted().collect(Collectors.toList());

            popPais.clear();
            popPais.addAll(popNova);
            popJoin.clear();
            popNova.clear();
            popElite.clear();
            popMutantes.clear();
            popFilhos.clear();

            printInd(popPais.stream().findFirst().get(), i);
        }

        return popPais.stream().findFirst().orElse(null);
    }

    private List<Individuo> crossOver(List<Individuo> popPais) {
        List<Individuo> auxPais = new ArrayList<>(popPais);
        List<Individuo> popFilhos = new ArrayList<>();

        while(!auxPais.isEmpty()) {
            int pos1 = random.nextInt(auxPais.size());
            Individuo pai1 = auxPais.get(pos1);
            auxPais.remove(pos1);
            int pos2 = random.nextInt(auxPais.size());
            Individuo pai2 = auxPais.get(pos2);
            auxPais.remove(pos2);

            List<Individuo> filhos = pai1.getFilhos(pai2);
            popFilhos.addAll(filhos);
        }

        return popFilhos;
    }

    private List<Individuo> getMutantes(List<Individuo> popPais) {
        List<Individuo> popMutantes = new ArrayList<>();
        for(Individuo pai : popPais) {
            Individuo mutante = pai.getMutante();
            popMutantes.add(mutante);
        }

        return popMutantes;
    }

    private List<Individuo> selecionaElite(List<Individuo> popJoin, boolean isMax, int nElite) {
        return isMax ?
                popJoin.stream().sorted(reverseOrder()).limit(nElite).collect(Collectors.toList()) :
                popJoin.stream().sorted().limit(nElite).collect(Collectors.toList());
    }

    private List<Individuo> selecao(List<Individuo> joinPop, int nRestantes, boolean isMax, double desloc) {
        List<Individuo> popTemp = new ArrayList<>(joinPop);
        List<Individuo> popSelec = new ArrayList<>();
        shuffle(popTemp);

        Individuo escolhido;
        for(int i = ZERO.intValue(); i < nRestantes; i++) {
            escolhido = roleta(popTemp, isMax, desloc);
            popSelec.add(escolhido);
            popTemp.remove(escolhido);
        }

        return popSelec;
    }

    private Individuo roleta(List<Individuo> pop, boolean isMax, double desloc) {
        double somaAvaliacao = calculaSomaAvaliacoes(pop, isMax, desloc);

        double limite = Math.random() * somaAvaliacao;
        Double aux = ZERO.doubleValue();
        int pos;

        for(pos = ZERO.intValue(); ((pos < pop.size()) && (aux < limite)); pos++) {
            aux += pop.get(pos).getAvaliacao() + desloc;
        }

        pos = (pos != ZERO.intValue()) ? pos - ONE.intValue() : pos;

        return pop.get(pos);
    }

    private Double calculaSomaAvaliacoes(List<Individuo> pop, boolean isMax, double desloc) {
        return isMax ?
                pop.stream().mapToDouble(individuo -> individuo.getAvaliacao() + desloc).sum() :
                pop.stream().mapToDouble(individuo -> desloc + (ONE.doubleValue() / individuo.getAvaliacao())).sum();
    }
}
