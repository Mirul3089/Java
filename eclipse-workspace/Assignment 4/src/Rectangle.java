import java.util.*;

public class Rectangle {
double width,length;

 Rectangle(double width,double length){
	 
	 this.width=width;
	 this.length=length;
	 
	 if(width<=0) {
		 width=0;
	 }
	 
	 if(length<=0) {
		 length=0;
	 }
	 
 }
 double getWidth() {
	 return width;
 }
 double getLength() {
	 return length;
 }
 double getArea() {
	 return width*length;
 }
 
}
