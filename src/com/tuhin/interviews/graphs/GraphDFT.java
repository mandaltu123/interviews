package com.tuhin.interviews.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author tuhinmandal on 19/09/16.
 *         <p/>
 *         Depth first traversal is similar to tree DFS. Difference is that in tree all nodes are strongly
 *         connected and there is no cycle present.
 *         But in case of a graph, there could be a cycle so we have to maintain the visited vertices.
 *         we do not need to print same vertex twice.
 *         Reference: geeksforgeeks
 */
public class GraphDFT {


    private int V; // no of vertices
    private LinkedList<Integer>[] adjacencyList; // adjacency list

    //constructor with initializations
    public GraphDFT(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    // add edge to the graph

    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }


    // dfs
    public void dfs() {
        //create visited array and initialize it with none visited
        boolean[] visited = new boolean[V];

        // we are calling this in side this loop because graph may not be completely connected.
        //to avoided leaving out any node which is not connected anyway from the starting vertex.
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                dfsTraversal(i, visited);
            }
        }
    }

    //recursive dfs traversal. actual traversal is happening here
    private void dfsTraversal(int s, boolean[] visited) {
        //mark current node as visited
        visited[s] = true;
        //print current vertex as it has been traversed
        System.out.print(s + " ");
        //traverse all vertices who are this vertex's neighbours
        Iterator<Integer> iterator = adjacencyList[s].listIterator();
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (!visited[n]) {
                dfsTraversal(n, visited);
            }
        }
    }


    public static void main(String[] args) {
        GraphDFT graph = new GraphDFT(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.dfs();
    }


}
