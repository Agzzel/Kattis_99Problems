This solution passes all the test cases. There is some repetition of code that does not look very nice, especially in the different cases for the switch.
This is necessary because Kattis gives different numbers as input and I prioritized function over style.

There are only two possible answers for each digit, so the challenge was to know
which of the two possible numbers was closest to N. That is, which number had the smallest difference with N.
Therefore I needed to calculate the two numbers and then subtract them with N, the number that had the lowest difference with N
was the one to be returned. I made a different solution previously that was similar but
didn't take into account which digit was closest to N at all, it only checked if N was made up of zeros and determined the correct answer accordingly, which did not work with all test cases.