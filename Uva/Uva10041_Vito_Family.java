package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Vito_Family_Uva10041 {
	static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i <n ; i++) {
			StringTokenizer toks = new StringTokenizer(in.readLine());
			 arr = new int[Integer.parseInt(toks.nextToken())];
			for (int j = 0; j < arr.length; j++) {
				arr[j]=Integer.parseInt(toks.nextToken());
			}
			Arrays.sort(arr);
			out.println(dist(solve()));

		}
		out.close();
	}
	static int solve(){
		int a=0;
		int b =arr[arr.length-1];
		int i =0;
		int t1;
		int t2;
		while(i++<100){
			
				
			t1=(b-a)/3+a;
			t2=b-(b-a)/3;	
			if (dist(t1)<dist(t2))
				b=t2;
			else
				a=t1;
		}
		return (a+b)/2;
		
	}
	static int dist(int a ){
		int res =0;
		for (int i = 0; i < arr.length; i++) {
			res+=Math.abs(arr[i]-a);
		}
		return res;
	}
	
}
