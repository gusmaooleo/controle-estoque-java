import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
  public static void main(String[] arg) {
    Peca[] estoque = new Peca[5];

    //declarando os itens iniciais do estoque.
    estoque[0] = new RoupaTamanhoUnico("Camisa", 10, 5, 20);
    estoque[1] = new RoupaTamanhoUnico("Saia", 15, 7, 25);
    estoque[2] = new Acessorio("Cinto", 20, 8, 30);
    estoque[3] = new Acessorio("Pulseira", 12, 6, 18);
    estoque[4] = new RoupaPMG("Saída de praia", 8, 4, 15, 3, 3, 2);

    Scanner read = new Scanner(System.in);

    //interface principal.
    while (true) {
      System.out.println("Menu Principal:");
      System.out.println("1 - Adicionar ao Estoque");
      System.out.println("2 - Remover do Estoque");
      System.out.println("3 - Visualizar Estoque");
      System.out.println("4 - Alterar a Descrição do Produto");
      System.out.println("5 - Definir Nova Quantidade Mínima");
      System.out.println("6 - Definir Nova Quantidade Máxima");
      System.out.println("7 - Alterar Tipo do Produto");
      System.out.println("8 - Sair do Sistema");

      System.out.print("Escolha uma opção: ");
      int opcaoPrincipal = read.nextInt();
      System.out.println();
      switch (opcaoPrincipal) {
        case 1:
          adicionarAoEstoque(estoque, read);
          break;
        case 2:
          removerDoEstoque(estoque, read);
          break;
        case 3:
          visualizarEstoque(estoque);
          break;
        case 4:
          alterarDescricao(estoque, read);
          break;
        case 5:
          definirQuantidade(estoque, read, "mínima");
          break;
        case 6:
          definirQuantidade(estoque, read, "máxima");
          break;
        case 7:
          alterarTipo(estoque, read);
          break;
        case 8:
          //opção para sair do sistema.
          System.out.println("Saindo do Sistema...");
          System.exit(0);
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }

  //função adicionar ao estoque - trata de exibir os itens do estoque e incrementar o item selecionado.
  private static void adicionarAoEstoque(Peca[] estoque, Scanner read) {
    System.out.println("Escolha o produto para adicionar ao estoque:");
    for (int i = 0; i < estoque.length; i++) {
      System.out.println(i + " - " + estoque[i].getDesc());
    }
    try {
      System.out.print("Opção: ");
      int opcaoAdicionar = read.nextInt();
      System.out.println();
      if (opcaoAdicionar >= 0 && opcaoAdicionar < estoque.length) {
        estoque[opcaoAdicionar].repor();
        estoque[opcaoAdicionar].remocaoEstoque();
      } else {
        System.out.println("Opção inválida.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número inteiro.");
      read.next();
    }
    System.out.println();
  }

  //função remover do estoque - trata de exibir os itens do estoque e remover o item selecionado.
  private static void removerDoEstoque(Peca[] estoque, Scanner read) {
    System.out.println("Escolha o produto para remover do estoque:");
    for (int i = 0; i < estoque.length; i++) {
      System.out.println(i + " - " + estoque[i].getDesc());
    }
    try {
      System.out.print("Opção: ");
      int opcaoRemover = read.nextInt();
      System.out.println();
      if (opcaoRemover >= 0 && opcaoRemover < estoque.length) {
        estoque[opcaoRemover].venda();
        estoque[opcaoRemover].reposicaoEstoque();
      } else {
        System.out.println("Opção inválida.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número inteiro.");
      read.next();
    }
    System.out.println();
  }

  //mostra os itens e suas quantidades ->
  private static void visualizarEstoque(Peca[] estoque) {
    System.out.println("Estoque Atual:");
    for (Peca peca : estoque) {
      System.out.println(peca.getDesc() + ": " + peca.getQuant());
    }
    System.out.println();
  }

  //altera a descrição do produto.
  private static void alterarDescricao(Peca[] estoque, Scanner read) {
    System.out.println("Escolha o produto para alterar a descrição no estoque:");
    for (int i = 0; i < estoque.length; i++) {
      System.out.println(i + " - " + estoque[i].getDesc());
    }
    try {
      System.out.print("Opção: ");
      int opcao = read.nextInt();
      System.out.println();
      if (opcao >= 0 && opcao < estoque.length) {
        System.out.print("Escolha uma nova descrição para o produto: ");
        String newDesc = read.next();
        estoque[opcao].setDesc(newDesc);
      } else {
        System.out.println("Opção inválida.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número inteiro.");
      read.next();
    }
    System.out.println();
  }

  //define a quantidade do produto no estoque.
  private static void definirQuantidade(Peca[] estoque, Scanner read, String type) {
    System.out.println("Escolha o produto para alterar a quantidade " + type + " :");
    for (int i = 0; i < estoque.length; i++) {
      System.out.println(i + " - " + estoque[i].getDesc());
    }
    try {
      System.out.print("Opção: ");
      int opcao = read.nextInt();
      System.out.println();
      if (opcao >= 0 && opcao < estoque.length) {
        System.out.print("Escolha uma nova quantidade " + type + " para o produto: ");
        int quant = read.nextInt();
        if (Objects.equals(type, "máxima")) {
          estoque[opcao].setMax(quant);
        } else {
          estoque[opcao].setMin(quant);
        }
      } else {
        System.out.println("Opção inválida.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número inteiro.");
      read.next();
    }
    System.out.println();
  }

  //muda o tipo do produto (acessório, roupa tamanho único, roupa PMG) e suas informações (descrição, quantidade, quantidade máxima e mínima ou a quantidade de p, m ou g - roupa PMG).
  private static void alterarTipo(Peca[] estoque, Scanner read) {
    System.out.println("Escolha o produto para alterar o tipo:");
    for (int i = 0; i < estoque.length; i++) {
      System.out.println(i + " - " + estoque[i].getDesc());
    }
    try {
      System.out.print("Opção: ");
      int opcao = read.nextInt();
      System.out.println();
      if (opcao >= 0 && opcao < estoque.length) {
        System.out.println("Escolha um novo tipo para o produto: ");
        System.out.println("1 - Acessório");
        System.out.println("2 - Roupa Tamanho Único");
        System.out.println("3 - Roupa Tamanho P, M ou G");
        System.out.print("Opção: ");
        int num = read.nextInt();
        System.out.println();
        if (num == 1) {
          moduloMudaTipo(estoque, read, "acessório", num, opcao);
        } else if (num == 2) {
          moduloMudaTipo(estoque, read, "Roupa Tamanho Único", num, opcao);
        } else if (num == 3) {
          moduloMudaTipo(estoque, read, "Roupa Tamanho P, M ou G", num, opcao);
        } else {
          System.out.println("Opção inválida.");
        }
      } else {
        System.out.println("Opção inválida.");
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número inteiro.");
      read.next();
    }
    System.out.println();
  }

  //modulação da mudança de tipo.
  private static void moduloMudaTipo(Peca[] estoque, Scanner read, String tipo, int num, int opcao) {
    try {
      System.out.print("Escolha uma descrição para " + tipo + ": ");
      String desc = read.next();

      System.out.print("Escolha uma quantidade atual: ");
      int quant = read.nextInt();

      System.out.print("Escolha uma quantidade mínima: ");
      int min = read.nextInt();

      System.out.print("Escolha uma quantidade máxima: ");
      int max = read.nextInt();

      if (num == 1) {
        estoque[opcao] = new RoupaTamanhoUnico(desc, quant, min, max);
        estoque[opcao].reposicaoEstoque();
        estoque[opcao].remocaoEstoque();
      } else if (num == 2) {
        estoque[opcao] = new Acessorio(desc, quant, min, max);
        estoque[opcao].reposicaoEstoque();
        estoque[opcao].remocaoEstoque();
      } else {
        System.out.print("Escolha uma quantidade de P: ");
        int quantP = read.nextInt();

        System.out.print("Escolha uma quantidade de M: ");
        int quantM = read.nextInt();

        System.out.print("Escolha uma quantidade de G: ");
        int quantG = read.nextInt();

        estoque[opcao] = new RoupaPMG(desc, quant, min, max, quantP, quantM, quantG);
        estoque[opcao].reposicaoEstoque();
        estoque[opcao].remocaoEstoque();
      }
    } catch (InputMismatchException e) {
      System.out.println("Entrada inválida. Digite um número inteiro.");
      read.next();
    }
    System.out.println();
  }
}
