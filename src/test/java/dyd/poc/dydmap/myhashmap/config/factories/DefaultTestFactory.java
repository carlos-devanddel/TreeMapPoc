package dyd.poc.dydmap.myhashmap.config.factories;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public class DefaultTestFactory {
	private static EasyRandom createRandomDefaultGenerator() {
		EasyRandomParameters parameters = new EasyRandomParameters();
		parameters.stringLengthRange(1,(int) (Math.random()*20)).collectionSizeRange(1, 5);
		return new EasyRandom(parameters);
	}

	public static Object createRandomTestObject(Class classname) {
		return createRandomDefaultGenerator().nextObject(classname);
	}

}
