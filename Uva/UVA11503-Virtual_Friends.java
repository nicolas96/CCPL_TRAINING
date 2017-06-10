package uva;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Virtual_Friends_UVA11503 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			int t = Integer.parseInt(in.readLine());
			Quick_union arr = new Quick_union(t*2);
			int cont=-1;
			HashMap<String,Integer> nombre= new HashMap<String,Integer>();
			for (int j = 0; j < t; j++) {
				StringTokenizer toks=new StringTokenizer(in.readLine());
				String a=toks.nextToken();
				String b=toks.nextToken();
				int n1 = 0;
				int n2= 0;
				if(nombre.containsKey(a)){
					n1=nombre.get(a);
				}else{
					n1=cont+1;
					cont++;
					nombre.put(a, n1);
				}
				if(nombre.containsKey(b)){
					n2=nombre.get(b);
				}else{
					n2=cont+1;
					cont++;
					nombre.put(b, n2);
				}
				int p1 = arr.find(n1);
				int p2 = arr.find(n2);
				if (p1 != p2) {
					arr.union(n1, n2);
				}
				out.println(Math.max(Math.abs(arr.arr[arr.find(n1)]),Math.abs(arr.arr[arr.find(n2)])));
			}
			
			
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

