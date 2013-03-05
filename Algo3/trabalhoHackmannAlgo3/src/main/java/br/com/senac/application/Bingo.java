package br.com.senac.application;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Bingo {

	private final int TAMANHO_CARTELA = 5;
	
	public void gerarCartela1(){
		
		Random random = new Random();
		
		int[][]arrays = new int[this.TAMANHO_CARTELA][this.TAMANHO_CARTELA]; 
		
		JPanel jp = new JPanel(new GridLayout(5,5));
		
		for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
			for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
				
				boolean validado = false;
				int numeroRandom = 0;
				while(validado == false){
					numeroRandom = random.nextInt(98 + 1);	
					validado = validarNumero(numeroRandom, arrays);
					
					arrays[i][j] = numeroRandom;	
				}
				
				jp.add(new JLabel(String.valueOf(numeroRandom)));
				
				
			}
		}
		
		jp.show(true);
		
		for (int i = 0; i < this.TAMANHO_CARTELA; i++) {
			for (int j = 0; j < this.TAMANHO_CARTELA; j++) {
//				System.out.println("posiçao: " + i + " - " + j + " = " + arrays[i][j]);
//				JOptionPane.showMessageDialog(null, arrays[i][j]);
				
				
			}
		}
		
	}
	
	
	public boolean validarNumero(int numero, int[][] arrays){
		boolean validou = true;
		
		if(numero > 0 && numero < 100){
			for (int i = 0; i < arrays.length; i++) {
				for (int j = 0; j < arrays.length; j++) {
					if(arrays[i][j] == numero){
						return false;
					}
					
				}
			}
		}
		
		return validou;
	}
}
