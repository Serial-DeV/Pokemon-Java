public abstract class Herbe extends Pokemon{
	
	public Herbe(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		attaquesDisponibles[1]="vege-attaque";
		nbAttaques = 2;
		type="Herbe";
	}
	
	public Herbe(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		attaquesDisponibles[1]="vege-attaque";
		nbAttaques = 2;
		type="Herbe";
	}
	
	public Herbe(){
		super();
		attaquesDisponibles[1]="vege-attaque";
		nbAttaques = 2;
		type="Herbe";
	}
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		super.attaque(adversaire,choixAttaque);
		if (choixAttaque.equals("vege-attaque")){
			multiplicateur=multiplicateur*2.5;
			System.out.println ("\t\t" + this.nom +" utilise vege-attaque" );
			System.out.println("");
		}
		
		
		else if (choixAttaque.equals("Vol-Vie")){
			int a = (int)((double)(adversaire.pvmax)*0.2);
			int b=attaque;
			attaque=a;
			super.attaque(adversaire);
			pv+=a;
			attaque=b;
			System.out.println (this.nom +" gagne "+a+" PV");
		}
		
	}
	
	public boolean fortContre(Pokemon adversaire){
		return adversaire.type.equals("Terre") || adversaire.type.equals("TerreEtEau");
	}
	
	public boolean faibleContre(Pokemon adversaire){
		return adversaire.type.equals("Herbe") || adversaire.type.equals("Feu")  || adversaire.type.equals("HerbeEtFeu"); // 1=herbe  et  5=feu
	}
			
		
	
	
	
	public abstract void talent ();
}
