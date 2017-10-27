package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ASCII_Diamondi_UVA12155 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos=1;
		String linea = in.readLine();
		StringTokenizer toks = new StringTokenizer(linea);
		int n =Integer.parseInt(toks.nextToken());
		int arriba=Integer.parseInt(toks.nextToken());
		int izquierda=Integer.parseInt(toks.nextToken());
		int abajo =Integer.parseInt(toks.nextToken());
		int derecha=Integer.parseInt(toks.nextToken());
		while(n!=0){
			//char[][]secuencia=new char[n][n];
			//int saltosF=0;
			//for (int i = k; i < secuencia.length; i++) {
//				int saltosC=0;
//				int temp=ini;
//				for (int j = k; j < secuencia[0].length; j++) {
//					secuencia[i][j]=(char) (temp>=tope?'.':temp<26?temp+97:(temp%26)+97);
//					secuencia[i][j-saltosC]=secuencia[i][j];
//					secuencia[i-saltosF][j]=secuencia[i][j];
//					secuencia[i-saltosF][j-saltosC]=secuencia[i][j];
//					saltosC+=2;
//					temp++;
//				}
//				ini++; 
//				saltosF+=2;
			//}
			int tam=n+(n-1);
			out.println("Case "+casos+":");
			for (int i = arriba; i <= abajo; i++) {
				for (int j = izquierda; j <= derecha; j++) {
					int i1=i%tam;
					int j1=j%tam;
					if(i1>(n-1))
						i1=(n-1)-(i1-(n-1));
					if(j1>(n-1))
						j1=(n-1)-(j1-(n-1));
					if(j1+i1<(n-1))
						out.print(".");
					else
						out.print((char)(97+((Math.abs(i1-(n-1))+Math.abs(j1-(n-1)))%26)));				
					
				}
				out.println();
			}
			linea=in.readLine();
			toks = new StringTokenizer(linea);
			n =Integer.parseInt(toks.nextToken());
			arriba=Integer.parseInt(toks.nextToken());
			izquierda=Integer.parseInt(toks.nextToken());
			abajo =Integer.parseInt(toks.nextToken());
			derecha=Integer.parseInt(toks.nextToken());
			casos++;
		}
		out.close();
	}
}

