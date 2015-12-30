package net.trivialities;

public class TrivialObject {
	private int age;
	final private String firstName;
	
	public TrivialObject(int anAge,String aName){
		this.age=anAge;
		this.firstName=aName;
	}
	@Override
	final public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.age;
		result = prime * result
				+ ((this.firstName == null) ? 0 : this.firstName.hashCode());
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
		if (this.firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!this.firstName.equals(other.firstName)) {
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
		return "TrivialObject [age=" + this.age + ", "
				+ (this.firstName != null ? "firstName=" + this.firstName : "")+" "+this.hashCode()+ "]";
	}

	public static void main(String[] args) {
		boolean carajada=args[0] instanceof Object;
		TrivialObject nacho=new TrivialObject(1, "Ignacio");
		TrivialObject meme=new TrivialObject(2, "Mauricio");
		System.out.println("Yo soy "+nacho);
		System.out.println("Yo soy "+meme);
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
}
