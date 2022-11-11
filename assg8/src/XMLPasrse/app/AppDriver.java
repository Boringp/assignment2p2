package XMLPasrse.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
    int i;
    int line,column;
    	 
		try {
			FileReader fr;
		    BufferedReader br;  
			fr = new FileReader("C:/Users/bo/git/repository2/assg8/res/sample2.xml");
			br=new BufferedReader(fr);  
			line=1;column=0;
		    while( (i=br.read())!=-1){
		    	if(i==10) {
		    		line++;
		    		column=0;
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
		    			
		    			if(str.toString().trim().substring(1).equals(stack.peek() )) {
		    				stack.pop();
		    				position1.pop();
		    			}
		    			else if((!errorQ.isEmpty()) && str.toString().trim().substring(1).equals(errorQ.peek()) ) {
		    				errorQ.dequeue();
		    				position2.dequeue();
		    			}
		    			else if(stack.isEmpty()) {
		    				errorQ.enqueue(str.toString().trim());
		    				position2.enqueue(line+","+column);
		    			}
		    			else {
		    				String ab =str.toString().trim().substring(1);
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
				
				System.out.println(extrasQ.dequeue());
				System.out.println(position3.dequeue());
			}
			else {
				
				System.out.println(errorQ.dequeue());
				System.out.println(position2.dequeue());
			}
		}
		if((!errorQ.isEmpty()) && (!extrasQ.isEmpty())) {
			boolean eq=errorQ.peek().split(" ")[0].equals(extrasQ.peek().substring(1));
			if(eq==false) {
			
				System.out.println(errorQ.dequeue());
				System.out.println(position2.dequeue());
			}
			else {
				
				errorQ.dequeue();
				extrasQ.dequeue();
			}
		}
       }
    
}
    
    
    
}

