package AAA.AAA;

import com.google.gson.Gson;


public class App {

public static void main(String[] args) {
	
	
	Gson gson = new Gson();
    //String js = "{'naziv' : 'senzor1','jedinica':'C','faktor': 10,'min': -32668, 'max':32668}";   	
    String json = "{'senzors':[{'naziv' : 'senzor1','jedinica':'C','faktor': 10,'min': -32668, 'max':32668},{'naziv' : 'senzor2','jedinica':'Bar','faktor': 10,'min': -32668, 'max':32668}]}";    
    MjeracVode m = gson.fromJson(json, MjeracVode.class);
	
	MjeracVode measurer = new MjeracVode();
	String test = gson.toJson(measurer);
	System.out.println(test);
	
	try {
		m.publish();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	


}
}