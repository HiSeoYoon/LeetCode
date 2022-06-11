package S1971_Find_if_Path_Exists_in_Graph;

public class Solution {
    public static void main(String[] args) {
        int[][] input = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        //{{0, 1}, {3, 4}, {5, 0}, {2, 5}, {1, 4}};
        //{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int n = 6;
        int start = 0;
        int end = 2;

        boolean output = validPath(n, input, start, end);
        System.out.println("result : " + output);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        DisjointSetUnion set = new DisjointSetUnion(n);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }

        return set.areConnected(source, destination);
    }
}

class DisjointSetUnion {
    private int[] parent;
    private int N;

    public DisjointSetUnion(int n) {
        this.N = n;
        this.parent = new int[this.N];
        for (int i = 0; i < this.N; i++) {
            this.parent[i] = i;
        }
    }

    public boolean areConnected(int u, int v) {
        System.out.println("find x : " + find(u) + ", find y : " + find(v));
        return find(u) == find(v);
    }

    public void union(int u, int v) {
        if (u != v) {
            //int a = find(u);
            //int b = find(v);
            int a = find_test(u);
            int b = find_test(v);
            parent[b] = a;
            //parent[a] = b;
        }
    }

    private int find(int u) {
        int x = u;
        while (x != this.parent[x]) {
            x = this.parent[x];
        }
        this.parent[u] = x;
        return x;
    }

    private int find_test(int u) {
        if (this.parent[u] == u)
            return u;
        else
            return this.parent[u] = find_test(this.parent[u]);
    }
}

class DisjointSetUnion_2 {
    private int[] parent;
    private int[] rank;
    private int N;

    public DisjointSetUnion_2(int n) {
        this.N = n;
        this.parent = new int[this.N];
        this.rank = new int[this.N];
        for (int i = 0; i < this.N; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public boolean areConnected(int u, int v) {
        return find(u) == find(v);
    }

    public void union(int u, int v) {
        if (u != v) {
            int a = find(u);
            int b = find(v);
            if (a != b) {
                if (rank[a] > rank[b]) {
                    parent[b] = a;
                    rank[a] += rank[b];
                } else {
                    parent[a] = b;
                    rank[b] += rank[a];
                }
            }
        }
    }

    private int find(int u) {
        int x = u;
        while (x != this.parent[x]) {
            x = this.parent[x];
        }

        this.parent[u] = x;
        return x;
    }
}

class Solution_2 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        DisjointSetUnion_2 set = new DisjointSetUnion_2(n);
        for (int[] edge : edges) {
            set.union(edge[0], edge[1]);
        }

        return set.areConnected(start, end);
    }
}