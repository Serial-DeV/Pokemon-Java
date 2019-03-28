public abstract class HerbeEtFeu extends Pokemon{
	
	public HerbeEtFeu(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[1]="boutefeu";
		attaquesDisponibles[2]="surchauffe";
		attaquesDisponibles[3]="vege-attaque";
		nbAttaques = 4;
		type="HerbeEtFeu";
	}
	
	public HerbeEtFeu(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[1]="boutefeu";
		attaquesDisponibles[2]="surchauffe";
		attaquesDisponibles[3]="vege-attaque";
		nbAttaques = 4;
		type="HerbeEtFeu";
	}
	
	public HerbeEtFeu(){
		super();
		attaquesDisponibles[1]="boutefeu";
		attaquesDisponibles[2]="surchauffe";
		attaquesDisponibles[3]="vege-attaque";
		nbAttaques = 4;
		type="HerbeEtFeu";
	}
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire,choixAttaque);
		if (choixAttaque.equals("boutefeu")){
			multiplicateur=multiplicateur*1.2;
			super.attaque(adversaire);
			this.pv=(int)((double)this.pv-0.1*(double)attaque*1.2);
		}
		if (choixAttaque.equals("surchauffe")){
			if(Math.random()>0.2){
				multiplicateur=multiplicateur*1.3;
				super.attaque(adversaire);	
			}
		}
		
		if (choixAttaque.equals("vege-attaque"))
			multiplicateur=multiplicateur*2.5;
			super.attaque(adversaire);
	}
	
	public boolean fortContre(Pokemon adversaire){
		return adversaire.type.equals("Herbe") || adversaire.type.equals("Terre") || adversaire.type.equals("TerreEtEau") || adversaire.type.equals("HerbeEtFeu");
	}
	
	public boolean faibleContre(Pokemon adversaire){
		return adversaire.type.equals("Eau") || adversaire.type.equals("Feu") || adversaire.type.equals("Terre") ||  adversaire.type.equals("Herbe") || adversaire.type.equals("TerreEtEau") || adversaire.type.equals("HerbeEtFeu");
	}
			
		
	
	
	
	public abstract void talent ();
}
