package upgrad;

import java.io.*;
//import java.io.*;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.*;
import java.util.Enumeration;


public class ElectionCount {
    Hashtable<String, String> voter2cand;
    static BufferedReader br;
    int index;

    public ElectionCount(){
        voter2cand = new Hashtable<String, String>();
        index = 0;
        br = null;
    }

    public void add(BloomFilter bf){
        String fileLocation1 = "/home/anushka/Downloads/BloomFilterApp/data/votersCandList.txt";
        String l = null;
        CustomHashFunction chf = new CustomHashFunction();
        int hash1, hash2, hash3, hash4, hash5, hash6, hash7; //hash function values
        String[] keyval;
        Enumeration values;
        String key;
        int valid =0, invalid = 0;
        BufferedWriter writer_valid;
        BufferedWriter writer_invalid;
        int numFalsePos = 0;

        try {
          br = new BufferedReader(new FileReader(fileLocation1));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            writer_valid = new BufferedWriter(new FileWriter("/home/anushka/Desktop/valid.txt"));
            writer_invalid = new BufferedWriter(new FileWriter("/home/anushka/Desktop/invalid.txt"));
            while((l = br.readLine()) != null) {
                keyval = l.split(" ");
                if(bf.isPresent(keyval[0])){
                    voter2cand.put(keyval[0], keyval[1]);
//                    System.out.println("Key: " + keyval[0]);
                    valid++;
                    writer_valid.write(keyval[0]);
                    writer_valid.newLine();
                    numFalsePos++;
                }
                else{
//                    System.out.println("Invalid: " + keyval[0]);
                    invalid++;

                    writer_invalid.write(keyval[0]);
                    writer_invalid.newLine();
                }
            }
            writer_valid.close();
            writer_invalid.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        values = voter2cand.keys();
//        while(values.hasMoreElements()){
//           key = (String) values.nextElement();
//           System.out.println("Key: " +key+ " & Value: " +
//           voter2cand.get(key));
//       }
        System.out.println("Valid: " + valid);
        System.out.println("Invalid: " + invalid);
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
