package net.trivialities;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TrivialObject implements Serializable {
	/**
	 * Automatically generated serialVersionUID = -3235082009608563171L;
	 */
	private static final long serialVersionUID = -3235082009608563171L;

	public static int getExistenceAmount(){
		synchronized(TrivialObject.class){
			return TrivialObject.existenceAmount;
		}
	}
	/**
	 * Controls the amount of instances of this class that have existed ever.
	 */
	private static int existenceAmount;
	/**
	 * DateTimeFormatter of value ISO_DATE 
	 */
	private static final DateTimeFormatter dateFormatter=DateTimeFormatter.ISO_DATE;
	private int age;
	private int ID;
	private Set<String> features;
	private Set<Pair<String,Double>> metrics;
	final private String firstName;
	final private LocalDate dob;
	
	public TrivialObject(int anAge,String aName,LocalDate aDateOfBirth){
		this.age=anAge;
		this.firstName=aName;
		this.dob=aDateOfBirth;
		this.features=new HashSet<String>();
		this.metrics=new HashSet<Pair<String,Double>>();
		synchronized(TrivialObject.class){
			TrivialObject.existenceAmount++;
			this.ID=TrivialObject.existenceAmount;
		}
	}
	public TrivialObject(int anAge,String aName){
		this(anAge,aName,LocalDate.now());
	}
	public TrivialObject(TrivialObject aTrivialObject){
		this(aTrivialObject.age,aTrivialObject.firstName,aTrivialObject.dob);
	}
	public void addFeature(String aDefect){
		this.features.add(aDefect);
	}
	public Set<String> getFeatures(){
		return new HashSet<String>(this.features);
	}
	public void addMetric(String name,double measure){
		this.metrics.add(new Pair<String, Double>(name,measure));
	}
	public Set<Pair<String, Double>> getMetrics(){
		return new HashSet<Pair<String, Double>>(this.metrics);
	}
	
	@Override
	final public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.age;
		result = prime * result
				+ ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = result + dob.hashCode();
		return result;
	}
	@Override
	final public boolean equals(Object obj) {
		System.out.println("calling net.trivialities.TrivialObject::equals");
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TrivialObject)) {
			return false;
		}
		TrivialObject other = (TrivialObject) obj;
		if (this.age != other.age) {
			return false;
		}
		if(this.ID!=other.ID){
			return false;
		}
		if (this.firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!this.firstName.equals(other.firstName) || !this.dob.equals(other.dob)) {
			return false;
		}
		return true;
	}
//	IMPORTANT GUIDANCE:
//		http://stackoverflow.com/a/27609/3802741
//		http://www.javapractices.com/topic/TopicAction.do?Id=29
//  previous and _VERY_NAIVE_ version
//	=================================	
//	public final boolean equals(Object o2){
//		boolean res=false;
//		System.out.println("calling equals");
//		if(o2 instanceof TrivialObject){
//			res=((TrivialObject) o2).firstName==this.firstName && ((TrivialObject) o2).age==this.age;
//		}
//		return res;
//	}	
	
	@Override
	public String toString() {
		String res="";
		res="TrivialObject [ID:"+this.ID+", age:" + this.age + ", "
				+ (this.firstName != null ? "firstName:" + this.firstName : "")+", dateOfBirth:"+dateFormatter.format(this.dob);
		if(!this.features.isEmpty()){
			res=res+", features: "+this.features.toString();
		}
		if(!this.metrics.isEmpty()){
			res=res+", metrics: [";
			Iterator<Pair<String,Double>> iterator=this.metrics.iterator();
			while(iterator.hasNext()){
				Pair<String,Double> e=iterator.next();
				res=res+e.getLeft()+":"+e.getRight();
				if(iterator.hasNext()){
					res=res+", ";
				}
			}
			res=res+"]";
		}
		res=res+", hashCode:"+this.hashCode()+ "]";
		return res;
	}

	public static void main(String[] args) {
		boolean carajada=args[0] instanceof Object;
		TrivialObject nacho=new TrivialObject(1, "Ignacio");
		TrivialObject meme=new TrivialObject(2, "Mauricio");
		TrivialObject monchito=new TrivialObject(meme);
		System.out.println("Yo soy "+nacho);
		System.out.println("Yo soy "+meme);
		System.out.println("Yo soy "+monchito+" (monchito)");
		if(nacho.equals(meme)){
			System.out.println("Son iguales los cabrones");
		}else{
			System.out.println("Son diferentes los cabrones");
		}
		if(carajada){
			System.out.println("This is an instance of Object");
			if(args[0] instanceof String){
				System.out.println("This is an instance of String");
			}else{
				System.out.println("This isn't an instance of String");
			}
		}else{
			System.out.println("This isn't an instance of Object");
		}
	}
	final public int getID(){
		return this.ID;
	}
}
