class Solution {
    public int[] solution(int n) {
        
        int m=0;
        m = n%2 == 0 ? n/2:n/2+1;
        int[] answer = new int[m];
        
        int cnt=0;
        for(int i=1; i<=n; i++) {
            if(i%2 != 0) answer[cnt++] = i;
        }
        return answer;
    }
}