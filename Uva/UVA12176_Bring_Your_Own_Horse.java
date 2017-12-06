package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class horse {
	static LinkedList<Integer>[] grafo;
	static Quick_union un;
	static int peso[][];
	static int fin;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder out1 = new StringBuilder();
		long casos = Long.parseLong(in.readLine());
		for (int i = 0; i < casos; i++) {
			StringTokenizer toks = new StringTokenizer(in.readLine());
			int nodos = Integer.parseInt(toks.nextToken());
			int aristas = Integer.parseInt(toks.nextToken());
			grafo = new LinkedList[nodos];
			arista cone[] = new arista[aristas];
			peso = new int[nodos][nodos];
			for (int j = 0; j < nodos; j++) {
				grafo[j] = new LinkedList<Integer>();
			}

			for (int j = 0; j < aristas; j++) {
				toks = new StringTokenizer(in.readLine());
				cone[j] = new arista(Integer.parseInt(toks.nextToken()) - 1, Integer.parseInt(toks.nextToken()) - 1,
						Integer.parseInt(toks.nextToken()));
			}
			Arrays.sort(cone);
			un = new Quick_union(nodos);
			for (int j = 0; j < aristas; j++) {
				int a = cone[j].x;
				int b = cone[j].y;
				int p1 = un.find(a);
				int p2 = un.find(b);
				if (p1 != p2) {
					grafo[a].add(b);
					peso[a][b]=cone[j].peso;
					grafo[b].add(a) ;
					peso[b][a]=cone[j].peso;
					un.union(a, b);
				}
			}
			int query = Integer.parseInt(in.readLine());
			out1.append("Case " + (i + 1) + "\n");
			for (int j = 0; j < query; j++) {
				toks = new StringTokenizer(in.readLine());
				int k = Integer.parseInt(toks.nextToken()) - 1;
				fin = Integer.parseInt(toks.nextToken()) - 1;
				boolean[]vistos= new boolean[nodos];
				dfs(Integer.MAX_VALUE,k,new int[] {0},vistos);
				out1.append( res+ "\n");
			}
			out1.append("\n");
		}
		out.print(out1);
		out.close();
	}
	private static void dfs(int padre,int inicio, int cont[],boolean vistos[]) {
		vistos[inicio]=true;
		if(inicio==fin){
			res= cont[0];
			return;
		}
		else{
			for(int u:grafo[inicio]){
				if(!vistos[u]){
					int temp =cont[0];
					cont[0]=Math.max(peso[inicio][u],cont[0]);
					dfs(temp,u,cont,vistos);
				}
			}
			cont[0]=Math.min(padre, cont[0]);
			return;
		}
		
	}
}
class arista implements Comparable<arista> {
	int x;
	int y;
	int peso;

	arista(int x, int y, int peso) {
		this.x = x;
		this.y = y;
		this.peso = peso;
	}

	@Override
	public int compareTo(arista o) {
		return Integer.compare(this.peso, o.peso);
	}

	public String toString() {
		return this.x + " " + this.y + " " + this.peso + " ";
		// TODO Auto-generated method stub

	}
}
class Quick_union {
	int arr[];
	public Quick_union(int a) {
		this.arr = new int[a];
		Arrays.fill(this.arr, -1);
	}
	public int find(int u) {
		if (arr[u] < 0)
			return u;
		else {
			int v = arr[u];
			while (arr[v] > -1)
				v = arr[v];
			return v;
		}
	}
	public void union(int u, int v) {
		int p1 = find(u);
		int p2 = find(v);
		if (arr[p1] < arr[p2]) {
			arr[p1] = arr[p2] + arr[p1];
			arr[p2] = p1;
		} else {
			arr[p2] = arr[p2] + arr[p1];
			arr[p1] = p2;
		}
	}

}

/*
2
4 4
1 2 100
2 3 100
3 4 100
4 1 200
1
1 4
6 9
2 4 5
5 1 7
3 6 6
3 1 4
2 3 2
1 2 1
6 5 42
4 5 3
4 6 5
4
1 3
3 4
5 4
6 1
5 8
5 1 37
3 1 64
4 3 85
2 4 60
3 4 33
1 4 61
2 1 47
4 3 8
8
3 1
3 4
2 5
5 2
5 3
4 5
2 1
2 5
*/
