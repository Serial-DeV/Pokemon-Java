public class CombatBS{
	public static void main(String[]args){
		
		Bulbizarre Bulbizarre1 = new Bulbizarre("Patrick", 180, 50);
		Salameche Salameche1 = new Salameche("Michel", 180, 50);
		Allumette Emmanuel = new Allumette("Emmanuel", 100000, 50);
		
		Dresseur Anne = new Dresseur("Anne");
		Dresseur Basile = new Dresseur("Basile");
		Dresseur Ferhat = new Dresseur("Ferhat");
		/*Salameche[]ts=new Salameche [1];
		ts[0]=Salameche1;*/
		
		Salameche[] ts = {Salameche1};
		Bulbizarre[] tb = {Bulbizarre1};
		Allumette[] ta = {Emmanuel};
		
		Anne.capturePokemons(tb);
		Basile.capturePokemons(ts);
		Ferhat.capturePokemons(ta);
		
		Ferhat.combat(Anne);
	}
	
}
