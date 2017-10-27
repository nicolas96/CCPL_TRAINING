package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA10203_SnowClearing {
	public static void main(String[] args) throws  IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos=Integer.parseInt(in.readLine())+1;
		in.readLine();
		for (int i = 1; i <casos; i++) {
			double res=0;
			StringTokenizer toks= new StringTokenizer(in.readLine());
			String linea = in.readLine();
			while(linea!=null&&!linea.trim().equals("")){
				toks= new StringTokenizer(linea);
				double x1=Double.parseDouble(toks.nextToken())/1000,y1=Double.parseDouble(toks.nextToken())/1000
						,x2=Double.parseDouble(toks.nextToken())/1000,y2=Double.parseDouble(toks.nextToken())/1000;
				
				double di1=dist(x1,x2),di2=dist(y1,y2);
				res+=Math.sqrt((di1*di1)+(di2*di2));
				linea=in.readLine();
			}
			int horas=(int)(res*2/20);
			int minutos=(int)Math.floor((((res*2/20)-Math.floor(res*2/20))*60)+0.5);
			if(minutos==60){
				minutos=0;
				horas++;
			}
			if(i==casos-1)
				out.printf("%d:%02d\n",horas,minutos);
			else
				out.printf("%d:%02d\n\n",horas,minutos);
		}
		out.close();
	}
	static double dist(double x1,double x2){
		double temp=x2-x1;
		return temp<0?temp*-1:temp;
	}
	static double dist(double x1,double y1, double x2, double y2){
		return (Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)));
	}
	
}
