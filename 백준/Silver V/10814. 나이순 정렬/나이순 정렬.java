import java.io.*;
import java.util.*;

public class Main {
    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        Person p[] = new Person[N];

        for (int i=0; i<N; i++){
            String a[] = br.readLine().split(" ");
            p[i] = new Person(Integer.valueOf(a[0]), a[1]);
        }

        Arrays.sort(p, Comparator.comparingInt(Person::getAge));

        for (int i=0; i<N; i++){
            bw.write(p[i].age+" "+p[i].name);
            bw.newLine();
        }
        bw.close();
    }
}