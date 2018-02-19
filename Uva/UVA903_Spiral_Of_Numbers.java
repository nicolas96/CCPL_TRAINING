
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
public class UVA903_Spiral_Of_Numbers {
	static 	long arr[]= new long[100_001];
	public static void main(String[] args)throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		System.setOut(new PrintStream("espiral.out"));
		arr[0]=1;
		for (int i = 1; i < arr.length; i++) {
			arr[i]=arr[i-1]+8*i;
		}
		String linea =in.readLine();
		while(linea!=null&&!linea.trim().equals("")){
			long res[][]={{7,8,9},{6,1,2},{5,4,3}};
			long n =Long.parseLong(linea);
			int index=binary(n);
			int raiz=(int)Math.sqrt(arr[index]);
			if(index>0){
				res[1][1]=n;
				long guia=n-arr[index-1];
				long k=arr[index]-arr[index-1];
				if(guia<raiz){
					res[0][2]=n+k;res[1][2]=n+k+1;res[2][2]=n+k+2;
					res[0][1]=n-1;res[2][1]=n+1;
					res[0][0]=n-(8*(index-1)+2);res[1][0]=n-(8*(index-1)+1);res[2][0]=n-(8*(index-1));
					if(guia==1){
						res[0][0]=arr[index]-1;
						res[0][1]=arr[index];
						res[1][0]=n-1;
						res[2][0]=n-(8*(index-1));
					}
					if(guia==2)
						res[0][0]=arr[index-1];
					if(guia==(raiz-2))
						res[2][0]=n+2;
					if(guia==(raiz-1)){
						res[1][0]=n+1;
						res[2][0]=n+k+4;
						res[2][1]=n+k+3;
					}
				}
				if(guia>=raiz&&guia<((raiz*2)-1)){
					res[2][0]=n+k+4;res[2][1]=n+k+3;res[2][2]=n+k+2;
					res[1][0]=n+1;res[1][2]=n-1;
					res[0][0]=n-(8*(index-1)+2);res[0][1]=n-(8*(index-1)+3);res[0][2]=n-(8*(index-1)+4);
					if(guia==(raiz*2)-2){
						res[1][0]=n+k+5;
						res[0][1]=n+1;
						res[0][0]=n+k+6;
					}
					if(guia==(raiz*2)-3){
						res[0][0]=n+2;
					}
					if(guia==raiz){
						res[0][2]=n-2;
					}
				}
				if(guia>=((raiz*2)-1)&&guia<((raiz*3)-2)){
					res[0][0]=n+k+6;res[1][0]=n+k+5;res[2][0]=n+k+4;
					res[0][1]=n+1;res[2][1]=n-1;
					res[0][2]=n-(8*(index-1)+4);res[1][2]=n-(8*(index-1)+5);res[2][2]=n-(8*(index-1)+6);
					if(guia==((raiz*2)-1))
						res[2][2]=n-2;
					if(guia==((raiz*3)-4))
						res[0][2]=n+2;
					if(guia==((raiz*3)-3)){
						res[1][2]=n+1;
						res[0][1]=n+k+7;
						res[0][2]=n+k+8;
					}
				}
				if(guia>=((raiz*3)-2)&&guia<=((raiz*4)-4)){
					res[0][0]=n+k+6;res[0][1]=n+k+7;res[0][2]=n+k+8;
					res[1][0]=n-1;res[1][2]=n+1;
					res[2][0]=n-(8*(index-1)+8);res[2][1]=n-(8*(index-1)+7);res[2][2]=n-(8*(index-1)+6);
					if(guia==((raiz*3)-2))
						res[2][0]=n-2;
					if(guia==((raiz*4)-4)){
						res[2][2]=n+2;
						res[2][1]=arr[index-1]+1;
						res[2][0]=arr[index-1];
					}
					if(guia==((raiz*4)-5)){
						res[2][2]=arr[index-1]+1;
					}
				}
			}
			linea=in.readLine();
			for (int i = 0; i < res.length; i++) {
				for (int j = 0; j < res.length; j++) {
					out.print(res[i][j]+";");
				}
				out.println();
			}
		}
		out.close();
	}
	private static int binary(long n) {
		int a=0;
		int b=100_000;
		int mejor=100_001;
		int m=0;
		while(a<=b){
			m=(a+b)/2;
			if(n<=arr[m]){
				mejor=Math.min(mejor, m);
				b=m-1;
			}else{
				a=m+1;
			}
		}
		return mejor;
	}
}

