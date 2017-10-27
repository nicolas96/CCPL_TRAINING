package uva;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
public class UVA10919_Prerequisites {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter (System.out);
		String linea=in.readLine();
		while(!linea.trim().equals("0")){
			StringTokenizer toks = new StringTokenizer(linea);
			int k=Integer.parseInt(toks.nextToken());
			int cursos=Integer.parseInt(toks.nextToken());
			HashSet<String>cur=new HashSet<String>();
			while(cur.size()<k){
				toks= new StringTokenizer(in.readLine());
				while(toks.hasMoreTokens())
					cur.add(toks.nextToken());
			}
			int req[]=new int [cursos];
			int aprob[]=new int [cursos];
			for (int i = 0; i < cursos; i++) {
				toks= new StringTokenizer(in.readLine());
				int a =Integer.parseInt(toks.nextToken());
				int b =Integer.parseInt(toks.nextToken());
				req[i]=b;
				while(toks.hasMoreTokens()){
					if(cur.contains(toks.nextToken()))
						aprob[i]++;
				}
				
			}
			boolean puede=true;
			for (int i = 0; i < cursos; i++) {
				if(aprob[i]<req[i]){
					puede=false;
					i=cursos;
				}
			}
			out.println(puede?"yes":"no");
			linea=in.readLine();
		}
		out.close();
	}
}
