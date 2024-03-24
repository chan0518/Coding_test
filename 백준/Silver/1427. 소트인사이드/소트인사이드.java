import java.util.Scanner;

class Main {
    public static int[] sort (int[] arr){
        int[] result = arr;

        for (int i=0; i< arr.length; i++){
            for (int j=0; j< arr.length-1-i; j++){
                if (result[j] < result[j+1]){
                    int tmp = result[j];
                    result[j] = result[j+1];
                    result[j+1] =tmp;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split("");
        int[] arr = new int[str.length];
        for (int i=0; i<arr.length; i++) arr[i] = Integer.valueOf(str[i]);
        arr = sort(arr);

        for (int i=0; i<arr.length; i++) System.out.print(arr[i]);
    }
}