package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SnakeEating {
	static long valores[];
	static long k ;
	static long sumas[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter (System.out);
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String linea = in.readLine().trim();
			StringTokenizer toks = new StringTokenizer(linea);
			int tamano = Integer.parseInt(toks.nextToken());
			int query = Integer.parseInt(toks.nextToken());
			valores= new long [tamano];
			toks= new StringTokenizer(in.readLine());
			int j1=0; 
			while(toks.hasMoreTokens()){
				valores[j1]=Integer.parseInt(toks.nextToken());
				j1++;
			}
			
			
			Arrays.sort(valores);
			sumas= new long [tamano];
			sumas[tamano-1]=valores[tamano-1];
			for (int j = tamano-2; j >-1; j--) {
				sumas[j]=sumas[j+1]+valores[j];
			}
//			System.out.println(Arrays.toString(valores));
//			System.out.println(Arrays.toString(sumas));
			for (int j = 0; j < query; j++) {
				k=Integer.parseInt(in.readLine());
				int m =busqueda();
				//System.out.println(m);
				long cont=valores.length>1?valores.length-(m+1):valores[0]>=k?1:0;
				cont+=solve(m);		
				out.println(cont);
			}
		}
		out.close();
	}
	static int solve(int b){
		int a=0,m=0,tope=b+1,mejor=b+1;
		long valor=b+1==valores.length?0:sumas[b+1];
		while(a<=b){
			m=(a+b)/2;
			if((k*(tope-m))-(sumas[m]-valor)<=m){
				mejor=Math.min(mejor, m);
				b=m-1;
			}else{
				a=m+1;
			}
			
		}
		return tope-mejor;
	}
	static int busqueda(){
		
		int a =0;
		int b =valores.length-1;
		int m =0;
		long mejor=0;
		int pos=-1;
		while(a<=b){
			m=(a+b)/2;
			if(valores[m]>=k){
				b=m-1;
			}else{
				if(mejor<=valores[m]){
					mejor=valores[m];
					pos =m;
				}
				a=m+1;
			}
		}
		return pos;
			
	}
}
