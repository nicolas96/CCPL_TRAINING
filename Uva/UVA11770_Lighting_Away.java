
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class UVA11770_Lighting_Away {
	static int grafo[][];
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine());
		for (int i = 1; i <= casos; i++) {
			StringTokenizer toks = new StringTokenizer(in.readLine());
			int nodos = Integer.parseInt(toks.nextToken());
			int aristas = Integer.parseInt(toks.nextToken());
			grafo= new int [nodos][nodos];
			for (int j = 0; j < aristas; j++) {
				toks = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(toks.nextToken())-1;
				int b = Integer.parseInt(toks.nextToken())-1;
				grafo[a][b]=1;
			}
			int cont =0;
			LinkedList<Integer>ordenT=dfs(nodos);
			boolean vistos[] = new boolean[nodos];
			while(!ordenT.isEmpty()){
				int u =ordenT.removeFirst();
				if(!vistos[u]){
					cont ++;
					explore(u,vistos);
				}
			}
			out.printf("Case %d: %d\n",i,cont);
			in.readLine();
		}
		out.close();
	}
	private static void explore(int u, boolean[] vistos) {
		vistos[u]=true;
		for (int j = 0; j < grafo.length; j++) {
			if(grafo[u][j]==1&&!vistos[j])
				explore(j,vistos);
		}
	}
	static LinkedList<Integer> dfs(int nodos){
		LinkedList<Integer>ordenT=new LinkedList<Integer>();
		boolean vistos[] = new boolean[nodos];
		for (int i = 0; i < vistos.length; i++) {
			if(!vistos[i]){
				explore(i,ordenT,vistos);
			}
		}
		return ordenT;
	}
	private static void explore(int i, LinkedList<Integer> ordenT, boolean[] vistos) {
		vistos[i]=true;
		for (int j = 0; j < grafo.length; j++) {
			if(grafo[i][j]==1&&!vistos[j])
				explore(j,ordenT,vistos);
		}
		ordenT.addFirst(i);
	}
}

