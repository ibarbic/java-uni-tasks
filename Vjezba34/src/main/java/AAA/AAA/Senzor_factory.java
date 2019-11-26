package AAA.AAA;

public class Senzor_factory {

Senzor_factory(){
}
enum senzor_type {
	  WaterTemperture,
	  WaterPressure,
	  WaterDay,
	  WaterYear;
}


public static Senzor generate(Senzor_factory.senzor_type type ) {
	
	if(type == Senzor_factory.senzor_type.WaterTemperture) {
		Senzor s = new Senzor("WaterTemperture","°C",10,-32668,32668);
		return s;
	}
	else if(type == Senzor_factory.senzor_type.WaterPressure) {
		Senzor s = new Senzor("WaterPressure","Bar",1000,0,65336);
		return s;
	}
	else if(type == Senzor_factory.senzor_type.WaterDay) {
		Senzor s = new Senzor("WaterDay","litra",1,0,65336);
		return s;
	}
	else if(type == Senzor_factory.senzor_type.WaterYear) {
		Senzor s = new Senzor("WaterYear","m3",10,0,65336);
		return s;
	}
	return new Senzor();
	
}

	
}

