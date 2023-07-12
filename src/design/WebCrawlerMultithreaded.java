package design;

import java.util.*;
import java.util.concurrent.*;

/**
 * Description: https://leetcode.com/problems/web-crawler-multithreaded
 * Difficulty: Medium
 */
public class WebCrawlerMultithreaded {

    private static final int WORKERS_NUMBER = 5;

    private String hostname;
    private HtmlParser parser;
    private Queue<String> seeds;
    private Set<String> visited;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        hostname = getHostname(startUrl);
        parser = htmlParser;
        seeds = new ConcurrentLinkedQueue<>();
        visited = ConcurrentHashMap.newKeySet();

        ExecutorService workersPool = Executors.newFixedThreadPool(WORKERS_NUMBER);
        Queue<Future<?>> tasks = new LinkedList<>();

        seeds.offer(startUrl);
        visited.add(startUrl);

        while (true) {
            String current = seeds.poll();
            if (current != null) {
                tasks.offer(workersPool.submit(crawlTask(current)));
            } else {
                if (tasks.isEmpty()) {
                    workersPool.shutdown();
                    break;
                }

                Future<?> task = tasks.poll();
                execute(task);
            }
        }

        return new ArrayList<>(visited);
    }

    private Runnable crawlTask(String current) {
        return () -> {
            for (String neighbor : parser.getUrls(current)) {
                if (neighbor.startsWith(hostname) && visited.add(neighbor)) {
                    seeds.offer(neighbor);
                }
            }
        };
    }

    private void execute(Future<?> task) {
        try {
            task.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private String getHostname(String startUrl) {
        return "http://" + startUrl.split("/")[2];
    }

    private interface HtmlParser {
        List<String> getUrls(String url);
    }
}
