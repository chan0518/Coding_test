import java.io.*;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> hs = new HashSet();

        String str = br.readLine();
        int len = str.length();

        for (int i = 1; i <= len; i++) {           // 부분 문자열의 길이
            for (int j = 0; j <= len - i; j++) {   // 시작 인덱스
                hs.add(str.substring(j, j + i));      // 부분 문자열을 바로 set에 추가
            }
        }
        System.out.println(hs.size());

    }
}
