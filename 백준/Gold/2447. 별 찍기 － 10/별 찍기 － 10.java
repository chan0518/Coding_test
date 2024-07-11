import java.util.*;
import java.io.*;

public class Main{
    static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++){
		    for(int j=0; j<n; j++) func(i,j,n);
		    bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	static void func(int i, int j, int n) throws Exception {
	    if(i/n % 3 == 1 && j/n % 3 == 1) bw.write(" ");
	    else{
	        if(n/3 == 0) bw.write("*");
	        else func(i, j, n/3);
	    }
	}
}