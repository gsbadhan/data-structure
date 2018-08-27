package com.graph.structure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Vertex implements IVertex{
	private final long id;
	private Map<String, Object> properties=new HashMap<>();

	public Vertex(long id) {
		super();
		this.id = id;
	}

	@Override
	public void update(String property,Object value) {
		properties.put(property, value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public Map<String, Object> get() {
		return Collections.unmodifiableMap(properties);
	}
	
	

}
