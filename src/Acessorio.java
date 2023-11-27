import java.util.Scanner;

public class Acessorio extends Peca implements Item {
  //construtor ->
  public Acessorio(String desc, int quant, int min, int max) {
    super(desc, quant, min, max);
  }

  //método venda ->
  @Override
  public void venda() {
    Scanner read = new Scanner(System.in);
    System.out.print("Informe quantos acessórios '" + getDesc() + "' foram vendidos : ");
    int amount = read.nextInt();
    System.out.println();
    setQuant(getQuant() - amount);
  }

  //método repor ->
  @Override
  public void repor() {
    Scanner read = new Scanner(System.in);
    System.out.print("Informe a quantidade de acessórios '" + getDesc() + "' serão adicionados no estoque: ");
    int amount = read.nextInt();
    System.out.println();
    setQuant(getQuant() + amount);
  }
}
