package graph;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/reconstruct-itinerary
 * Difficulty: Hard
 * Time complexity: O(V ^ E)
 * Space complexity: O(V + E)
 */
public class ReconstructItinerary {

    private static final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Ticket>> adjList = buildAdjList(tickets);

        List<String> itinerary = new ArrayList<>();
        itinerary.add(START);
        int[] usedTickets = new int[tickets.size()];

        return findItinerary(START, adjList, usedTickets, itinerary);
    }

    private List<String> findItinerary(
            String current,
            Map<String, List<Ticket>> adjList,
            int[] usedTickets,
            List<String> currentItinerary) {
        if (currentItinerary.size() == usedTickets.length + 1) {
            return currentItinerary;
        }

        for (Ticket next : adjList.getOrDefault(current, List.of())) {
            if (usedTickets[next.index] == 0) {
                usedTickets[next.index] = 1;
                currentItinerary.add(next.destination);

                List<String> itinerary = findItinerary(next.destination, adjList, usedTickets, currentItinerary);
                if (!itinerary.isEmpty()) return itinerary;

                usedTickets[next.index] = 0;
                currentItinerary.remove(currentItinerary.size() - 1);
            }
        }

        return List.of();
    }

    private Map<String, List<Ticket>> buildAdjList(List<List<String>> tickets) {
        Map<String, List<Ticket>> adjList = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            adjList.computeIfAbsent(ticket.get(0), __ -> new ArrayList<>()).add(new Ticket(ticket.get(1), i));
        }

        for (List<Ticket> t : adjList.values()) {
            t.sort(Comparator.comparing(a -> a.destination));
        }

        return adjList;
    }

    private record Ticket(String destination, int index) {
    }
}
