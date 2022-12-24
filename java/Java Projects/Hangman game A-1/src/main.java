
import java.util.*;
import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class main{
    
    static List<String> inputwords=new ArrayList<String>(); // list
   
    static JFrame jf=new JFrame();  //GUI components
    
    static JLabel l1=new JLabel(""); 
    
    static JLabel l2=new JLabel(""); 
    
    static JTextField tf=new JTextField(10);
    
    static char userInput;
    
    static JButton jb1=new JButton("Guess");
    static boolean wordIsGuessed = false;
   
    static boolean buttonPressed=false;
    
    static JButton jb2=new JButton("Click here to continue");
    static JButton jb3=new JButton("Add new words");
    
    static JTextField tf1=new JTextField(20);
    static JButton jb4=new JButton("Add");
    
    public static void main(String[] args) {
    	
    	jf.add(l1);
        jf.add(l2);
        jf.add(tf);
        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(tf1);
        jf.add(jb4);
        
                
        l1.setBounds(150, 225, 400, 400);
        l1.setFont(new Font("Verdana", Font.PLAIN, 14)); //set the Sizes
        
        l2.setBounds(150, 450, 400, 400);
        l2.setFont(new Font("Verdana", Font.PLAIN, 14));
        
        tf.setBounds(150, 600, 25, 25);
        tf.setFocusable(true);
        
        jb1.setBounds(200, 600, 100, 25);
        jb1.setFont(new Font("Verdana", Font.PLAIN, 12));
        
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setSize(550, 700);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        jb2.setBounds(150, 450, 300, 25);
        jb3.setBounds(150, 500, 300, 25);
        
        tf1.setBounds(150, 410, 300, 25);
        jb4.setBounds(150, 450, 300, 25);
        
        jb2.setVisible(false);
        jb3.setVisible(false);
        jb4.setVisible(false); // Set visibilities
        tf1.setVisible(false);

        ArrayList<String> words = new ArrayList<>(); // arraylist
        
		try (Scanner input = new Scanner(new FileReader("hangman.txt"));) // file i/o to take words from text file 
		
		 {
			while (input.hasNext()) {
				String b= input.next();
				words.add(b);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        // Random generator
        int rand = (int) (Math.random() * words.size());

        // array to store already entered characters

        char[] enteredLetters=new char[words.get(rand).length()];

        jb1.addActionListener(new ActionListener() //for guess button
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                CheckString();
            }
       });
        
        jb2.addActionListener(new ActionListener() //for countinue button
        {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jf.setVisible(true);
            	jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
       });
        
         jb3.addActionListener(new ActionListener() //for add new words
        {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tf1.setVisible(true);
            	jb4.setVisible(true);
            	jb2.setVisible(false);
                jb3.setVisible(false);
            }
       });
         
         jb4.addActionListener(new ActionListener() // add button
         {
             @Override
             public void actionPerformed(ActionEvent e) {
            	 
                   pwrite();
             }
        });
        
        
        tf.addActionListener(jb1.getActionListeners()[0]);
        
        int triesCount = 0;
        
        do {
        
        switch (enterLetter(words.get(rand), enteredLetters)) {
            case 0:                     //enterred letter is not in the word
                triesCount++;
                break;
            case 1:                    //first letter entered
                triesCount++;
                break;
            case 2:                    //
                break;
            case 3:                    //all letters are guessed
                wordIsGuessed = true;

                jb1.setVisible(false);
                tf.setVisible(false);
                
                
                jb2.setVisible(true);
                jb3.setVisible(true);
                break;
        }
        } while (! wordIsGuessed);

        l1.setText("\nThe word is " + words.get(rand) +
            ". You missed " + (triesCount -findEmptyPosition(enteredLetters)) +
            " time(s).");
      
        l2.setText("");
        
    }

   
    public static int enterLetter(String word, char[] enteredLetters)    {
        
    	inputwords.clear();
        
    	inputwords.add("Enter a letter from a word ");
        
        if (! printWord(word, enteredLetters))
            return 3;

        
       String sentence="";
        for (int i=0; i<inputwords.size(); i++) {
            sentence+=inputwords.get(i);
        }
       l1.setText(sentence);
        int emptyPosition = findEmptyPosition(enteredLetters);

        
       if(buttonPressed) {
        if (inEnteredLetters(userInput, enteredLetters)) {
            
            l2.setText(userInput+" is already in the word");
            
            buttonPressed=false;

            return 2;
        }
        else if (word.contains(String.valueOf(userInput))) {
            enteredLetters[emptyPosition] = userInput;
            
            l2.setText("");
            
            buttonPressed=false;

            return 1;
        }
        else {
            
            l2.setText(userInput + " is not in the word");
             
            buttonPressed=false;

            return 0;
            }

       }
       return 2;

    }
    
    public static void pwrite() 
    {
    	File file = new File("hangman.txt");
    	try(PrintWriter output = new PrintWriter(file);)           // file i/o to write words in text file 
    	{
    		
        	String op=tf1.getText();
        	output.println(op);
        	
        	output.close();
    	}
        	
       catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();	
		}
    	
    	
      
    }

    
   public static boolean printWord(String word, char[] enteredLetters) {
      
        boolean asteriskPrinted = false;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            
            if (inEnteredLetters(letter, enteredLetters)) {
            	inputwords.add(String.valueOf(letter));            
            }
            else {
            	inputwords.add("*"); 
                asteriskPrinted = true;
            }
        }
        return asteriskPrinted;
    }
    
   public static void CheckString() {
            
            try {
             userInput=tf.getText().charAt(0);
             if(userInput!=' ') {
                 buttonPressed=true;
                 
            tf.setText(null);
             }
            }
            catch(Exception err) { // checks the characters and strings
                return;
            }
           
    }
    
    public static boolean inEnteredLetters(char letter, char[] enteredLetters) {
        return new String(enteredLetters).contains(String.valueOf(letter));
    }

    
  public static int findEmptyPosition(char[] enteredLetters) {
        int i = 0;

       
        for(int it=0; it<enteredLetters.length; it++) { 
            if(enteredLetters[it]=='\u0000') break;
            i++;
        }
        return i;
    }
}

