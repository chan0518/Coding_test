import java.util.*;

class Solution {
    public int solution(String s) {
        
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        HashMap<String, String> map = new HashMap();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        for(int i=0; i<10; i++) s = s.replace(str[i], map.get(str[i]));
        
        int answer = Integer.valueOf(s);
        return answer;
    }
}