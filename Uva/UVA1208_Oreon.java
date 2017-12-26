

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA1208 {

	static int N;
	static ArrayList<edge> lAdy[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int cases = Integer.parseInt(in.readLine());
		for (int c = 1; c <= cases; c++) {
			N = Integer.parseInt(in.readLine());
			StringTokenizer tok;
			lAdy = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				lAdy[i] = new ArrayList<edge>();
				tok = new StringTokenizer(in.readLine(), ",");
				int j = 0;
				while (tok.hasMoreTokens()) {
					int t = Integer.parseInt(tok.nextToken().trim());
					if (t > 0)
						lAdy[i].add(new edge(i, j, t));
					j++;
				}
			}
			out.println("Case " + c + ":");
			for (edge e : primPQ()) {
				if (e.start < e.end)
					out.println(((char) ('A' + e.start)) + "-" + ((char) ('A' + e.end)) + " " + e.with);
				else
					out.println(((char) ('A' + e.end)) + "-" + ((char) ('A' + e.start)) + " " + e.with);

			}
		}
		out.close();
	}

	static public ArrayList<edge> primPQ() {
		boolean visit[] = new boolean[lAdy.length];
		PriorityQueue<edge> pq = new PriorityQueue<>();
		// int res[][] = new int[lAdy.length][lAdy.length];
		ArrayList<edge> res = new ArrayList<edge>();
		pq.addAll(lAdy[0]);
		while (!pq.isEmpty()) {
			edge v = pq.poll();
			if (!visit[v.end]) {
				visit[v.start] = true;
				visit[v.end] = true;
				// res[v.start][v.end] = res[v.end][v.start] = v.with;
				res.add(v);
				pq.addAll(lAdy[v.end]);
			}
		}
		for (int i = 0; i < res.size(); i++) {
			int pivote=res.get(i).start;
			if(pivote>res.get(i).end){
				res.get(i).start=res.get(i).end;
				res.get(i).end=pivote;
			}
		}
		Collections.sort(res, new Comparator<edge>() {

			@Override
			public int compare(edge a, edge b) {
				if(a.with==b.with){
					if(a.start==b.start){
						return Integer.compare(a.end, b.end);
					}else{
						return Integer.compare(a.start, b.start);
					}
				}else{
					return Integer.compare(a.with, b.with);
				}
			}

		});
		return res;
	}

}

class edge implements Comparable<edge> {
	int start, end, with;

	public edge(int start, int end, int with) {
		this.start = start;
		this.end = end;
		this.with = with;
	}

	@Override
	public int compareTo(edge b) {

		return Integer.compare(this.with, b.with);
	}

	@Override
	public String toString() {
		return (this.start) + "," + (this.end) + "," + this.with;
	}
}
