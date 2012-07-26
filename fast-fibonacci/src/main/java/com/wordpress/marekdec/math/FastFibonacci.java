package com.wordpress.marekdec.math;

public class FastFibonacci {

	public static void main(String[] args) {
		int indexOfAFibonacciNumber = 91;

		TwoByTwoMatrix fibonacciMatrix = new TwoByTwoMatrix(1, 1, 1, 0);

		System.out.println(fibonacciMatrix.power(indexOfAFibonacciNumber).getTopRight());
	}

}
