package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Uva886_NamedExtensionDialing {
	static HashMap<String,Integer> claves;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader((System.in)));
		PrintWriter out = new PrintWriter(System.out);
		String linea= in.readLine();
		while(linea!=null&&!linea.equals("")){
			StringTokenizer toks= new StringTokenizer (linea);
			trie diccionario= new trie();
			claves= new HashMap<String,Integer>();
			int cont=0;
			int a[][]=new int[2][2];
			int k =a.length;
			while(toks.countTokens()==3){
				String u =toks.nextToken().toLowerCase();
				String v=toks.nextToken().toLowerCase();
				String n =toks.nextToken();
				claves.put(n+"",cont);
				diccionario.agregar(u,v, n);
				toks= new StringTokenizer (in.readLine());
				cont++;
			}
			linea=toks.nextToken();
			while(linea!=null&&!linea.equals("")){
				ArrayList<String>lista= diccionario.buscar(linea);
				Collections.sort(lista, new Comparator<String>(){
					@Override
					public int compare(String o1, String o2) {
						
						return Integer.compare(claves.get(o1), claves.get(o2));
					}
				});
				if(claves.containsKey(linea))
					out.println(linea);
				else{
					if(lista.size()==0)
						
						out.println(0);
					else{
						StringBuilder temp=new StringBuilder();
						for(String i:lista)
							temp.append(i+" ");
						temp.delete(temp.length()-1, temp.length());
						out.println(temp);
					}
				}
				linea=in.readLine();
			}
		}
		out.close();
	}
}
class trie{
	nodo root;
	LinkedList<Integer>	[]teclas= new LinkedList[10];
	trie(){
		this.root=(new nodo());
		root.hijos(this.root);
		for (int i = 0; i < teclas.length; i++) {
			teclas[i]=new LinkedList<Integer>();
		}
		teclas[2].addLast(0);teclas[2].addLast(1);teclas[2].addLast(2);
		teclas[3].addLast(3);teclas[3].addLast(4);teclas[3].addLast(5);
		teclas[4].addLast(6);teclas[4].addLast(7);teclas[4].addLast(8);
		teclas[5].addLast(9);teclas[5].addLast(10);teclas[5].addLast(11);
		teclas[6].addLast(12);teclas[6].addLast(13);teclas[6].addLast(14);
		teclas[7].addLast(15);teclas[7].addLast(16);teclas[7].addLast(17);teclas[7].addLast(18);
		teclas[8].addLast(19);teclas[8].addLast(20);teclas[8].addLast(21);
		teclas[9].addLast(22);teclas[9].addLast(23);teclas[9].addLast(24);teclas[9].addLast(25);
	}
	public void agregar(String s,String k,String i){
		agregar((s.charAt(0)-'a'),i);
		nodo guia=root.arr[s.charAt(0)-'a'];
		
		for (int j = 0,n=k.length(); j < n; j++) {
			if(guia.arr==null)
				root.hijos(guia);
			
				if(guia.arr[k.charAt(j)-'a']!=null)
					guia.arr[k.charAt(j)-'a'].numeros.addLast(i);
				else{
					guia.arr[k.charAt(j)-'a']=new nodo();
					guia.arr[k.charAt(j)-'a'].numeros.addLast(i);
				}
			guia=guia.arr[k.charAt(j)-'a'];
		}
	}
	public void agregar(int a,String b){
		if(this.root.arr[a]==null)
			this.root.arr[a]=new nodo();
		this.root.arr[a].numeros.addLast(b);
	}
	public ArrayList<String>  buscar(String s){
		ArrayList<String>lista= new ArrayList<String>();
		LinkedList<nodo>orden[]= new LinkedList[s.length()];
		for (int i = 0; i < orden.length; i++) {
			orden[i]= new LinkedList<nodo>();
		}
		for (int i = 0,indice=Integer.parseInt(s.charAt(0)+""); i < teclas[indice].size(); i++) {
			int u =teclas[indice].get(i);
			if(root.arr[u]!=null){
				orden[0].addLast(root.arr[u]);
			}
		}
		for (int i = 0,n=orden.length; i < n-1; i++) {
			while(!orden[i].isEmpty()){
				nodo u =orden[i].removeFirst();
				if(u.arr!=null){
					for (int j = 0,indice=Integer.parseInt(s.charAt(i+1)+""); j < teclas[indice].size(); j++) {
						int v =teclas[indice].get(j);
						if(u.arr[v]!=null){
							orden[i+1].addLast(u.arr[v]);
						}
					}
				}
			}
		}
		while(!orden[s.length()-1].isEmpty()){
			nodo u=orden[s.length()-1].removeFirst();
			for(String k:u.numeros)
			lista.add(k);
		}
		return lista;
		
	}
	
}
class nodo{
	nodo arr[];
	LinkedList<String>numeros;
	nodo(){
		this.arr=null;
		numeros= new LinkedList<String>();
	}
	public void hijos(nodo u){
		u.arr=new nodo [26];
	}
}
