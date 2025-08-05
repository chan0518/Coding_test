import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int white, blue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }// 입력 완

        func(0, 0, N);


        // 1. 4등분으로 나눔
        // 2. 나눈것들 중 1이나 0으로만 이루어진게 있는지 확인

        print(); // 출력
    }

    // 출력 함수
    static void print(){
//        for(int[] e1 : map){
//            for(int e2 : e1) System.out.print(e2 + " ");
//            System.out.println();
//        }
        System.out.println(white);
        System.out.println(blue);
    }

    static void func(int row, int col, int size){
        if(size == 0) return;

        if(check(row, col, size)){              // 똑같은 숫자로 채워져 있다면
            if(map[row][col] == 0)  white++;    // 흰색이라면
            else blue++;                        // 파란색이라면

            return;
        }

        int newSize = size/2;
        func(row, col, newSize);                                  // 2사분면
        func(row + newSize, col, newSize);                   // 1사분면
        func(row, col + newSize, newSize);                   // 3사분면
        func(row + newSize, col + newSize, newSize);    // 4사분면
    }

    static boolean check(int row, int col, int size){
        int num = map[row][col];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(num != map[row+i][col+j]) return false;
            }
        }
        return true;
    }


}