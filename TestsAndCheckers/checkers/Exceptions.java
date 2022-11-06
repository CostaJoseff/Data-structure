package checkers;

public class Exceptions {

	public static void exceptionCheck(int arrayLength, int leftIndex, int rightIndex) {
		if (arrayLength <= 0) {
			throw new IllegalArgumentException("array cannot be empty");
		}
		if (leftIndex > rightIndex) {
			throw new IllegalArgumentException("left index: [" + leftIndex + "] cannot be greater than the right index: [" + rightIndex + "]");
		}
		if (leftIndex < 0) {
			throw new IllegalArgumentException("left index: [" + leftIndex + "] cannot be less than 0");
		}
		if (rightIndex < 0) {
			throw new IllegalArgumentException("right index: [" + rightIndex + "] cannot be less than 0");
		}
		if (leftIndex > arrayLength - 1) {
			throw new IllegalArgumentException("left index: [" + leftIndex + "] cannot be greater than the array length index limit: [" + (arrayLength - 1) + "]");
		}
		if (rightIndex > arrayLength - 1) {
			throw new IllegalArgumentException("right index: [" + rightIndex + "] cannot be greater than the array length index limit: [" + (arrayLength - 1) + "]");
		}
	}
	
}
