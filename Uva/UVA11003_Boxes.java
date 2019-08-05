
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	static int x[];
	static int y[];
	static int memo[][] = new int[3002][1001];
	static int memoGui[][] = new int[3002][1001];
	static int caso = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		while (line != null && !line.trim().equals("0")) {
			int N = Integer.parseInt(line);
			caso++;
			x = new int[N];
			y = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer toks = new StringTokenizer(in.readLine());
				int peso = Integer.parseInt(toks.nextToken());
				int max = Integer.parseInt(toks.nextToken());
				x[i] = peso;
				y[i] = max;
			}
			out.println(respuesta(3001, 0));
			line = in.readLine();
		}
		out.close();
	}

	private static int respuesta(int maxValue, int index) {
		if (index == x.length)
			return 0;
		else {
			if (memoGui[maxValue][index] == caso) {
				return memo[maxValue][index];
			} else {
				if (maxValue >= x[index]) {
					int temp = Math
							.max(1 + respuesta(Math.min(maxValue == 3001 ? y[index] : maxValue - x[index], y[index]),
									index + 1), respuesta(maxValue, index + 1));
					memoGui[maxValue][index] = caso;
					return memo[maxValue][index] = temp;

				} else {
					int temp = respuesta(maxValue, index + 1);
					memoGui[maxValue][index] = caso;
					return memo[maxValue][index] = temp;
				}
			}
		}
	}
}


