
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA900_Brick_Wall_Patterns {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linea = in.readLine();
		int arr[]= new int [51];arr[1]=1;arr[0]=1;
		for (int i = 2; i < arr.length; i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		
		while(linea!=null&&!linea.trim().equals("0")){
			out.println(arr[Integer.parseInt(linea)]);
			linea=in.readLine();
		}
		out.close();
	}
}
