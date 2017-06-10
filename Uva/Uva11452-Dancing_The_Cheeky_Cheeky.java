package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Uva11452_Dancing_The_Cheeky_Cheeky {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i <casos; i++) {
			String linea = in.readLine();
			int bordes[] = borde(linea.toCharArray());
			int periodo=linea.length()-bordes[bordes.length-1];
			int siguiente=linea.length()%periodo;
			String guia = linea.substring(0, periodo);
			
			for (int j = 0; j < 8; j++) {
				out.print(guia.charAt(siguiente));
				if(siguiente+1==periodo)
					siguiente=0;
				else
					siguiente++;
			}
			out.println("...");
		}
		out.close();
	}
	public static int[] borde(char[] p) {
		int m = p.length;
		int[] borde = new int[m + 1];
		borde[0] = -1;
		borde[1] = 0;
		for (int q = 1; q <= m; q++) {
			int k = borde[q - 1];
			while (k >= 0 && p[q - 1] != p[k])
				k = borde[k];
			if (k >= 0 && p[q - 1] == p[k])
				k = k + 1;
			else
				k = 0;
			borde[q] = k;
		}
		return borde;
	}
}
