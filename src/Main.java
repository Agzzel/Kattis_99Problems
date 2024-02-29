/*
    This class is my solution to the Kattis challenge named "99 Problems",
    the challenge can be found at: https://open.kattis.com/problems/99problems
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int magnitude = String.valueOf(n).length();

        int closestNumber = 0;// the result that the program will output
        int firstDigit = Integer.parseInt(Integer.toString(n).substring(0, 1));
        int secondDigit, thirdDigit;// only defined if n has 3 to 5 digits
        int diffWithLargest, diffWithLowest;// used to calculate which number to return

        switch(magnitude){
            case 1:
            case 2:
                closestNumber = 99;
                break;
            case 3:
                diffWithLargest = (firstDigit * 100 + 99) - n;//calculate the largets number and subtract with n
                diffWithLowest = n - (firstDigit * 100 - 1);

                if(Math.min(diffWithLargest, diffWithLowest) == diffWithLargest){
                    closestNumber = firstDigit * 100 + 99;
                }else{
                    closestNumber = firstDigit * 100 - 1;
                }
                break;
            case 4:
                secondDigit = Integer.parseInt(Integer.toString(n).substring(1,2));
                diffWithLargest = (firstDigit * 1000 + secondDigit * 100 + 99) - n;
                diffWithLowest = n - (firstDigit * 1000 + secondDigit * 100 - 1);

                if(Math.min(diffWithLargest, diffWithLowest) == diffWithLargest){
                    closestNumber = firstDigit * 1000 + secondDigit * 100 + 99;
                }
                else{
                    closestNumber = firstDigit * 1000 + secondDigit * 100 - 1;
                }
                break;
            case 5:
                secondDigit = Integer.parseInt(Integer.toString(n).substring(1,2));
                thirdDigit = Integer.parseInt(Integer.toString(n).substring(2,3));

                diffWithLargest = (firstDigit * 10000 + secondDigit * 1000 + thirdDigit * 100) + 99 - n;
                diffWithLowest = n - (firstDigit * 10000 + secondDigit * 1000 + thirdDigit * 100) - 1;

                if(Math.min(diffWithLargest, diffWithLowest) == diffWithLargest){
                    closestNumber = (firstDigit * 10000 + secondDigit * 1000 + thirdDigit * 100) + 99;
                }
                else {
                    closestNumber = (firstDigit * 10000 + secondDigit * 1000 + thirdDigit * 100) - 1;
                }
                break;
        }

        System.out.println(closestNumber);
    }
}