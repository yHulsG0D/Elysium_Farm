package dev.huls.elysium_farm.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NumberFormatter {

    // Mapa de sufixos para as magnitudes dos números
    private static final NavigableMap<BigDecimal, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(BigDecimal.valueOf(1_000L), "K");
        suffixes.put(BigDecimal.valueOf(1_000_000L), "M");
        suffixes.put(BigDecimal.valueOf(1_000_000_000L), "B");
        suffixes.put(BigDecimal.valueOf(1_000_000_000_000L), "T");
        suffixes.put(BigDecimal.valueOf(1_000_000_000_000_000L), "Qa");
        suffixes.put(BigDecimal.valueOf(1_000_000_000_000_000_000L), "Qi");
        suffixes.put(new BigDecimal("1000000000000000000000"), "Sx"); // 10^21
        suffixes.put(new BigDecimal("1000000000000000000000000"), "Sp"); // 10^24
        suffixes.put(new BigDecimal("1000000000000000000000000000"), "Oc"); // 10^27
        suffixes.put(new BigDecimal("1000000000000000000000000000000"), "No"); // 10^30
        suffixes.put(new BigDecimal("1000000000000000000000000000000000"), "Dc"); // 10^33
        suffixes.put(new BigDecimal("1000000000000000000000000000000000000"), "UnDc"); // 10^36
        suffixes.put(new BigDecimal("1000000000000000000000000000000000000000"), "DoDc"); // 10^39
    }

    /**
     * Formata um número longo em uma representação mais legível com sufixos.
     *
     * @param value O número a ser formatado.
     * @return A representação formatada do número.
     */
    public static String formatNumber(long value) {
        return formatBigDecimal(BigDecimal.valueOf(value));
    }

    /**
     * Formata um número grande em uma representação mais legível com sufixos.
     *
     * @param value O número grande a ser formatado.
     * @return A representação formatada do número.
     */
    public static String formatBigDecimal(BigDecimal value) {
        if (value.compareTo(BigDecimal.valueOf(1_000)) < 0) {
            return value.toString();
        }

        // Encontra o maior valor em nosso mapa que é menor ou igual ao valor
        BigDecimal divideBy = suffixes.floorKey(value);
        String suffix = suffixes.get(divideBy);

        BigDecimal truncated = value.divide(divideBy, 2, BigDecimal.ROUND_DOWN);
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(truncated) + suffix;
    }
}