package br.com.resource.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class LerCSV {

	public static void main(String[] args) {
		
		String pathArquivo = "C:\\Users\\resource\\eclipse-workspace\\ImportarCSV\\arqCSV_" + System.currentTimeMillis() + ".csv";
		criarArquivoCSV(pathArquivo);
		lerArquivoCSV(pathArquivo);
		
	}
	
	private static void lerArquivoCSV(String csvArquivo) {
		

		BufferedReader conteudoCSV = null;
		String linha = "";
		String csvSeparadorCampos = ",";

		try {
			conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
			while ((linha = conteudoCSV.readLine()) != null) {
				String[] arquivo = linha.split(csvSeparadorCampos);

				if (!arquivo[0].equals("agencia"))
				{
					Conta item = new Conta();
					item.setAgencia(arquivo[0]);
					item.setConta(arquivo[1]);
					item.setValor(Double.parseDouble(arquivo[2]));
					item.setTipo(arquivo[3]);
					item.setSaldo(Float.parseFloat(arquivo[4]));
					
					
					
					System.out.println("Agencia = " + item.getAgencia() 
						+ " , Conta = " + item.getConta() 
						+ " , Valor = " + item.getValor()
						+ " , Tipo = " +  item.getTipo()
						+ " , Saldo = " + item.getSaldo());				
				}

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
	private static void criarArquivoCSV(String filePath) {
		
		List<Conta> contas = new ArrayList<Conta>();
		
		Conta conta = new Conta();
		conta.setAgencia("4201");
		conta.setConta("10000045");
		conta.setSaldo(13.33f);
		conta.setTipo("TED");
		conta.setValor(300.00);
		contas.add(conta);
		
		conta = new Conta();
		conta.setAgencia("4202");
		conta.setConta("10000112");
		conta.setSaldo(2.334f);
		conta.setTipo("DOC");
		conta.setValor(30.0);
		contas.add(conta);
		
		conta = new Conta();
		conta.setAgencia("4203");
		conta.setConta("10000332");
		conta.setSaldo(2.323f);
		conta.setTipo("DOC");
		conta.setValor(320.0);
		contas.add(conta);
		
		conta = new Conta();
		conta.setAgencia("4204");
		conta.setConta("10002312");
		conta.setSaldo(2.234f);
		conta.setTipo("TED");
		conta.setValor(303.0);
		contas.add(conta);
		
		FileWriter fileWriter = null;
		try {
			 fileWriter = new FileWriter(filePath);
			
			fileWriter.append("agencia, conta, valor, tipo, saldo \n");
			
			for(int i = 0; i < contas.size();i++) {
				fileWriter.append(contas.get(i).getAgencia());
				fileWriter.append(",");
				fileWriter.append(contas.get(i).getConta());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(contas.get(i).getValor()));
				fileWriter.append(",");
				fileWriter.append(contas.get(i).getTipo());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(contas.get(i).getSaldo()));
				fileWriter.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
		
		
		
		
	}

}
