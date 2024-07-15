import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.valueOf(br.readLine());
        String[] day = br.readLine().split(" ");
        int[] dd = new int[14];
        for(int i=0; i<14; i++) dd[i] = Integer.valueOf(day[i]);
        int joon = money;
        int sung = money;
        int jj = 0;//준현이의 주식 갯수
        int sj = 0;//성민이의 주식 갯수

        //준현이의 매매 알고리즘
        for(int i=0; i<14; i++){
            if(dd[i] <= joon) {
                jj = joon/dd[i];
                joon%=dd[i];
                break;
            }
        }
        joon += jj * dd[13];

        //성민이의 매매 알고리즘
        int idx = 0;
        for(int i=3; i<14; i++){
            if(dd[i-3] > dd[i-2] && dd[i-2] > dd[i-1] && dd[i-1] > dd[i] && dd[i] < joon){
                sj += sung/dd[i];
                sung = sung%dd[i];
                idx = i;
            } 
        }
        boolean TF = false;
        for(int i=idx; i<11; i++) {
            if(dd[i] < dd[i+1] && dd[i+1] < dd[i+2] && dd[i+2] < dd[i+3]){
                sung += sj*dd[i+3];
                TF=true;
                break;
            }
        }
        
        if(!TF) sung += sj*dd[13];
        
        if(joon > sung) System.out.println("BNP");
        else if(sung > joon) System.out.println("TIMING");
        else System.out.println("SAMESAME");
        
        /*
        100
        10 20 23 34 55 30 22 19 12 45 23 44 34 38
        BNP
        15
        20 20 33 98 15 6 4 1 1 1 2 3 6 14
        TIMING
        */

        
    }
}
