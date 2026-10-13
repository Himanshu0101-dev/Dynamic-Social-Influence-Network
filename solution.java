import java.util.*;

public class DynamicSocialInfluenceNetwork {

    public static int[] socialInfluence(int n, int[][] edges, int[] activated, int k) {
        // Build graph and indegree map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> indegree = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            indegree.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }

        Set<Integer> active = new HashSet<>();
        for (int a : activated) active.add(a);

        int steps = 0;

        while (true) {
            Set<Integer> newActive = new HashSet<>();
            for (int node = 0; node < n; node++) {
                if (!active.contains(node)) {
                    List<Integer> incoming = indegree.getOrDefault(node, new ArrayList<>());
                    int count = 0;
                    for (int nei : incoming) {
                        if (active.contains(nei)) count++;
                    }
                    if (count >= k) {
                        newActive.add(node);
                    }
                }
            }
            if (newActive.isEmpty()) break;
            active.addAll(newActive);
            steps++;
        }

        return new int[]{steps, active.size()};
    }

    public static void main(String[] args) {
        int n = 6, k = 2;
        int[][] edges = {
            {0,1},{0,2},{1,3},{2,3},{3,4},{4,5}
        };
        int[] activated = {0};

        int[] result = socialInfluence(n, edges, activated, k);
        System.out.println("Steps = " + result[0]);
        System.out.println("Final Activated Count = " + result[1]);
    }
}
