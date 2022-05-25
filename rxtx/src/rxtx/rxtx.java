package rxtx;

import java.util.Enumeration;

import gnu.io.CommPortIdentifier;

public class rxtx {
		 
		 public static void main(String[] args) {
		 
		  try {
		   Enumeration e = CommPortIdentifier.getPortIdentifiers();
		 
		   System.out.println("Enumeration get()............... "+ e.hasMoreElements());
		 
		   while (e.hasMoreElements()) {
		    CommPortIdentifier first = (CommPortIdentifier) e.nextElement();
		    System.out.println("COM name : " + first.getName());
		   }
		    
		  } catch (Exception e) {
		   e.printStackTrace();
		 }
		 
	 }
		 
}

