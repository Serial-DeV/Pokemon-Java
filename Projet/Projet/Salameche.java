public class Salameche extends Feu{
	private String espece;
	
	public Salameche(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Salameche";
	}
	
	
	public Salameche(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Salameche";
	}
	
	public Salameche(){
		super();
		espece="Salameche";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	public void talent (){
		if(pv<=(0.33)*pvmax){// && talentActif==false){
			multiplicateur=multiplicateur*1.2;
			//talentActif=true;
		}
		/*if(pv>(1/3)*pvmax)
			talentActif=false;*/
	}
}
