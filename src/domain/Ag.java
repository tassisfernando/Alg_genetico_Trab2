package domain;

import domain.factory.IndividuoFactory;

import java.util.List;

public class Ag {

    public Individuo executar(int nPop, IndividuoFactory indFactory, int nElite, boolean isMax, int nGer) {
        // TODO for para criar nPop individuos em uma lista

        // TODO aleatoriamente selecionar duplas de indivíduos para o crossover

        /*
         * TODO para cada dupla {
         *      List<Individuo> fList = p1.getFilho(p2);
         *      filhosList.addAll(fList);
         * }
         */

        /*
         * TODO para cada pai {
         *      Individuo mut = p.getMutante(p2);
         *      mutantesList.add(mut);
         * }
         */

        /* TODO
            List<Individuo> joinPop = new ArrayList<>();
            joinPop.addAll(pop);
            joinPop.addAll(filhosList);
            joinPop.addAll(mutantesList);
         */

        /* TODO
            Selecionar os nElite individuos p/ newPop
            Utilizar lst.stream()
                         .sorted(Comparator.reverseOrder())
                         .limit(5)
                         .collect(Collectors.toList());
         */

        /* TODO
            List<Individuo> restanteList = this.roleta(joinPop, nPop - nElite, isMax);
            newPop.addAll(restanteList);
            popIni.clear();
            popIni.addAll(newPop);
         */

        /* TODO
            Retornar ao ponto de gerar filho e mutantes. Fazendo isto, nGer gerações
            return do melhor da última geração
         */

        return null;
    }

    private List<Individuo> roleta(List<Individuo> joinPop, int nRestantes, boolean isMax) {
        return null;
    }
}
