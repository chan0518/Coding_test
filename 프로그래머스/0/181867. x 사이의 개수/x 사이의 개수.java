class Solution {
    public int[] solution(String myString) {
        
        String a[] = myString.split("x",-1);
        int[] answer = new int[a.length];
        for(int i=0; i<a.length; i++){
            answer[i] = a[i].length();
        }
        
        return answer;
        
    }
}