package upgrad;
import java.util.Scanner;

public class CustomHashFunction {
	
	//typical hash function
	public int genHash(String x) {
//	    System.out.println("Hash1");
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
//        System.out.println("Hash2");
		int prime = 17;
		int a = 1;
		String s = "second";
		int hash = x.hashCode();
		for(int i = 0; i < s.length(); i++) {
			a = (prime * a) + s.charAt(i) + hash;
		}
		return a;
	}

    public int genHash3(String x)
    {
//        System.out.println("Hash3");
        int prime = 11;
        int a = 1;
        String s = "third";
        int hash = x.hashCode();
        for(int i = 0; i < s.length(); i++) {
            a = (prime * a) + s.charAt(i) + hash;
        }
        return a;
    }

    public int genHash4(String x) {
//        System.out.println("Hash4");
        int prime = 61;
        int a = 1;
        String s = "fourth";
        int hash = x.hashCode();
        for(int i = 0; i < s.length(); i++) {
            a = (prime * a) + s.charAt(i) + hash;
        }
        return a;
    }

    public int genHash5(String x) {
//        System.out.println("Hash5");
        int prime = 71;
        int a = 1;
        String s = "fifth";
        int hash = x.hashCode();
        for(int i = 0; i < s.length(); i++) {
            a = (prime * a) + s.charAt(i) + hash;
        }
        return a;
    }

    public int genHash6(String x) {
//        System.out.println("Hash6");
        int prime = 67;
        int a = 1;
        String s = "sixth";
        int hash = x.hashCode();
        for(int i = 0; i < s.length(); i++) {
            a = (prime * a) + s.charAt(i) + hash;
        }
        return a;
    }

    public int genHash7(String x) {
//        System.out.println("Hash7");
        int prime = 97;
        int a = 1;
        String s = "seventh";
        int hash = x.hashCode();
        for(int i = 0; i < s.length(); i++) {
            a = (prime * a) + s.charAt(i) + hash;
        }
        return a;
    }
}
