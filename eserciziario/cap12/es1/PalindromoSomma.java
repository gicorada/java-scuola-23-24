package eserciziario.cap12.es1;

import java.math.BigInteger;
import java.util.Random;

public class PalindromoSomma {
    public static void main(String[] args) {
        BigInteger num = new BigInteger(16, new Random());
        while (!isPalindrome(num.toString())) {
            String reversed = reverse(num.toString());
            BigInteger reversedNum = new BigInteger(reversed);
            num = num.add(reversedNum);
        }
        System.out.println("Numero palindromo: " + num);
    }

    public static String reverse(String str) {
        if (str.isEmpty()) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static boolean isPalindrome(String text) {
        return isPalindrome(text, 0, text.length() - 1);
    }

    private static boolean isPalindrome(String text, int start, int end) {
        if (start >= end) {
            return true;
        } else {
            char first = text.charAt(start);
            char last = text.charAt(end);

            if(Character.isDigit(first) && Character.isDigit(last)) {
               if(first == last) {
                    return isPalindrome(text, start + 1, end - 1);
               }
               else {
                   return false;
               }
            } else if (!Character.isDigit(last)) {
                return isPalindrome(text, start, end-1);
            } else {
                return isPalindrome(text, start+1, end);
            }
        }

    }
}