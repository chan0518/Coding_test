import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int T, N;
    static String[] str;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            Cal();
        }
        System.out.println(sb.toString());
    }
    
    static void Cal() throws IOException {
        N = Integer.parseInt(br.readLine());
        str = new String[N]; // 전화번호 저장
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        
        Arrays.sort(str);// 사전순으로 정렬이 됌
//        System.out.println(Arrays.toString(str));
        
        //사전순으로 정렬하면 양 옆에는 접두어가 비슷한 것끼리 정렬이 되므로 양 옆에만 비교하여 접두어가 있는지 확인 만약 접두어가 있다면 바로 리턴
        for (int i = 0; i < N - 1; i++) {// 옆에 있는 것만 비교
            if (str[i+1].startsWith(str[i])) {// 사전순으로 뒤에 있는 인덱스에 앞 인덱스의 문자열이 접두사가 되는지 검사 ㄱ
                sb.append("NO\n");
                return;
            }
        }
        sb.append("YES\n");
    }
}