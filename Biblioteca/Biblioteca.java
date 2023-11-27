package Biblioteca;

import javax.swing.JOptionPane;

class Item {
   private String inicioEmprestimo;
   private String fimEmprestimo;

   public Item(String inicioEmprestimo, String fimEmprestimo) {
      this.inicioEmprestimo = inicioEmprestimo;
      this.fimEmprestimo = fimEmprestimo;
   }

   public String getInicioEmprestimo() {
      return inicioEmprestimo;
   }

   public void setInicioEmprestimo(String inicioEmprestimo) {
      this.inicioEmprestimo = inicioEmprestimo;
   }

   public String getFimEmprestimo() {
      return fimEmprestimo;
   }

   public void setFimEmprestimo(String fimEmprestimo) {
      this.fimEmprestimo = fimEmprestimo;
   }

}

class Livro extends Item {
   private String codigoISBN;
   private String autor;
   private String titulo;

   public Livro(String codigoISBN, String autor, String titulo, String inicioEmprestimo, String fimEmprestimo) {
      super(inicioEmprestimo, fimEmprestimo);
      this.titulo = titulo;
      this.codigoISBN = codigoISBN;
      this.autor = autor;
   }

   public String getAutor() {
      return autor;
   }

   public void setAutor(String autor) {
      this.autor = autor;
   }

   public String getCodigoISBN() {
      return codigoISBN;
   }

   public void setCodigoISBN(String codigoISBN) {
      this.codigoISBN = codigoISBN;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }
}

class DVD extends Item {
   private int tempoDuracao;
   private String produtora;

   public DVD(int tempoDuracao, String produtora, String inicioEmprestimo, String fimEmprestimo) {
      super(inicioEmprestimo, fimEmprestimo);
      this.produtora = produtora;
      this.tempoDuracao = tempoDuracao;
   }

   public int getTempoDuracao() {
      return tempoDuracao;
   }

   public void setTempoDuracao(int tempoDuracao) {
      this.tempoDuracao = tempoDuracao;
   }

   public String getProdutora() {
      return produtora;
   }

   public void setProdutora(String produtora) {
      this.produtora = produtora;
   }
}

public class Biblioteca {
   public static void main(String[] args) {
      JOptionPane.showMessageDialog(null, "Vamos fazer o cadastro do livro");
      String isbn, autorLivro, tituloLivro, inicioDataEmprestimo, fimDataEmprestimo;

      isbn = JOptionPane.showInputDialog("Digite o codigo de barras:");
      autorLivro = JOptionPane.showInputDialog("Digite o autor do livro:");
      tituloLivro = JOptionPane.showInputDialog("Digite o titulo do livro:");
      inicioDataEmprestimo = JOptionPane.showInputDialog("Data de inicio do emprestimo:");
      fimDataEmprestimo = JOptionPane.showInputDialog("Data do fim do emprestimo:");

      Livro livro = new Livro(isbn, autorLivro, tituloLivro, inicioDataEmprestimo, fimDataEmprestimo);

      String produtoraDVD, inicioDataEmprestimoDVD, fimDataEmprestimoDVD;
      int duracaoDVD;

      duracaoDVD = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo de duração do DVD (em minutos):"));
      produtoraDVD = JOptionPane.showInputDialog("Digite o nome da produtora do DVD:");
      inicioDataEmprestimoDVD = JOptionPane.showInputDialog("Data de inicio do emprestimo do DVD:");
      fimDataEmprestimoDVD = JOptionPane.showInputDialog("Data do fim do emprestimo do DVD:");

      DVD dvd = new DVD(duracaoDVD, produtoraDVD, inicioDataEmprestimoDVD, fimDataEmprestimoDVD);

      JOptionPane.showMessageDialog(null, "Dados do livro:");
      imprimirDados(livro);

      JOptionPane.showMessageDialog(null, "Dados do DVD:");
      imprimirDados(dvd);
   }

   private static void imprimirDados(Item item) {
      if (item instanceof Livro) {
         JOptionPane.showMessageDialog(null, "Data de inicio do emprestimo: " + item.getInicioEmprestimo());
         JOptionPane.showMessageDialog(null, "Data do fim do emprestimo: " + item.getFimEmprestimo());

         Livro livro = (Livro) item;
         JOptionPane.showMessageDialog(null, "Codigo ISBN: " + livro.getCodigoISBN() +
               "\nAutor: " + livro.getAutor() +
               "\nTitulo: " + livro.getTitulo());
      } else if (item instanceof DVD) {
         JOptionPane.showMessageDialog(null, "Data de inicio do emprestimo: " + item.getInicioEmprestimo());
         JOptionPane.showMessageDialog(null, "Data do fim do emprestimo: " + item.getFimEmprestimo());

         DVD dvd = (DVD) item;
         JOptionPane.showMessageDialog(null, "Tempo de duração: " + dvd.getTempoDuracao() + " em minutos." +
               "\nProdutora: " + dvd.getProdutora());
      }
   }
}
