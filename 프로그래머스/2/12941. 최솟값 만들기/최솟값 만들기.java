import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<B.length; i++) answer += A[i] * B[B.length-1-i];
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        return answer;
    }
}