package com.example.algorithms.week1;

/**
 * Code for simple recursive integer multiplication algorithm (one just before
 * Karatsuba is presented).
 * 
 * @author Gautham
 *
 */
public class SimpleIntegerMultiplication {

	public static void main(String[] args) {
		System.out.println("ANSWER: " + multiply(500, 500));;
	}
	
	private static int multiply(int x, int y) {
		
		int xdigits = String.valueOf(x).length();
		int ydigits = String.valueOf(y).length();
		if (xdigits == ydigits && xdigits == 1) {
			return x*y;
		}
		
		// Decompose x into a,b
		int[] parts = split(x);
		int a = parts[0];
		int b = parts[1];
		
		// Decompose y into c,d
		parts = split(y);
		int c = parts[0];
		int d = parts[1];
		
		// Log
		System.out.println("Doing (" + x + ")(" + y + ")");
		System.out.println("a: " + a + " b: " + b + " c: " + c + " d: " + d);
		
		int c1 = power(10, xdigits);
		int c2 = power(10, xdigits/2);
		return c1*multiply(a,c) + c2*(multiply(a,d) + multiply(b,c)) + multiply(b,d);
		
		
	}
	
	private static int[] split(int x) {
		int xdigits = String.valueOf(x).length();
		int b = x % power(10, xdigits/2);
		int a = (x - b)/power(10, xdigits/2);
		return new int[] {a, b};
	}
	
	private static int power(int x, int y) {
		if(y == 0) { return 1; }
		int rv = x;
		for(int i = 1; i < y; i++) {
			rv = rv * x;
		}
		return rv;
	}

	
}
