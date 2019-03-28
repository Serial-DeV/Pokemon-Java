public class TestCombat2{ // Classe de test pas encore utilisée
	public static void main(String[]args){
		
		// Création de dresseurs
		Dresseur D1=new Dresseur("Red",4,12);
		Dresseur D2=new Dresseur(4,9,19);
		
		//Ajout de Pokémon
		D1.capturePokemons(1);
		D2.capturePokemons(7);
		
		//Affichage infos sur les Pokémon
		System.out.println(D1.getPokemons());
		System.out.println(D2.getPokemons());
		
		//Combat
		D1.combat(D2);
		
	}
}