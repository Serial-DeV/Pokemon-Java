public class Dresseur {
	protected String nom;
	protected Pokemon [] pokemons;
	protected int nbPokeballs;
	protected int nbPokemons;
	protected static int nbDresseurs = 0;
	protected boolean vaincu;
	protected int nbValides;
	
	//Attributs ajoutés uniquement pour la compilation
	protected int x,y;
	protected int niveau;
	protected boolean estJoueur;
	protected int argent;
	
	
	public Dresseur (String nom, int x, int y) {
		this.nom = nom;
		pokemons = new Pokemon[10];
		nbPokeballs = 10;
		nbPokemons = 0;
		this.x = x;
		this.y = y;
		nbDresseurs++;
		vaincu = false;
		capturePokemons(0); //nombre de Pokemons que possède le dresseur au départ
		nbValides = nbPokemons;
		this.niveau=(int)(Math.random()*40+1);//ajout de l'initialisation de niveau
		this.estJoueur=false;
		argent=(int)(Math.random()*500)+100+20*niveau;
	}

	
	public Dresseur (int x, int y, int niveau) {
		this("Dresseur"+(nbDresseurs), x, y);
		this.niveau=niveau;//ajout de l'initialisation de niveau
	}

	public Dresseur (String nom) { // Constructeur non utilisé dans TestMonde
		this(nom, 0, 0);
	}
	
	public Dresseur (int x, int y) { // Constructeur non utilisé dans TestMonde
		this("Dresseur"+(nbDresseurs), x, y);
	}

	public Dresseur () { // Constructeur non utilisé dans TestMonde
		this("Dresseur"+(nbDresseurs));
	}
	
	//Ajout d'un getter de niveau
	public int getNiveau(){
		return niveau;
	}
	// Ajout getter nbPokemons
	public int getnbPokemons(){
		return nbPokemons;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	// Ajout getter pokemon
	public String getPokemons(){
		String s="";
		for(int i=0;i<pokemons.length;i++){
			s+=pokemons[i];
		}
		return s;
	}

	public void capturePokemons (Pokemon [] nouveauxPokemons) {
		for (int pokemonNum=0; pokemonNum<nouveauxPokemons.length; pokemonNum++) {
			if (nbPokemons == 10 || nbPokeballs == 0) {
					break;
			}
			pokemons[nbPokemons] = nouveauxPokemons[pokemonNum];
			nbPokemons++;
			nbValides++;
			nbPokeballs-=1;
		}
	}

	public void capturePokemons (int nbPokemons) {	// Permet d'ajouter des Pokemon dans le tableau pokemons
		Pokemon [] nouveauxPokemons = new Pokemon[nbPokemons];
		for (int n=0; n<nbPokemons; n++) {
			nouveauxPokemons[n] = Pokemon.pokemonAleatoire();
		}
		capturePokemons(nouveauxPokemons);
	}
	

	public void infirmerie () {
		for (int pokemonNum=0; pokemonNum<nbPokemons; pokemonNum++) {
			pokemons[pokemonNum].soigner();
		}
		nbValides = nbPokemons;
	}
	
	public String toString () {
		return nom;
	}

	public void combat (Dresseur adversaire) {
		System.out.println (this + " affronte " + adversaire);
		boolean termine = false;
		int pokemonNum = 0, pokemonNumAdv = 0;
		Dresseur vainqueur = null;
		while (!termine) {
			Pokemon.combat(pokemons[pokemonNum], adversaire.pokemons[pokemonNumAdv]);
			if (pokemons[pokemonNum].estKO()) {
				pokemonNum++;
			}
			if (adversaire.pokemons[pokemonNumAdv].estKO()) {
				pokemonNumAdv++;
			}
			if (pokemonNum == nbPokemons) {
				termine = true;
				if (pokemonNumAdv != adversaire.nbPokemons) {
					vainqueur = adversaire;
				}
			}
			else if (pokemonNumAdv == adversaire.nbPokemons) {
			termine = true;
			vainqueur = this;
			}
		}
		infirmerie();
		adversaire.infirmerie();
		if (vainqueur == null) {
			System.out.println ("Egalite !");
		}
		else {
			System.out.println ("Victoire de " + vainqueur + " !");
		}
	}
}
