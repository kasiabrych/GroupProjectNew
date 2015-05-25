package ie.cit.caf.domain;

public class Images {

	private B b;
   	private D d;
   	private N n;
   	private Sq sq;
   	private Z z;
   	
   	public String toString() {
		String images = "\n-----Images-----" + "\nImage B: " + b + 
				"\nImage D: " + d + "\nImage N: " + n + 
				"\nImage Sq" + sq + "\nImage Z: " + z + "\n";
		
		return images;		
		}
   	
   	

 	public B getB(){
		return this.b;
	}
	public void setB(B b){
		this.b = b;
	}
 	public D getD(){
		return this.d;
	}
	public void setD(D d){
		this.d = d;
	}
 	public N getN(){
		return this.n;
	}
	public void setN(N n){
		this.n = n;
	}
 	public Sq getSq(){
		return this.sq;
	}
	public void setSq(Sq sq){
		this.sq = sq;
	}
 	public Z getZ(){
		return this.z;
	}
	public void setZ(Z z){
		this.z = z;
	}
}
