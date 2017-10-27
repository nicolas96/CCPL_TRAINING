package uva;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Settin_Problems_Uva11269 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String linea = in.readLine();
		while (linea != null&&!linea.trim().equals("")) {
		
			int N = Integer.parseInt(linea);
			int S[] = new int[N];
			int G[] = new int[N];
			pareja T[]=new pareja[N];
			pareja[] res=new pareja[N];
			linea = in.readLine();
			
			StringTokenizer toks = new StringTokenizer(linea, " ");
			for (int i = 0; i < S.length; i++) {
				
				S[i] = Integer.parseInt(toks.nextToken());
			}
			linea = in.readLine();
			
			toks = new StringTokenizer(linea, " ");
			for (int i = 0; i < G.length; i++) {
				
				G[i] = Integer.parseInt(toks.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				T[i]=new pareja(S[i],G[i]);
			}
			Arrays.sort(T);
			
			int i=0;
			int j =N-1;
			int k=0;
			while(k<N){
				if(T[N-1].s<=T[N-1].g){
					res[i]=new pareja(T[N-1].s,T[N-1].g);
					i++;
				}else{
					res[j]=new pareja(T[N-1].s,T[N-1].g);
					j--;
				}
				T[N-1].s=200;
				T[N-1].g=200;
				k++;
				Arrays.sort(T);
				
			}
			
			int mejor =0;
			
			for (int k2 = 0; k2 < N-1; k2++) {
				mejor +=res[k2].s;
				if(res[k2].g>res[k2+1].s){
					res[k2+1].g=(res[k2].g-res[k2+1].s)+res[k2+1].g;
				}
					
			}
			mejor=res[N-1].s+res[N-1].g+mejor;
			
			out.println(mejor);
			linea = in.readLine();
		}
		out.close();
	}

}

class pareja implements Comparable<pareja>{
	int s;
	int g;
	pareja(int s,int g){
		this.s=s;
		this.g=g;
	}
	@Override
	public int compareTo(pareja o) {
		if(Math.min(this.s, this.g)<Math.min(o.s, o.g))
			return 1;
		else if(Math.min(this.s, this.g)>Math.min(o.s, o.g))
				return-1;
		return 0;
	}
	public String toString(){
		return this.s+" "+this.g;
	}
	
	
}