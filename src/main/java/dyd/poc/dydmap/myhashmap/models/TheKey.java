package dyd.poc.dydmap.myhashmap.models;

import lombok.Data;

@Data
public class TheKey {

	private String firstField;
	private String secondField;
	private String thirdField;

	public int mySpecialComparer(TheKey otherKey){
		if(this.firstField.equals(otherKey.firstField)  && this.secondField.equals(otherKey.secondField)){
			return 0;
		} else{
			return firstField.concat(secondField).compareTo(otherKey.firstField.concat(otherKey.secondField));
		}
	}
}
