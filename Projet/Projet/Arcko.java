public class Arcko extends Herbe{
	private String espece;
	
	public Arcko(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[2]="Vol-Vie";
		nbAttaques = 3;
		espece="Arcko";
	}
	
	
	public Arcko(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[2]="Vol-Vie";
		nbAttaques = 3;
		espece="Arcko";
	}
	
	public Arcko(){
		super();
		attaquesDisponibles[2]="Vol-Vie";
		nbAttaques = 3;
		espece="Arcko";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire,choixAttaque);	
	}

	
	public void talent (){}
	
	
	
}
