

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Jagdish Bhanushali on 1/7/2017.
 * https://www.hackerrank.com/challenges/service-lane?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class ServiceLane {
    public static void main(String args[]){
        long lengthOfFreeWay;
        int numberOfTestCase;

        Scanner sc=new Scanner(System.in);

        String [] temp = sc.nextLine().split(" ");
        lengthOfFreeWay=Integer.parseInt(temp[0]);
        numberOfTestCase=Integer.parseInt(temp[1]);

        long[] freewayWidth=new long[(int)lengthOfFreeWay];
        long[][] testCases=new long[numberOfTestCase][2];

        freewayWidth = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for(int i=0;i<numberOfTestCase;i++){
            temp=sc.nextLine().split(" ");
            testCases[i][0]=Long.parseLong(temp[0]);
            testCases[i][1]=Long.parseLong(temp[1]);
        }

        long entry,exit;
        int vehicleType;
        for(int i=0;i<numberOfTestCase;i++){
            entry=testCases[i][0];
            exit=testCases[i][1];
            vehicleType=4;  //As service length will be 1 always
            for(long j=entry;j<=exit;j++){
                if(freewayWidth[(int)j]==3 && vehicleType>3){
                    vehicleType=3;
                }else if(freewayWidth[(int)j]==2 && vehicleType>2){
                    vehicleType=2;
                }else if(freewayWidth[(int)j]==1 && vehicleType>1){
                    vehicleType=1;
                    break;
                }
            }
            System.out.println(vehicleType);
        }

    }
}
