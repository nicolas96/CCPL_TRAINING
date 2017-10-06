package algoritmos;

public class borde {

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
