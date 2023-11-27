public class RoupaTamanhoUnico extends Peca implements Item {
  //construtor ->
  public RoupaTamanhoUnico(String desc, int quant, int min, int max) {
    super(desc, quant, min, max);
  }

  //método venda ->
  @Override
  public void venda() {
    setQuant(getQuant() - 1);
  }

  //método repor ->
  @Override
  public void repor() {
    setQuant(getQuant() + 1);
  }
}
