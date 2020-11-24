package net.iessanclemente.pmdm.pmdm02_calculadora.service;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * CalculadoraPrimos
 */
public class CalculadoraPrimos {

    private final static Map<Integer, Integer> mapNumerosCalculados = new HashMap<>();

    /**
     * Calcular Primo
     * @param numero
     * @return
     */
    public static Integer calcularPrimo (final Integer numero) {
        final String TAG = "calcularPrimo";

        Integer numeroPrimo;

        // Comprobamos si o número esta no Map calculado
        if (mapNumerosCalculados.containsKey(numero)) {
            numeroPrimo = mapNumerosCalculados.get(numero);
        } else {
            // Como non esta no Mapa temolo que calcular
            Integer contadorPrimos = 0;
            numeroPrimo = 1;

            // Como se gardan todos os números primos buscamos o maior gardado
            if (mapNumerosCalculados.containsKey(mapNumerosCalculados.size())) {
                contadorPrimos = mapNumerosCalculados.size();
                numeroPrimo = mapNumerosCalculados.get(contadorPrimos);
            }

            while(contadorPrimos<numero) {
                numeroPrimo++;
                if (esPrimo(numeroPrimo)) {
                    contadorPrimos++;
                    Log.i(TAG, String.format("El número %s es un número primo y esta en la posicion %s", numeroPrimo, contadorPrimos));
                    // Gardamos todos os numeros primos xa calculados
                    mapNumerosCalculados.put(contadorPrimos, numeroPrimo);
                }
            }

        }

        return numeroPrimo;
    }

    /**
     * Comprobar si un número es Primo
     * @param numero
     * @return
     */
    private static boolean esPrimo (final Integer numero) {

        boolean esPrimo = Boolean.FALSE;

        int contador = 0;
        for (int i = 2; i < numero; i++) {
            if (numero%i==0) {
                contador++;
                break;
            }
        }

        // Contador si es un numero primo
        if (contador == 0) {
            esPrimo = Boolean.TRUE;
        }

        return esPrimo;
    }

}
