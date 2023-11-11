package ControleDePonto;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ponto {
    private static Map<String, String> registros = new HashMap<>();

    public static void main(String[] args) {
        menuPonto();
    }

    public static void menuPonto() {
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Controle de Ponto" +
                "\n 1 - Registrar Entrada" +
                "\n 2 - Registrar Saída" +
                "\n 3 - Calcular Horas trabalhadas" +
                "\n 0 - Sair"));

        switch (opcao) {
            case 1:
                registrarEntrada();
                break;
            case 2:
                registrarSaida();
                break;
            case 3:
                calcularHoras();
                break;
            case 0:
                JOptionPane.showMessageDialog(null, "Encerrando...");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção não encontrada!");
                menuPonto();
                break;
        }
    }

    public static void registrarEntrada() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");
        String entradaAtual = JOptionPane.showInputDialog("Digite a hora de entrada (formato HH:mm):");
        registros.put(nome, entradaAtual);
        JOptionPane.showMessageDialog(null, "Entrada realizada com sucesso!");
        menuPonto();
    }

    private static void registrarSaida() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");

        if (registros.containsKey(nome)) {
            String saidaAtual = JOptionPane.showInputDialog("Digite a hora de saída (formato HH:mm):");
            registros.put(nome, registros.get(nome) + ";" + saidaAtual);
            JOptionPane.showMessageDialog(null, "Saída realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
        menuPonto();
    }

    private static void calcularHoras() {
        String nome = JOptionPane.showInputDialog("Digite seu nome:");

        if (registros.containsKey(nome)) {
            String[] horarios = registros.get(nome).split(";");
            String entrada = horarios[0];
            String saida = horarios[1];

            int minutosEntrada = converterParaMinutos(entrada);
            int minutosSaida = converterParaMinutos(saida);

            int minutosTrabalhados = minutosSaida - minutosEntrada;

            if (minutosTrabalhados < 0) {
                JOptionPane.showMessageDialog(null,
                        "Horas trabalhadas não podem ser negativas. Verifique os horários informados.");
            } else {
                int horasNormais = minutosTrabalhados / 60;
                int minutosNormais = minutosTrabalhados % 60;

                JOptionPane.showMessageDialog(null,
                        "Horas trabalhadas: " + horasNormais + " horas e " + minutosNormais + " minutos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado. Registre a entrada primeiro.");
        }
        menuPonto();
    }

    private static int converterParaMinutos(String hora) {
        String[] partes = hora.split(":");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return horas * 60 + minutos;
    }
}
