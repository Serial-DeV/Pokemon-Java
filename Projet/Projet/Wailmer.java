public class Wailmer extends Eau{
	private String espece;
	
	public Wailmer(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Wailmer";
	}
	
	
	public Wailmer(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Wailmer";
	}
	
	public Wailmer(){
		espece="Wailmer";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void talent (){
		if(pv<0.33*pvmax ){
			if(Math.random()<0.2){
				this.soigner();
			}
		}
	}
	
	
	
}
