package com.tuhin.interviews.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuhin mandal on 9/19/2016.
 * <p>
 * This class demonstrates BFT traversal of graph.
 * <p>
 * code reference : http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal of a tree (See method 2 of this
 * post). The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same node again. To
 * avoid processing a node more than once, we use a boolean visited array. For simplicity, it is assumed that all
 * vertices are reachable from the starting vertex.
 * For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all
 * adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be
 * processed again and it will become a non-terminating process. A Breadth First Traversal of the following
 * graph is 2, 0, 3, 1.
 *
 *
 *  0-------1
 *  |      /
 *  |     /
 *  |    /       |---
 *  |   /        | /
 *   2-----------3 [3 has a cycle to itself]
 */
public class GraphBFT {


    private int V; // number of vertices
    private LinkedList<Integer>[] adjacencyList; // adjacency list

    //constructor with number of vertices for initializations
    public GraphBFT(int v) {
        V = v;
        adjacencyList = new LinkedList[V];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    //add and edge to the graph
    public void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }


    /**
     * @param s : input vertex to start traversal
     */
    public void printBFT(int s) {

        // create an array to maintain status whether the vertices are visited or not, by default all elements
        // are set to false, means not visited
        boolean[] visited = new boolean[V];
        // create a queue and insert current node into it for backtracking it's neighbours
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true; // set current node as visited
        queue.add(s); // add current node to the queue


        // check current vertex's neighbours and check if that neighbour is visited or not.
        // if not visited make that true in visited list and push that to the queue to
        // check it's neighbours

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> iterator = adjacencyList[s].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphBFT graph = new GraphBFT(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.printBFT(2);
    }

}
