class Solution {
    public int[] solution(int[] num_list) {
        int a[] = num_list;
        int answer[] = new int[num_list.length];
        for(int i=0; i<a.length; i++){
            answer[i] = a[a.length-1-i];
        }        
        return answer;
    }
}