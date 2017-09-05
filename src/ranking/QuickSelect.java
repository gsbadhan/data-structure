package ranking;

/**
 * Quick-Select algorithm used to find out Kth smallest and largest element in
 * given array.
 *
 */
public class QuickSelect {

	public static void main(String args[]) {
		int[] arr = { 2, 45, 89, 5, 8, 100, 45 };

		// Kth smallest
		int kthSmallestIndex = 3;

		int kthSmallestElement = quickSelect(kthSmallestIndex, arr, 0, arr.length - 1);

		System.out.println("Kth smallest element:" + kthSmallestElement + " at index:" + kthSmallestIndex);
	}

	private static int quickSelect(int kthSmallestIndex, int[] arr, int start, int end) {
		int pIndex = partition(arr, start, end);

		if (pIndex == kthSmallestIndex) {
			return arr[pIndex];
		}
		if (kthSmallestIndex > pIndex) {
			quickSelect(kthSmallestIndex, arr, start, pIndex - 1);
		} else {
			quickSelect(kthSmallestIndex, arr, pIndex + 1, end);
		}
		return -1;
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;
		for (int i = start; i < end; i++) {
			if (pivot > arr[i]) {
				int temp = arr[i];
				arr[i] = arr[pIndex];
				arr[pIndex] = temp;
				pIndex = pIndex + 1;
			}
		}

		arr[end] = arr[pIndex];
		arr[pIndex] = pivot;

		return pIndex;
	}

}
