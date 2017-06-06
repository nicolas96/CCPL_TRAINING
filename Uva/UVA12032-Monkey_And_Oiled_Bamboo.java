package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Monkey_And_Oiled_Bamboo_UVA12032 {
	static int arr[];
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader in = new BufferedReader ( new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			int casos = Integer.parseInt(in.readLine());
			for (int i = 1; i <= casos; i++) {
				int n = Integer.parseInt(in.readLine());
				arr= new int [n];
				StringTokenizer toks = new StringTokenizer(in.readLine());
				int j=0;
				while(toks.hasMoreTokens()){
					arr[j]=Integer.parseInt(toks.nextToken());
					j++;
				}
				if(arr.length>1)
					out.println("Case "+i+": "+solve());
				else
					out.println("Case "+i+": "+arr[0]);
			}
			out.close();
		}
		static int solve(){
			int a=0,b=Integer.MAX_VALUE,m=0,mejor=Integer.MAX_VALUE;
			while(a<=b){
				m=(a+b)/2;
				if(puede(m)){
					mejor=Math.min(mejor,m);
					b=m-1;
				}else{
					a=m+1;
				}
			}
			return mejor;
		}
		static boolean puede(int k ){
			boolean p= true;
			if(k<arr[0])
				return false;
			else if(k==arr[0])k--;
			for (int i = 0; i < arr.length-1; i++) {
				int l =arr[i+1]-arr[i];
				if(l>k){
					p=false;
					i=arr.length;
				}else if(l==k)k--;
			
			}
			return p ;
		}
}
