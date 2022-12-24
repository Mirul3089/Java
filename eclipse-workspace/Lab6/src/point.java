import java.util.*;
public class point {
 int x,y;
 public point() {
	 
 }
 public point(int x,int y) 
 {
	this.x=x;
	this.y=y;
 }
 
 public int getX() 
 {
	 return x;
 }
 public int getY() 
 {
	 return y;
 }
 public void setX(int x) 
 {
	 this.x=x;
 }
 public void setY(int y) 
 {
	 this.y=y;
 }
 public double distance()
 {
	 return Math.sqrt(this.x * this.x + this.y * this.y);
 }
 public double distance(int x,int y)
 {
	 return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * ((this.y - y)));
 }
 public double distance(point point)
 {
	 return Math.sqrt((this.x - point.getX()) * (this.x - point.getX()) + (this.y - point.getY()) * (this.y - point.getY()));
 }
	public static void main(String[] args) {
		

	}

}
