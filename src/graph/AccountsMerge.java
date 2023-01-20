package graph;

import java.util.*;

import static java.util.Collections.emptySet;

/**
 * Description: https://leetcode.com/problems/accounts-merge
 * Difficulty: Medium
 * Time complexity: O(nlog n)
 * Space complexity: O(n)
 */
public class AccountsMerge {

    private Map<String, String> names;
    private Map<String, Integer> visited;
    private Map<String, Set<String>> adjList;
    private int component = 1;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        names = new HashMap<>();
        visited = new HashMap<>();
        adjList = adjList(accounts);

        for (String email : adjList.keySet()) {
            if (visited.get(email) == null) {
                dfs(email);
            }
        }

        return formatResult();
    }

    private Map<String, Set<String>> adjList(List<List<String>> accounts) {
        Map<String, Set<String>> adjList = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                names.put(email, name);

                Set<String> neighbors = adjList.computeIfAbsent(email, k -> new HashSet<>());

                if (i > 1) {
                    String prevEmail = account.get(i - 1);
                    neighbors.add(prevEmail);
                    adjList.get(prevEmail).add(email);
                }
            }
        }

        return adjList;
    }

    private void dfs(String start) {
        Deque<String> stack = new LinkedList<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (visited.get(current) == null) {
                visited.put(current, 0);
                stack.push(current);

                Set<String> neighbors = Optional.ofNullable(adjList.get(current)).orElse(emptySet());
                for (String neighbor : neighbors) {
                    if (visited.get(neighbor) == null) {
                        stack.push(neighbor);
                    }
                }
            } else if (visited.get(current) == 0) {
                visited.put(current, component);
            }
        }

        component++;
    }

    private List<List<String>> formatResult() {
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < component - 1; i++) {
            result.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> v : visited.entrySet()) {
            String email = v.getKey();
            int idx = v.getValue() - 1;

            List<String> account = result.get(idx);
            account.add(email);
        }

        for (List<String> account : result) {
            String email = account.get(0);
            Collections.sort(account);
            account.add(0, names.get(email));
        }

        return result;
    }
}
