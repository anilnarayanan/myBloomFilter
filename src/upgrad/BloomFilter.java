package upgrad;

import java.util.BitSet;

/*** 
 * 
 * @author upgrad.com
 * 
 * The Bloomfilter logic is implemented with help of this class 
 * And we use CustomHashFunction class to build our BloomFilter.
 */
public class BloomFilter {
	BitSet bs;//BloomFilter array of bits
	
	CustomHashFunction chf;
	int collisionCount = 0;
	int hash1, hash2, hash3, hash4, hash5, hash6, hash7; //hash function values
	int size; //size of the bloom filter
	int numHashFunctions; //total number of hash functions to work with bloom filter
	
	public BloomFilter(int x, int y) {
		/*** Constructor
		 * x indicate the size of bloom filter and y indicate the number of hash functions
		 */
		bs = new BitSet(x);
		bs.clear();
		chf = new CustomHashFunction();
		size = bs.size();
		System.out.println("Size: " + size);
		numHashFunctions = y;
	}
	
	public boolean isPresent(String x) {
		/***
		 * This function returns true is x is present and false if x is not present-
		 * according to bloom filter.
		 */
		hash1 = chf.genHash(x);
		hash2 = chf.genHash2(x);
//		hash3 = chf.genHash3(x);
//		hash4 = chf.genHash4(x);
//		hash5 = chf.genHash5(x);
//		hash6 = chf.genHash6(x);
//		hash7 = chf.genHash7(x);

		for(int i = 1; i <= numHashFunctions; i++) {
//            if (bs.get(Math.abs((hash1 + i * hash2 + i*hash3 + i*hash4 + i*hash5 + i*hash6 + i*hash7) % size))) {
			if (bs.get(Math.abs((hash1 + i * hash2 + i*i) % size))) {
                continue;
            } else {
                return false;
            }
        }
		return true;
	}
	
	public void add(String x) {
		/***
		 * Build the bloom filter by adding the elements to it
		 */
		if(isPresent(x)) {
			collisionCount++;
		}
		
		hash1 = chf.genHash(x);
		hash2 = chf.genHash2(x);
//        hash3 = chf.genHash3(x);
//        hash4 = chf.genHash4(x);
//        hash5 = chf.genHash5(x);
//        hash6 = chf.genHash6(x);
//        hash7 = chf.genHash7(x);

		for(int i = 1; i <= numHashFunctions; i++) {
//			bs.set(Math.abs((hash1 + i *hash2 + i*hash3 + i*hash4 + i*hash5 + i*hash6 + i*hash7) % size));
			bs.set(Math.abs((hash1 + i *hash2 + i*i) % size));
		}
	}
	
}
