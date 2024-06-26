import java.util.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        String[] str = my_string.split("");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<index_list.length; i++){
            sb.append(str[index_list[i]]);
        }
        return sb.toString();
    }
}