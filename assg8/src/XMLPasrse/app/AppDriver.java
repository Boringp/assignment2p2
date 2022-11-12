package XMLPasrse.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import utilities.Iterator;
import utilities.MyArrayList;
import utilities.MyQueue;
import utilities.MyStack;

public class AppDriver {
public static void main(String[] args) {
	
    MyStack<String> stack =new MyStack<String>();
    MyStack<String> position1 =new MyStack<String>();
    MyQueue<String> errorQ=new MyQueue();
    MyQueue<String> extrasQ=new MyQueue();
    MyQueue<String> position2=new MyQueue();
    MyQueue<String> position3=new MyQueue();
    StringBuilder str = new StringBuilder();
    MyArrayList<String> errorPosition = new MyArrayList<>();
    MyArrayList<Integer> errorLine = new MyArrayList<Integer>();
    int i;
    int line,column;
    String path = args[0];	 
		try {
			FileReader fr;
		    BufferedReader br;  
			fr = new FileReader(path);
			br=new BufferedReader(fr);  
			line=1;column=0;
		    while( (i=br.read())!=-1){
		    	if(i==10) {
		    		line++;
		    		column=0;
		    	}
		    	else if(i==9) {
		    		column=column+4;
		    	}
		    	else {
		    		column++;
		    	}
		    	if((char)i=='<') {
		    		str = new StringBuilder();
		    	}
		    	else if((char)i!='>') {
		    		str.append((char)i);
		    	}
		    	else {
		    		
		    		if (str.length()==0) {
		    			continue;
		    		}
		    		else {
		    		if	(str.charAt(str.length()-1)=='?' && str.charAt(0)=='?'){
		    			str = new StringBuilder();
		    			continue;
		    		}
		    		
		    		if(str.charAt(str.length()-1)=='/') {
		    			str = new StringBuilder();
		    			continue;
		    		}
		    		if(str.charAt(0)!='/') {
		    			position1.push(line+","+column);
		    			stack.push(str.toString().split(" ")[0])	;
		    			
		    		}
		    		else if(str.charAt(0)=='/') {
		    			String ab =str.toString().trim().substring(1);
		    			if(str.toString().trim().substring(1).equals(stack.peek() )) {
		    				stack.pop();
		    				position1.pop();
		    			}
		    			else if((!errorQ.isEmpty()) && str.toString().trim().substring(1).equals(errorQ.peek()) ) {
		    				errorPosition.add(position2.peek());
    						
		    				errorQ.dequeue();
		    				position2.dequeue();
		    			}
		    			else if(stack.isEmpty()) {
		    				errorQ.enqueue(str.toString().trim());
		    				position2.enqueue(line+","+column);
		    			}
		    			else {
		    				
		    				boolean t2=stack.contains(ab);
		    				if(t2) {
		    					while(!stack.peek().equals(ab)){
		    						errorQ.enqueue(stack.pop());
		    						position2.enqueue(position1.pop());
		    						
		    					}
		    					stack.pop();
		    					position1.pop();
		    				}
		    				else {
		    			
		    					extrasQ.enqueue(str.toString());
		    					position3.enqueue(line+","+column);
		    				}
		    			}
		    			
		    		}
		    		str = new StringBuilder();
		    	}
		    		
		    	}
		    }
		    br.close();    
	        fr.close();    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}    
	
       while(!(errorQ.isEmpty()&&extrasQ.isEmpty())) {
		while (!stack.isEmpty()){
			errorQ.enqueue(stack.pop());
			position2.enqueue(position1.pop());
		}
		if(  errorQ.isEmpty()||extrasQ.isEmpty()  ) {
			if(errorQ.isEmpty()) {
				
				extrasQ.dequeue();
				errorPosition.add(position3.dequeue());
			}
			else {
				
				errorQ.dequeue();
				errorPosition.add(position2.dequeue());
			}
		}
		if((!errorQ.isEmpty()) && (!extrasQ.isEmpty())) {
			boolean eq=errorQ.peek().split(" ")[0].equals(extrasQ.peek().substring(1));
			if(eq==false) {
			
				errorQ.dequeue();
				errorPosition.add(position2.dequeue());
			}
			else {
				
				errorQ.dequeue();
				extrasQ.dequeue();
			}
		}
       }
       Iterator<String> ep = errorPosition.iterator();
       while(ep.hasNext()) {
    	   String a=ep.next();
    	   System.out.printf("Error exists in Line %s , Column %s %n",a.split(",")[0],a.split(",")[1]);
    	   if(!errorLine.contains(Integer.parseInt(a.split(",")[0]))) {
    		   errorLine.add(Integer.parseInt(a.split(",")[0]));
    	   }
       }
       
     
      String thisLine = null;
		try {
			int printline =1;
			FileReader fr;
		    BufferedReader br;  
			fr = new FileReader(path);
			br=new BufferedReader(fr);  
			  while ((thisLine = br.readLine()) != null) {
				  if(errorLine.contains(printline))
		            System.out.printf("Line %d : %s %n",printline,thisLine.trim());
				  printline++;
		         }  
			br.close();    
	        fr.close();    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}    
           
       
       
}
    
    
    
}

