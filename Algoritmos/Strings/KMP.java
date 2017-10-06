package algoritmos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class KMP {
	public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//        int casos = Integer.parseInt(in.readLine());
//        for (int i = 0; i < casos; i++) {
//            String t = in.readLine();
//            int patron = Integer.parseInt(in.readLine());
//            for (int j = 0; j < patron; j++) {
//                String p = in.readLine();
//                if (findPattern(p, t))
//                    out.println("y");
//                else out.println("n");
//            }
//        }
        String t = "aaaaaaa";
        out.println(findPattern("aa",t));
//        if (findPattern("aa", t))
//        	out.println("y");
//        else out.println("n");
        out.close();
        in.close();
    }
     
	
	// static boolean findPattern(String pattern,String text){
	 static int findPattern(String pattern,String text){
	        int count = 0;
	        int ocurr=0;
	        for (int i = 0,j=0; i < text.length(); i++) {
	            if(pattern.charAt(j)==text.charAt(i)){
	                count++;
	                j++;
	            }
	            else {j=0; count = 0;}
	            if (count == pattern.length()) {
	            	ocurr++;
	            	j=0; count = 0;
	            }
	            	//return true;
	        }
	        return ocurr;
	        //return false;
	    }
}
