public abstract class TerreEtEau extends Pokemon{
	
	public TerreEtEau(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[1]="Hydroblast";
		attaquesDisponibles[2]="Ampleur";
		nbAttaques = 3;
		type="TerreEtEau";
	}
	
	public TerreEtEau(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[1]="Hydroblast";
		attaquesDisponibles[2]="Ampleur";
		nbAttaques = 3;
		type="TerreEtEau";
	}
	
	public TerreEtEau(){
		super();
		attaquesDisponibles[1]="Hydroblast";
		attaquesDisponibles[2]="Ampleur";
		nbAttaques = 3;
		type="TerreEtEau";
	}
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire,choixAttaque);
		if (choixAttaque.equals("Hydroblast")){
			if(Math.random()>0.2){
				multiplicateur=multiplicateur*2.2;
				this.paralyse=2;
				super.attaque(adversaire);
				System.out.println(this+" est maintenant paralyse");
			}
			else
				System.out.println("\t\tHydroblast est sans effet\n");
		}
		if (choixAttaque.equals("Ampleur")){
			multiplicateur=multiplicateur*(Math.random()*0.7+0.8);
			super.attaque(adversaire);
		}
	}
	
	public boolean fortContre(Pokemon adversaire){
		return adversaire.type.equals("Feu") ||  adversaire.type.equals("Electricite") || adversaire.type.equals("Terre") || adversaire.type.equals("TerreEtEau") || adversaire.type.equals("HerbeEtFeu");
	}
	
	public boolean faibleContre(Pokemon adversaire){
		return adversaire.type.equals("Eau") || adversaire.type.equals("Herbe") || adversaire.type.equals("Terre") ||  adversaire.type.equals("Herbe") || adversaire.type.equals("TerreEtEau") || adversaire.type.equals("HerbeEtFeu");
	}
			
		
	
	
	
	public abstract void talent ();
}
