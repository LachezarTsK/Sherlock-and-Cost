import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int length = scanner.nextInt();
			int[] array = new int[length];

			for (int j = 0; j < length; j++) {
				array[j] = scanner.nextInt();
			}
			System.out.println(getMaximumSumOfAbsoluteDifference(array));
		}
		scanner.close();
	}

	/**
	 * Calculates the maximum sum of the absolute difference of consecutive pairs in
	 * the new array, where each element in the new array is in accord with the rule
	 * 1<=new array[i]<=original array[i].
	 * 
	 * During each iteration through the original array, only this combination of
	 * elements that could form the new array is added to the maximum sum, which
	 * contribute most to the maximum sum of the absolute differences. The value of
	 * the actual elements of the new array is not stored.
	 *
	 * Variables SubSumLow/SubSumHigh represent possible combinations of elements
	 * that could form the new current maximum sum of the absolute difference of
	 * consecutive pairs. In SubSumLow the last element that could form the new
	 * array is always 1. In SubSumHigh the last element that could form the new
	 * array is always the element at the current index of the original array.
	 */
	private static int getMaximumSumOfAbsoluteDifference(int[] array) {

		int subSumLow = 0;
		int subSumHigh = 0;
		int maximumSum = 0;

		for (int i = 1; i < array.length; i++) {

			int previous_SubSumLow = subSumLow;
			int previous_SubSumHigh = subSumHigh;

			int low_firstOption = previous_SubSumLow;
			int low_secondOption = previous_SubSumHigh + Math.abs(array[i - 1] - 1);
			subSumLow = Math.max(low_firstOption, low_secondOption);

			int high_firstOption = previous_SubSumHigh + Math.abs(array[i] - array[i - 1]);
			int high_secondOption = previous_SubSumLow + Math.abs(array[i] - 1);
			subSumHigh = Math.max(high_firstOption, high_secondOption);

			maximumSum = Math.max(subSumLow, subSumHigh);
		}
		return maximumSum;
	}
}
