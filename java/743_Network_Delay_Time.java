/*
 * Problem: 743. Network Delay Time
 * 
 * Description:
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times
 * as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is
 * the time it takes for a signal to travel from source to target. We will send a signal from a given node k.
 * Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the
 * n nodes to receive the signal, return -1.
 * 
 * Requirements:
 * - Find minimum time for signal to reach all nodes from node k
 * - Return -1 if impossible to reach all nodes
 * 
 * Example:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * 
 * Constraints:
 * - 1 <= k <= n <= 100
 * - 1 <= times.length <= 6000
 * - times[i].length == 3
 * - 1 <= ui, vi <= n
 * - ui != vi
 * - 0 <= wi <= 100
 * - All the pairs (ui, vi) are unique (i.e., no multiple edges)
 */

class Solution {
    /*Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        // DFS
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        for (int node: graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dfs(graph, K, 0);
        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

    public void dfs(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info: graph.get(node))
                dfs(graph, info[1], elapsed + info[0]);
    }*/
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        // Dijkstra
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dist.put(K, 0);
        boolean[] seen = new boolean[N+1];

        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }

            if (candNode < 0) break;
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist.put(info[0],
                             Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }

        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}
