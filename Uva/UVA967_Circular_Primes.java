
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA967_Circular_Primes {
	static boolean primos [];
	static int res[]= new int[999_902];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		primos();
		for (int i = 101; i <=1_000_000; i++) {
			res[i-100]=solucion(i)+res[i-101];
		}
		String linea = in.readLine();
		while(linea!=null&&!linea.trim().equals("-1")){
			StringTokenizer toks = new StringTokenizer(linea);
			int a =Integer.parseInt(toks.nextToken());
			int b = Integer.parseInt(toks.nextToken());
			int sol=res[b-100]-res[(a-1-100)<0?0:(a-1-100)];
			if(sol==0)
				out.println("No Circular Primes.");
			else if(sol==1)
				out.println("1 Circular Prime.");
			else
				out.printf("%d Circular Primes.\n",sol);
			linea = in.readLine();
		}
		out.close();
	}
	
	private static int solucion(int a) {
		char s []=(a+"").toCharArray();
		char copia []=new char[s.length];
		boolean puede =true;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				int index=(j-i)<0?s.length-Math.abs(i-j):j-i;
				copia[j]=s[index];
			}
			if(copia[0]!='0'){
				String temp ="";
				for (int j = 0; j < copia.length; j++) {
					temp+=copia[j];
				}
				if(!primos[Integer.parseInt(temp)]){
					puede=false;
					i=s.length;
				}
			}
			
			
		}
		return puede?1:0;
	}

	public static void primos() {
		int max = 1_000_001;
		 primos = new boolean[max];
		primos[2] = true;
		for (int i = 3; i < max; i += 2) {
			primos[i] = true;
		}
		int I = (int) Math.sqrt(max) + 1;
		for (int i = 3; i <= I; i += 2) {
			if (primos[i]) {
				for (int j = i * i, bi = 2 * i; j < max; j += bi) {
					primos[j] = false;
				}
			}
		}
		
	}
}

