class Solution {
    public int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int[] answer = new int[str.length];
        for(int i=0; i<answer.length; i++) answer[i] = Integer.valueOf(str[str.length-1-i]);
        return answer;
    }
}