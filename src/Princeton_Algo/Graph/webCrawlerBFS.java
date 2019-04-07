package Princeton_Algo.Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class webCrawlerBFS {

    public webCrawlerBFS() {
        Queue<String> queue = new Queue<String>();
        Set<String> discovered = new HashSet<>();

        String root = "http://www.princeton.com";
        queue.enqueue(root);
        discovered.add(root);

        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            StdOut.println(v);
            In in = new In(v);
            String input = in.readAll();

            String regexp = "http://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String w = matcher.group();
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.enqueue(w);
                }
            }
        }
    }
}
