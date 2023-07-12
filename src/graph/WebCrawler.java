package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/web-crawler
 * Difficulty: Medium
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class WebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = getHostname(startUrl);

        Queue<String> planned = new LinkedList<>();
        planned.offer(startUrl);
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);

        while (!planned.isEmpty()) {
            String current = planned.poll();

            for (String neighbor : htmlParser.getUrls(current)) {
                if (neighbor.startsWith(hostname) && visited.add(neighbor)) {
                    planned.offer(neighbor);
                }
            }
        }

        return new ArrayList<>(visited);
    }

    private String getHostname(String startUrl) {
        return "http://" + startUrl.split("/")[2];
    }

    private interface HtmlParser {
        List<String> getUrls(String url);
    }
}
