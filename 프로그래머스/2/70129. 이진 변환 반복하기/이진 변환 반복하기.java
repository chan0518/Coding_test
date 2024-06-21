class Solution {
    public int[] solution(String s) {
        int total_cnt = 0;
        int round = 0;
        while (true){
            String[] str = s.split("");
            if (str.length == 1) break;
            round++;
            int cnt0 = 0;
            for (int i=0; i<str.length; i++) if (str[i].equals("0")) cnt0++;//0의개수
            int n = str.length - cnt0;//1의 개수
            total_cnt+=cnt0;
            s = Integer.toBinaryString(n);
        }
        int[] answer = {round, total_cnt};
        return answer;
    }
}