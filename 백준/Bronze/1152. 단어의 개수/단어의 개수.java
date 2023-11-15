import java.util.Scanner;

public class Main{
    public static void main (String []args){
        int result=0;
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
       
        
        String b[] = a.split(" ");
        for(int i=0; i<b.length; i++){
            if(b[i] == "") result++;
        }
        System.out.println(b.length - result);
    }
}