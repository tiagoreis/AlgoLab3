package br.com.senac.application;


import java.awt.*;

import javax.swing.*;

public class Cartela extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1939663492008637016L;
	private Tabela tabela;
	
  public Cartela() {
  
    this.setLayout(null);
    Insets insets = this.getInsets();
    
    this.setBackground(Color.CYAN);
    this.setPreferredSize(new Dimension((255+15),250));
    
    tabela = new Tabela();

	JLabel label= new JLabel("B  I  N  G  O");
	label.setPreferredSize(new Dimension(0,1));
	label.setHorizontalAlignment(JLabel.CENTER);
	
	label.setBounds(insets.left, insets.top,260, 20);
    label.setFont(new Font("SansSerif", Font.BOLD, 20));
    label.setBounds(0, 0,260,20);
    
    tabela.setBorder(BorderFactory.createLineBorder (Color.black, 2));
    tabela.setBounds(insets.left+5, insets.top+25, (252),(252));
    
    this.add(label);
    this.add(tabela);
    tabela.popularTabela();
    
  }
  
  public boolean verificaCartela(int numero){
	  tabela.marcaNumero(numero);
	  if(tabela.isCartelaPreenchida()){
		  return true;
	  }
		  
	  return false;
  }

}

