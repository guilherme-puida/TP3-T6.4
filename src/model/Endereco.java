package model;

public class Endereco {
  private String bairro;
  private String rua;
  private String numero;
  private String cep;

  public Endereco(String bairro, String rua, String numero, String cep) {
    this.bairro = bairro;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
  }

  public String stringEndereco() {
    return String.format("%s %s-%s (%s)", bairro, rua, numero, cep);
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
