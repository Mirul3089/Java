/*************************************************************************************************                                                                                                                         *

*  I declare that this code is my own work in accordance with Humber Academic Policy.        *

*  No part of this code has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: ______________Mirul Patel________ Student ID: __N01489347________________ */

import java.util.*;
public class q1 {

 
public static void main(String[] args)
{
 
	int i,j;
	
      for(i=1;i<=5;i++) //if this true then it will go to inner for loop otherwise it will go to second outer for loop
    	           // i have choose the limit as 5 because of the pattern we need
      {
         for(j=1;j<=5-i;j++) // if this condition is true it will print space otherwise it will go to next for loop
           {
              System.out.print(" ");
           }
         
         for(j=1;j<=i*2-1;j++) //  if this condition is true it will print * otherwise it will go to outer for loop
         {
             System.out.print("*");
         }
         
         System.out.println(); //for new line
      } 
      
      //for decrement portion
      for(i=5-1;i>0;i--) //if this true then it will go to inner for loop
      {
          for(j=1;j<=5-i;j++)  //if this condition is true it will print space otherwise it will go to next for loop
          {
             System.out.print(" ");
          }
      for(j=1;j<=i*2-1;j++) //  if this condition is true it will print * otherwise it will go to outer for loop
      {
        System.out.print("*");
      }
      System.out.println();//for new line
      }
     }

}