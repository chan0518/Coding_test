class Solution {
    public String[] solution(String[] strArr) {
        int cnt = 0;
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].indexOf("ad") != -1){
                cnt++;
            }
        }
        int idx = 0;
        String answer[] = new String[strArr.length-cnt];
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].indexOf("ad") != -1) continue;
            answer[idx] = strArr[i];
            idx++;
        }
        
        return answer;
    }
}