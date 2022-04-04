import java.io.*;

public class Main {

    public static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int sumOfDigits(int n) {
        if (n < 0) {
            n = n * -1;
        }
        if (n == 0) {
            return 0;
        }

        return ((n % 10) + sumOfDigits(n / 10));
    }

    public static int pow(int base, int exponent) {
        if (base == 0 || base == 1) {
            return 0;
        }

        if (exponent < 0) {
            return -1;
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        return (base * pow(base, exponent - 1));

    }

    public static int gcd(int num1, int num2) {

        if (num1 > num2) {
            return gcd(num2, num1);
        }
        if (num2 < 0) {
            num2 = num2 * -1;
        }
        if (num1 < 0) {
            num1 = num1 * -1;
        }

        if (num1 == 0) {
            return num2;
        } else if (num2 == 0) {
            return num1;
        }

        if (num1 == num2) {
            return num1;
        }

        if (num2 % num1 == 0) {
            return num1;
        } else {
            return gcd(num2 % num1, num1);
        }

    }

    public static Integer decimalToBinary(Integer n) {
        if(n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }

        return ((decimalToBinary(n/2) * 10) + (n%2));
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(217));
    }
}