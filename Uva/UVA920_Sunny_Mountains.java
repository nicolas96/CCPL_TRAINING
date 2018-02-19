
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA920_Sunny_Mountains {
	public static void main(String[] args)  throws Exception{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos = Integer.parseInt(in.readLine());
		for (int i = 0; i < casos; i++) {
			int n =Integer.parseInt(in.readLine());
			punto arr[]= new punto[n];
			for (int j = 0; j < n; j++) {
				StringTokenizer toks = new StringTokenizer(in.readLine());
				arr[j]=new punto(Integer.parseInt(toks.nextToken()),Integer.parseInt(toks.nextToken()));
			}
			Arrays.sort(arr);
			double cont=0;
			int pivote=n-1;
			boolean primero=true;
			for (int j =  arr.length-2; j >-1; j--) {
				if(arr[j].y>arr[pivote].y){
					if (primero){
						cont+=dist(arr[j].x,arr[pivote].x,arr[j].y,arr[pivote].y);
						primero=false;
						pivote=j;
					}else{
						double inter[]=ds(0,arr[pivote].y,arr[pivote].x,arr[pivote].y,arr[j].x,arr[j].y,arr[j+1].x,arr[j+1].y);
						cont+=dist(inter[0],arr[j].x,inter[1],arr[j].y);
						pivote=j;
					}
				}
			}
			out.printf(String.format("%.2f\n",cont).replace(",","."));
		}
		out.close();
	}
	static double[ ]ds(double x1, double y1, double x2, double y2, 
			double x3, double y3, double x4, double y4){
		double xa =x2-x1,xb=x4-x3,xc=x1-x3,ya=y2-y1,yb=y4-y3,yc=y1-y3,d=yb*xa-xb*ya,n=xb*yc-yb*xc;
		return Math.abs(d)<1e-11?null:new double[]{x1+xa*n/d,y1+ya*n/d};
	}
	static double dist(double x,double x1,double y,double y1){
		return Math.sqrt(Math.pow(x-x1, 2)+Math.pow(y-y1, 2));
	}
}
class punto implements Comparable<punto>{
	int x;
	int y;
	punto(int x,int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public int compareTo(punto o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.x, o.x);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.x+"---"+this.y;
	}
}

