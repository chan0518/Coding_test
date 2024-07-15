
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = new String[3];
		str[0] = br.readLine();
		str[1] = br.readLine();
		str[2] = br.readLine();
		
		int cnt = 0;
		int value = 0;
		for(int i=0; i<3; i++) {
			if(!str[i].equals("FizzBuzz") && !str[i].equals("Fizz") && !str[i].equals("Buzz")) {
				cnt = 3 - i;
				value = Integer.valueOf(str[i]) + cnt;
			}
		}
		if (value%3 == 0 && value%5 == 0) bw.write("FizzBuzz");
		else if (value%3 == 0) bw.write("Fizz");
		else if (value%5 == 0) bw.write("Buzz");
		else bw.write(value+"");
		bw.flush();
		bw.close();
	}
}
