class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        answer += myString.substring(0,myString.lastIndexOf(pat)+pat.length());
        return answer;
    }
}