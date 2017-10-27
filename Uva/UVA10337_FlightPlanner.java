package uva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class UVA10337_FlightPlanner {
	static int[][]arr ;
	static int[][]mem ;
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		Scanner tec = new Scanner(System.in);
		int casos = tec.nextInt();
		for (int i = 0; i < casos; i++) {
			int X=tec.nextInt();
			X=X/100;
			arr= new int[10][X];
			mem=new int[10][X];
			for (int j = 9; j>-1; j--) {
				for (int k = 0; k < X; k++) {
					arr[j][k]=tec.nextInt();
				}
			}
			out.println(Math.min(solve(1,X-1)+(-1*arr[1][X-1])+20, solve(0,X-1)+30+(-1*arr[0][X-1])));
			out.println();
		}
		tec.close();
		out.close();
	}
	private static int solve(int i,int j) {
		if(i<0||j<0||i>9||j>=arr[0].length)
			return Integer.MAX_VALUE/2;
		if(j==0){
			if(i>0)
				return Integer.MAX_VALUE/2;
			else
				return 0;
		}
		if(mem[i][j]!=0)
			return mem[i][j];
		else{
			int a=0,b=0,c=0;
			if(j>-1){
				a=arr[i][j-1];
				if(i-1>-1)
					c=arr[i-1][j-1];
				if(i+1<10)
					b=arr[i+1][j-1];
			}
			mem[i][j]=Math.min(solve(i,j-1)+30+(a*-1), Math.min(solve(i+1,j-1)+20+(-1*b),
					solve(i-1,j-1)+60+(-1*c)));
			return mem[i][j];
		}
	}
}
