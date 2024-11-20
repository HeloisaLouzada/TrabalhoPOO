/*package ageOfMythologyRetoldArena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import manipulararquivo.ManipularArquivo;

public class Testeeee {
    private Arena arena; // Instância da classe principal
    private JTextArea logArea; // Área de texto para exibir o log
    private JButton iniciarRodadasButton;
    private JButton carregarEquipesButton;

    public Testeeee() {
        arena = new Arena();

        // Configurar a janela principal (JFrame)
        JFrame frame = new JFrame("Age of Mythology Retold Arena");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Configurar os componentes
        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        carregarEquipesButton = new JButton("Carregar Equipes");
        iniciarRodadasButton = new JButton("Iniciar Rodadas");
        iniciarRodadasButton.setEnabled(false); // Desativado até carregar as equipes

        // Painel para botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(carregarEquipesButton);
        buttonPanel.add(iniciarRodadasButton);

        // Configurar layout
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Adicionar ação ao botão "Carregar Equipes"
        carregarEquipesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarEquipes();
            }
        });

        // Adicionar ação ao botão "Iniciar Rodadas"
        iniciarRodadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarRodadas();
            }
        });

        // Exibir a janela
        frame.setVisible(true);
    }

    private void carregarEquipes() {
        try {
            // Carregar equipes (simula a lógica da main)
            final int quantidade = 4;
            arena.ladoGN = Equipe.CriaLista(quantidade);
            arena.ladoAE = Equipe.CriaLista(quantidade);

            arena.ladoGN.add(ManipularArquivo.LerArquivo("arquivo1.txt", 1));
            arena.ladoGN.add(ManipularArquivo.LerArquivo("arquivo2.txt", 1));
            arena.ladoGN.add(ManipularArquivo.LerArquivo("arquivo3.txt", 1));
            arena.ladoGN.add(ManipularArquivo.LerArquivo("arquivo4.txt", 1));

            arena.ladoAE.add(ManipularArquivo.LerArquivo("arquivo5.txt", 2));
            arena.ladoAE.add(ManipularArquivo.LerArquivo("arquivo6.txt", 2));
            arena.ladoAE.add(ManipularArquivo.LerArquivo("arquivo7.txt", 2));
            arena.ladoAE.add(ManipularArquivo.LerArquivo("arquivo8.txt", 2));

            logArea.append("Equipes carregadas com sucesso!\n");
            iniciarRodadasButton.setEnabled(true);
        } catch (Exception ex) {
            logArea.append("Erro ao carregar equipes: " + ex.getMessage() + "\n");
        }
    }

    private void iniciarRodadas() {
        try {
            final int quantidade = 4;
            Equipe equipeGN = new Equipe(1, arena.ladoGN, 0);
            Equipe equipeAE = new Equipe(2, arena.ladoAE, 0);

            logArea.append("Iniciando rodadas...\n");
            arena.rodada(arena, equipeGN, equipeAE, quantidade);
            logArea.append("Rodadas concluídas!\n");
        } catch (Exception ex) {
            logArea.append("Erro durante as rodadas: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Testeeee());
    }
}
*/