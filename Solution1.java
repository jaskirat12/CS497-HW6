import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public static boolean validPath(int n, int[][] edges, int start, int end) {
	    return validPath(getAdjList(edges), new HashSet<>(), start, end);
    }

    private static Map<Integer, Set<Integer>> getAdjList(int[][] edges) {
	    var adjList = new HashMap<Integer, Set<Integer>>();
	    for (var edge : edges) {
		    adjList.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
		    adjList.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
	    }
    	return adjList;
    }

    private static boolean validPath(Map<Integer, Set<Integer>> adjList, Set<Integer> visited, int current, int end) {
    	if (current == end)
    		return true;		
    	if (!visited.add(current))
    		return false;
    		
    	for (var neighbor : adjList.getOrDefault(current, Set.of()))
    		if (validPath(adjList, visited, neighbor, end))
    			return true;			
    	return false;
    }
    public static void main(String args[]) {
        int n = 6;
        int edges[][] = new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}};
      System.out.println(validPath(n, edges, 0, 5));
    }
}