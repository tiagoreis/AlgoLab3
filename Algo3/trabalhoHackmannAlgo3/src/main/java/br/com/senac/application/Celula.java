package br.com.senac.application;


import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Celula{
	private int valor = 0;
	private boolean hasBorda = false;
	JLabel tela;
	
	public Celula(int valor){
		//String txto = String.valueOf(valor);
		//super();
		//String txto = String.valueOf(valor);
		//this.setText(txto);
		tela = new JLabel(String.valueOf(valor));
		this.valor = valor;

		tela.setVisible(true);
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public boolean isHasBorda() {
		return hasBorda;
	}
	public void setHasBorda(boolean hasBorda) {
		this.hasBorda = hasBorda;
	}
	
	

}
