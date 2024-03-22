import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long answer = 1L;

		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int h = sc.nextInt();

		for(int i = 0; i < n-1; i ++){
			answer = (answer * m)%1000000007;
		}
        System.out.println(answer);
	}
}