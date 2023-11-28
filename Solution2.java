public class Solution2 {
  public static int longestCycle(int[] edges) {
    int r = -1;
    int t = 1;
    int[] visitTimes = new int[edges.length];

    
    for (int i = 0; i < edges.length; ++i) {
      if (visitTimes[i] > 0)
        continue;
      final int s = t; 
      int x = i;
      
      while (x != -1 && visitTimes[x] == 0) {
        visitTimes[x] = t;
        t++;
        x = edges[x];
      }
      
      if (x != -1 && visitTimes[x] >= s)
        r = Math.max(r, t - visitTimes[x]);
    }

    return r;
  }
  public static void main(String[] args) {
      int[] edges = new int[]{3,3,4,2,3};
      System.out.println("Longest Cycle: " + longestCycle(edges));
      int[] edges1 = new int[]{2,-1,3,1};
      System.out.println("Longest Cycle: " + longestCycle(edges1));
  }
}