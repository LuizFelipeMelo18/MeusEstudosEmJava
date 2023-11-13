package ToDoList;

import javax.swing.JOptionPane;
import java.util.ArrayList;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaConcluida() {
        return concluida;
    }

    public void marcarConcluida() {
        concluida = true;
    }

    @Override
    public String toString() {
        return "[" + (concluida ? "X" : " ") + "] " + descricao;
    }
}

public class ToDoList {
    private ArrayList<Tarefa> tarefas;

    public ToDoList() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
        JOptionPane.showMessageDialog(null, "Tarefa adicionada com sucesso: " + descricao);
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa adicionada!");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                JOptionPane.showMessageDialog(null, "Tarefas: " + (i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    public void marcarTarefaConcluida(int indice) {
        if (indice >= 1 && indice <= tarefas.size()) {
            Tarefa tarefa = tarefas.get(indice - 1);
            tarefa.marcarConcluida();
            JOptionPane.showMessageDialog(null, "Tarefa marcada como concluída: " + tarefa.getDescricao());
        } else {
            JOptionPane.showMessageDialog(null, "Índice inválido!");
        }
    }

    public static void main(String[] args) {
        ToDoList todolist = new ToDoList();
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\n ==SISTEMA DE GERENCIAMENTO DE TAREFAS==" +
                    "\n1 - Adicionar tarefa" +
                    "\n2 - Listar tarefas" +
                    "\n3 - Marcar como concluída" +
                    "\n0 - Sair" +
                    "\nEscolha a opção:"));

            switch (opcao) {
                case 1:
                    String descricaoTarefa = JOptionPane.showInputDialog("Digite a descrição da tarefa:");
                    todolist.adicionarTarefa(descricaoTarefa);
                    break;
                case 2:
                    todolist.listarTarefas();
                    break;
                case 3:
                    int indiceTarefa = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o índice da tarefa a ser marcada como concluída:"));
                    todolist.marcarTarefaConcluida(indiceTarefa);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente!");
                    break;
            }
        } while (opcao != 0);
    }
}
