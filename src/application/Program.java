package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		String caminho = "C:\\temp\\lista.txt"; // Coloque o nome do arquivo aqui
		String saida = "C:\\temp\\lista2.txt"; // Coloque a saida do arquivo aqui
		List<String> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "UTF-8"))) {
			String linha = br.readLine();
			while (linha != null) {

				String texto = linha.replace("  ", "");
				list.add(texto);
				System.out.println(texto);
				linha = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(saida))) {

				for (String line : list) {
					bw.write(line);
					bw.newLine();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
