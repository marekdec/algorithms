package com.wordpress.marekdec.math;

public class TwoByTwoMatrix {

	private static final TwoByTwoMatrix TWO_BY_TWO_IDENTITY_MATRIX = new TwoByTwoMatrix(1, 0, 0, 1);
	private final long topLeft;
	private final long bottomLeft;
	private final long topRight;
	private final long bottomRight;

	public TwoByTwoMatrix(long topLeft, long bottomLeft, long topRight, long bottomRight) {
		super();
		this.topLeft = topLeft;
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
		this.bottomRight = bottomRight;
	}

	public TwoByTwoMatrix multiplyBy(TwoByTwoMatrix other) {
		long newTopLeft = this.topLeft * other.topLeft + this.topRight * other.bottomLeft;
		long newBottomLeft = this.bottomLeft * other.topLeft + this.bottomRight * other.bottomLeft;
		long newTopRight = this.topLeft * other.topRight + this.topRight * other.bottomRight;
		long newBottomRight = this.bottomLeft * other.topRight + this.bottomRight * other.bottomRight;
		return new TwoByTwoMatrix(newTopLeft, newBottomLeft, newTopRight, newBottomRight);
	}

	private TwoByTwoMatrix computePower(TwoByTwoMatrix matrix, long e) {
		if (e < 0) {
			throw new IllegalArgumentException("exponent has to be a non-negative number, given number was [" + e + "]");
		} else if (e == 0) {
			return TWO_BY_TWO_IDENTITY_MATRIX;
		} else {
			if (isEven(e)) {
				TwoByTwoMatrix matrixToExponentHalved = computePower(matrix, e / 2);
				return matrixToExponentHalved.multiplyBy(matrixToExponentHalved);
			} else {
				TwoByTwoMatrix matrixToExponentMinus1Halved = computePower(matrix, (e - 1) / 2);
				return matrixToExponentMinus1Halved.multiplyBy(matrixToExponentMinus1Halved).multiplyBy(matrix);
			}
		}
	}

	public TwoByTwoMatrix power(long e) {
		return computePower(this, e);
	}

	private boolean isEven(long e) {
		return (e & 1) != 1;
	}

	public long getTopRight() {
		return topRight;
	}

	@Override
	public String toString() {
		return "|" + topLeft + ", " + topRight + "|\n|" + bottomLeft + ", " + bottomRight + "|";
	}

}
