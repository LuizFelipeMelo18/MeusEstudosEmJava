package MegaSena;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class MegaSena {
    public static void main(String[] args) {
        int quantiApostas, numeroAposta;

        quantiApostas = Integer
                .parseInt(JOptionPane.showInputDialog("Digite a quantidade de apostas que você deseja fazer:"));

        numeroAposta = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de numeros por aposta:"));

        gerarApostas(quantiApostas, numeroAposta);
    }

    private static void gerarApostas(int quantiApostas, int numeroAposta) {
        Random random = new Random();
        for (int i = 1; i <= quantiApostas; i++) {
            int[] aposta = new int[numeroAposta];

            for (int j = 0; j < numeroAposta; j++) {
                int numero;
                do {
                    numero = random.nextInt(60) + 1;
                } while (contem(aposta, numero));
                aposta[j] = numero;
            }
            Arrays.sort(aposta);
            JOptionPane.showMessageDialog(null, "Aposta " + i + " : " + Arrays.toString(aposta));
        }

    }

    private static boolean contem(int[] array, int numero) {
        for (int elemento : array) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }
}