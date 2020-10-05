/* Author: Mitsu Fukuzaki
 * Class: CSE360 (Tuesdays at 9:00am - 10:15am)
 * Date: 10/04/2020
 * Description: The purpose of this assignment is to familiarize ourself with using Github.
 */

package cse360assignment01;
import java.util.ArrayList;

//Name of the class is AddingMachine.
public class AddingMachine {
	
//Declares a private int variable called total.
  private int total;
  
//Declares a private int variable called counter to keep track of the ArrayList length.
  private int counter;
  
//Declares a private int ArrayList called arrStr that keeps track of operators.
  private ArrayList<String> str = new ArrayList<String>(); 
  
  //Declares a public instance of the Adding Machine class.
  public AddingMachine () {
	str.add(String.valueOf(0));
    total = 0;  // not needed - included for clarity
  }
  
  //Declares a public method called getTotal returns the total value.
  public int getTotal () {
    return total;
  }
  
  //Declares a public add method that adds parameter value to the int total then returns void.
  public void add (int value) {
	  total = total + value;
	  str.add(" + ");
	  str.add(String.valueOf(value));
	  counter = counter + 2;
  }
  
  //Declares a public subtract method that subtracts the parameter value and returns void.
  public void subtract (int value) {
	  total = total - value;
	  str.add(" - ");
	  str.add(String.valueOf(value));
	  counter = counter + 2;
  }

  //Declares a public toString method that returns all the computations as a single string.
  public String toString () {
	  for (int i = 0; i <= counter; i++) {
		  System.out.print(str.get(i));
	  }
    return "";
  }

  //Declares a public clear method that clears the memory and returns void.
  public void clear() {
	  total = 0;
	  str = null;
	  System.out.println("\nMemory cleared.");
  }
}

//Tests the AddingMachine class.
class TestEnvironment {
	public static void main (String[] args) {
		AddingMachine test = new AddingMachine();
		test.add(5);
		test.subtract(3);
		test.add(10);
		test.add(7);
		test.subtract(2);
		test.toString();
		test.clear();
	}
}