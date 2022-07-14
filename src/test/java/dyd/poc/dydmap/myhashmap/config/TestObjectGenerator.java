package dyd.poc.dydmap.myhashmap.config;


import dyd.poc.dydmap.myhashmap.config.factories.DefaultTestFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObjectGenerator {
	public <T> T createRandomTestObject(Class<T> type) {
		return (T) DefaultTestFactory.createRandomTestObject(type);
	}

	public <T> List<T> createRandomListOfTestObjects(Class<T> classname, int length) {
		List<T> ret = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			ret.add(createRandomTestObject(classname));
		}
		return ret;
	}
}
