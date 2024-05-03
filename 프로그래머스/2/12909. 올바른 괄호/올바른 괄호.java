class Solution {
    boolean solution(String s) {
        boolean answer = true;

        String[] str = s.split("");
        if(str[0].equals(")")) return false;
        int cnt = 0;
        for(int i=0; i<str.length; i++){
            if(str[i].equals("(")) cnt++;
            else cnt--;
            if(cnt < 0) return false;
        }
        return cnt == 0 ? true:false;
    }
}