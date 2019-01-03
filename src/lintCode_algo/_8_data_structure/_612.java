package lintCode_algo._8_data_structure;

import common.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given some points and an origin point in two-dimensional space, find k points which are nearest to the origin.
 * Return these points sorted by distance, if they are same in distance, sorted by the x-axis, and if they are same in the x-axis, sorted by y-axis.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 */
public class _612 {
    // Time complexity: O(nlogk)
    // Space complexity: O(k)
    public static class sol1_PQ {
        public Point[] kClosest(Point[] points, Point origin, int k) {
            // Write your code here
            PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new PointComparator(origin));

            // maxpq keep the small ks.
            for (int i = 0; i < points.length; i++) {
                pq.add(points[i]);
                if (pq.size() > k) {
                    pq.remove();
                }
            }

            k = pq.size();
            Point[] ret = new Point[k];
            while (!pq.isEmpty()) {
                ret[--k] = pq.poll();
            }
            return ret;
        }

        public class PointComparator implements Comparator<Point> {
            Point origin;

            public PointComparator(Point origin) {
                this.origin = origin;
            }

            @Override
            public int compare(Point p1, Point p2) {
                int dist = Float.compare(getDistance(p2, origin), getDistance(p1, origin));
                if (dist == 0) {
                    dist = p2.x - p1.x;
                }
                if (dist == 0) {
                    dist = p2.y - p1.y;
                }
                return dist;
            }

            private float getDistance(Point a, Point b) {
                return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
            }
        }
    }

    //TODO
    // O(k * logk + n)
    public class sol2_QuickSelect {

    }
}
