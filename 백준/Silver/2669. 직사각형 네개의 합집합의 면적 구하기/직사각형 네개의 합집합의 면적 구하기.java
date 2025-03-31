import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] arr = new int[101][101];
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            cal(sx,sy,ex,ey);
        }
            //print();
            System.out.println(cnt);
        
    }

    public static void cal (int sx, int sy, int ex, int ey){
        for(int i=sy; i<ey; i++){
            for(int j=sx; j<ex; j++){
                if(arr[i][j] == 0){
                    ++cnt;
                    arr[i][j] = 1;
                }
            }
        }
    }

    public static void print (){
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}