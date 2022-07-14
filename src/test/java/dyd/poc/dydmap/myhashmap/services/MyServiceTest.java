package dyd.poc.dydmap.myhashmap.services;

import dyd.poc.dydmap.myhashmap.config.TestObjectGenerator;
import dyd.poc.dydmap.myhashmap.models.TheKey;
import dyd.poc.dydmap.myhashmap.models.TheValue;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyServiceTest {

	TestObjectGenerator testObjectGenerator = new TestObjectGenerator();

	MyService sut = new MyService();

	@Test
	void convertListToMap_should_add3ElementsAllWith1Element_when3completeDiferentKeys() {
		List<TheValue> inputList = testObjectGenerator.createRandomListOfTestObjects(TheValue.class, 3);

		Map<TheKey, List<TheValue>> result = sut.convertListToMap(inputList);

		assertEquals(3, result.size());
		inputList.forEach(theValue ->assertEquals(1, result.get(theValue.getTheKey()).size()));

	}

	@Test
	void convertListToMap_should_add2ElementsAndOneWith2Elements_when2completeDiferentKeysAnd3Values() {
		TheKey key = testObjectGenerator.createRandomTestObject(TheKey.class);
		List<TheValue> inputList = testObjectGenerator.createRandomListOfTestObjects(TheValue.class, 3);
		inputList.get(0).setTheKey(key);
		inputList.get(1).setTheKey(key);

		Map<TheKey, List<TheValue>> result = sut.convertListToMap(inputList);

		assertEquals(2, result.size());
		assertEquals(2, result.get(inputList.get(0).getTheKey()).size());
		assertEquals(1, result.get(inputList.get(2).getTheKey()).size());

	}

	@Test
	void convertListToMap_should_add2ElementsAndOneWith2Elements_when2EqualKeysThatHasTheThirdFieldDifferentAnd3Values() {
		TheKey key = testObjectGenerator.createRandomTestObject(TheKey.class);
		TheKey key2 = testObjectGenerator.createRandomTestObject(TheKey.class);
		key2.setFirstField(key.getFirstField());
		key2.setSecondField(key.getSecondField());
		key2.setThirdField("AAAAA");
		key.setThirdField("BBBBBB");
		List<TheValue> inputList = testObjectGenerator.createRandomListOfTestObjects(TheValue.class, 3);
		inputList.get(0).setTheKey(key);
		inputList.get(1).setTheKey(key2);

		Map<TheKey, List<TheValue>> result = sut.convertListToMap(inputList);

		assertEquals(2, result.size());
		assertEquals(2, result.get(inputList.get(0).getTheKey()).size());
		assertEquals(1, result.get(inputList.get(2).getTheKey()).size());

	}
}