package uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA13018_DiceCup {
	static long[]arr; 
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linea = in.readLine().trim();
		StringBuilder p= new StringBuilder();
		while(linea!=null&&!linea.trim().equals("")){
			StringTokenizer toks = new StringTokenizer(linea.trim());
			int a =Integer.parseInt(toks.nextToken());
			int b =Integer.parseInt(toks.nextToken());
			arr= new long[42];
			long max=-1;
			solve(a,b);
			for(int i=0,n=arr.length;i<n;i++){
				max=Math.max(max, arr[i]);
			}
			for(int i=0,n=arr.length;i<n;i++){
				if(arr[i]==max)
					p.append(i+"\n");
			}
			p.append("\n");
			linea=in.readLine();
		}
		p.delete(p.length()-1, p.length());
		out.print(p);
		out.close();
	}
	private static void solve(long a, int b) {
		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <=b ; j++) {
				arr[i+j]++;
			}
		}
	}

}
