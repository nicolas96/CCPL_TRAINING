package algoritmos;

import java.util.Arrays;

public class z_Function {
	public static void main(String[] args) {
		StringBuilder cadena = new StringBuilder();
		cadena.append("1231");
		
		cadena.append("#");
		cadena.append("1231");
		System.out.println(Arrays.toString(zFucntion("123456789101110987654321")));
	}
	
	static int[] zFucntion(String s) {
		int n = s.length(), R = 0, L = 0;
		int z[] = new int[n];
		for (int i = 1; i < n; i++) {
			z[i] = 0;
			if (R > i) {
				z[i] = Math.min(R - i, z[i - L]);
			}
			while (i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) {
				z[i]++;
			}
			if (i + z[i] > R) {
				L = i;
				R = i + z[i];
			}
		}
		// z[0] = n;
		return z;
	}
}
