import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAdjacencyMatrix {

    public static class WeightedAdjacencyMatrix {
        int nodeCount; 
        int[][] data;
        WeightedAdjacencyMatrix(int size) {
            this.nodeCount = size;
            data = new int[size][];
            for (int i = 0; i < size; i++) {
                data[i] = new int[size];
                for (int j = 0; j < size; j++) {
                    data[i][j] = 0;
                }
            }
        }
    }

    /**
     * @param graph
     * @param source
     * @param needle
     * @return the order in which we found the nodes
     */
    public Integer[] bfs(
        WeightedAdjacencyMatrix graph,
        int source,
        int needle
    ) {

        boolean[] seen = new boolean[graph.nodeCount];
        // Later needed for iterating backwards
        int[] prev = new int[graph.nodeCount];

        seen[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source); // First node

        while (q.size() > 0) {
            Integer curr = q.poll();
            if (curr == needle) { // Abort if we found the needle
                break;
            } else if (seen[curr]) { // Skip if we have already seen this
                continue;
            }

            seen[curr] = true; // We have seen this node now

            int[] adj = graph.data[curr]; // Retrieve all outgoing connections from this node

            for (int i = 0; i < adj.length; i++) {
                if (adj[i] == 0) { // No connection
                    continue;
                }
                
                if (seen[i]) { // Already seen
                    continue;
                }

                seen[i] = true;
                prev[i] = curr; // Current is the previous of the next node.
                q.add(adj[i]);
            };
        }

        // Iterate backwards through the prev list to create the path
        int curr = needle;
        List<Integer> out = new LinkedList<>();

        while (prev[curr] != -1) {
            out.add(curr);
            curr = prev[curr];
        }

        if (out.size() > 0) {
            // We have to also add the source in the beginning,
            // that does not have a parent, aka was -1
            out.add(source);
            Collections.reverse(out);
        }

        return out.toArray(new Integer[0]);
    }
    
}
