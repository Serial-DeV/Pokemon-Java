import java.util.Scanner;

public class Monde{
	private int[][]cases;
	private double probabilitePresenceInitiale;
	private Joueur joueur;
	private Dresseur[]tabDresseur;
	private int nbDresseurs;
	private int nbDresseursActifs;
	
	private String s; // Pour le deplacement
	private String s2; // Pour le magasin
	
	
	// Coordonnees de l'infirmerie
	private int posX;
	private int posY;
	
	
	// Coordonnees du magasin
	private int mag1Y;
	private int mag1X;
	
	
	public Monde(int h, int l, double probPI){
		cases=new int[h][l];
		probabilitePresenceInitiale=probPI;
		nbDresseurs=0;
		nbDresseursActifs=0;
		
		for(int i=0;i<cases.length;i++){
			for(int j=0;j<cases[i].length;j++){
				cases[i][j]=0;
			}
		}
		
		// Determination de l'emplacement de l'infirmerie
		do{
			posY = (int)(Math.random()*h);
			posX = (int)(Math.random()*l);
	   	}while(cases[posY][posX] != 0);
	   		cases[posY][posX] = 3;
		
		
		// Magasin de Pokemon
		
		do{
			mag1Y = (int)(Math.random()*h);
			mag1X = (int)(Math.random()*l);
		}while(cases[mag1Y][mag1X] != 0);
				cases[mag1Y][mag1X] = 5;
		
		
		
		
		
		tabDresseur=new Dresseur[20]; // Creation d'un tableau pouvant contenir au maximum 20 Dresseur
		
		// Creation d'un tableau contenant les noms que peut porter un Dresseur
		String[]nomDresseur = {"Red","Sacha","Silver","Link","Giovanni","Iris","Lem","Jasmine","Trovato","Malafid","Leaf","Ludwig","Ludvina","Kalem","Serena","Levy","Tatia","Scout","Jacky","Nico"};
		int idRgNomDresseur = 0;
	
		
		//Placement des murs (sous forme de biome)
		for(int i=0;i<cases.length;i++){
			for(int j=0;j<cases[0].length;j++){ // Pas de murs sur les bords du monde
				if(i!=h-1 && i!=0 && j!=0 && j!=l-1){
					if((cases[i-1][j]==4) && Math.random()<0.6 && (cases[i][j]==0))
						cases[i][j]=4;
					else if(Math.random()<0.01 && (cases[i][j]==0) )
						cases[i][j]=4;
				}
				
				if(j!=l-1 && j!=0 && i!=0 && i!=h-1){ // Pas de murs sur les bords du monde
					if((cases[i][j-1]==4) && Math.random()<0.6 && (cases[i][j]==0))
						cases[i][j]=4;
					else if(Math.random()<0.01 && (cases[i][j]==0))
						cases[i][j]=4;
				}
			}
		}
			

		for(int i=0;i<tabDresseur.length;i++){ //Remplissage du tableau de Dresseur
			
	   		int Y = (int)(Math.random()*h);
	   		int X =  (int)(Math.random()*l);
	   		if (cases[Y][X] == 0 && Math.random()<probabilitePresenceInitiale){
	   			tabDresseur[i]=new Dresseur(nomDresseur[idRgNomDresseur],X,Y);
				idRgNomDresseur++;
	   			cases[Y][X]=1;
				nbDresseurs+=1;
				nbDresseursActifs+=1;
	   			tabDresseur[i].capturePokemons(tabPoke());
				if(i<2)
					tabDresseur[i].niveau=1; // Pour avoir 3 dresseurs de niveau 1
				
				// Modification des niveaux des Pokemon du Dresseur
				for(int j=0; j<tabDresseur[i].pokemons.length;j++){
					int niv =(int)(Math.random()*tabDresseur[i].niveau)+1;
					int cpt=0;
					if(tabDresseur[i].pokemons[j]!=null){
						while(cpt!=niv){
							tabDresseur[i].pokemons[j].gagnerNiveau();
							cpt++;
						}
					}
				}
			}
				
		}
		
		System.out.print("\nInitialisation des niveaux des Pokemons terminee avec succes");
		
		
		// Placement du joueur
		int jX=0;
		int jY=0;
		do{
		jX=(int)(Math.random()*l);
		jY=(int)(Math.random()*h);
		}while(cases [jY][jX]!=0);
		
		System.out.print("\n\n\n\n\n\nEntrez votre nom\n");
		read();
		joueur=new Joueur(s,jX,jY);
		joueur.niveau=1;
		
		joueur.capturePokemons(tabPoke());
	}
	
	public Pokemon[]tabPoke(){
		int nbDePoke = (int)(Math.random()*5)+1;
		Pokemon[]tabPoke=new Pokemon[nbDePoke];
		for(int i=0; i<tabPoke.length; i++){
			tabPoke[i]=pokemonAleatoire();
		}
		return tabPoke;
	}
	
	
	String[]nomPokemon = {"Red","Blue","Silver","Link","Jupiter","Giovanni","Green","Prince","Star","Ultra","Killer","OhOO","Mars","Rocket","Crache-Feu","Caid","Boss","King","Lem","Trovato","Malafid","Leaf","Kalem","Scout","Jacky","Nico"};
	
	public Pokemon pokemonAleatoire() {
		int numPokemon = (int)(Math.random()*11);
			if (numPokemon == 0)
				return new Arcko(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 1)
				return new Bulbizarre(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 2)
				return new Carapagos(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 3)
				return new Carapuce(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 4)
				return new Elektek(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 5)
				return new Onix(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 6)
				return new Ouisticram(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 7)
				return new Pikachu(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 8)
				return new Racaillou(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			if (numPokemon == 9)
				return new Salameche(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
			return new Wailmer(nomPokemon[(int)(Math.random()*nomPokemon.length)],100+(int)(Math.random()*100), 40+(int)(Math.random()*100));
	}
			
	
	public String toString(){
		String d="";
		for(int i=0;i<joueur.pokemons.length;i++){
			if(joueur.pokemons[i]!=null)
				d+=joueur.pokemons[i].getId()+"\n\t";
		}
		
		return"\n\nDimensions du monde: "+cases.length+"*"+cases[0].length+"\tDresseurs restants: "+nbDresseursActifs+"\nVictoires: "+this.joueur.nombreVictoires+
		"\tDefaites: "+this.joueur.nombreDefaites+"\tPokecoins: "+this.joueur.argent+"\n\n\t"+d;
	}
	
	public void afficheMondeTerminal(){
		String str="";
		for(int i=0;i<cases.length;i++){
			if(i>0)
				str+="\n"; // Retour à la ligne
		
			for(int j=0;j<cases[i].length;j++){
				
				if(i==this.joueur.getY() && j==this.joueur.getX())
					str+="J ";
				else if(cases[i][j]==0) // Case vide
					str+=". ";
				else if(cases[i][j]==1) // Dresseur actif
					str+="D ";
				else if(cases[i][j]==3) // Infirmerie
					str+="I ";
				else if(cases[i][j]==4) // Pour les murs
					str+="# ";
				else if(cases[i][j]==5) // Pour le magasin de Pokemon aléatoire
					str+="? ";
				else 					// Dresseur vaincu
					str+="X ";
				
			}
		}
		
		// Effacage de l'ecran du terminal
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		System.out.println(str);
		System.out.println(this.toString());
	}

	
	public void read(){ // entree clavier
		
		Scanner a = new Scanner(System.in);
		this.s=a.next();
   
	}
	
	public void read2(){ // entree clavier pour le magasin
		
		Scanner a = new Scanner(System.in);
		this.s2=a.next();
   
	}
	
	public void verif(){ 
		int v = joueur.nombreVictoires;
		
		if(joueur.y == posY && joueur.x == posX){
			joueur.infirmerie();
			afficheMondeTerminal();
		}
		 // Si on tombe sur le magasin de Pokemon aléatoire
		if(joueur.y == mag1Y && joueur.x == mag1X){
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("\n\n\nTapez 1 pour acheter un Pokemon aleatoire (-950 Pokecoins) (ou autre chose pour annuler)");
			read2();
			if(!(s2.equals("1")))
				rejet(); // Sortie du magasin
			if(s2.equals("1")){
				if(joueur.argent<950){
					System.out.println("Vous n'avez pas assez de Pokecoins\n\n\t\t\t\t\t\t\tAppuyez sur C puis ENTREE pour continuer");
					read2();
					if(s2.equals("c"))
						rejet(); // Sortie du magasin
				}	
				if(joueur.argent>=950){
					joueur.argent-=950;
					Pokemon pokeAlea=pokemonAleatoire();
					
					//Permet d'avoir un Pokemon de niveau allant de 6 à 25
					int nbNVsupp=(int)(Math.random()*20)+5;
					for(int i=0;i<nbNVsupp;i++){
					pokeAlea.gagnerNiveau();
					}
					System.out.print("\033[H\033[2J");
					System.out.flush();
					if(joueur.pokemons[9]==null){
						System.out.println("\n\nTapez 1 pour recuperer "+pokeAlea.getId()+" (ou autre chose pour annuler)");
						read2();
						if(s2.equals("1")){
							int i=0;
							while(joueur.pokemons[i]!=null && i<joueur.pokemons.length){
								i++;
							}
							joueur.pokemons[i]=pokeAlea;
							joueur.nbPokemons+=1;
						}
					}
				
				
					else{		
						String d="\t";
						for(int i=0;i<joueur.pokemons.length;i++){
							if(joueur.pokemons[i]!=null)
								d+=i+" "+joueur.pokemons[i].getId()+"\n\t";
						}
						System.out.println("Tapez le numero du Pokemon(de 0 a 9) a echanger contre " +pokeAlea.getId()+ " (ou autre chose pour annuler)\n\n"+d);
						read2();
						
						if(s2.equals("0"))
							joueur.pokemons[0]=pokeAlea;
						else if(s2.equals("1"))
							joueur.pokemons[1]=pokeAlea;
						else if(s2.equals("2"))
							joueur.pokemons[2]=pokeAlea;
						else if(s2.equals("3"))
							joueur.pokemons[3]=pokeAlea;
						else if(s2.equals("4"))
							joueur.pokemons[4]=pokeAlea;
						else if(s2.equals("5"))
							joueur.pokemons[5]=pokeAlea;
						else if(s2.equals("6"))
							joueur.pokemons[6]=pokeAlea;
						else if(s2.equals("7"))
							joueur.pokemons[7]=pokeAlea;
						else if(s2.equals("8"))
							joueur.pokemons[8]=pokeAlea;
						else if(s2.equals("9"))
							joueur.pokemons[9]=pokeAlea;
					}
					rejet(); // Sortie du magasin
				}
			}
		}
			
		// verifie si un dresseur adverse se trouve sur la meme case que le joueur	
		for(int i=0;i<tabDresseur.length;i++){
			if(tabDresseur[i]!=null && tabDresseur[i].x==joueur.x && tabDresseur[i].y==joueur.y && !tabDresseur[i].vaincu){
				joueur.combat(tabDresseur[i]);
				if(joueur.nombreVictoires>v){
					nbDresseursActifs-=1;
					cases[joueur.y][joueur.x]=2;
					System.out.println("\n\n\t\t\t\t\t\t\tAppuyez sur C puis ENTREE pour continuer");
					this.read();
					break;
				}
				else{
					System.out.println("\n\n\t\t\t\t\t\t\tAppuyez sur C puis ENTREE pour continuer");
					this.read();
					rejet(); // Rejet sur une case voisine en cas de défaite.
				}
			}
		}
	}
	
	public void rejet(){
		if (joueur.y!=0 && cases[(joueur.y)-1][joueur.x]!=1 && cases[(joueur.y)-1][joueur.x]!=4){ //Rejet en haut
			joueur.y-=1;
			afficheMondeTerminal();
		}
		else if (joueur.y!=cases.length-1 && cases[(joueur.y)+1][joueur.x]!=1 && cases[(joueur.y)+1][joueur.x]!=4){ //Rejet en bas
			joueur.y+=1;
			afficheMondeTerminal();
		}
		else if (joueur.x!=0 && cases[joueur.y][(joueur.x)-1]!=1 && cases[joueur.y][(joueur.x)-1]!=4){ //Rejet à gauche
			joueur.y-=1;
			afficheMondeTerminal();
		}
		else if (joueur.x!=cases[0].length-1 && cases[joueur.y][(joueur.x)+1]!=1 && cases[joueur.y][(joueur.x)+1]!=4){ //Rejet à droite
			joueur.y+=1;
			afficheMondeTerminal();
		}
	}
	
	public void deplacer(){
	
		if(this.s.equals("z") && joueur.y!=0 && cases[(joueur.y)-1][joueur.x]!=4){ // deplacement en haut
				joueur.y-=1;
				afficheMondeTerminal();
				verif();
			}
						
					
			if(this.s.equals("s") && joueur.y!=cases.length-1 && cases[(joueur.y)+1][joueur.x]!=4){ // deplacement en bas
				joueur.y+=1;
				afficheMondeTerminal();
				verif();
						
			}
					
			if(this.s.equals("q") && joueur.x!=0 && cases[joueur.y][(joueur.x)-1]!=4){ // deplacement a gauche
				joueur.x-=1;
				afficheMondeTerminal();
				verif();
						
			}
					
			if(this.s.equals("d") && joueur.x!=cases[0].length-1 && cases[joueur.y][(joueur.x)+1]!=4){ // deplacement a droite
				joueur.x+=1;
				afficheMondeTerminal();
				verif();
				
			}
			if(this.s.equals("c")) //Apres une victoire
				afficheMondeTerminal();
	}
	
	
	
	public void Jouer(){
		
		while(nbDresseursActifs>0){
			
			do{
				verif();
				afficheMondeTerminal();
				this.read();
				
			}while(!(this.s.equals("z") || this.s.equals("q") || this.s.equals("s") || this.s.equals("d") || (this.s.equals("quitter"))));
			
			if((this.s.equals("quitter"))){ // Si on est bloqué dans la partie
				System.out.print("\033[H\033[2J");
				System.out.flush();
				break;
			}
			deplacer();
		}
		
		if(nbDresseursActifs==0){
		// Quand il n'y a plus de DresseurActif
		System.out.println(this.toString());
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("        _ _    ___  _____   ___    _ _    __    ___    |");
		System.out.println("|   |    |    |       |    |   |    |    |__|  |       |");
		System.out.println("|   |    |    |       |    |   |    |    | |   |--     |");
		System.out.println(" |_|    _|_   |___    |    |___|   _|_   |  |  |___    o");
		System.out.println("\n\n\n\n\n\n\n");
		}
	}
		
}
					
		
		
		
		
