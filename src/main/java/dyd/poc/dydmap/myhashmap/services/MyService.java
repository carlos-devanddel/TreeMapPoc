package dyd.poc.dydmap.myhashmap.services;

import dyd.poc.dydmap.myhashmap.models.TheKey;
import dyd.poc.dydmap.myhashmap.models.TheValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyService {

	public Map<TheKey, List<TheValue>> convertListToMap(List<TheValue> values) {
		TreeMap<TheKey, List<TheValue>> map = new TreeMap<>((key1, key2) -> key1.mySpecialComparer(key2));
		values.forEach(theValue -> injectValueToMap(theValue, map));
		return map;
	}

	private void injectValueToMap(TheValue theValue, TreeMap<TheKey, List<TheValue>> map) {
		map.putIfAbsent(theValue.getTheKey(), new ArrayList<>());
		map.get(theValue.getTheKey()).add(theValue);
	}
}
