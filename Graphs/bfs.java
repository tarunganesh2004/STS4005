import java.util.*;

class graph {
    LinkedList<Integer> adj[];

    graph(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    void insert(int s, int d) {
        adj[s].add(d);
        adj[d].add(s);
    }

    void bfs(int source, int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v];
        q.add(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            int n = q.poll();
            System.out.print(n + " ");
            for (int i : adj[n]) {
                if (vis[i] != true) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }

    void dfs(int source,int v){
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];
        s.add(source);
        vis[source] = true;
        while (!s.isEmpty()) {
            int n = s.pop();
            System.out.print(n + " ");
            for (int i : adj[n]) {
                if (vis[i] != true) {
                    s.add(i);
                    vis[i] = true;
                }
            }
        }
    }
}
class bfs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        graph g = new graph(v);
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt(); // source
            int d = sc.nextInt(); // destination
            g.insert(s, d);
        }
        int source = sc.nextInt(); // from this vertex we should traverse
        g.bfs(source, v);
        sc.close();
    }
}