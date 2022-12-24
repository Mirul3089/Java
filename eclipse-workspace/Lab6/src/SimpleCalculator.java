import java.util.*;
public class SimpleCalculator 
{
   double firstNumber,secondNumber;
 public double getFirstNumber() 
 {
	 return firstNumber;
 }
 public double getSecondNumber() 
 {
	 return secondNumber;
 }
 public void setFirstNumber(double firstNumber) 
 {
	 this.firstNumber=firstNumber;
 }
 public void setSecondNumber(double secondNumber) 
 {
	 this.secondNumber=secondNumber;
 }
 public double getAdditionResult() {
	 return firstNumber + secondNumber;
 }
 public double getSubstractionResult() {
	 return firstNumber - secondNumber;
 }
 public double getMultiplicationResult() {
	 return firstNumber * secondNumber;
 }
 public double getDivisionResult() {
	 if(secondNumber != 0) {
		 return firstNumber / secondNumber;
	 }
	 else
	 {
		 return 0;
	 }
 }
 
	public static void main(String[] args) {
		
	}

}
