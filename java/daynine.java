import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class daynine {
	
	Vector<String> possibleStarts;
	//Vector<Vector<Integer>> adjMatrix;
	Integer[][] adjMatrix;
	//man I'm lazy , just find the unique number of cities
	int uniquenums=8;
	public void daynine(){
		
		String fileName = "/Users/stephenkinser/Projects/advent-io/day09/Riuchando.input";
		//String fileName = "/Users/stephenkinser/Projects/advent-io/day09/test.input";
		possibleStarts= new Vector<String>();
        // This will reference one line at a time
        String line = null;
        
        //adjMatrix=new Vector<Vector<Integer>>();
        adjMatrix=new Integer[uniquenums][uniquenums];
        
		 try {
			 
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = 
	                new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            
	            while((line = bufferedReader.readLine()) != null) {
	                String[] instruction= line.split(" ");
	                
	                //System.out.println(possibleStarts.isEmpty());
	            	//System.out.println(array[0].equals("toggle"));
	                //adjMatrix.put(new keyset(instruction[0],instruction[3]), Integer.parseInt(instruction[5]));
	                if(!possibleStarts.contains(instruction[0]) /*|| possibleStarts.isEmpty()*/){
	                	possibleStarts.add(instruction[0]);
	                	//System.out.println(possibleStarts.indexOf(instruction[0]));
	                }
	                if(!possibleStarts.contains(instruction[2])){
	                	possibleStarts.add(instruction[2]);
	                }
	                	//System.out.println(instruction[4]);
	                	int to=possibleStarts.indexOf(instruction[0]);
	                	int from=possibleStarts.indexOf(instruction[2]);
	                	
	                	//System.out.println(to + " "+ ", "+ from );
	                	adjMatrix[to][to]=0;
	                	adjMatrix[from][from]=0;
	                	adjMatrix[to][from]=Integer.parseInt(instruction[4]);
	                	adjMatrix[from][to]=Integer.parseInt(instruction[4]);
	                	
	            }
	    		//System.out.println( adjMatrix);
	         
	            /*for(int i =0; i< uniquenums; i++){
	        	   String arrayln="";
	            	for (int j=0; j<uniquenums; j++){
	            		arrayln=arrayln+" "+adjMatrix[i][j];
	            		//System.out.println( adjMatrix[i][j]);
	            	}
	            	System.out.println(arrayln);
	            }*/
	            
	            
	            // Always close files.
	            bufferedReader.close();
	           //System.out.println( bruteforce());
	           System.out.println( longestroute());
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
	        catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	            // Or we could just do this: 
	            // ex.printStackTrace();
	        }
	
	}
	 public int bruteforce(){
		 int answer=9999;
		 int rowsum;
		 int[] start= new int[uniquenums];
		 
		 for (int i=1; i<uniquenums;i++ ){
			 start[i-1]=i;
		 }
		 ArrayList<ArrayList<Integer>> brute= new ArrayList<ArrayList<Integer>>();
		 brute=permute(start);
		 //System.out.println(brute.get(brute.size()-1).get(7));
		 //travel every possible node from start node 
		 	for(int i=0; i< brute.size()-1 ; i++ ){
		 		
		 		rowsum=0;
		 		//System.out.println(brute.get(i).size()-1);
		 		for(int j=1; j<brute.get(i).size(); j++){
		 			//System.out.println(adjMatrix[brute.get(i).get(j-1)][brute.get(i).get(j)]);	
		 			rowsum=rowsum+adjMatrix[brute.get(i).get(j-1)][brute.get(i).get(j)];
		 		}
		 		if(rowsum< answer){
		 			System.out.println(rowsum);
		 			answer=rowsum;
		 		}
		 		
		 	}
		 return answer;
		 
	 }
	 public int longestroute(){
		 int answer=0;
		 int rowsum;
		 int[] start= new int[uniquenums];
		 
		 for (int i=1; i<uniquenums;i++ ){
			 start[i-1]=i;
		 }
		 ArrayList<ArrayList<Integer>> brute= new ArrayList<ArrayList<Integer>>();
		 brute=permute(start);
		 //System.out.println(brute.get(brute.size()-1).get(7));
		 //travel every possible node from start node 
		 	for(int i=0; i< brute.size()-1 ; i++ ){
		 		
		 		rowsum=0;
		 		//System.out.println(brute.get(i).size()-1);
		 		for(int j=1; j<brute.get(i).size(); j++){
		 			//System.out.println(adjMatrix[brute.get(i).get(j-1)][brute.get(i).get(j)]);	
		 			rowsum=rowsum+adjMatrix[brute.get(i).get(j-1)][brute.get(i).get(j)];
		 		}
		 		if(rowsum> answer){
		 			//System.out.println(rowsum);
		 			answer=rowsum;
		 		}
		 		
		 	}
		 return answer;
	 }
	 
	 public ArrayList<ArrayList<Integer>> permute(int[] num) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 
			//start from an empty list
			result.add(new ArrayList<Integer>());
		 
			for (int i = 0; i < num.length; i++) {
				//list of list in current iteration of the array num
				ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
		 
				for (ArrayList<Integer> l : result) {
					// # of locations to insert is largest index + 1
					for (int j = 0; j < l.size()+1; j++) {
						// + add num[i] to different locations
						l.add(j, num[i]);
		 
						ArrayList<Integer> temp = new ArrayList<Integer>(l);
						current.add(temp);
		 
						//System.out.println(temp);
		 
						// - remove num[i] add
						l.remove(j);
					}
				}
		 
				result = new ArrayList<ArrayList<Integer>>(current);
			}
		 
			return result;
		}
	}
