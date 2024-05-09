import java.util.*;
class Solution {
    public long solution(long n) {
        String[] a = String.valueOf(n).split("");
        Arrays.sort(a);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a.length; i++) sb.append(a[a.length-1-i]);
        long answer = Long.valueOf(sb.toString());
        System.out.println(answer);
        return answer;
    }
}