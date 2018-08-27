package com.graph.structure;

import java.util.UUID;

public final class Edge implements IEdge {
	private final String id ;
	private final long source;
	private final long dest;

	public Edge(long source, long dest) {
		super();
		this.source = source;
		this.dest = dest;
		this.id = UUID.randomUUID().toString();
	}

	@Override
	public long getSource() {
		return source;
	}

	@Override
	public long getDestination() {
		return dest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
