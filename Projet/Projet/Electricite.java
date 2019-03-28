public abstract class Electricite extends Pokemon{
	
	public Electricite(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[1]="Elecanon";
		nbAttaques = 2;
		type="Electricite";
	}
	
	public Electricite(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[1]="Elecanon";
		nbAttaques = 2;
		type="Electricite";
	}
	
	public Electricite(){
		super();
		attaquesDisponibles[1]="Elecanon";
		nbAttaques = 2;
		type="Electricite";
	}
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire,choixAttaque);
		if (choixAttaque.equals("Elecanon")){
			multiplicateur=multiplicateur*0.6;	
			super.attaque(adversaire);
			if(Math.random()<0.6 && adversaire.paralyse != 2){
				adversaire.paralyse=2;//Paralyse 1 tour mais pas 2
				System.out.println(adversaire+" est maintenant paralyse");
			}
				
		}
	}
	
	public boolean fortContre(Pokemon adversaire){
		return adversaire.type.equals("Eau") || adversaire.type.equals("TerreEtEau");
	}
	
	public boolean faibleContre(Pokemon adversaire){
		return adversaire.type.equals("Electricite") || adversaire.type.equals("Terre") || adversaire.type.equals("TerreEtEau");
	}
			
		
	
	
	
	public abstract void talent ();
}
