package common.NodeClass;

/**
 * Merge two sorted (ascending) lists of interval and return it as a new sorted list. The new sorted list should be made by splicing together the intervals of the two lists and sorted in ascending order.
 * <p>
 * Example
 * Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].
 * <p>
 * Notice
 * The intervals in the given list do not overlap.
 * The intervals in different lists may overlap.
 */
public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
