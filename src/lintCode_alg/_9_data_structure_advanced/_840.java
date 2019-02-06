package lintCode_alg._9_data_structure_advanced;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * 1.The array is only modifiable by the update function.
 * 2.You may assume the number of calls to update and sumRange function is distributed evenly.
 * <p>
 * Example
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */
public class _840 {
    class SegmentTreeNode {
        SegmentTreeNode left, right;
        int sum, start, end;

        public SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = null;
            this.right = null;
        }
    }

    class SegmentTree {
        SegmentTreeNode root;

        public SegmentTree(int[] nums) {
            root = build(0, nums.length - 1, nums);
        }

        public SegmentTreeNode build(int start, int end, int[] A) {
            // write your code here
            if (start > end) {
                return null;
            }

            SegmentTreeNode root = new SegmentTreeNode(start, end, 0);

            if (start != end) {
                int mid = (start + end) / 2;
                root.left = build(start, mid, A);
                root.right = build(mid + 1, end, A);
                root.sum = root.left.sum + root.right.sum;
            } else {
                root.sum = A[start];

            }
            return root;
        }

        public int querySegmentTree(SegmentTreeNode root, int start, int end) {
            // write your code here

            if (start == root.start && root.end == end) {
                return root.sum;
            }

            int mid = (root.start + root.end) / 2;
            int leftsum = 0, rightsum = 0;

            if (start <= mid) {
                if (mid < end) {
                    leftsum = querySegmentTree(root.left, start, mid);
                } else {
                    leftsum = querySegmentTree(root.left, start, end);
                }
            }

            if (mid < end) {
                if (start <= mid) {
                    rightsum = querySegmentTree(root.right, mid + 1, end);
                } else {
                    rightsum = querySegmentTree(root.right, start, end);
                }
            }

            return leftsum + rightsum;
        }

        public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
            // write your code here
            if (root.start == index && root.end == index) {
                root.sum = value;
                return;
            }

            int mid = (root.start + root.end) / 2;
            if (root.start <= index && index <= mid) {
                modifySegmentTree(root.left, index, value);
            }

            if (mid < index && index <= root.end) {
                modifySegmentTree(root.right, index, value);
            }

            root.sum = root.left.sum + root.right.sum;
        }
    }

    class NumArray {
        SegmentTree st;

        public NumArray(int[] nums) {
            st = new SegmentTree(nums);
        }

        public void update(int i, int val) {
            st.modifySegmentTree(st.root, i, val);
        }

        public int sumRange(int i, int j) {
            return st.querySegmentTree(st.root, i, j);
        }
    }
}
