package utils;

import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ZERO;

public class Utils {

    public static int MENOS_UM = -1;

    public static List<Integer> criarPosicoes(int max) {
        List<Integer> posicoes = new ArrayList<>(max);
        for(int i = ZERO.intValue(); i < max; i++) {
            posicoes.add(i);
        }
        return posicoes;
    }
}
