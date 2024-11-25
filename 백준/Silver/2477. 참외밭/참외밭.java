import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[] D = new int[6];
	static int maxX=0, maxY=0;
	static int IndexMaxX=0, IndexMaxY=0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			D[i] = b;
			if(a == 1 || a == 2) {
				if(maxX < b) {
					maxX = b;
					IndexMaxX = i;
				}
			}
			if(a == 3 || a == 4) {
				if(maxY < b) {
					maxY = b;
					IndexMaxY = i;
				}
			}
		}
		int totalExtent = maxX * maxY;
		
		int IndexLeftX = IndexMaxX-1 < 0 ? 5 : IndexMaxX-1;
		int IndexRightX = IndexMaxX+1 > 5 ? 0 : IndexMaxX+1;
		int smallValueY = D[IndexLeftX] < D[IndexRightX] ? D[IndexLeftX] : D[IndexRightX];
		
		int IndexLeftY = IndexMaxY-1 < 0 ? 5 : IndexMaxY-1;
		int IndexRightY = IndexMaxY+1 > 5 ? 0 : IndexMaxY+1;
		int smallValueX = D[IndexLeftY] < D[IndexRightY] ? D[IndexLeftY] : D[IndexRightY];
		
		int smallExtent = (maxX - smallValueX) * (maxY - smallValueY);
		
		int resultExtent = totalExtent - smallExtent;
		System.out.println(resultExtent * N);
		
		
	}	
}