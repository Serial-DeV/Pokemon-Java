public class Ouisticram extends Feu{
	private String espece;
	
	public Ouisticram(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Ouisticram";
	}
	
	
	public Ouisticram(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Ouisticram";
	}
	
	public Ouisticram(){
		super();
		espece="Ouisticram";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void talent (){
		if(pv>(0.66)*pvmax ){
			multiplicateur=multiplicateur*1.5;
		}
	}
	
	
}
