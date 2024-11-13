package structuralDesignPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
	private static Map<String, TreeType> treeTypes = new HashMap<>();
	
	public static TreeType getTreeType(String name, String color, String texture) {
		String key = name+color+texture;
		if(!treeTypes.containsKey(key)) {
			treeTypes.put(key, new ConcreteTreeType(name, color, texture));
		}
		return treeTypes.get(key);
	}
}
