import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static boolean[][] visited;
    static String[][] map;
    static int startX;
    static int startY;
    static int[][] D = {
            {0, -1},//좌
            {0, 1},//우
            {-1, 0},//상
    };
    static int result = 0;
    static int ban_D = 10;
    //0일 때 좌    1일 때 우  2일 때 상
     
     
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
         
        q.add(new int[] {startX, startY});
         
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            result = y;
             
            for(int i=0; i<3; i++) {
                if(i < 2 && ban_D == i) continue;//currentD가 나오면 그 수는 건너 뜀
                // i =      0일 때 좌      1일 때 우  2일 때 상
                 
                int nx = x+D[i][0];
                int ny = y+D[i][1];
                 
                if(i==2) ban_D = 10;
                if(0 <= nx && nx < 100 && 0 <= ny && ny < 100 && map[nx][ny].equals("1")) {// nx, ny가 범위 안에 있고 1인 겨우에만
                    q.add(new int[] {nx, ny});//q에 진입할 위치를 추가
                    if(i == 0) ban_D = 1;
                    else if(i == 1) ban_D = 0;
                    //ban_D가 0이면 왼쪽으로 진입했기 때문에 무조건 직진하거나 오른쪽으로 가야함 따라서 그 방향은 continue시킴
                     
                    break;//하나의 길만 탐색할 것이기 때문에 q에 값이 들어오면 break
                }
            }
        }
    }
     
    public static void main(String args[]) throws Exception
    {
//      Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
//      T=sc.nextInt();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
         
        for(int tc = 1; tc <= T; tc++)
        {
            System.out.print("#"+Integer.valueOf(br.readLine())+" ");
            /////////////////////////////////////////////////////////////////////////////////////////////
            map = new String[100][100];
            for(int i=0; i<100; i++) {
                String[] input = br.readLine().split(" ");
                map[i] = input;
            }
            startX = 99;
            startY = 0;
 
            for(int i=0; i<100; i++) {
                if(map[99][i].equals("2")) {
                    startY = i;
                    break;
                }
            }//시작 위치 찾음
            bfs();
            System.out.println(result);
             
             
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}