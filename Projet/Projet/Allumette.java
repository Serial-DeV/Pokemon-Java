public class Allumette extends HerbeEtFeu{
	private String espece;
	
	public Allumette(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Allumette";
	}
	
	
	public Allumette(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Allumette";
	}
	
	public Allumette(){
		super();
		espece="Allumette";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	
	
	public void talent (){
		multiplicateur = 1.5;
		if (Math.random() < 0.5)
			this.perdu();
	
	}
}
