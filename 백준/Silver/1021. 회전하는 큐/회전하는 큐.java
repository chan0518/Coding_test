import java.io.*;
import java.util.ArrayList;

public class Main {
    static int cnt = 0;

    public static ArrayList<Integer> arrayList_left (ArrayList<Integer> al, int value){//왼쪽으로 한칸 씩
        while (al.get(0) != value) {//ArrayList의 첫번째 값이 value가 될때까지 무한반복
            al.add(al.get(0));//첫번째 값 끝으로 복사
            al.remove(0);//첫번째 값 삭제
            cnt++;
        }
        al.remove(0);
        return al;
    }

    public static ArrayList<Integer> arrayList_right (ArrayList<Integer> al, int value){//오른쪽으로 한칸 씩
        while (al.get(0) != value) {//ArrayList의 첫번째 값이 value가 될때까지 무한반복
            al.add(0, al.get(al.size() - 1));
            al.remove(al.size()-1);
            cnt++;
        }
        al.remove(0);
        return al;
    }

    public static ArrayList<Integer> arrayList (ArrayList<Integer> al, int value){
        if (al.get(0) == value) al.remove(0);
        else {
            int idx = al.indexOf(value);//value가 있는 인덱스 번호

//            al = idx <= al.size() ? arrayList_left(al, value) : arrayList_right(al, value);
            if (idx <= al.size()/2) al = arrayList_left(al, value);//idx가 (al.size()홀짝포함)절반보다 작거나 같다면 왼쪽으로 한칸씩 땡기고 첫번째는 마지막으로 이동
            else al = arrayList_right(al, value);//idx가 중앙 인덱스보다 크니까 오른쪽으로 한칸씩 땡기고 마지막은 첫번째로 이동
        }
        return al;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int N = Integer.valueOf(str[0]);
        int M = Integer.valueOf(str[1]);
        String[] st = br.readLine().split(" ");
        int[] arr = new int[st.length];
        for (int i=0; i<arr.length; i++) arr[i] = Integer.valueOf(st[i]);
        ArrayList<Integer> AL = new ArrayList<>();

        for (int i=0; i<N; i++) AL.add(i+1);//ArrayList에 1~N값 넣기

        for (int i=0; i<arr.length; i++) AL = arrayList(AL, arr[i]);//원하는 숫자 뽑기 반복

        System.out.println(cnt);
        br.close();
        bw.close();
    }
}
/*
10 3        1부터 10의 숫자가 있고 3개의 원소를 뽑아낼 것이다
2 5 9                   최소 연산

1   2   3   4   5   6   7   8   9   10
2   3   4   5   6   7   8   9   10  1   연사 1번
3   4   5   6   7   8   9   10  1                       2를 뽑아냄
9   10  1   3   4   5   6   7   8       -> 쪽으로 3번
10  1   3   4   5   6   7   8                           9를 뽑아냄
5   6   7   8   10  1   3   4              연산 4번
6   7   8   10  1   3   4                               5를 뽑아냄
 */