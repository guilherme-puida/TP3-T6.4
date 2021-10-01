package controller;

import model.*;
import view.VendaDetails;
import view.VendasTab;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class VendasTabController implements ActionListener, ListSelectionListener {
  private final VendasTab vendasTab;

  public VendasTabController(VendasTab vendasTab) {
    this.vendasTab = vendasTab;
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
      vendasTab.getDetails().popularDados(venda);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(vendasTab.getDetails().getSubmit())) {
      Venda venda = (Venda) vendasTab.getListaVendas().getLista().getSelectedValue();
      VendaDetails details = vendasTab.getDetails();

      venda.setCliente((Cliente) details.getCliente().getSelectedItem());
      venda.setFuncionario((Funcionario) details.getFuncionario().getSelectedItem());

      HashMap<Chocolate, Integer> vendidos = new HashMap<>();
      List<JSpinner> produtosSpinner = details.getListaQuantidades();
      List<JComboBox<Chocolate>> boxes = details.getListaChocolates();


      for (int i = 0; i < produtosSpinner.size(); i++) {
        vendidos.put((Chocolate) boxes.get(i).getSelectedItem(),
                (int) produtosSpinner.get(i).getValue());
      }

      System.out.println(vendidos);

      HashMap<Chocolate, Integer> vendidosAntes = venda.getChocolateVendidos();
      venda.setChocolateVendidos(vendidos);

      for (Chocolate chocolate : vendidos.keySet()) {
        if (vendidosAntes.containsKey(chocolate)) {
          Loja.getInstance().getEstoque().retirarQuantidade(
                  chocolate, vendidos.get(chocolate) - vendidosAntes.get(chocolate)
          );
        } else {
          Loja.getInstance().getEstoque().retirarQuantidade(
                  chocolate, vendidos.get(chocolate)
          );
        }
      }

      venda.calcularValor();
      int index = vendasTab.getListaVendas().getLista().getSelectedIndex();
      vendasTab.getListaVendas().updateLista();
      vendasTab.getListaVendas().getLista().setSelectedIndex(index);

      vendasTab.resetListSelectionController();

    }
  }
}
