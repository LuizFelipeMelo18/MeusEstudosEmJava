package SistemaDeAutenticacao;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Autenticacao {
    private static final int MAX_TENTATIVAS = 3;
    private static final Map<String, String> credenciais = new HashMap<>();
    private static final Map<String, Integer> tentativasErradas = new HashMap<>();

    public static void main(String[] args) {
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");

        inicializarCredenciais();

        while (true) {
            String usuario = JOptionPane.showInputDialog("Digite seu nome:");

            if (verificarUsuario(usuario)) {
                int tentativas = 0;

                while (tentativas < MAX_TENTATIVAS) {
                    String senha = JOptionPane.showInputDialog("Digite sua senha:");

                    if (verificarSenha(usuario, senha)) {
                        JOptionPane.showMessageDialog(null, "Autenticação feita com sucesso! Bem Vindo " + usuario);
                        break;
                    } else {
                        tentativas++;
                        JOptionPane.showMessageDialog(null,
                                "Senha incorreta, tentativa " + tentativas + " de " + MAX_TENTATIVAS);

                        if (tentativas == MAX_TENTATIVAS) {
                            JOptionPane.showMessageDialog(null, "Você excedeu o limite de tentativas.");
                            int opcao = JOptionPane.showConfirmDialog(null, "Deseja redefinir sua senha?");

                            if (opcao == JOptionPane.YES_OPTION) {
                                redefinirSenha(usuario, senha);
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não encontrado!");
            }
        }
    }

    private static void inicializarCredenciais() {
        credenciais.put("Chedarzin", "123456");
        credenciais.put("NoobMaster123", "thordeusdotrovao");
    }

    private static boolean verificarUsuario(String usuario) {
        return credenciais.containsKey(usuario);
    }

    private static boolean verificarSenha(String usuario, String senha) {
        String senhaSalva = credenciais.get(usuario);
        return senhaSalva != null && senhaSalva.equals(senha);
    }

    private static void redefinirSenha(String usuario, String senha) {
        String novaSenha = JOptionPane.showInputDialog("Digite sua nova senha:");
        credenciais.put(usuario, novaSenha);
        JOptionPane.showMessageDialog(null, "Senha redefinida com sucesso!");
    }
}
