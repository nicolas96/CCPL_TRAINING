
//Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

//Please name your class Main
public class UVA13282_Cakey_McCakeFace {
	public static void main (String[] args) throws Exception {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String linea = in.readLine();
		while(linea!=null&&!linea.trim().equals("")){
		    int N=Integer.parseInt(linea);
		    int M=Integer.parseInt(in.readLine());
		    long izq[]=new long[N];
		    long der[]=new long[M];
		    StringTokenizer toks =new StringTokenizer(in.readLine());
		    StringTokenizer toks1 = new StringTokenizer(in.readLine());
		    for(int i=0;i<N;i++){
		        izq[i]=Long.parseLong(toks.nextToken());
		    }
		    for(int i=0;i<M;i++){
		        der[i]=Long.parseLong(toks1.nextToken());
		    }
		    long[]guia=new long[N*M];
		    int index=0;
		    for(int i=0;i<N;i++){
		        for(int j=0;j<M;j++){
		        	guia[index]=der[j]-izq[i];
		        	index++;
		        }
		    }
		    Arrays.sort(guia);
//		    System.out.println(Arrays.toString(guia));
		    int k=0;
		    if(guia[guia.length-1]>=0){
		    	while(guia[k]<0)k++;
//			    System.out.println(guia[k]);
			    long mejor=guia[k],pivote=guia[k],cont=1,max=1;
			    for (int i = k+1; i < guia.length; i++) {
					if(pivote==guia[i]){
						cont++;
					}else{
						if(cont>max){
							mejor=pivote;
							max=cont;
						}
						cont=1;
					}
					pivote=guia[i];
				}
			    out.println(mejor);
		    }else
		    	out.println(0);
		    linea=in.readLine();
		}
		out.close();
	}
}

