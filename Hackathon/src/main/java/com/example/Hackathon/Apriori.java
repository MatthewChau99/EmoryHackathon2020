import java.util.Scanner;
import java.io.*;
import java.util.*;

/*
Julian Zhao
jzzhao@emory.edu
2020.02.20

THIS  CODE  WAS MY OWN WORK.
IT WAS  WRITTEN  WITHOUT  CONSULTING  ANYSOURCES  OUTSIDE  OF  THOSE  APPROVED  BY THE  INSTRUCTOR. 
Name: Julian Zhao
*/



public class Apriori {
	
	//Final Answer Map that contains all the frequent items with its counts
	private static Map<SortedSet<String>,Integer> finalMap;

	//All transactions in the documents
	private static List<SortedSet<String>> initialSet;

	//for each finallist generation round, the updatedSet records each transaction if it is updated on the subset or not. 
	//If there are identical transaction, it directly get the subset (instead of re-updating the subset) and made the algorithm more efficient
	private static Set<SortedSet<String>> updatedSet;

	//This map records the subset of each transaction.
	private static Map<SortedSet<String>,SortedSet<SortedSet<String>>> subsetMap;

	//Threshold
	private static int threshold;

	//Item size of each round
	private static int itemsize;

	public static void main(String[] args){

		//Record the time
		long startTime = System.currentTimeMillis();

		//Initiate all the Maps and Sets
		initialSet = new ArrayList<SortedSet<String>>();
		finalMap = new TreeMap<SortedSet<String>,Integer>(new SortSet());
		subsetMap = new TreeMap<SortedSet<String>,SortedSet<SortedSet<String>>>(new SortSet());
		updatedSet = new HashSet<>();
		

		if (args.length != 3){
			System.out.println("Must enter 3 arguments.");
			System.exit(1);
		} else {
			//Read the arguments

			//the first argument is the file name we read
			//the second one is the threshold
			//the thrid one is the name of the file you plan to write
			String fileName = args[0];
			threshold = Integer.parseInt(args[1]);
			String writeName = args[2];

			//frequent 1 itemsets
			itemsize = 1;

			//Initiate he list of the first pass item
			SortedSet<SortedSet<String>> frequent_set = initiate(fileName);
			SortedSet<SortedSet<String>> candidate_set = new TreeSet<>(new SortSet());
			System.out.println("Transaction total: "+ initialSet.size());


			// The loop stops when the final_list is empty (no more combination is beyond the threshold )
			while(!frequent_set.isEmpty()){

				//Printing statements
				System.out.println("Round: " + itemsize);
				System.out.println("Item Size: " + frequent_set.size());

				//Apriori generation steps
				candidate_set = apriori_gen(frequent_set,true);
				System.out.println("Done candidate generate: " + candidate_set.size());

				//Scan transaction, compare candidates, and eliminate those that are under the threshold.
				//Generate the next candidates for combination steps.
				frequent_set = finallist_gen(candidate_set);
				
				//Increase the itemsize by 1
				itemsize++;
				System.out.println("Done finalist generate: " + frequent_set.size());

				//Use the garbage collector to clear memory
				//System.gc();

			}
			
			//Write the file
			writeFrequent(writeName);

			//Record time and print out the seconds
			long endTime = System.currentTimeMillis();
			System.out.println("Apriori execution time: " + (endTime - startTime)/1000.0 + " seconds");

		}
	}


	//initiate method reads the document and generate the frequent_set itemsets (frequent-1-itemsets)
	public static SortedSet<SortedSet<String>> initiate(String fileName){
		//Record those 1-frequent-item which passes the threshold
		SortedSet<SortedSet<String>> freq1 = new TreeSet<>(new SortSet());
		try{

			//Use the FileReader and Bufferedreader to read the files
			FileReader reader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(reader);

			//line to read each line
			String line;
			//Count the frequency of each candidates
			Map<String,Integer> countMap = new HashMap<String,Integer>();
			//Loop ends when no more line exists
			while((line = bReader.readLine()) != null){
				//Each line is split by the spacebar
				String[] numbers = line.split(", ");

				//curSet saves each line (transaction) to the initialSet
				SortedSet<String> curSet = new TreeSet<>();

				//This records the 1 item subset for each transaction (each number save in a sorted set)
				SortedSet<SortedSet<String>> eachSubset = new TreeSet<>(new SortSet());
				
				//for each item (number) in the transaction, add it in to curSet and eachSubset
				//Also update the countMap for each number
				for(String i:numbers){
					if(i.trim().length()!=0){
						SortedSet<String> setInt = new TreeSet<>();
						setInt.add(i);
						eachSubset.add(setInt);
						if (curSet.add(i)){
							countMap.put(i,countMap.getOrDefault(i,0)+1);
						
						}	
					}
						
				}
	
				//initialSet adds the transaction
				initialSet.add(curSet);
				//for each transaction, saves the subset combination as its value.
				subsetMap.put(curSet,eachSubset);

			}

			//Close the reader
			reader.close();

			
			// Store the size1-frequent-item that passes the threshold	
			for (String i:countMap.keySet()){
				int val = countMap.get(i);
				
				if(val >= threshold){
					//The first frequent single item adding to the final Map
					SortedSet<String> set = new TreeSet<>();
					set.add(i);
					finalMap.put(set,val);
					freq1.add(set);
	
				}
			}

			

			

		} catch (IOException e) {
            //Throw the exception
            System.out.println("error while reading the files");
            e.printStackTrace();
        }

        return freq1;

	}

	// apriori generation method use a last_frequent_item to generate the join set.
	// a boolean check_infrequent is true for the apriori generation step
	// later when generating the subset for each transaction, we also use this method to generate its all possible join set.
	// But the subset generation no longer need to check for infrequent items
	public static SortedSet<SortedSet<String>> apriori_gen(SortedSet<SortedSet<String>> l_lastround,boolean check_infrequent){
		
		//the candidate_set that will be return
		SortedSet<SortedSet<String>> candidate_set = new TreeSet<>(new SortSet());
		//done_scanned set avoids scanning the previous items
		Set<SortedSet<String>> done_scanned = new HashSet<>();


		for(SortedSet<String> itemset1:l_lastround){
			//add itemset1 to the list so in future for loops it avoids to join itself.
			done_scanned.add(itemset1);
			for(SortedSet<String> itemset2:l_lastround){
				
				//if done_scanned already contains the itemset2, then skip (already visited in previous round)
				if(done_scanned.contains(itemset2)){
					continue;
				}
				
				//Transform both itemset to arrays.
				String[] i1 = itemset1.toArray(new String[0]);
				String[] i2 = itemset2.toArray(new String[0]);

				//use i to count the index
				int i = 0;

				//use candi to records the join set 
				SortedSet<String> candi = new TreeSet<>();

				//as i is smaller than the itemsize (assuming the set of the itemset is itemsize-1)
				//we only merge those who start with the same i-1 items and the last item is different
				//Since the set is stored in sortedset, each set is in ascending order
				while(i<itemsize){
		
					//if i is the last index of item
					if(i==itemsize-1&&!i1[i].equals(i2[i])){
						//add each item to the candi set
						candi.add(i1[i]);
						candi.add(i2[i]);
						
						//check for the boolean (check_infrequent for generating c list)
						//(check_infrequent=false means that this generate a join set for the transaction subset)
						if(check_infrequent){
							
							//if it has infrequent subset then break. Else the candidate set adds the candi set
							if (has_infrequent_sub(candi,l_lastround)){
								break;
							} else {
								candidate_set.add(candi);
							}
						} else {
							//solely add the subset combination to teh candidate set
							candidate_set.add(candi);
						}
						
					} else if(i<itemsize-1&&i1[i].equals(i2[i])){
						//if i is not the last index and the String in each array is equal
						//Add it to the candi sets
						candi.add(i1[i]);
						
					} else {
						//if they fail both qualifications. Break!
						break;
					}

					i++;
					
					
				}
				

			}

		}

		return candidate_set;

	}

	//finallist generate the new subset for each transaction, check if it exists in the last candidate list
	public static SortedSet<SortedSet<String>> finallist_gen(SortedSet<SortedSet<String>> c_lastround){


		//The qualified list that are returned
		SortedSet<SortedSet<String>> l_pass = new TreeSet<>(new SortSet());
		//A temporary map to store value (counts) of each candidate
		Map<SortedSet<String>,Integer> curMap = new HashMap<>();
		//for printing purpose.
		//int transaction_count = 1;
		for(SortedSet<String> transaction:initialSet){
			//System.out.println("Item: "+transaction_count++);


			//TreeSet that stores the new subset
			SortedSet<SortedSet<String>> newSubset = new TreeSet<>(new SortSet());

			//if the updateSet doesn't contains the transaction (first appearance of a transaction)
			if(!updatedSet.contains(transaction)){
				//add the transaction
				updatedSet.add(transaction);

				//get the last_subset generated
				SortedSet<SortedSet<String>> curSubset = subsetMap.get(transaction);
			
				//use apriori to generate the joins (combination)
				//No need to check for infrequent item
				newSubset = apriori_gen(curSubset,false);

				//A list to store usefulSubset
				SortedSet<SortedSet<String>> usefulSubset = new TreeSet<>(new SortSet());

				//for each set in the newly generated Subset
				for(SortedSet<String> candidate:newSubset){

					//if the candidate list contains the candidate.
					if(c_lastround.contains(candidate)){
						
						//add it to the curMap. and add the value by 1 if exists
						curMap.put(candidate,curMap.getOrDefault(candidate,0)+1);
						//add the candidate to the usefulSubset 
						//if the candidate doesn't contains the candidate, then it wont be added to the subset
						//If a subset is infrequent, then its superset is also infrequent
						usefulSubset.add(candidate);
					} 

				}
				
				subsetMap.put(transaction,usefulSubset);
				
				
			} else {
				//if updatedSet contains the transaction, then there's no need to re-update the subsetMap
				//Simply reuse the subset of this transaction and calculates the conuts
				newSubset = subsetMap.get(transaction);
				for(SortedSet<String> candidate:newSubset){

					if(c_lastround.contains(candidate)){
						curMap.put(candidate,curMap.getOrDefault(candidate,0)+1);
					}

				}
			}
			
		}

		//for each key in the curMap, add the ones with 500+ value to the finalMap

		for(SortedSet<String> candidate:curMap.keySet()){
			int count = curMap.get(candidate);
			if(count>=threshold){
				finalMap.put(candidate,count);
				//also put them to the pass list
				l_pass.add(candidate);
			}
		}

		//clear the updateSet eachtime
		//So that for the next round each transaction can have a new subset update
		updatedSet.clear();
		return l_pass;

	}

	//check for infrequent subset
	public static boolean has_infrequent_sub(SortedSet<String> candidate,SortedSet<SortedSet<String>> l_lastround){
		//for each intiger in the candidate
		for(String i:candidate){
			//create a copy of it and remove the String (this will be a subset of this candidate)
			SortedSet<String> copy = new TreeSet<>(candidate);
			copy.remove(i);
			//if the l_lastround doesn't contains this subset, then it does contain infrequent subset
			if (!l_lastround.contains(copy)) {
				return true;
			}
		}
		//else return false
		return false;
	}

	//Final step, write the documents based on the final map
	public static void writeFrequent(String writeName){
		try{

			//crete FileWriter and BufferedWriter
			FileWriter writer = new FileWriter(writeName, false);
        	BufferedWriter bWriter = new BufferedWriter(writer);
       
       		//for each candidate in the finalMap keyset
			for (SortedSet<String> candidate:finalMap.keySet()){
				//get the value of this candidate
				int val = finalMap.get(candidate);
				
				//use string builder
				StringBuilder sb = new StringBuilder();
				//add each number to the sb
				int len = candidate.size();

				for(String i:candidate){
					len--;
					sb.append(i);
					if(len!=0){
						sb.append(", ");
					}

				}

				
				//with its value in the bracket
				sb.append(": ("+finalMap.get(candidate)+")");
				//write the stringbuilder and return to the next line
				bWriter.write(sb.toString());
				bWriter.newLine();
				
			}
			//close the bufferedwriter
			bWriter.close();

		} catch (IOException e) {
            e.printStackTrace();
        }
	}

}

//This is a Comparator for SortedSet
class SortSet implements Comparator<SortedSet<String>>{
	public int compare(SortedSet<String> s1, SortedSet<String> s2){
		//stored the first set in a queue
		Queue<String> q = new LinkedList<>();
		for(String i:s1){
			q.add(i);
		}
		//for each number in s2
		for(String j:s2){
			//if q is out of number, then s1 is smaller than the s2
			if (q.size()==0){
				return -1;
			}
			String cur = q.poll();
			int com = cur.compareTo(j);
			//if equal then continue
			//bigger returns 1
			//smaller returns -1
			if(com==0){
				continue;
			} else if (com>0){
				return 1;
			} else {
				return -1;
			}
		}
		//if after the forloop q is out of number, return 0
		//else return 1
		if(q.size()==0){
			return 0;
		} else {
			return 1;
		}
		
	}	
}





