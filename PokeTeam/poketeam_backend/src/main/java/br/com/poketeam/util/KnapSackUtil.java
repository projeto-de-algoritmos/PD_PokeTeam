package br.com.poketeam.util;

public abstract class KnapSackUtil {
    public static Integer max(Integer a, Integer b) {
        return (a > b) ? a : b;
    }

    public static Integer knapSack(Integer W, Integer wt[], Integer val[], Integer n){
        Integer i, w;
        Integer K[][] = new Integer[n + 1][W + 1];

        for (i = 0; i<= n; i++) {
            for (w = 0; w<= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1]<= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }
}
