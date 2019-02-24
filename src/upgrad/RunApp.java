package upgrad;

import java.io.*;
//import java.util.BitSet;
import java.util.Scanner;

public class RunApp {
	static BufferedReader br = null, br2 = null;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileLocation1 = "/home/anushka/Downloads/BloomFilterApp/data/validVotersList.txt";
		String fileLocation2 = "/home/anushka/Downloads/BloomFilterApp/data/votersCandList.txt";
		Scanner input = new Scanner(System.in);
		int numFalsePos = 0;
		String l = null;
		String voter_id = null;
		CustomHashFunction chf = new CustomHashFunction();
		BloomFilter bf = new BloomFilter(7188794, 10);

		try {
			br = new BufferedReader(new FileReader(fileLocation1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//	Scenario-1 Bloom filter creation
		try {
			while ((l = br.readLine()) != null) {
				bf.add(l, chf); //Adding elements from file voterid to bloomfilter.
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			br2 = new BufferedReader(new FileReader(fileLocation2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while ((l = br2.readLine()) != null) {
				if (bf.isPresent(l, chf)) {
					numFalsePos++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("total number of collisions while building a bloom filter are " + bf.collisionCount);
		System.out.println("Total number of false positives are " + numFalsePos);


//	Scenario-2 Hash Table implementation
		ECHashTable ec = new ECHashTable();
		ec.add(bf, chf);
		System.out.println("Enter Voter Id: ");
		voter_id = input.nextLine();
		ec.find(voter_id.trim());


// Scenario-3 Direct Addressing implementation
		ECDirectAddressing ecd = new ECDirectAddressing(1000000);
		ecd.add(bf, chf);


	}
}
