public class Carapagos extends TerreEtEau{
	private String espece;
	
	public Carapagos(String nom, int pvmax, int attaque, int x, int y){
		super(nom,pvmax,attaque,x,y);
		espece="Carapagos";
		
	}
	
	
	public Carapagos(String nom, int pvmax, int attaque) {
		super(nom,pvmax,attaque);
		espece="Carapagos";
	}
	
	public Carapagos(){
		super();
		espece="Carapagos";
	}
	
	public String toString(){
		return nom;
	}
	
	public String getId(){
		return espece+" "+nom+ " (" + pv + "/" + pvmax + "pv, " + attaque + " att, Niv. " + niveau +")";
	}
	
	
	public void talent (){
		pv=pv+(int)(pvmax*0.1);
		if (Math.random() < 0.1)
			this.soigner();
	
	}
}
