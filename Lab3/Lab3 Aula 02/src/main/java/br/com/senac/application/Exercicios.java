package br.com.senac.application;
import java.lang.reflect.Array;

import javax.swing.JOptionPane;

public class Exercicios {

	public void exercicio01(){
		 
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um número positivo: "));
		String div = separarDivisiveis(numero);
		JOptionPane.showMessageDialog(null,"Os divisores são: "+div);
		
	 }

	private String separarDivisiveis(int numero) {

		StringBuilder sb = new StringBuilder();
		Integer[] array = new Integer[numero];
		int cont = 0;
		
		if(numero > 0){
			for (int i = 1; i <= numero; i++) {
				if(numero % i == 0){
					array[cont] = i;
					cont++;
				}
			}
			
			if(cont > 0){
				for (int i = 0; i < array.length; i++) {
					if(i == 0){
						sb.append(array[i]);
					} else {
						sb.append(String.format(", %s",  array[i]));
					}
				}
				
			} else {
				sb.append("Sem divisores!");
			}
			
		} else {
			sb.append("Número inválido!");
		}
		
		
		return sb.toString();
	}
}
