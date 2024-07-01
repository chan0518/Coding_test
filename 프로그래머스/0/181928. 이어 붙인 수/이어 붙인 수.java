class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 1) sb1.append(String.valueOf(num_list[i]));
            else sb2.append(String.valueOf(num_list[i]));
        }
        int a = sb1.length() > 0 ? Integer.valueOf(sb1.toString()) : 0;
        int b = sb2.length() > 0 ? Integer.valueOf(sb2.toString()) : 0;
        
        answer = a + b;
        return answer;
    }
}
