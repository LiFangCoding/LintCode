package lintCode_alg._2_binary_search;

/**
 * Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.
 * <p>
 * Return -1, if the number doesn't exist in the array.
 * <p>
 * Example
 * Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.
 * <p>
 * Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.
 * <p>
 * Challenge
 * O(log k), k is the first index of the given target number.
 * <p>
 * Notice
 * If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.
 */
public class _447 {
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // find end idx that larger than target
        int end = 1;

        while (reader.get(end) < target) {
            end = end * 2;
        }

        int start = 0;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }

        if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }

    public static class ArrayReader {
        int[] A;

        public ArrayReader() {
            A = new int[Integer.MAX_VALUE];
        }

        public int get(int i) {
            return A[i];
        }
    }
}
