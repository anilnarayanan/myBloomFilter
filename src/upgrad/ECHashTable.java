package upgrad;

import java.io.*;
import java.util.*;


public class ECHashTable {
    Hashtable<String, String> voter2cand;
    static BufferedReader br;

    public ECHashTable(){
        voter2cand = new Hashtable<String, String>();
        br = null;
    }

    public void add(BloomFilter bf){
        String fileLocation1 = "/home/anushka/Downloads/BloomFilterApp/data/votersCandList.txt";
        String l = null;
        CustomHashFunction chf = new CustomHashFunction();
        int hash1, hash2; //hash function values
        String[] keyval;
        String key;

        int numFalsePos = 0;

        try {
          br = new BufferedReader(new FileReader(fileLocation1));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            while((l = br.readLine()) != null) {
                keyval = l.split(" ");
                if(bf.isPresent(keyval[0])){
                    voter2cand.put(keyval[0], keyval[1]);
                    numFalsePos++;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        System.out.println("Total number of false positives are " + numFalsePos);
    }

    public void find(String voter_id){
        if(voter2cand.get(voter_id) != null){
            System.out.println("Candidate Id: " + voter2cand.get(voter_id));
        }
        else{
            System.out.println("Invalid Voter");
        }
    }

}
