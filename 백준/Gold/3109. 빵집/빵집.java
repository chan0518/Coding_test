import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    
    static int r, c;
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int min, cnt;
    static int[][] D = { 
            { -1, 1 },
            { 0, 1 },
            { 1, 1 },
            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = ch[j];
            }
        }//입력 완료
        
        for(int i=0; i<r; i++) {
            flag = false;
            dfs(i,0);//시작 지점 (i,0)
        }
        
        for(int i=0; i<r; i++) {
            if(visited[i][c-1]) ++cnt;
        }
        
        System.out.println(cnt);
    }
    
    static void dfs(int x, int y) {
    	visited[x][y] = true;
        if(y == c-1) {
            flag = true;
            return;
        }
        
        for(int[] d : D) {
            int nx = x + d[0];
            int ny = y + d[1];
            
            if(0 <= nx && nx < r && 0 <= ny && ny < c && !visited[nx][ny] && map[nx][ny] == '.') {
                dfs(nx,ny);
                if (flag) {
                    break;
                }
            }
        }
    }
}