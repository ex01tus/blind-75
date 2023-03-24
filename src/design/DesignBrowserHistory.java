package design;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: https://leetcode.com/problems/design-browser-history
 * Difficulty: Medium
 */
public class DesignBrowserHistory {

    /**
     * Time complexity: O(1) for visit(), O(n) for back() and forward()
     * Space complexity: O(n)
     */
    private static class BrowserHistoryViaLinkedList {

        private final HistoryList historyList;

        public BrowserHistoryViaLinkedList(String homepage) {
            this.historyList = new HistoryList(homepage);
        }

        public void visit(String url) {
            historyList.add(url);
        }

        public String back(int steps) {
            return historyList.backAtMost(steps);
        }

        public String forward(int steps) {
            return historyList.forwardAtMost(steps);
        }

        private static class HistoryList {

            private HistoryNode current;

            public HistoryList(String url) {
                current = new HistoryNode(url);
            }

            public void add(String url) {
                HistoryNode added = new HistoryNode(url);
                current.next = added;
                added.prev = current;

                current = added;
            }

            public String backAtMost(int steps) {
                for (int i = 0; i < steps; i++) {
                    if (current.prev == null) break;
                    current = current.prev;
                }

                return current.url;
            }

            public String forwardAtMost(int steps) {
                for (int i = 0; i < steps; i++) {
                    if (current.next == null) break;
                    current = current.next;
                }

                return current.url;
            }
        }

        private static class HistoryNode {
            private final String url;
            private HistoryNode next;
            private HistoryNode prev;

            public HistoryNode(String url) {
                this.url = url;
            }
        }
    }

    /**
     * Time complexity: O(1) for visit(), O(n) for back() and forward()
     * Space complexity: O(n)
     */
    private static class BrowserHistoryViaTwoStacks {

        private final HistoryStacks historyStacks;

        public BrowserHistoryViaTwoStacks(String homepage) {
            historyStacks = new HistoryStacks(homepage);
        }

        public void visit(String url) {
            historyStacks.add(url);
        }

        public String back(int steps) {
            return historyStacks.backAtMost(steps);
        }

        public String forward(int steps) {
            return historyStacks.forwardAtMost(steps);
        }

        private static class HistoryStacks {

            private final Deque<String> past;
            private final Deque<String> future;
            private String current;

            public HistoryStacks(String url) {
                this.past = new LinkedList<>();
                this.future = new LinkedList<>();
                this.current = url;
            }

            public void add(String url) {
                past.push(current);
                current = url;
                future.clear();
            }

            public String backAtMost(int steps) {
                for (int i = 0; i < steps; i++) {
                    if (past.isEmpty()) break;

                    future.push(current);
                    current = past.pop();
                }

                return current;
            }

            public String forwardAtMost(int steps) {
                for (int i = 0; i < steps; i++) {
                    if (future.isEmpty()) break;

                    past.push(current);
                    current = future.pop();
                }

                return current;
            }
        }
    }

    /**
     * Time complexity: O(1) for visit(), back() and forward()
     * Space complexity: O(n)
     */
    private static class BrowserHistoryViaArrayList {

        private final HistoryList historyList;

        public BrowserHistoryViaArrayList(String homepage) {
            historyList = new HistoryList(homepage);
        }

        public void visit(String url) {
            historyList.add(url);
        }

        public String back(int steps) {
            return historyList.backAtMost(steps);
        }

        public String forward(int steps) {
            return historyList.forwardAtMost(steps);
        }

        private static class HistoryList {

            private final List<String> urls;
            private int current;
            private int last;

            public HistoryList(String url) {
                this.urls = new ArrayList<>(List.of(url));
                this.current = 0;
                this.last = 0;
            }

            public void add(String url) {
                current++;
                if (urls.size() > current) {
                    urls.set(current, url);
                } else {
                    urls.add(url);
                }

                last = current;
            }

            public String backAtMost(int steps) {
                current = Math.max(0, current - steps);
                return urls.get(current);
            }

            public String forwardAtMost(int steps) {
                current = Math.min(last, current + steps);
                return urls.get(current);
            }
        }
    }

    public static void main(String[] args) {
        BrowserHistoryViaArrayList history = new BrowserHistoryViaArrayList("leetcode.com");

        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        System.out.println(history.back(1));    // back 1 step from youtube -> facebook
        System.out.println(history.back(1));    // back 1 step from facebook -> google
        System.out.println(history.forward(1)); // forward 1 step from google -> facebook
        history.visit("linkedin.com");
        System.out.println(history.forward(2)); // forward 2 steps from linkedin -> nowhere to move -> linkedin
    }
}
