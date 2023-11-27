public abstract class Peca {
  private String desc;
  private int quant;
  private int min;
  private int max;

  //construtor ->
  public Peca(String desc, int quant, int min, int max) {
    this.desc = desc;
    this.quant = quant;
    this.min = min;
    this.max = max;
  }

  public abstract void venda();
  public abstract void repor();


  //getters e setters ->
  public String getDesc() {
    return desc;
  }

  public void setDesc(String descricao) {
    this.desc = descricao;
  }

  public int getQuant() {
    return quant;
  }

  public void setQuant(int quantidade) {
    this.quant = quantidade;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int estoqueMinimo) {
    this.min = estoqueMinimo;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int estoqueMaximo) {
    this.max = estoqueMaximo;
  }

  //metódo reposição de estoque ->
  public void reposicaoEstoque() {
    if (getQuant() < getMin()) {
      setQuant(getMin());
    }
  }

  //metódo remoção do estoque ->
  public void remocaoEstoque() {
    if (getQuant() > getMax()) {
      setQuant(getMax());
    }
  }
}