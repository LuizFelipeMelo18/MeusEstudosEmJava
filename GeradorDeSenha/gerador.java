package GeradorDeSenha;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gerador {
    public static void main(String[] args) {
        int tamanhoSenha = 15;
        String senha = gerarSenha(tamanhoSenha);

        System.out.println("Senha gerada com sucesso: " + senha);
    }

    private static String gerarSenha(int tamanhoSenha) {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        List<Character> listaCaracter = new ArrayList<>();

        for (char c : caracteres.toCharArray()) {
            listaCaracter.add(c);
        }
        Collections.shuffle(listaCaracter);

        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < tamanhoSenha; i++) {
            senha.append(listaCaracter.get(random.nextInt(listaCaracter.size())));
        }
        return senha.toString();
    }
}
