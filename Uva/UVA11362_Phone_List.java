package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA11362_Phone_List {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i <casos; i++) {
			int n = Integer.parseInt(in.readLine().trim());
			String s[]= new String[n];
			for (int j = 0; j < n; j++) {
				s[j]= in.readLine().trim();
			}
			Arrays.sort(s);
			boolean puede=true;
			loop:for (int j = 0; j < s.length-1; j++) {
				if(s[j].length()<=s[j+1].length()){
					if(s[j].equals(s[j+1].substring(0, s[j].length()))){
						puede=false;
						break loop;
					}
				//System.out.println(Arrays.toString(borde));
				}	
			}
			if(puede)
				out.println("YES");
			else
				out.println("NO");
			
		}
		out.close();
	}
	
	public static int[] borde(char[] p) {
		int m = p.length;
		int[] borde = new int[m + 1];
		borde[0] = -1;
		borde[1] = 0;
		for (int q = 1; q <= m; q++) {
			int k = borde[q - 1];
			while (k >= 0 && p[q - 1] != p[k])
				k = borde[k];
			if (k >= 0 && p[q - 1] == p[k])
				k = k + 1;
			else
				k = 0;
			borde[q] = k;
		}
		return borde;
	}
}
