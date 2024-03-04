class Solution {
    public String[] solution(String myStr) {
        String a[] = myStr.split("a|b|c");
        
        int cnt = 0;
        for(int i=0; i<a.length; i++){
            if (a[i].length() == 0) {
                cnt++;
            }
        }
        String[] answer = new String[a.length-cnt];
        int idx = 0;
        for(int i=0; i<a.length; i++){
            if (a[i].length() == 0) {
                continue;
            }
            answer[idx] = a[i];
            idx++;
        }
        if(answer.length == 0) {
            answer = new String[1];
            answer[0] = "EMPTY";
        }
        return answer;
    }
}