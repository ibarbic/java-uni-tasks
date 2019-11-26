package AAA.AAA;
import java.util.Random;
public class Senzor {
	
	private String naziv;
	private String jedinica;
	private int faktor;
	private int min;
	private int max;
	
	Senzor(String naziv,String jedinica,int faktor,int min,int max){
		this.naziv=naziv;
		this.jedinica=jedinica;
		this.faktor=faktor;
		this.min=min;
		this.max=max;
		
		
	}
	public Senzor(){}
	public String get_value(){
		 
		int broj = getRandomNumberInRange(min,max);
		String s = Float.toString((float)broj/faktor);
		String _vrijednost = s + " " + jedinica;
		return _vrijednost;
		
	
	}
	public String get_naziv(){
		return naziv;
	}
	public int get_max(){
		return max;
	}



		
	private  int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
