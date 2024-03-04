class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String a[] = binomial.split(" ");
        
        if(a[1].equals("+")){
            answer = Integer.valueOf(a[0]) + Integer.valueOf(a[2]);   
        }else if(a[1].equals("-")){
            answer = Integer.valueOf(a[0]) - Integer.valueOf(a[2]);
        }else if(a[1].equals("*")){
            answer = Integer.valueOf(a[0]) * Integer.valueOf(a[2]);
        }
        
        return answer;
    }
}