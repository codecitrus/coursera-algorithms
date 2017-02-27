package com.example.algorithms.week1;

public class KaratsubaMultiplication {
	
	public static void main(String[] args) {
		System.out.println("ANSWER: " + multiply(123, 456));;
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
		
		System.out.println("Doing (" + x + ")(" + y + ")");
		
		int r1 = multiply(a,c);
		int r3 = multiply(b,d);
		int r2 = multiply(a + c, b + d) - r1 - r3;
		int c1 = power(10, xdigits);
		int c2 = power(10, xdigits/2);
		int retval = r1*power(10, xdigits) + r2*power(10, xdigits/2) + r3;
		
		// Log
		System.out.println("\nDone (" + x + ")(" + y + ")");
		System.out.println("Returning: " + retval);
		
		return retval;
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
