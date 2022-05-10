package utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class Utils {

    public static int MENOS_UM = -1;
    public static int DOIS = 2;

    public static List<Integer> criarPosicoes(int max) {
        List<Integer> posicoes = new ArrayList<>(max);
        for(int i = ZERO.intValue(); i < max; i++) {
            posicoes.add(i);
        }
        return posicoes;
    }

    public static List<Integer> iniciarLista(int max) {
        List<Integer> lista = new ArrayList<>(max);
        for(int i = ZERO.intValue(); i < max; i++) {
            lista.add(MENOS_UM);
        }
        return lista;
    }

}
