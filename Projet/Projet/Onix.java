public class Onix extends Terre{
	private String espece;

	
	public Onix(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[2]="Queud'fer";
		nbAttaques = 3;
		espece="Onix";
	}
	
	
	public Onix(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[2]="Queud'fer";
		nbAttaques = 3;
		espece="Onix";
	}
	
	public Onix(){
		super();
		attaquesDisponibles[2]="Queud'fer";
		nbAttaques = 3;
		espece="Onix";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	

	public void talent (){}
	
	
	
}
