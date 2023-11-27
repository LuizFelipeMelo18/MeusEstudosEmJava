package ReservaDeSala;

import javax.swing.JOptionPane;
import java.util.ArrayList;

class Sala{
    private String nome;
    private boolean disponivel;

    public Sala(String nome){
        this.nome = nome;
        this.disponivel = true;
    }

    public String getnome(){
        return nome;
    }

    
}