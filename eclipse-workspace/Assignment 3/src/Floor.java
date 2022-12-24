import java.util.*;
public class Floor {
	
double width,length,area;

public Floor(double width,double length) 
{
	this.width=width;
	this.length=length;
	
	if(width<0) {
		this.width=0;
	}
	else if(length<0)
	{
		this.length=0;
	}
}
public double getArea()
{
	double area=width*length;
	return area;
}
}
class Tile
{
	double cost;
	
	Tile(double cost)
	{
	this.cost=cost;
	
	if(cost<0) 
	{
	    cost=0;
	}
	}
	public double getCost() 
	{
		return cost;
	}
}
class Calculator
{
	Floor floor;
	Tile tile;
	
	Calculator(Floor floor,Tile tile)
	{
		this.floor=floor;
		this.tile=tile;
	}
	
	public double getTotalCost() 
	{
		double area=floor.getArea();
		double cost=tile.getCost();
		
	   	double tc= area * cost;
		   return tc;  
	}

}

	


