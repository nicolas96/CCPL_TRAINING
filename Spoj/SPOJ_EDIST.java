package spoj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class SPOJ_EDIST {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			String a =in.readLine();
			String b =in.readLine();
			out.println(solve(a,b));
		}
		out.close();
	}
	private static int solve(String a, String b) {
		int matriz[][]= new int[a.length()+1][b.length()+1];
		matriz[0][0]=0;
		for (int i = 1; i < matriz.length; i++) {
			matriz[i][0]=i;
		}
		for (int i = 1; i < matriz[0].length; i++) {
			matriz[0][i]=i;
		}
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz[0].length; j++) {
				matriz[i][j]=Math.min(1+matriz[i-1][j], Math.min(1+matriz[i][j-1], igual(a.charAt(i-1),b.charAt(j-1))+matriz[i-1][j-1]));
			}
		}
		return matriz[a.length()][b.length()];
	}
	private static int igual(int i, int j) {
		return i==j?0:1;
	}
}
