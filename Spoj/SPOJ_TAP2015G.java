package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
public class TAP2015G {
	static HashMap<Character,Character>imagen= new HashMap<Character,Character>();
	static StringBuilder b;
	static StringBuilder a ;
	static int memoria[][][];
	static int memoriaGuia[][][];
	static int casos=1;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter (System.out);
		memoria= new int[1002][1002][2];
		memoriaGuia= new int[1002][1002][2];
		imagen.put('o', 'o');imagen.put('v', 'v');imagen.put('w', 'w');imagen.put('x', 'x');
		imagen.put('b', 'd');imagen.put('d', 'b');imagen.put('p', 'q');imagen.put('q', 'p');
		String linea = in.readLine();
		while(linea!=null&&!linea.equals("")){
			int n=Integer.parseInt(linea);
			a= new StringBuilder();
			b = new StringBuilder();
			a.append(in.readLine());
			b.append(in.readLine());
			if(n>1){
				int k=solve(0,0,1)+1;
				int q =solve(0,0,0);
				int res=Math.min(q,k);
				out.println(res>=(Integer.MAX_VALUE/6)?-1:res);
			}else{
				if(a.charAt(0)==b.charAt(0))
					out.println(0);
				else if(imagen.get(a.charAt(0))==b.charAt(0))
					out.println(1);
				else
					out.println(-1);
			}
			linea=in.readLine();
			casos++;
		}
		out.close();
	}
	private static int solve( int i, int j,int inv) {
		if((i+j)==a.length()-1){
			if(inv==0)
				if(b.charAt(i+j)!=a.charAt(i))
					return Integer.MAX_VALUE/6;
			if(inv==1)
				if(b.charAt(i+j)!=imagen.get(a.charAt(a.length()-1-j)))
					return Integer.MAX_VALUE/6;
			return 0;
		}
		if(memoriaGuia[i][j][inv]==casos)return memoria[i][j][inv];
		if(inv==0){
			if(b.charAt(i+j)!=a.charAt(i))
				return Integer.MAX_VALUE/6;
			else{
				int temp=Math.min(solve(i+1,j,0), solve(i+1,j,1)+1);
				memoriaGuia[i][j][inv]=casos;
				return memoria[i][j][inv]=temp;
			}
		}
		if(inv==1){
			if(b.charAt(i+j)!=imagen.get(a.charAt(a.length()-1-j)))
				return Integer.MAX_VALUE/6;
			else{
				int temp=Math.min(solve(i, j+1,0)+1,solve(i,j+1,1));
				memoriaGuia[i][j][inv]=casos;
				return memoria[i][j][inv]=temp;
			}
		}
		return 0;
	}
}

