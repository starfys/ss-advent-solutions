import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class daysix {
	
	public static void main(String[] args){
		int[][] instructions= new int[1000][1000];
		String fileName = "/Users/stephenkinser/daysix.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] array= line.split(" ");
            	//System.out.println(line);
            	//System.out.println(array[0].equals("toggle"));
            	
            	if(array[0].equals("toggle") ){
            		String[] startcoord =array[1].split(",");
        			String[] endcoord =array[3].split(",");
        			//System.out.println(endcoord[0]);
        			//System.out.println(startcoord[0]);
        			for(int i= Integer.parseInt(startcoord[0]);i<=Integer.parseInt(endcoord[0]) ;i++){
        				for(int j= Integer.parseInt(startcoord[1]);j<=Integer.parseInt(endcoord[1]) ;j++){
        					//System.out.println(instructions[i][j]);
        					//instructions[i][j]=instructions[i][j]==0?1:0;
        					instructions[i][j]=instructions[i][j]+2;
        					//System.out.println(instructions[i][j]);
        				}
        			}
            	}else if(array[0].equals("turn") ){
            		if(array[1].equals("on")){
            			String[] startcoord =array[2].split(",");
            			String[] endcoord =array[4].split(",");
            			//System.out.println(endcoord[0]);
            			//System.out.println(startcoord[0]);
            			for(int i= Integer.parseInt(startcoord[0]);i<=Integer.parseInt(endcoord[0]) ;i++){
            				for(int j= Integer.parseInt(startcoord[1]);j<=Integer.parseInt(endcoord[1]) ;j++){
            				//	instructions[i][j]=1;
            					instructions[i][j]=instructions[i][j]+1;
            				}
            			}
            		}
            		else if(array[1].equals("off")){
            			String[] startcoord =array[2].split(",");
            			String[] endcoord =array[4].split(",");
            			for(int i= Integer.parseInt(startcoord[0]);i<=Integer.parseInt(endcoord[0]) ;i++){
            				for(int j= Integer.parseInt(startcoord[1]);j<=Integer.parseInt(endcoord[1]) ;j++){
            					//instructions[i][j]=0;
            					instructions[i][j]=instructions[i][j]>0?instructions[i][j]-1:0;
            				}
            			}
            		}
            	}
            	/*
            	int sum=0;
                for (int i=0; i<1000; i++){
                	//String arrayln="";
                	
                	for (int j=0; j<1000; j++){
                		//arrayln=arrayln+" "+Integer.toString(instructions[i][j]);
                		sum=sum+instructions[i][j];
                	}
                	//System.out.println(arrayln);
                }
                System.out.println(sum);
                */
            }
            
            int sum=0;
            for (int i=0; i<1000; i++){
            	//String arrayln="";
            	
            	for (int j=0; j<1000; j++){
            		//arrayln=arrayln+" "+Integer.toString(instructions[i][j]);
            		sum=sum+instructions[i][j];
            	}
            	//System.out.println(arrayln);
            }
            System.out.println(sum);
            // Always close files.
            bufferedReader.close();         
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
}
