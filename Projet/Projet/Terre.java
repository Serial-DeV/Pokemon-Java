public abstract class Terre extends Pokemon{
	
	public Terre(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[1]="Ampleur";
		nbAttaques = 2;
		type="Terre";
	}
	
	public Terre(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[1]="Ampleur";
		nbAttaques = 2;
		type="Terre";
	}
	
	public Terre(){
		super();
		attaquesDisponibles[1]="Ampleur";
		nbAttaques = 2;
		type="Terre";
	}
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire,choixAttaque);
		if (choixAttaque.equals("Ampleur")){
			multiplicateur=multiplicateur*(Math.random()*0.7+0.8);
			super.attaque(adversaire);
		}
		if (choixAttaque.equals("Queud'fer")){
			if(Math.random()<0.25){
				multiplicateur=multiplicateur*100;
				super.attaque(adversaire);
			}
			else
				System.out.println("\t\tQueud'fer est sans effet\n");
		}
	}
	
	public boolean fortContre(Pokemon adversaire){
		return adversaire.type.equals("Feu") || adversaire.type.equals("Electricite") || adversaire.type.equals("HerbeEtFeu");
	}
	
	public boolean faibleContre(Pokemon adversaire){
		return adversaire.type.equals("Terre") || adversaire.type.equals("Eau") || adversaire.type.equals("Herbe") || adversaire.type.equals("TerreEtEau") || adversaire.type.equals("HerbeEtFeu");
	}
			
	
	public abstract void talent ();
}
