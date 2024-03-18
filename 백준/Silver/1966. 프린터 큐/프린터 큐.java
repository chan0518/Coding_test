import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static boolean bigValue(Queue<Integer> queue, int value) {
        for (int e : queue) if (e > value) return true;//q안에 value보다 큰 값이 있다
        return false;//없다
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

//        q.offer(1);//뒤에 1 추가
//        q.poll();//제일 앞에값 출력 후 제거
//        q.remove();//제알 앞에 값 제거

        for (int i = 0; i < num; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();

            String str[] = sc.nextLine().split(" ");
            int arr[] = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.valueOf(str[j]);//중요도 넣음
                q.offer(arr[j]);
            }
            //예시 6 0
            //1 1 9 1 1 1     정답은 5가 나와야함

            int idx = M;//궁금한 문서의 위치
            int print = 0;
            while (true) {
                if (bigValue(q, q.peek())) {//만약 큐의 첫번째 값보다 큰 수가 큐안에 있다면 true
                    q.offer(q.poll());//맨뒤로 옮김
                    if (idx == 0) idx = q.size()-1;//궁금한 문서가 맨뒤로 갔으므로 cnt를 맨뒤로 옮김
                    else idx--;//궁금한 문서의 앞에 문서들이 뒤로 갔으니 궁금한문서가 한칸씩 앞으로 옮
                }else {//큐의 1번째 값보다 큰 값이 없다면
                    q.remove();//인쇄됬으니 삭제하고
                    ++print;//몇번째로 인쇄됬는지 확인
                    if (idx == 0) {//궁금한 문서가 인쇄가 됬다면 몇 번째로 인쇄됬는지 출력
                        System.out.println(print);
                        q.clear();
                        break;
                    }else idx--;//앞으로 당김
                }
            }
        }
        sc.close();
    }
}
