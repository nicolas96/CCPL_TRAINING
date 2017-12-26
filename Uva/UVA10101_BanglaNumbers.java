

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA10101{

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linea = in.readLine();
		long casos=1;
		while(linea!=null&&!linea.equals("")) {
			long a=Long.parseLong(linea);
			StringBuilder k = new StringBuilder();
			k =a==0?k.append("0"):solve(a);
			if(casos<10)
			out.printf("   %d. %s\n",casos,k);
			else if(casos<100)
				out.printf("  %d. %s\n",casos,k);
			else if(casos<1000)
				out.printf(" %d. %s\n",casos,k);
			else
				out.printf("%d. %s\n",casos,k);
			//out.printf("%d. %s\n",casos,solve(a));
			casos++;
			linea=in.readLine();
		}
		out.close();
	}
	
	private static StringBuilder solve(long a) {
		long arr[]= {100,1000,100000,10000000};
		String arr1[]= {"shata","hajar","lakh","kuti"};
		StringBuilder res= new StringBuilder();
		while(a!=0) {
			if(a%arr[0]!=0)
			res.insert(0, (a%arr[0])+" ");
			if((a/arr[0])%10!=0)
				res.insert(0, (a/arr[0])%10+" "+arr1[0]+" ");
			if(a/arr[1]%100!=0)
				res.insert(0, a/arr[1]%100+" "+arr1[1]+" ");
			if(a/arr[2]%100!=0)
				res.insert(0, a/arr[2]%100+" "+arr1[2]+" ");
			if(a/arr[3]!=0)
				res.insert(0, arr1[3]+" ");
			a=a/arr[3];
		}
		if(res.length()>0)
			res=res.delete(res.length()-1, res.length());
		return res;
		
	}
}
