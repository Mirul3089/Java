import java.util.*;
public class circle {
   double radius;
   
   circle(double radius)
   {
	   this.radius=radius;
	   if(radius<=0)
	   {
		   radius=0;
	   }
   }
   double getRadius(){
	   return radius;
   }
   double getArea()
   {
	   double area=Math.PI*radius*radius;
	   return area;
   }
   
}
