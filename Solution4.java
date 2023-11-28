import java.util.*;

public class Solution4 {
    public static void dfs(int[][] graph, List<List<Integer>> ret, List<Integer> path, int x) {
        path.add(x);
        if(x!=graph.length-1) {
            for(int y:graph[x]) {
                dfs(graph, ret, path, y);
            }
        }
        else {
            ret.add(new ArrayList(path));
        }
        path.remove(path.size()-1);
    }
    
    public static List<List<Integer>> allPaths(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(graph, ret, path, 0);
        return ret;
    }
    public static void main(String args[]) {
      int[][] graph = new int[][] {{1,2},{3},{3},{}};
      System.out.println(allPaths(graph));
      int[][] graph1 = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
      System.out.println(allPaths(graph1));
    }
}