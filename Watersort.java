import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

//import jdk.internal.org.jline.terminal.Size;

//import javax.xml.stream.events.Characters;

//import org.graalvm.compiler.lir.alloc.trace.DefaultTraceRegisterAllocationPolicy.BottomUpNumVariablesStrategy;

public  class Watersort {
   //the test program should create a single bottle 
   static  Character red = new Character('r');
   static  Character blue = new Character('b');
   static  Character yellow = new Character('y');
  static int sizee[] = {5, 5};
   public static StackAsMyArrayList<Character>[] Bottles  =  (StackAsMyArrayList<Character>[]) Array.newInstance(StackAsMyArrayList.class, 5);
  
  

   public static boolean Solved(StackAsMyArrayList[] bottles)
   {
    boolean uniform = true;
    for (int i = 0; i < 5; ++i)
    {
      //check if all the stacks are uniform
      uniform =  bottles[i].checkStackUniform();
      if (!uniform)
      return false;


     
     
    
    }

     //check if the number of elements are equal to 0 (for the empty bottles) or 4 for the other 3 bottles
    int count = 0;
     for (int i = 0; i < 5; ++i)
    if (bottles[i].getStackSize() == 0 || bottles[i].getStackSize() == 4)
    {    
      ++count;
        
    }
    
    if (count == 5)
      return true;
    else
      return false;
    


   }

   public static String ShowAll()
   {
     String out = "";
     for (int i = 0 ; i < 5; ++i)
     {
        out += "Bottles" + i + " ";
       
          out += Bottles[i]; 

        out += '\n';
     }
     return out;
           
   }
   

   
    public static void main(String[] args) {
     
        StackAsMyArrayList<Character> stack  = new StackAsMyArrayList<>();
      

      
    

    //create 5 bottles  
     
      for (int i = 0 ; i < 5; ++i)
        Bottles[i]  = new StackAsMyArrayList<Character>();

      int empty_spaces = 5* 4 ;//there are 5 bottles of which each of them can can only have 4 colors (worst case);
      int red_count = 0; //these colors can only reach a max of 4 each
      int blue_count = 0;
      int yellow_count = 0;
        do 
        {
          for (int i = 0; i < 5; ++i)
          {
          Random rand = new Random();
          Random randseed = new Random();
          int seed = randseed.nextInt(8) + 1;
          int num = rand.nextInt(seed);
       
              switch (num) {
                case 0:
                  if (Bottles[i].getStackSize() <= 4 && red_count < 4)//insure that ink is not spilled
                  {
                    Bottles[i].push(red);
                    --empty_spaces;
                    ++red_count;
                  }
                   
                  break;
                case 1 : 
                if (Bottles[i].getStackSize() <= 4 && blue_count < 4)
                {
                  Bottles[i].push(blue);
                  --empty_spaces;
                  ++blue_count;
                }
                break;

                case 2:
                if (Bottles[i].getStackSize() <= 4 && yellow_count < 4)
                  {
                    Bottles[i].push(yellow);
                    --empty_spaces;
                    ++yellow_count;
                  }
                break;

                default:
                  break;
              }
            }
        
        }while(red_count <= 4 && blue_count <= 4 && yellow_count <= 4 && empty_spaces > 8);
     
        //display
        System.out.println(ShowAll());

        //move colors around
        int input_bottle;
        int target_bottle;
        Scanner input = new Scanner(System.in);
        do
        {
        System.out.println("Move color from: ");
        Scanner _input = new Scanner(System.in);
        input_bottle = _input.nextInt();
        System.out.println("To bottle: ");
        target_bottle = _input.nextInt();
        //check if the values are in range
        if (input_bottle > 5 || input_bottle < 0 || target_bottle > 5 || target_bottle < 0 )
        {
         System.out.println("Either your input bottle of target bottle is out of bunds3");
          
        }else
        {
          //check if the if the colors are the same and the stack is not full
          if (Bottles[input_bottle].peek() == Bottles[target_bottle].peek() && Bottles[target_bottle].getStackSize() < 5)
            {
              Bottles[target_bottle].push(Bottles[input_bottle].pop());
            }
          else
          {
            System.out.println("target bottle full or you are trying to put a two different colors on top of each other");
          }


          
        }
        for (int j= 0; j < 5; ++j)
          System.out.println(Solved(Bottles));
        System.out.println(ShowAll());
      }while (!Solved(Bottles));

      System.out.println("Congretualations you won");
          }

            


         


        

     
      
      
    
     
     

        
    }
  

