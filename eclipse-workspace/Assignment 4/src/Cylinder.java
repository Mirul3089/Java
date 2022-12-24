import java.util.*;

public class Cylinder extends circle{
	
	double height;

	 Cylinder(double radius,double height)
	 {
		 super(radius);
		this.height=height;
		
		if(height<=0)
		   {
			   height=0;
		   }
	 }
	 double getHeight() {
		 return height;
	 }
     double getVolume() {
    	 double area=this.getArea();
    	 double vol= area*height;
    	 return vol;
     }
}
