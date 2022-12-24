import java.util.*;
public class Cuboid extends Rectangle{
 double height;
 
 Cuboid(double width,double length, double height){
	 super(width,length);
	 
	 this.height=height;
	 
	 if(height<=0) {
		 height=0;
	 }
 }
 
 double getHeight() {
	 return height;
 }
 double getVolume() {
	 
	 double area=this.getArea();
	 return area*height;
 }
}
