public abstract class Pokemon {
	protected static int aleaNum = 1;
	protected String nom;
	protected int pvmax;
	protected int niveau, pv, attaque;
	protected String [] attaquesDisponibles;
	protected int nbAttaques;
	protected double multiplicateur;
	protected int paralyse;
	protected int x, y;
	
	// Ajouté
	protected String type;
	
	public Pokemon (String nom, int pvmax, int attaque, int x, int y) {
		this.nom = nom;
		this.pvmax = pvmax;
		pv = pvmax;
		niveau = 1;
		this.attaque = attaque;
		attaquesDisponibles = new String[5];
		attaquesDisponibles[0] = "defaut";
		nbAttaques = 1;
		multiplicateur = 1.0;
		paralyse = 0;
	}

	public Pokemon (String nom, int pvmax, int attaque) {
		this(nom, pvmax, attaque, 0, 0);
	}
	
	public Pokemon () {
		this("Anonyme"+aleaNum, 100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
		aleaNum++;
	}
	public static Pokemon pokemonAleatoire (){
		return null;
	}
	
	
	public int getNiveau() {
		return niveau;
	}

	public boolean estKO () {
		return pv == 0;
	}

	public void perdu () {
		pv = 0;
		multiplicateur = 1;
	}

	public void soigner () {
		pv = pvmax;
		paralyse=0;
	}

	public boolean fortContre (Pokemon adversaire) {
		return false;
	}

	public boolean faibleContre (Pokemon adversaire) {
		return false;
	}
	
	public String [] getAttaquesDisponibles() {
		return attaquesDisponibles.clone();
	}

	public boolean estAttaqueValide(String s){   // Methode ajoutée pour la classe Joueur
		for(int i =0;i<attaquesDisponibles.length;i++){
			if(s.equals(attaquesDisponibles[i]))
				return true;
		}
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\n\nAttaque inexistante, veuillez reessayer.");
		return false;
	}
	
	public void afficheAttaques () {
		String s = "";
		int c=0;
		for (int i=0; i< attaquesDisponibles.length; i++){
			if(attaquesDisponibles[i]!=null){//String attaque : attaquesDisponibles
				s +="*"+attaquesDisponibles[i]+"*    ";
			}
			c++;
		}
		System.out.println ("Selectionnez l'action a realiser: \t"+s);
	}

	public abstract void talent ();

	public void subire (Pokemon adversaire, int degats) {
		pv -= degats;
		System.out.println (this + " subit " + degats + " ! ");
	}
	
	public void attaque (Pokemon adversaire) {
		double multiplicateurAvantage = 1;
		if (fortContre(adversaire)) {
			multiplicateurAvantage = multiplicateurAvantage*2;
		}
		if (faibleContre(adversaire)) {
			multiplicateurAvantage = multiplicateurAvantage*0.5;
		}
		System.out.println ("\t\t" + this + " attaque avec un multiplicateur de " + multiplicateur*multiplicateurAvantage + " : " + attaque*multiplicateur*multiplicateurAvantage + " !");
		adversaire.subire(this, (int)(attaque * multiplicateur * multiplicateurAvantage));
		multiplicateur = 1;
	}
	
	public String attaqueAleatoire(){	//Ajoutée
		return attaquesDisponibles[(int)(Math.random()*attaquesDisponibles.length)];
	}

	public String choixAttaque(int i){
		return attaquesDisponibles[i];
	}
	
		
	
	
	public void attaque (Pokemon adversaire, String choixAttaque) {
		System.out.print ("\t\t\t\tAttaque " + choixAttaque + " ! ");
			if (choixAttaque.equals("defaut"))
				attaque(adversaire);
	}

	public static void combat (Pokemon p1, Pokemon p2, String attaque1, String attaque2) {
		p1.talent();
		p2.talent();
		if (p1.paralyse==0 && p2.paralyse==0 && !(p2.estKO()) && !(p1.estKO())){
			p1.attaque(p2,attaque1);
			p2.attaque(p1,attaque2);
			if(p1.pv>p1.pvmax)
				p1.pv=p1.pvmax;
			if(p2.pv>p2.pvmax)
				p2.pv=p2.pvmax;
			if(p2.pv<=0 && p1.pv<=0){
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p2.perdu();
				p1.perdu();
			}
			else if(p2.pv<=0){
				p2.perdu();
				p1.gagnerNiveau();
			}
			else if(p1.pv<=0){
				p1.perdu();
				p2.gagnerNiveau();
			}
		}
		else if (p2.paralyse==0 && !(p1.paralyse==0) && !(p2.estKO()) && !(p1.estKO())){
			p2.attaque(p1,attaque2);
			if(p1.pv>p1.pvmax)
				p1.pv=p1.pvmax;
			if(p2.pv>p2.pvmax)
				p2.pv=p2.pvmax;
			if(p2.pv<=0 && p1.pv<=0){
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p2.perdu();
				p1.perdu();
			}
			else if(p2.pv<=0){
				p2.perdu();
				p1.gagnerNiveau();
			}
			else if(p1.pv<=0){
				p1.perdu();
				p2.gagnerNiveau();
			}
				
		}
		else if (p1.paralyse==0 && !(p2.paralyse==0) && !(p2.estKO()) && !(p1.estKO())){
			p1.attaque(p2,attaque1);
			if(p1.pv>p1.pvmax)
				p1.pv=p1.pvmax;
			if(p2.pv>p2.pvmax)
				p2.pv=p2.pvmax;
			if(p2.pv<=0 && p1.pv<=0){
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p2.perdu();
				p1.perdu();
			}
			else if(p2.pv<=0){
				p2.perdu();
				p1.gagnerNiveau();
			}
			else if(p1.pv<=0){
				p1.perdu();
				p2.gagnerNiveau();
			}
		}
		if (p1.paralyse > 0)
			p1.paralyse -= 1;
		if (p2.paralyse > 0)
			p2.paralyse -= 1;
		
	}
		
	public static void combat (Pokemon p1, Pokemon p2) {
		p1.talent();
		p2.talent();
		if (p1.paralyse==0 && p2.paralyse==0 && !(p2.estKO()) && !(p1.estKO())){
			p1.attaque(p2);
			p2.attaque(p1);
			if(p1.pv>p1.pvmax)
				p1.pv=p1.pvmax;
			if(p2.pv>p2.pvmax)
				p2.pv=p2.pvmax;
			if(p2.pv<=0 && p1.pv<=0){
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p2.perdu();
				p1.perdu();
			}
			else if(p2.pv<=0){
				p2.perdu();
				p1.gagnerNiveau();
			}
			else if(p1.pv<=0){
				p1.perdu();
				p2.gagnerNiveau();
			}
		}
		else if (p2.paralyse==0 && !(p1.paralyse==0) && !p2.estKO() && !(p1.estKO())){
			p2.attaque(p1);
			if(p1.pv>p1.pvmax)
				p1.pv=p1.pvmax;
			if(p2.pv>p2.pvmax)
				p2.pv=p2.pvmax;
			if(p2.pv<=0 && p1.pv<=0){
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p2.perdu();
				p1.perdu();
			}
			else if(p2.pv<=0){
				p2.perdu();
				p1.gagnerNiveau();
			}
			else if(p1.pv<=0){
				p1.perdu();
				p2.gagnerNiveau();
			}
		}
		else if (p1.paralyse==0 && !(p2.paralyse==0) && !(p2.estKO()) && !(p1.estKO())){
			p1.attaque(p2);
			if(p1.pv>p1.pvmax)
				p1.pv=p1.pvmax;
			if(p2.pv>p2.pvmax)
				p2.pv=p2.pvmax;
			if(p2.pv<=0 && p1.pv<=0){
				p1.gagnerNiveau();
				p2.gagnerNiveau();
				p2.perdu();
				p1.perdu();
			}
			else if(p2.pv<=0){
				p2.perdu();
				p1.gagnerNiveau();
			}
			else if(p1.pv<=0){
				p1.perdu();
				p2.gagnerNiveau();
			}
		}
		if (p1.paralyse > 0)
			p1.paralyse -= 1;
		if (p2.paralyse > 0)
			p2.paralyse -= 1;
		
		
	}
	

	public void gagnerNiveau() {
		niveau++;
		pvmax += 20;
		pv += pvmax/2;
		if (pv > pvmax) {
			pv = pvmax;
		}
		attaque += 10;
		System.out.println (this.nom + " passe au niveau " + niveau + " !");
	}

	public void changerNom (String nouveauNom) {
		nom = nouveauNom;
	}
	
	public String toString() {
		return nom + " (" + pv + "/" + pvmax + "pv, " + attaque + " att)";
	}
	
	public String getNom() {
		return nom;
	}
	public String getId() {
		return "Pas d'espèce ! " + nom;
	}
	
	
}
