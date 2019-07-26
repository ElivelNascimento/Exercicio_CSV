package br.com.resource.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {

	public static void main(String[] args) {

		String csvArquivo = "C:\\Users\\resource\\eclipse-workspace\\ImportarCSV\\testCSV.vsc";

		BufferedReader conteudoCSV = null;
		String linha = "";
		String csvSeparadorCampos = ",";

		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			while ((linha = conteudoCSV.readLine()) != null) {
				String[] arquivo = linha.split(csvSeparadorCampos);

				System.out.println("CONTA = " + arquivo[0] 
						+ " , Col 1 = " + arquivo[1] 
						+ " , Col 1 = " + arquivo[2]
						+ " , Col 1 = " + arquivo[3] 
						+ " , Col 1 = " + arquivo[4]
						+ " , Col 1 = " + arquivo[5] + "]");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado:  \n" +e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBounds: \n" + e.getMessage());
		}catch(IOException e) {
			System.out.println("IO Erro: \n " + e.getMessage());
		}finally {
			if(conteudoCSV != null) {
				try {
					conteudoCSV.close();
				} catch (Exception e) {
					System.out.println("IO Erro: \n"+e.getMessage());
				}
			}
		}
	}

}
