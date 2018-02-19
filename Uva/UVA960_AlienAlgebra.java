
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;

public class alienALgebra {
	public static void main(String[] args)throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int casos=Integer.parseInt(in.readLine().trim());
		for (int i = 0; i <casos; i++) {
			StringBuilder a =new StringBuilder(in.readLine());
			StringBuilder b=new StringBuilder(in.readLine());
			quitarI(a);quitarK(a);
			
			quitarI(b);quitarK(b);
			out.println(a.toString().equals(b.toString()));
		}
		out.close();
	}
	static void quitarI(StringBuilder s){
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='i'){
				int cont=1,k=i+2,temp=i;
				while(cont>0){
					if(s.charAt(k)=='('){
						cont++;
					}else if(s.charAt(k)==')'){
						cont--;
					}
					k++;
				}
				s.replace(i, k, s.substring(i+2, k-1));
				i=temp-1;
			}
		}
	}
	
	static void quitarK(StringBuilder s){
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='k'){
				int cont=1,k=i+2,temp=i;
				while(cont>0){
					if(s.charAt(k)=='('){
						cont++;
					}else if(s.charAt(k)==')'){
						cont--;
					}
					k++;
				}
				String te=s.substring(i+2, k-1);
				boolean puede=true;
				int pa=0;int index=0;
				while(puede){
					if(te.charAt(index)==','&&pa==0){
						puede=false;
					}
					if(te.charAt(index)=='('){
						pa++;
					}else if(te.charAt(index)==')'){
						pa--;
					}
					index++;
				}
				s.replace(i, k, String.format("t(%s,t(%s,0))",te.substring(index, te.length()),te.substring(0, index-1)));
				i=temp-1;
			}
		}
	}
}

