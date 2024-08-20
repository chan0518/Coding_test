import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static boolean[] visited = new boolean[9];
    static int[] kyu0 = new int[9];
    static int[] in0 = new int[9];
    static ArrayList<Integer> li = new ArrayList<>();
    static int winCnt;
    static int loseCnt;
     
    public static void dfs() {
        if(li.size() == 9) {
            Cal();
            return;
        }
         
        for(int i=0; i<9; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            li.add(in0[i]);
            dfs();
            visited[i] = false;
            li.remove(li.size()-1);
        }
    }
     
    public static void Cal() {
        int pointI = 0;
        int pointK = 0;
        for(int i=0; i<9; i++) {
            if(li.get(i) > kyu0[i]) pointI += li.get(i) + kyu0[i];
            else if (li.get(i) < kyu0[i]) pointK += li.get(i) + kyu0[i];
        }
        if(pointI > pointK) winCnt++;
        else if(pointI < pointK) loseCnt++;
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        sc.nextLine();
        /*
           여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
        */
         
        for(int tc = 1; tc <= T; tc++)
        {
         
            /////////////////////////////////////////////////////////////////////////////////////////////
            winCnt = 0;
            loseCnt = 0;
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            int[] kyuClone = new int[9];
            for(int i=0; i<9; i++) {
                kyu0[i] = Integer.valueOf(st.nextToken());
                kyuClone[i] = kyu0[i];
            }
            Arrays.sort(kyuClone);
            int idxK = 0;
            int idxI = 0;
            for(int i=1; i<=18; i++) {
                if(idxK < 9 && i == kyuClone[idxK]) {
                    idxK++;
                    continue; 
                }
                else in0[idxI++] = i;
            }//입력완료
             
            dfs();
            System.out.println("#"+tc +" "+ loseCnt+" "+winCnt);
 
             
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}