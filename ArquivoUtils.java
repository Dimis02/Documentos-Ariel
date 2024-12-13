package view;

import model.Documento;
import util.ArquivoUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroView extends JFrame {
    private JTextField tituloField;
    private JTextField autorField;
    private JTextField dataCriacaoField;
    private JButton salvarButton;

    public CadastroView() {
        setTitle("Cadastro de Documentos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Campos do formulário
        add(new JLabel("Título:"));
        tituloField = new JTextField();
        add(tituloField);

        add(new JLabel("Autor:"));
        autorField = new JTextField();
        add(autorField);

        add(new JLabel("Data de Criação (DD/MM/AAAA):"));
        dataCriacaoField = new JTextField();
        add(dataCriacaoField);

        salvarButton = new JButton("Salvar");
        add(salvarButton);

        // Ação do botão Salvar
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarDocumento();
            }
        });
    }

    private void salvarDocumento() {
        String titulo = tituloField.getText().trim();
        String autor = autorField.getText().trim();
        String dataCriacao = dataCriacaoField.getText().trim();


        JOptionPane.showMessageDialog(this, "Documento salvo com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        tituloField.setText("");
        autorField.setText("");
        dataCriacaoField.setText("");
    }
}
