package uva;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Airports_UVA11733 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			StringTokenizer toks = new StringTokenizer(in.readLine());
			int puntos=Integer.parseInt(toks.nextToken());
			int aristas=Integer.parseInt(toks.nextToken());
			int costo=Integer.parseInt(toks.nextToken());
			Quick_union arr = new Quick_union(puntos);
			caminos t[] = new caminos[aristas];
			for (int j = 0; j < aristas; j++) {
				 toks = new StringTokenizer(in.readLine());
				t [j]= new caminos(Integer.parseInt(toks.nextToken()),Integer.parseInt(toks.nextToken()),Integer.parseInt(toks.nextToken()));
			}
			Arrays.sort(t);
			
			long suma=0;
			for (int j = 0; j < t.length; j++) {
				int p1 = arr.find(t[j].x-1);
				int p2 = arr.find(t[j].y-1);
				if (p1 != p2&&t[j].c<costo) {
					arr.union(t[j].x-1, t[j].y-1);
					suma+=t[j].c;
				}
			}
			int cont=0;
			for (int j = 0; j < arr.arr.length; j++) {
				if(arr.arr[j]<0)cont++;
			}
			suma+=cont*costo;
			out.println("Case #"+(i+1)+": "+suma+" "+cont);
			
		}
		out.close();

	}
	static class Quick_union {
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
				while (arr[v] > 0)
					v = arr[v];
				return v;
			}
		}

		public void union(int u, int v) {
			int p1 = find(u);
			int p2 = find(v);
			if (p1 > p2) {
				arr[p1] = arr[p2] + arr[p1];
				arr[p2] = p1;
			} else {
				arr[p2] = arr[p2] + arr[p1];
				arr[p1] = p2;
			}
		}
	}
}
class caminos implements Comparable<caminos>{
	int x;
	int y;
	int c;
	caminos(int i){
		this.x=i;
		this.y=i;
		this.c=i;
	}
	caminos(int x,int y,int c){
		this.x=x;
		this.y=y;
		this.c=c;
	}
	@Override
	public int compareTo(caminos o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.c, o.c);
	}
	public String toString(){
		return this.x+" "+this.y+" "+this.c;
	}
	
}
