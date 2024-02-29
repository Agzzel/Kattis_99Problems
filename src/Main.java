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

/*
Måste returnera det närmaste talet till N som slutar på 99.
Hantera om två olika tal är lika långt ifrån N. T.ex för N = 249 så är 299 och 199 lika långt ifrån N.
299 - 249 = 50 och 249 - 199 = 50.

Denna lösning klarar alla testfall på Kattis. Det finns en del upprepning av kod som inte ser så snyggt ut,
dock är det nödvändigt för att programmet ska fungera. Det finns bara två möjliga svar för varje siffra, så utmaningen
var att veta vilken av de två möjliga siffrorna som var närmast N. Alltså vilken siffra som hade lägst skillnad med N.
Därför behövde jag räkna ut de två siffrorna och sedan subtrahera de med N, den siffra som hade lägst skillnad med N
var den som skulle returneras. Den gamla lösningen var liknande men tog inte alls hänsyn till vilken siffra som var närmast N,
den kontrollerade bara om N bestod av nollor och bestämde rätt svar därefter. Fungerade inte med alla testfall.
 */

/*
This solution passes all test cases on Kattis. There is some repetition of code that does not look very nice,
but it is necessary for the program to work. There are only two possible answers for each digit, so the challenge was to know
which of the two possible numbers was closest to N. That is, which number had the smallest difference with N.
Therefore I needed to calculate the two numbers and then subtract them with N, the number that had the lowest difference with N
was the one to be returned. The old solution was similar but didn't take into account which digit was closest to N at all,
it only checked if N was made up of zeros and determined the correct answer accordingly. Did not work with all test cases.

 */