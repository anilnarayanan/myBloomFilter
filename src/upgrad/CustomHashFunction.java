package upgrad;

public class CustomHashFunction {
	
	//typical hash function
	public int genHash(String x) {
		int prime = 31;
		String s = "first";
		int a = 1;
		int hash = x.hashCode();
		for(int i = 0; i < s.length(); i++) {
			a = (prime * a) + s.charAt(i) + hash;
		}
        return a;
	}

	public int genHash2(String x) {
		int prime = 17;
		int a = 1;
		String s = "second";
		int hash = x.hashCode();
		for(int i = 0; i < s.length(); i++) {
			a = (prime * a) + s.charAt(i) + hash;
		}
		return a;
	}
}
