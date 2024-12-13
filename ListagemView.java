package view;

import model.Documento;
import util.ArquivoUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListagemView extends JFrame {
    private JTable tabela;
    private DefaultTableModel tableModel;
    private JButton carregarButton;
    private JButton excluirButton;

    public ListagemView() {
        setTitle("Listagem de Documentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabela
        tableModel = new DefaultTableModel(new Object[]{"Título", "Autor", "Data de Criação"}, 0);
        tabela = new JTable(tableModel);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões
        JPanel buttonPanel = new JPanel();
        carregarButton = new JButton("Carregar Dados");
        excluirButton = new JButton("Excluir Selecionado");
        buttonPanel.add(carregarButton);
        buttonPanel.add(excluirButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Ação dos botões
        carregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carregarDados();
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                excluirSelecionado();
            }
        });
    }

    private void carregarDados() {
        tableModel.setRowCount(0); // Limpar a tabela
        List<Documento> documentos = ArquivoUtils.carregarDocumentos();
        for (Documento doc : documentos) {
            tableModel.addRow(new Object[]{doc.getTitulo(), doc.getAutor(), doc.GetDataCriacao()});
        }
    }

    private void excluirSelecionado() {
        int selectedRow = tabela.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um documento para excluir!");
            return;
        }

        String titulo = (String) tableModel.getValueAt(selectedRow, 0);
        carregarDados();
        JOptionPane.showMessageDialog(this, "Documento excluído com sucesso!");
    }
}
