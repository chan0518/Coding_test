import java.util.*;

class Solution {
    static int f_len;// 친구 수
    static int[][] gg; // giftGraph 선물 교환 그래프
    static int[] gn; // giftNum 친구가 받은 선물 수 저장 배열
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        f_len = friends.length;
        gg = new int[f_len][f_len];
        gn = new int[f_len];
        
        //친구들 이름 인덱스랑 매핑
        HashMap<String, Integer> hm = new HashMap<>();
        
        for ( int i = 0; i < f_len; i++ ) hm.put(friends[i], i);
        
        for ( String g : gifts ) {// 선물 관계 입력
            String[] giftArr = g.split(" ");
            gn[hm.get(giftArr[0])]++; // 선물 준 친구 선물 개수 증가
            gn[hm.get(giftArr[1])]--;// 선물 받은 친구 선물 개수 감소
            gg[hm.get(giftArr[0])][hm.get(giftArr[1])]++;     // 선물 그래프에 관계 저장
        }
        answer = Cal();
        return answer;
    }
    
    public int Cal() {
        int result = 0;
        for (int i = 0; i < f_len; i++) {
            int num = 0;
            for ( int j = 0; j< f_len; j++) {// i번 친구와 다른 친구들 선물 교환 관계 비교
                if (i != j && ((gg[i][j] == gg[j][i] && gn[i] > gn[j]) || gg[i][j] > gg[j][i])) num++;
            }// 양방향 선물이 동일한 경우  or   일방적으로 더 많은 선물을 준 경우
            if (result < num) result = num;// 가장 많은 선물 관계를 가진 친구이 수 계산
        }
        return result;
    }
}