package ControleDeHora;

import java.util.ArrayList;
import javax.swing.JOptionPane;

class Atividade {
    String nome;
    String horaEntrada;
    String horaSaida;

    public Atividade(String nome, String horaEntrada, String horaSaida) {
        this.nome = nome;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }

    public int calcularEmMinutos() {
        int entradaMinutos = converterMinutos(horaEntrada);
        int saidaMinutos = converterMinutos(horaSaida);

        return saidaMinutos - entradaMinutos;
    }

    private int converterMinutos(String hora) {
        String[] partes = hora.split(":");

        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);

        return horas * 60 + minutos;
    }
}

public class controle {
    static ArrayList<Atividade> atividades;

    public static void main(String[] args) {
        atividades = new ArrayList<Atividade>();
        menu();
    }

    public static void menu() {
        int opcao;

        opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: " +
                "\n 1 - Registrar atividade" +
                "\n 2 - Exibir resumo" +
                "\n 3 - Sair"));

        switch (opcao) {
            case 1:
                registrarAtividade(atividades);
                break;
            case 2:
                exibirResumo(atividades);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Obrigado por utilizar nossos serviços <3");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção não encontrada!");
                menu();
                break;
        }
    }

    private static void registrarAtividade(ArrayList<Atividade> atividades) {
        String nome = JOptionPane.showInputDialog("Nome da atividade:");
        String horaEntrada = JOptionPane.showInputDialog("Hora de Inicio (HH:MM):");
        String horaSaida = JOptionPane.showInputDialog("Hora de saida (HH:MM):");

        Atividade atividade = new Atividade(nome, horaEntrada, horaSaida);
        atividades.add(atividade);
        JOptionPane.showMessageDialog(null, "Atividade registrada com sucesso!");
        menu();
    }

    private static void exibirResumo(ArrayList<Atividade> atividades) {
        if (atividades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma atividade registrada!");
            menu();
            return;
        }

        StringBuilder resumo = new StringBuilder("Resumo das atividades:\n");

        for (Atividade atividade : atividades) {
            int duracaoMinutos = atividade.calcularEmMinutos();

            resumo.append("Atividade: ").append(atividade.nome).append("\n");
            resumo.append("Duração: ").append(duracaoMinutos).append(" minutos\n\n");
        }

        JOptionPane.showMessageDialog(null, resumo.toString());
        menu();
    }
}
