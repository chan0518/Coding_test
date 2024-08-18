import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> op = new ArrayList<>();
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
         
         String input = br.readLine();
         for(int i=0; i<N; i++) {
             if(i%2==0) {
                 num.add(input.charAt(i)-'0');//짝수라면 아스키 코드를 이용해서 숫자를 저장해줌
             }
             else {
                 op.add(input.charAt(i));//홀수라면 연산자 추가
             }
         }
         int start = num.get(0);
         dfs(0,start);//첫번째 값을 start에 넣음
         System.out.println(max);
    }
    
    public static void dfs(int idx, int sum) {
        if(idx >= op.size()) {
            max = Math.max(max, sum);
            return;
        }
        
        // 1. 괄호 안치고 진행하기
        int unUseValue = cal(idx, sum, num.get(idx+1));
        dfs(idx+1, unUseValue);
        // 2. 괄호 치고 진행하기
        if(idx < op.size()-1) { // 인덱스 범위 오류를 제거하기 위해
            int useValue = cal (idx+1, num.get(idx+1), num.get(idx+2));
            int result = cal (idx, sum, useValue);
            dfs(idx+2, result);
        }
   }
    
    public static int cal(int op_idx,int a, int b) {
        switch(op.get(op_idx)) {
        case '+':
            return a+b;
        case '-':
            return a-b;
        case '*':
            return a*b;
        }
        return 1;
    }
}