package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA10298_PowerString {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new  BufferedReader( new InputStreamReader ( System.in));
		PrintWriter out = new PrintWriter (System.out);
		String linea = in.readLine();
		while(!linea.equals(".")){
			
				int bordes[] = borde(linea.toCharArray());
				System.out.println(Arrays.toString(bordes));
				int max=bordes[bordes.length-1];
				
				out.println(linea.length()/(linea.length()-max));
			
			
			linea=in.readLine();
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
