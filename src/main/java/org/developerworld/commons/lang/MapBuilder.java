package org.developerworld.commons.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * Map 构建器
 * @author Roy Huang
 *
 * @param <K>
 * @param <V>
 */
public class MapBuilder<K, V> {

	private Map<K, V> map;

	public MapBuilder() {
		this(new HashMap<K, V>());
	}

	public MapBuilder(Map<K, V> map) {
		this.map = map;
	}

	public MapBuilder(Map<K, V> map, K key, V value) {
		this.map = map;
		map.put(key, value);
	}

	public MapBuilder<K, V> put(K key, V value) {
		map.put(key, value);
		return this;
	}

	public MapBuilder<K, V> putAll(Map<K, V> map) {
		this.map.putAll(map);
		return this;
	}

	public MapBuilder<K, V> clear() {
		map.clear();
		return this;
	}

	public Map<K, V> map() {
		return map;
	}
}
