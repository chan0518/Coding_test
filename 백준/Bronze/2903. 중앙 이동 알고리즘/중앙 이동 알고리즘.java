import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int edge = 1;
        int vertex = 2;

        for (int i = 0; i<N; i++){
            vertex += edge;//꼭짓점 추가
            edge *= 2;//변 추가
        }
        System.out.println(vertex*vertex);
    }
}