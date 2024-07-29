import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int ACGT_cnt[] = new int[4];// 0000
	static String ACGT[] = { "A", "C", "G", "T" };
	static int cnt[] = new int[4];// 0000
	static int result = 0;

	public static boolean check() {
		for (int i = 0; i < 4; i++) {
			if (cnt[i] < ACGT_cnt[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int strLen = Integer.valueOf(st.nextToken());// 문자열크기
		int len = Integer.valueOf(st.nextToken());// 부분 문자열
		String DNA = br.readLine();// 문자열
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++)
			ACGT_cnt[i] = Integer.valueOf(st.nextToken());// 필요한 ACGT갯수

		String str = DNA.substring(0, len);
		String a[] = str.split("");// 부분 문자열의 배열
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < 4; j++) {// ACGT중 포함하는게 있다면 증가
				if (a[i].equals(ACGT[j])) {
					cnt[j]++;
					break;
				}
			}
		}
		if (check())
			result++;

		String dna[] = DNA.split("");// 문자열의 배열

		for (int i = 0; i + len < strLen; i++) {

			for (int j = 0; j < 4; j++) {// ACGT중 포함하는게 있다면 감소
				if (dna[i].equals(ACGT[j])) {
					cnt[j]--;
					break;
				}
			} // 첫 번째 자리부터 같은게 있다면 cnt의 ACGT자리에 -1해줌

			for (int j = 0; j < 4; j++) {// ACGT중 포함하는게 있다면 증가
				if (dna[i + len].equals(ACGT[j])) {
					cnt[j]++;
					break;
				}
			} // 끝자리가 같다면 cnt++해줌
			if (check()) {
				result++;
			}
//			if (i == 1) {
//				System.out.println(Arrays.toString(cnt));
//				System.out.println("========");
//				System.out.println(dna[i]);
//				System.out.println(dna[len - 1 + i]);
//			}
//			if (i == 0) {
//				System.out.println(Arrays.toString(cnt));
//				System.out.println("========");
//				System.out.println(dna[i]);
//				System.out.println(dna[len - 1 + i]);
//			}
		}
		System.out.println(result);
	}
}
