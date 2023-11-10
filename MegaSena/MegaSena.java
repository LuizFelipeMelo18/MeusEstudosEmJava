package MegaSena;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class MegaSena {
    public static void main(String[] args) {
        int numero, i, j;
        int[] mega = new int[10];
        Random r = new Random();
        for (i = 0; i < mega.length; i++) {
            numero = r.nextInt(60) + 1;

            for (j = 0; j < mega.length; j++) {
                if (numero == mega[j] && j != i) {
                    numero = r.nextInt(60) + i;
                } else {
                    mega[i] = numero;
                }
            }
        }

        for (i = 0; i < mega.length; i++) {
            for (j = i + 1; j < mega.length; j++) {
                if (mega[i] > mega[j]) {
                    numero = mega[i];
                    mega[i] = mega[j];
                    mega[j] = numero;
                }
            }
        }

        JOptionPane.showMessageDialog(null, Arrays.toString(mega), "Seus numeros são:",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
