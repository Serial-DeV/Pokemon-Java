public class TestJoueur {
	public static void main(String[]args){
		
		Joueur Quentin=new Joueur("Quentin");
		Dresseur Emmanuel = new Dresseur("Emmanuel");
		Dresseur Ferhat = new Dresseur("Ferhat");

		Bulbizarre Bulbizarre1 = new Bulbizarre("Patrick", 180, 50);
		Salameche Salameche1 = new Salameche("Michel", 160, 60);
		Arcko Arcko1 = new Arcko("Alric", 180, 50);

		Salameche[] ts = {Salameche1};
		Bulbizarre[] tb = {Bulbizarre1};
		Arcko[] ta = {Arcko1};

		Quentin.capturePokemons(ts);
		Emmanuel.capturePokemons(tb);
		Ferhat.capturePokemons(ta);

		Quentin.combat(Emmanuel);
		/*Emmanuel.combat(Ferhat);
		Ferhat.combat(Quentin);*/

	}
}
