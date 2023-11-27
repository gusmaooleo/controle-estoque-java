import java.util.Scanner;

public class RoupaPMG extends Peca implements Item {
  private int quantP;
  private int quantM;
  private int quantG;

  public RoupaPMG (String desc, int quant, int min, int max, int quantP, int quantM, int quantG) {
    super(desc, quant, min, max);
    this.quantP = quantP;
    this.quantM = quantM;
    this.quantG = quantG;
  }

  @Override
  public void venda() {
    Scanner read = new Scanner(System.in);
    System.out.print("Indique o tamanho do item a ser vendido (P, M ou G): ");
    char size = read.next().charAt(0);
    System.out.println();

    switch (size) {
      case 'P':
        quantP--;
        break;
      case 'M':
        quantM--;
        break;
      case 'G':
        quantG--;
        break;
      default:
        System.out.println("tamanho inválido.");
    }
  }

  @Override
  public void repor() {
    Scanner read = new Scanner(System.in);
    System.out.print("Indique o tamanho do item a ser reposto (P, M ou G): ");
    char size = read.next().charAt(0);
    System.out.println();

    switch (size) {
      case 'P':
        quantP++;
        break;
      case 'M':
        quantM++;
        break;
      case 'G':
        quantG++;
        break;
      default:
        System.out.println("tamanho inválido.");
    }
  }

  @Override
  public void reposicaoEstoque() {
    super.reposicaoEstoque();
    if (quantP < getMin()) {
      quantP = getMax();
    }
    if (quantM < getMin()) {
      quantM = getMax();
    }
    if (quantG < getMin()) {
      quantG = getMax();
    }
  }
}
