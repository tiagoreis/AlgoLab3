package br.com.senac.application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tabela extends JPanel  {

	private JLabel [][] numerosCartela=null;
	private boolean cartelaPreenchida = false;
	private static final long serialVersionUID = 1L;
	static final int TAMANHO_CARTELA = 5;
	private List<Integer> numeros;
	int line1 = 1; 
	int line2 = 1;
	int line3 = 1;
	int line4 = 1;
	int line5 = 1;
	int colB = 1;
	int colI = 1;
	int colN = 1;
	int colG = 1;
	int colO = 1;
	int diag1 = 1;
	int diag2 = 1;
	
	public Tabela(){
		//super(new GridLayout(TAMANHO_CARTELA,TAMANHO_CARTELA));
		
		//this.setPreferredSize(new Dimension(50,50));
		super();
		this.setLayout(null);
		numerosCartela = new JLabel[Tabela.TAMANHO_CARTELA][Tabela.TAMANHO_CARTELA];
		numeros = new ArrayList<Integer>();
		
		this.setVisible(true);
	}

	public void popularTabela(){
		Random random = new Random();
		Insets insets = this.getInsets();
		
		for (int i = 0; i < Tabela.TAMANHO_CARTELA; i++) {
			for (int j = 0; j < Tabela.TAMANHO_CARTELA; j++) {
				boolean validado = false;
				int numeroRandom = 0;
				if(i ==2 && j ==2){
					JLabel tela = new JLabel("FREE");
					tela.setBounds(insets.left+(j*50), insets.top+(i*50),48, 48);
					tela.setBackground(Color.YELLOW);
					tela.setBorder(BorderFactory.createLineBorder (Color.white, 2));
					tela.setOpaque(true);
					tela.setVisible(true);
					tela.setHorizontalAlignment(JLabel.CENTER);
					this.add(tela);
					numeros.add(Integer.valueOf(0));
				}
				while(validado == false){
					numeroRandom = random.nextInt(98 + 1);	
					validado = validarNumero(numeroRandom);
					if(validado){
						
						String lab = String.valueOf(numeroRandom);
						JLabel tela = new JLabel(lab);
						tela.setBounds(insets.left+(j*50), insets.top+(i*50),48, 48);
						tela.setBackground(Color.YELLOW);
						tela.setBorder(BorderFactory.createLineBorder (Color.white, 2));
						tela.setOpaque(true);
						tela.setVisible(true);
						tela.setHorizontalAlignment(JLabel.CENTER);
						this.add(tela);
						
						numerosCartela[i][j] = tela;
						numeros.add(Integer.valueOf(numeroRandom));
					}
				}
			}
		}
	}
	

	public boolean validarNumero(int numero){
		boolean validou = true;
		
		if(numero > 0 && numero < 100){
			if(numeros.contains(Integer.valueOf(numero))){
				return false;
			}
		}
		
		return validou;
	}

	public boolean isCartelaPreenchida() {
		return cartelaPreenchida;
	}

	public void setCartelaPreenchida(boolean cartelaPreenchida) {
		this.cartelaPreenchida = cartelaPreenchida;
	}

	public void marcaNumero(int numero) {
		if(numeros.contains(Integer.valueOf(numero))){
			int pos = numeros.indexOf(Integer.valueOf(numero));
			int x = pos/5;
			int y = pos - (x*5);
			numerosCartela[x][y].setBorder(BorderFactory.createLineBorder (Color.red, 10));
			switch(x)
			{
				case 0:
					line1++;
					break;
				case 1:
					line2++;
					break;
				case 2:
					line3++;
					break;
				case 3:
					line4++;
					break;
				case 4:
					line5++;
					break;
					
			}
			switch(y)
			{
				case 0:
					colB++;
					break;
				case 1:
					colI++;
					break;
				case 2:
					colN++;
					break;
				case 3:
					colG++;
					break;
				case 4:
					colO++;
					break;
			}
			if(x==y){
				diag1++;
			}
			if(x == 4-y){
				diag2++;
			}

		}
		if(verificaVitoria()){
			this.cartelaPreenchida = true;
		}
			
	}

	private boolean verificaVitoria() {
		if( (line1 == 5) || (line2 == 5) || (line3 == 5) || (line4 == 5) || (line5 == 5)){
			return true;
		}
		if( (colB == 5) || (colI == 5) || (colN == 5) || (colG == 5) || (colO == 5)){
			return true;
		}
		if( (diag1 == 5) || (diag2 == 5) ) {
			return true;
		}
		
		return false;
	}

}
