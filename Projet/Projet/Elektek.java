public class Elektek extends Electricite{
	private String espece;
	
	public Elektek(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Elektek";
	}
	
	
	public Elektek(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Elektek";
	}
	
	public Elektek(){
		super();
		espece="Elektek";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void talent (){}
	
	public void subire (Pokemon adversaire, int degats) {
		super.subire(adversaire,degats);
		if (Math.random() < 0.3 && adversaire.paralyse != 2){
			adversaire.paralyse = 2; // Paralyse pour 1 tour(pas 2)
			System.out.println(adversaire+" est maintenant paralyse");
		}
	}
}
