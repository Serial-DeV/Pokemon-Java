public class TestCombat{
	public static void main(String[]args){
		
		// Création de dresseurs
		Dresseur D1=new Dresseur("Red",4,12);
		Dresseur D2=new Dresseur(4,9,19);
		Dresseur D3=new Dresseur("Silver");
		Dresseur D4=new Dresseur(1,0);
		Dresseur D5=new Dresseur();
		
		
		//Test de l'affichage des noms des dresseurs
		System.out.println(D1);
		System.out.println(D2);
		System.out.println(D3);
		System.out.println(D4);
		System.out.println(D5);
		
		//Test de l'affichage des niveaux des dresseurs
		System.out.println(D1.getNiveau());
		System.out.println(D2.getNiveau());
		System.out.println(D3.getNiveau());
		System.out.println(D4.getNiveau());
		System.out.println(D5.getNiveau());
		
		//Ajout de Pokémon
		/*for(int i=0;i<5;i++){
			D1.pokemons[i]=new Pokemon();				
		}											<----- A retirer : méthode incorrecte
		for(int i=0;i<3;i++){						
			D2.pokemons[i]=new Pokemon();
		}*/
		
		//Ajout de Pokémon
		D1.capturePokemons(1); // D1 a maintenant 3+1 Pokemon
		D2.capturePokemons(7); // D2 a maintenant 3+7 Pokemon		<----- Inutile de mettre un nombre > 7 car impossible d'avoir + de 10 Pokemon 
		
		//Affichage nb de Pokémon
		System.out.println(D1.getnbPokemons());
		System.out.println(D2.getnbPokemons());
		
		//Affichage infos sur les Pokémon
		System.out.println(D1.getPokemons());
		System.out.println(D2.getPokemons());
		
		//Combat
		D1.combat(D2);
	}
}