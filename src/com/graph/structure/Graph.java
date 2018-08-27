package com.graph.structure;

import java.util.HashSet;

public class Graph {
	private HashSet<IVertex> vertices;
	private HashSet<IEdge> edges;

	public void buid() {
		this.vertices = new HashSet<>(100);
		this.edges = new HashSet<>(vertices.size() * 3);
	}

	public boolean create(Vertex v) {
		return vertices.add(v);
	}

	public boolean delete(Vertex v) {
		return vertices.remove(v);
	}

	public boolean createEdge(Vertex a, Vertex b) {
		Edge e = new Edge(a.getId(), b.getId());
		return edges.add(e);
	}
	
}
