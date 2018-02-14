package uva;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class UVA991_Safe_Salutations {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int res []=new int [11];res[1]=1;
		for (int i = 2; i < res.length; i++) {
			int cont =0;
			for (int j = 1,k=i*2; j < k; j++) {
				int a =j-1;
				int b=(k-1)-j;
				int a1=a/2,b1=b/2;
				if((a1+b1+1)==i){
					if(a1==0||b1==0)
						cont+=res[a1]+res[b1];
					else
						cont+=res[a1]*res[b1];
				}
			}
			res[i]=cont;
		}
		String linea = in.readLine();
		StringBuilder out1= new StringBuilder();
		while(linea!=null&&!linea.trim().equals("")){
			out1.append(res[Integer.parseInt(linea)]+"\n\n");
			in.readLine();
			linea=in.readLine();
		}
		out1.delete(out1.length()-2, out1.length());
		out.println(out1);
		out.close();
	}
}

