public class Pikachu extends Electricite{
	private String espece;
	
	public Pikachu(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Pikachu";
	}
	
	
	public Pikachu(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Pikachu";
	}
	
	public Pikachu(){
		super();
		espece="Pikachu";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	
	
	public void talent (){}
		

	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire, choixAttaque);
		if (Math.random() < 0.2 && adversaire.paralyse != 2){
			adversaire.paralyse = 2; // Paralyse 1 tour (pas 2)
			System.out.println(adversaire+" est maintenant paralyse");
		}
		
	}
}
