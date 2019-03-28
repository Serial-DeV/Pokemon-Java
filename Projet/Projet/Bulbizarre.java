public class Bulbizarre extends Herbe{
	private String espece;
	
	public Bulbizarre(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Bulbizarre";
	}
	
	
	public Bulbizarre(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Bulbizarre";
	}
	
	public Bulbizarre(){
		super();
		espece="Bulbizarre";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	
	
	public void talent (){
		if(pv<=0.3*pvmax){// && talentActif==false){
			multiplicateur=multiplicateur*1.3;
			//talentActif=true;
		}
		/*if(pv>0.3*pvmax)
			talentActif=false;*/
	}
}
