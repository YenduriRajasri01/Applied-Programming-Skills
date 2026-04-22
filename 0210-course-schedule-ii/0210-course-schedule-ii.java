class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;

        // Build graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for(int[] p : prerequisites) {
            int a = p[0], b = p[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Push nodes with indegree 0
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] ans = new int[n];
        int idx = 0;

        // BFS
        while(!q.isEmpty()) {
            int node = q.poll();
            ans[idx++] = node;

            for(int neigh : adj.get(node)) {
                indegree[neigh]--;
                if(indegree[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        // Cycle check
        if(idx == n) return ans;
        return new int[0];
    }
}