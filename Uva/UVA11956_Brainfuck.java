package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11956_Brainfuck {
	public static void main(String[] args) throws  IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine());
		for (int i = 1; i <= casos; i++) {
			String linea=in.readLine();
			int guia =0;
			int arr []= new int [100];
			for (int j = 0; j < linea.length(); j++) {
				if(linea.charAt(j)=='>')
					guia=guia+1==100?0:guia+1;
				else if (linea.charAt(j)=='<')
					guia=guia-1==-1?99:guia-1;
				else if (linea.charAt(j)=='-')
					arr[guia]=arr[guia]-1==-1?255:arr[guia]-1;
				else if (linea.charAt(j)=='+')
					arr[guia]=arr[guia]+1==256?0:arr[guia]+1;
			}
			
			out.print("Case "+i+": ");
			for (int j = 0; j < arr.length; j++) {
				out.print(Integer.toHexString(arr[j]).length()==2?Integer.toHexString(arr[j]).toUpperCase():"0"+Integer.toHexString(arr[j]).toUpperCase());
				if((j+1)<arr.length)
					out.print(" ");
			}
			out.println();
		}
		out.close();
	}
}
