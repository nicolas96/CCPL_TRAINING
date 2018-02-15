

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
public class UVA970_Particles {
	static PrintWriter out;
	static int memoria[][]= new int [102][102];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		out = new PrintWriter (System.out);
		//System.setOut(new PrintStream("casos.sol"));
		int casos =Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < casos; i++) {
			String s =in.readLine().trim().toUpperCase();
			int arr[]= new int [s.length()];
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j)=='X')
					arr[j]=0;
				if(s.charAt(j)=='Y')
					arr[j]=1;
				if(s.charAt(j)=='Z')
					arr[j]=2;
			}
			solve(arr);
			
		}
		out.close();
	}
	private static void solve(int[] arr) throws IOException {
//		int memoria[][]= new int [arr.length+1][arr.length+1];
		for (int i = 1; i <= arr.length; i++) {
			memoria[i][i]=0;
			memoria[i][i]|=1<<arr[i-1];
		}
		for (int s = 1; s < arr.length+1; s++) {
			for (int i = 1; i < arr.length+1-s; i++) {
				int j=i+s;
				memoria[i][j]=0;
				for (int k = i; k < j; k++) {
					int temp=memoria[i][k];
					int temp1=memoria[k+1][j];
					memoria[i][j]|=((temp&1)&(temp1&1))==1||(((((temp)&(1<<1))>>1)&(((temp1&(1<<1)))>>1))==1)||(((((temp)&(1<<1))>>1)&(((temp1&(1<<2)))>>2))==1)||(((((temp)&(1<<2))>>2)&(((temp1&(1<<1)))>>1))==1)?2:0;
					memoria[i][j]|=((temp&1)&(((temp1)&(1<<1))>>1))==1||(((((temp)&(1<<1))>>1)&(temp1&1))==1)||(((((temp)&(1<<2))>>2)&(((temp1&(1<<2)))>>2))==1)?1:0;
					memoria[i][j]|=((temp&1)&(((temp1)&(1<<2))>>2))==1||(((((temp)&(1<<2))>>2)&(temp1&1))==1)?4:0;
					if(memoria[i][j]==7)break;
					
				}
			}
			
		}
//		for (int i = 0; i < memoria.length; i++) {
//				out.println(Arrays.toString(memoria[i]));
//			
//		}
		out.println(((memoria[1][arr.length]&(1<<2))>>2)==1?"Z":((memoria[1][arr.length]&(1<<1))>>1)==1?"Y":"X");
	}
}

