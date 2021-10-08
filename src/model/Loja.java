package model;

import java.time.LocalDate;
import java.util.*;

/**
 * Classe que representa a loja. Guarda e configura os clientes, funcionarios, vendas e estoque.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class Loja {
  private static final Loja instance = new Loja();

  private final Estoque estoque;
  private final ArrayList<Funcionario> funcionarios;
  private final ArrayList<Cliente> clientes;
  private final ArrayList<Venda> vendas;

  private int clienteId = 0;
  private int funcionarioId = 0;
  private int produtoId = 0;
  private int vendaId = 0;

  /**
   * Guarda os clientes, funcionarios, vendas e estoque* em ArrayLists.
   */
  private Loja() {
    this.estoque = new Estoque();
    this.funcionarios = new ArrayList<>();
    this.clientes = new ArrayList<>();
    this.vendas = new ArrayList<>();
  }

  public static Loja getInstance() {
    return instance;
  }

  /**
   * Cadastra um novo cliente na lista de clientes
   * @param id representa o id do cliente.
   * @param idade representa a idade do cliente.
   * @param nome representa o nome do cliente.
   * @param cpf representa o cpf do cliente.
   * @param telefone representa o telefone do cliente.
   * @param email representa o email do cliente.
   * @param endereco representa o endereço do cliente.
   * @param categoria representa a categoria do cliente.
   */
  public void cadastrarCliente(int id, int idade, String nome, String cpf, String telefone,
                               String email, Endereco endereco, String categoria) {
    clientes.add(new Cliente(id, idade, nome, cpf, telefone, email, endereco, categoria));
  }

  /**
   * Cadastra um novo funcionário na lista de funcionários
   * @param id representa o id do funcionario.
   * @param idade representa a idade do funcionario.
   * @param nome representa o nome do funcionario.
   * @param cpf representa o cpf do funcionario.
   * @param telefone representa o telefone do funcionario.
   * @param email representa o email do funcionario.
   * @param endereco representa o endereço do funcionario.
   * @param salario representa o salario do funcionario.
   * @param cargo representa o cargo do funcionario.
   */
  public void cadastrarFuncionario(int id, int idade, String nome, String cpf, String telefone,
                                   String email, Endereco endereco, double salario, String cargo) {
    funcionarios.add(new Funcionario(id, idade, nome, cpf, telefone, email, endereco, salario,
            cargo));
  }

  /**
   * Cadastra uma nova barra na lista de chocolates
   * @param id representa o id da barra.
   * @param peso representa o peso da barra.
   * @param nome representa o nome da barra.
   * @param descricao representa a descrição da barra.
   * @param tipo representa o tipo da barra.
   * @param dataCompra representa a data da compra da barra.
   * @param precoCompra representa o preço de compra da barra.
   * @param precoVenda representa o preço de venda da barra.
   * @param porcentagemCacau representa a porcentagem de cacau da barra.
   * @param contemGluten representa a opção de glutem da barra.
   * @param contemLactose representa a opção de lactose da barra.
   * @param artesanal representa a opção artesanal da barra.
   * @param sabor representa o sabor da barra.
   * @param nibs representa os nibs da barra.
   * @param quantidade representa a quantidade de barras que serão cadastradas.
   */
  public void cadastrarBarra(int id, int peso, String nome, String descricao, String tipo,
                             LocalDate dataCompra, double precoCompra, double precoVenda,
                             double porcentagemCacau, boolean contemGluten, boolean contemLactose
          , boolean artesanal, String sabor, String[] nibs, int quantidade) {
    estoque.adicionarChocolate(new Barra(id, peso, nome, descricao, tipo, dataCompra, precoCompra
            , precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal, sabor, nibs),
            quantidade);
  }

  /**
   * Cadastra uma nova trufa na lista de chocolates
   * @param id representa o id da trufa.
   * @param peso representa o peso da trufa.
   * @param nome representa o nome da trufa.
   * @param descricao representa a descrição da trufa.
   * @param tipo representa o tipo da trufa.
   * @param dataCompra representa a data da compra da trufa.
   * @param precoCompra representa o preço de venda da trufa.
   * @param precoVenda representa o preço de venda da trufa.
   * @param porcentagemCacau representa a porcentagem de cacau da trufa.
   * @param contemGluten representa a opção de glutem da trufa.
   * @param contemLactose representa a opção de lactose da trufa.
   * @param artesanal representa a opção artesanal da trufa.
   * @param recheio representa o recheio da trufa.
   * @param alcoolico representa a opção alcoolica da trufa.
   * @param quantidade representa a quantidade de trufas que serão cadastradas.
   */
  public void cadastrarTrufa(int id, int peso, String nome, String descricao, String tipo,
                             LocalDate dataCompra, double precoCompra, double precoVenda,
                             double porcentagemCacau, boolean contemGluten, boolean contemLactose
          , boolean artesanal, String recheio, boolean alcoolico, int quantidade) {
    estoque.adicionarChocolate(new Trufa(id, peso, nome, descricao, tipo, dataCompra, precoCompra
            , precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal, recheio,
            alcoolico), quantidade);
  }

  /**
   * Cadastra um novo chocotone na lista de chocolates
   * @param id representa o id do Chocotone.
   * @param peso representa o peso do Chocotone.
   * @param nome representa o nome do Chocotone.
   * @param descricao representa a descrição do Chocotone.
   * @param tipo representa o tipo do Chocotone.
   * @param dataCompra representa a data da compra do Chocotone.
   * @param precoCompra representa o preço de venda do Chocotone.
   * @param precoVenda representa o preço de venda do Chocotone.
   * @param porcentagemCacau representa a porcentagem de cacau do Chocotone.
   * @param contemGluten representa a opção de glutem do Chocotone.
   * @param contemLactose representa a opção de lactose do Chocotone.
   * @param artesanal representa a opção artesanal do Chocotone.
   * @param recheio representa o recheio do Chocotone
   * @param frutas representa as frutas do Chocotone
   * @param quantidade representa a quantidade de chocotones que serão cadastrados.
   */
  public void cadastrarChocotone(int id, int peso, String nome, String descricao, String tipo,
                                 LocalDate dataCompra, double precoCompra, double precoVenda,
                                 double porcentagemCacau, boolean contemGluten,
                                 boolean contemLactose, boolean artesanal, String recheio,
                                 String[] frutas, int quantidade) {
    estoque.adicionarChocolate(new Chocotone(id, peso, nome, descricao, tipo, dataCompra,
            precoCompra, precoVenda, porcentagemCacau, contemGluten, contemLactose, artesanal,
            recheio, frutas), quantidade);
  }

  /**
   * Soma 1 ao id do cliente e o retorna.
   * @return Id do Cliente.
   */
  public int getProximoIdCliente() {
    clienteId++;
    return clienteId;
  }

  /**
   * Retorna o proximo id do cliente.
   * @return Id do cliente + 1.
   */
  public int showProximoIdCliente() {
    return clienteId + 1;
  }

  /**
   * Soma 1 ao id do funcionario e o retorna.
   * @return Id do Funcionario.
   */
  public int getProximoIdFuncionario() {
    funcionarioId++;
    return funcionarioId;
  }

  /**
   * Retorna o proximo id do funcionario.
   * @return Id do funcionario + 1.
   */
  public int showProximoIdFuncionario() {
    return funcionarioId + 1;
  }

  /**
   * Soma 1 ao id do chocolate e o retorna.
   * @return Id do chocolate.
   */
  public int getProximoIdChocolate() {
    produtoId++;
    return produtoId;
  }

  /**
   * Retorna o proximo id do chocolate.
   * @return Id do chocolate + 1.
   */
  public int showProximoIdChocolate() {
    return produtoId + 1;
  }

  /**
   * Soma 1 ao id da venda e o retorna.
   * @return Id da venda.
   */
  public int getProximoIdVenda() {
    vendaId++;
    return vendaId;
  }

  /**
   * Retorna o proximo id da venda.
   * @return Id da venda + 1.
   */
  public int showProximoIdVenda() {
    return vendaId + 1;
  }

  /**
   * Calcula o lucro de determinado mes.
   * @param mes mes que o lucro deve ser calculado.
   * @param ano ano do mes que o lucro deve ser calculado.
   * @return lucro desse mes.
   * @throws IllegalArgumentException caso o mes inserido seja invalido.
   */
  public double calcularLucroMes(int mes, int ano) throws IllegalArgumentException {
    if (mes < 1 || mes > 12) {
      throw new IllegalArgumentException("Mês inválido");
    }

    double gastos = calcularGastosMes(mes, ano);
    double receita = 0;

    for (Venda venda : vendas) {
      LocalDate dataVenda = venda.getData();
      if (dataVenda.getMonthValue() == mes && dataVenda.getYear() == ano) {
        receita += venda.getValor();
      }
    }

    return receita - gastos;
  }

  /**
   * Calcula os gastos em um determinado mes
   * @param mes mes que os gastos deve ser calculado.
   * @param ano ano do mes que os gastos deve ser calculado.
   * @return gastos desses mes.
   * @throws IllegalArgumentException caso o mes seja invalido.
   */
  public double calcularGastosMes(int mes, int ano) throws IllegalArgumentException {
    if (mes < 1 || mes > 12) {
      throw new IllegalArgumentException("Mês inválido");
    }
    double gastos = 0;

    for (Chocolate chocolate : estoque.getChocolates()) {
      LocalDate dataCompra = chocolate.getDataCompra();
      if (dataCompra.getMonthValue() == mes && dataCompra.getYear() == ano) {
        gastos += chocolate.getPrecoCompra();
      }
    }

    for (Funcionario funcionario : funcionarios) {
      gastos += funcionario.getSalario();
    }

    return gastos;
  }

  /**
   * Realiza uma venda, retirando a quantidade de chocolates vendidos do estoque.
   * @param chocolatesQuantidades quantidades de chocolate vendido.
   * @param id id da venda.
   * @param cliente cliente que fez a venda.
   * @param funcionario funcionario que fez a venda.
   * @param data data da venda.
   */
  public void fazerVenda(Map<Chocolate, Integer> chocolatesQuantidades, int id,
                         Cliente cliente, Funcionario funcionario, LocalDate data) {
    Venda venda = new Venda(id, cliente, funcionario, data);

    for (Chocolate chocolate : chocolatesQuantidades.keySet()) {
      try {
        estoque.retirarQuantidade(chocolate, chocolatesQuantidades.get(chocolate));
        venda.adicionarChocolate(chocolate, chocolatesQuantidades.get(chocolate));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        return;
      }
    }

    venda.calcularValor();
    vendas.add(venda);
  }

  /**
   * Pesquisa um cliente por id.
   * @param id id do cliente.
   * @return cliente.
   */
  public Cliente getClientePorId(int id) {
    for (Cliente cliente : clientes) {
      if (cliente.getId() == id) {
        return cliente;
      }
    }
    return null;
  }

  /**
   * Pesquisa um cliente pelo nome
   * @param nome nome do cliente.
   * @return cliente.
   */
  public Cliente getClientePorNome(String nome) {
    for (Cliente cliente : clientes) {
      if (Objects.equals(cliente.getNome(), nome)) {
        return cliente;
      }
    }
    return null;
  }

  /**
   * Pesquisa um funcionario por id.
   * @param id id do funcionario.
   * @return funcionario.
   */
  public Funcionario getFuncionarioPorId(int id) {
    for (Funcionario funcionario : funcionarios) {
      if (funcionario.getId() == id) {
        return funcionario;
      }
    }

    return null;
  }

  /**
   * Pesquisa um funcionario pelo nome.
   * @param nome nome do funcionario.
   * @return funcionario.
   */
  public Funcionario getFuncionarioPorNome(String nome) {
    for (Funcionario funcionario : funcionarios) {
      if (Objects.equals(funcionario.getNome(), nome)) {
        return funcionario;
      }
    }
    return null;
  }

  /**
   * Pesquisa uma venda por id.
   * @param id id da venda.
   * @return venda.
   */
  public Venda getVendaPorId(int id) {
    for (Venda venda : vendas) {
      if (venda.getId() == id) {
        return venda;
      }
    }

    return null;
  }

  /**
   * Cria uma representação em string de todas as vendas.
   * @return representação em string de todas as vendas.
   */
  public String stringVendas() {
    StringBuilder s = new StringBuilder();
    for (Venda venda : vendas) {
      s.append(venda.info()).append("\n");
    }

    return s.toString();
  }

  /**
   * Cria uma Representação em string de todos os funcionários.
   * @return representação em string de todos os funcionários.
   */
  //
  public String stringFuncionarios() {
    StringBuilder s = new StringBuilder();
    for (Funcionario funcionario : funcionarios) {
      s.append(funcionario.infoBasica()).append("\n");
    }

    return s.toString();
  }

  /**
   * Cria uma representação em string de todos os clientes.
   * @return Representação em string de todos os clientes.
   */
  public String stringClientes() {
    StringBuilder s = new StringBuilder();
    for (Cliente cliente : clientes) {
      s.append(cliente.infoBasica()).append("\n");
    }
    return s.toString();
  }

  /**
   * Remove um chocolate da lista.
   * @param chocolate chocolate que sera removido da lista.
   */

  public void removerChocolate(Chocolate chocolate) {
    vendas.removeIf(venda -> venda.getChocolateVendidos().containsKey(chocolate));
    System.out.println(vendas);
    estoque.removerChocolate(chocolate);
  }

  // Remove um funcionário da lista

  /**
   * Remove um cliente da lista.
   * @param cliente cliente que sera removivdo da lista.
   */
  public void removerCliente(Cliente cliente) {
    vendas.removeIf(venda -> venda.getCliente().equals(cliente));
    clientes.remove(cliente);
  }

  /**
   * Remove um funcionario da lista.
   * @param funcionario funcionario que sera removido da lista.
   */
  public void removerFuncionario(Funcionario funcionario) {
    vendas.removeIf(venda -> venda.getFuncionario().equals(funcionario));
    funcionarios.remove(funcionario);
  }

  /**
   * Remove uma venda da lista.
   * @param venda venda que sera removida da lista.
   */
  public void removerVenda(Venda venda) {
    vendas.remove(venda);
  }

  public Cliente[] getClientes() {
    return clientes.toArray(new Cliente[0]);
  }

  public Funcionario[] getFuncionarios() {
    return funcionarios.toArray(new Funcionario[0]);
  }

  public Venda[] getVendas() {
    return this.vendas.toArray(new Venda[0]);
  }

  public Estoque getEstoque() {
    return estoque;
  }
}
