package be.tiemenvermote.projecteuler004;

//This program attempts to find the largest palindrome product possible between two 3-digit numbers as per Project Euler 004

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(largestPalindromeProduct(3));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime + " ms");
    }

    private static int largestPalindromeProduct(int digits) {
        int largestProduct = 1;
        double largestNumberToMultiply = Math.pow(10, digits);
        for (int i = 1; i < largestNumberToMultiply; i++) {
            for (int j = 1; j < largestNumberToMultiply; j++) {
                int product = i * j;
                if (product > largestProduct) {
                    String productAsString = String.valueOf(product);
                    int stringLength = productAsString.length();
                    //string has either an even or odd number of characters
                    if (productAsString.length() % 2 == 0) {//then its an even amount of chars
                        String substringStart = productAsString.substring(0, (stringLength / 2));
                        String substringEnd = productAsString.substring(stringLength / 2);
                        String substringEndReversed = new StringBuilder(substringEnd).reverse().toString();
                        if (substringStart.equals(substringEndReversed)) { //it's a palindrome!
                            largestProduct = product;
                        }
                    } else if (stringLength >= 3) { //then its an uneven amount of chars
                        String substringStart = productAsString.substring(0, (stringLength / 2) - 1);
                        String substringEnd = productAsString.substring(stringLength / 2);
                        String substringEndReversed = new StringBuilder(substringEnd).reverse().toString();

                        if (substringStart.equals(substringEndReversed)) { //it's a palindrome!
                            largestProduct = product;
                        }
                    }
                }
            }
        }
        return largestProduct;
    }
}
