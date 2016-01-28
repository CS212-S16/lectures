
public class Name implements Comparable<Name> {

	private String first;
	private String last;
	
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	
	public String toString() {
		return first + " " + last;
	}
	
	@Override
	public boolean equals(Object obj) {
		Name other = (Name) obj;
		boolean result = this.last.equals(other.getLast()) && this.first.equals(other.getFirst());
		System.out.println(toString() + "\t" + other.toString() + " " + result);
		return result;
	}

	@Override
	public int compareTo(Name o) {
		if(this.last.equals(o.getLast())) {
			return this.first.compareTo(o.getFirst());
		}
		return this.last.compareTo(o.getLast());
	}
	 
}

