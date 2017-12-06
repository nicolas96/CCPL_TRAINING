package uva;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class UVA10681_TeobaldosTrip {
	static LinkedList<Integer>[]grafo;
	static int memoria[][];
	static int fin;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader ( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter (System.out);
		String linea = in.readLine();
		while(linea !=null &&!linea.trim().equals("0 0")){
			StringTokenizer toks = new StringTokenizer (linea);
			int ciudades=Integer.parseInt(toks.nextToken());
			int aristas=Integer.parseInt(toks.nextToken());
			grafo=new LinkedList[ciudades];
			for (int i = 0; i < ciudades; i++) {
				grafo[i]=new LinkedList<Integer>();
			}
			for (int i = 0; i < aristas; i++) {
				toks= new StringTokenizer(in.readLine());
				int a=Integer.parseInt(toks.nextToken())-1;
				int b=Integer.parseInt(toks.nextToken())-1;
				grafo[a].add(b);
				grafo[b].add(a);
			}
			toks=new StringTokenizer (in.readLine());
			int inicio=Integer.parseInt(toks.nextToken());
			fin=Integer.parseInt(toks.nextToken())-1;
			int dias=Integer.parseInt(toks.nextToken());
			memoria=new int [ciudades][dias+1];
			out.println(dfs(inicio-1,dias)?"Yes, Teobaldo can travel.":"No, Teobaldo can not travel.");
			in.readLine();
			linea =in.readLine();
		}
		out.close();
	}
	private static boolean dfs(int inicio, int dias) {
		if(memoria[inicio][dias]!=0)
			return memoria[inicio][dias]==1?true:false;
		if(dias==0){
			if(inicio==fin)
				memoria[inicio][dias]=1;
			else
				memoria[inicio][dias]=2;
			return memoria[inicio][dias]==1?true:false;
		}else{
			boolean res =false;
			for(int u:grafo[inicio]){
				res=res||dfs(u,dias-1);
			}
			if(res)
				memoria[inicio][dias]=1;
			else
				memoria[inicio][dias]=2;
			return memoria[inicio][dias]==1?true:false;
		}
	}
}

