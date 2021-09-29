package view;

import model.Funcionario;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final MainToolBar toolBar;
    private final JTabbedPane tabs;

    private final ClientesTab clientesTab;
    private final FuncionariosTab funcionariosTab;

    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabs = new JTabbedPane();
        clientesTab = new ClientesTab();
        funcionariosTab = new FuncionariosTab();

        tabs.add("Clientes", clientesTab);
        tabs.add("Funcionarios", funcionariosTab);

        toolBar = new MainToolBar();

        getContentPane().add(tabs, BorderLayout.CENTER);
        add(toolBar, BorderLayout.BEFORE_FIRST_LINE);

        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
    }

    public MainToolBar getToolBar() {
        return toolBar;
    }

    public JTabbedPane getTabs() {
        return tabs;
    }

    public ClientesTab getClientesTab() {
        return clientesTab;
    }

    public FuncionariosTab getFuncionariosTab() {
        return funcionariosTab;
    }
}
