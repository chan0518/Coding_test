import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {

    	List<Integer> li = new ArrayList<>();
        int size = queue1.length;
        
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<size; i++) {
            sum1 += queue1[i];
            li.add(queue1[i]);
        }
        for(int i=0; i<size; i++) {
            sum2 += queue2[i];
            li.add(queue2[i]);
        }

        long sum = sum1 + sum2;
        long num = sum / 2;
        
        int s = 0, e = size - 1;
        int cnt = 0;
        
        while(s <= e && cnt <= size * 3) {  // 일정한 횟수 초과하면 종료
            if(sum1 == num) {// sum1이 num이랑 같다는말은 sum2도 값이 같아 질거임
                return cnt;
            } else if(sum1 > num) {
                sum1 -= li.get(s);
                s++;
            } else {
                e++;
                if(e >= li.size()) e = 0; // 순환 리스트 처리
                sum1 += li.get(e);
            }
            cnt++;
        }
        
        return -1; // 원하는 합으로 만들 수 없는 경우
    }
    
}
