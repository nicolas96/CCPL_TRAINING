package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class Waterland_UVA11655 {
	static int nodos;
	static int modulo=100_000;
	static int S;
	static int D;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine());
		for (int i = 1; i <= casos; i++) {
			StringTokenizer toks = new StringTokenizer(in.readLine());
			nodos = Integer.parseInt(toks.nextToken());
			int aristas = Integer.parseInt(toks.nextToken());
			LinkedList<Integer>[] grafo = new LinkedList[nodos+1];
			LinkedList<Integer>[] grafoInvertido = new LinkedList[nodos+1];
			S=0;D=0;
			for (int j = 1; j <= nodos; j++) {
				grafo[j]= new LinkedList<Integer>();
				grafoInvertido[j]=new LinkedList<Integer>();
			}
			for (int j = 0; j < aristas; j++) {
				toks = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(toks.nextToken());
				int b = Integer.parseInt(toks.nextToken());
				grafo[a].addLast(b);
				grafoInvertido[b].addLast(a);
			}
			dfs(grafo,grafoInvertido);
			out.println("Case "+i+": "+S+" "+D);
		}
		out.close();
	}
	static void dfs(LinkedList<Integer>[] grafo,LinkedList<Integer>[] grafoInvertido){
		boolean visitados []= new boolean [nodos+1];
		LinkedList<Integer> stack= new LinkedList<Integer>();
		for (int i = 1; i < visitados.length; i++) {
			if(!visitados[i])
				explore(visitados,i,stack,grafo);
		}
		int sumas[]= new int[nodos+1];
		int caminos[]=new int[nodos+1];
		sumas[1]=0;
		caminos[1]=1;
		stack.removeLast();
		while(!stack.isEmpty()){
			int u =stack.removeLast();
			while(!grafoInvertido[u].isEmpty()){
				int v = grafoInvertido[u].removeFirst();
				caminos[u]+=caminos[v];	
				sumas[u]+=sumas[v];	
				caminos[u]%=modulo;	
				sumas[u]%=modulo;	
			}
			sumas[u]+=caminos[u];
			sumas[u]%=modulo;	
		}
		S=sumas[nodos];
		D=caminos[nodos];
	}
	static void explore(boolean visit [],int v, LinkedList<Integer> stack,LinkedList<Integer>[] grafo){
		visit[v]=true;
			for (int i = 0; i < grafo[v].size(); i++) {
				int u =grafo[v].get(i);
				if(!visit[u]){
					 explore( visit, u,stack,grafo);
				}			}
		stack.addLast(v);
	}
}
/*
3
2 1
1 2
4 4
1 2
1 3
2 4
3 4
4 3
1 2
2 3
3 4
1
5 8
1 3
1 2
2 3
2 5
2 4
3 2
3 4
4 5
*/