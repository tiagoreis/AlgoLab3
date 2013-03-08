package br.com.senac.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class BingoTeste extends JFrame{
  public BingoTeste(){
    super("Como usar a classe GridBagLayout");

    // define o layout
    setLayout(new GridBagLayout());
    
    // define uma borda para aumentar o espaço
    // entre as bordas da janela e o gerenciador
    // de layout
//    ((JComponent)getContentPane()).setBorder(
//       new EmptyBorder(10, 10, 10, 10));

//    ((JComponent)getContentPane()).setBorder(BorderFactory.createLineBorder(Color.darkGray, 10));
//    ((JComponent)getContentPane()).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
    ((JComponent)getContentPane()).setBorder(BorderFactory.createBevelBorder(10));
    

    // cria o GridBagConstraints
    GridBagConstraints gbc = new GridBagConstraints();

    // controla o espaço entre os componentes
    // e as linhas do GridBagLayout.
    // aqui nós definimos 5 pixels para os
    // lados de cima, esquerda, inferior e direita
    gbc.insets = new Insets(5, 5, 5, 5);

    // adiciona componentes à janela
    gbc.gridy = 0; // linha
    gbc.gridx = 0; // coluna
    add(new JButton("Botão 1"), gbc);

    gbc.gridy = 0; // linha
    gbc.gridx = 1; // coluna
    add(new JButton("Botão 2"), gbc);

    gbc.gridy = 0; // linha
    gbc.gridx = 2; // coluna
    add(new JButton("Botão 3"), gbc);

    gbc.gridy = 1; // linha
    gbc.gridx = 0; // coluna
    add(new JButton("Botão 4"), gbc);

    gbc.gridy = 1; // linha
    gbc.gridx = 1; // coluna
    add(new JButton("Botão 5"), gbc);

    gbc.gridy = 1; // linha
    gbc.gridx = 2; // coluna
    add(new JButton("Botão 6"), gbc);
    
    //setSize(350, 150);
    pack(); // ajusta o tamanho da janela ao
            // dos componentes
    setVisible(true);    
  }

  public static void main(String args[]){
	BingoTeste app = new BingoTeste();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
