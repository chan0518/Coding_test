import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> stack = new ArrayDeque<>();
        String str;
        while (!(str = br.readLine()).equals(".")) {
            stack.clear();
            String text = "yes";
            String[] st = str.split("");
            for (int i = 0; i < st.length; i++) {
                if (st[i].equals("(") || st[i].equals(")") || st[i].equals("[") || st[i].equals("]")) {//괄호 일 때만 if문안으로
                    if (stack.isEmpty()) {//스택에 아무것도 안쌓였는데 괄호가 닫힌다면 no
                        if (st[i].equals(")") || st[i].equals("]")) {
                            text = "no";
                            break;
                        }
                    }
                    if (st[i].equals("(") || st[i].equals("[")) stack.addFirst(st[i]);//괄호 추가
                    else if (stack.peek().equals("(") && st[i].equals(")")) stack.removeFirst();//같으면 삭제
                    else if (stack.peek().equals("[") && st[i].equals("]")) stack.removeFirst();//같으면 삭제
                    else if (!stack.peek().equals(st[i])) {//괄호가 서로 다를 때
                        text = "no";
                        break;
                    }
                }//괄호가 아니라면 그냥 넘어감
            }//문자열의 문자를 하나씩 뒤져보다가 문자열 한줄을 다봄
            if (stack.size() != 0) text = "no";
            System.out.println(text);
        }
    }
}
