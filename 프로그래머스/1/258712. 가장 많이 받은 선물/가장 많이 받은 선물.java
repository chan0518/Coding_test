import java.util.*;

class Solution {
    static int f_len;
    static int[][] gg; // giftGraph
    static int[] gn; // giftNum
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        f_len = friends.length;
        gg = new int[f_len][f_len];
        gn = new int[f_len];
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        for ( int i = 0; i < f_len; i++ ) hm.put(friends[i], i);
        
        for ( String g : gifts ) {
            String[] giftArr = g.split(" ");
            gn[hm.get(giftArr[0])]++;
            gn[hm.get(giftArr[1])]--;
            gg[hm.get(giftArr[0])][hm.get(giftArr[1])]++;    
        }
        answer = Cal();
        return answer;
    }
    
    public int Cal() {
        int result = 0;
        for ( int i =0; i< f_len; i++) {
            int num = 0;
            for ( int j = 0; j< f_len; j++) {
                if (i != j && ((gg[i][j] == gg[j][i] && gn[i] > gn[j]) || gg[i][j] > gg[j][i])) num++;
            }
            if ( result < num) result = num;
        }
        return result;
    }
}