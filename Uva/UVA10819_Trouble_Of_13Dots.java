
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA10819{
	static int[][]matriz;
	static int[]costo;
	static int []beneficio;
	static int m;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linea = in.readLine();
		while(linea!=null&&!linea.trim().equals("")) {
			StringTokenizer toks = new StringTokenizer(linea);
			m =Integer.parseInt(toks.nextToken());
			n =Integer.parseInt(toks.nextToken());
			matriz= new int[m+201][n+5];
			 costo= new int[n+1];
			 beneficio= new int[n+1];
			 for (int i = 0; i < matriz.length; i++) {
				Arrays.fill(matriz[i], -1);
			}
			for (int i = 0; i < n; i++) {
				toks = new StringTokenizer(in.readLine());
				costo[i+1]=Integer.parseInt(toks.nextToken());
				beneficio[i+1]=Integer.parseInt(toks.nextToken());
			}
//			System.out.println(Arrays.toString(costo));
			out.println(solve(0,0));
			linea=in.readLine();
//			for (int i = 0; i < matriz.length; i++) {
//				System.out.println(Arrays.toString(matriz[i]));
//			}
		}
		out.close();
	}
	private static int solve(int w, int j) {
		if(w>m&&m<=1800)return Integer.MIN_VALUE/2;
		if(w>m+200)return  Integer.MIN_VALUE/2;
		if(j==n){
			if(w>m&&w<=2000)return  Integer.MIN_VALUE/2;
			return 0;
		}
		if(matriz[w][j]!=-1)return matriz[w][j];
		matriz[w][j]=Math.max(beneficio[j+1]+solve(w+costo[j+1],j+1), solve(w,j+1));
		return matriz[w][j];
	}
	
}
/*
1900 3
2000 5
1950 2
101 1
*/
