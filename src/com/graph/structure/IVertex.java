package com.graph.structure;

import java.util.Map;

public interface IVertex {
	long getId();

	Map<String, Object> get();

	void update(String property,Object value);
}
