class Solution {
    public String solution(String myString, String pat) {
        
        String a[] = myString.split("");
        String aa[] = new String[a.length];
        for (int i=0; i<myString.length(); i++){
            aa[i] = a[a.length-1-i];
        }//aa역순 완료

        String p[] = pat.split("");
        String pp[] = new String[p.length];
        for (int i=0; i<pat.length(); i++){
            pp[i] = p[p.length-1-i];
        }//pp역순 완료

        int idx = 0;
        for (int i=0; i<=myString.length()-pat.length(); i++){
            int cnt=0;
            for (int j=0; j<pat.length(); j++){
                if (pp[j].equals(aa[i+j])){
                    cnt++;
                }
            }
            if (cnt == pat.length()) {
                idx = i;
                break;
            }
        }
        
        String answer = "";
        for (int i=0; i<myString.length()-idx; i++){
            answer += a[i];
        }
        
        return answer;
    }
}