/*
 * Binary Conversion using Multi-Threading
 * 
 * @author Alex Persinger
 * @version 1.0 April 1st 2012
 */
package binaryarithmetic;
class ConvertToBinary implements Runnable
{
   Thread t;
   private int binary;
   private String parameter;
   public ConvertToBinary(String numberToConvert)
   {
      this.parameter = numberToConvert;
   }
   
   public void run()
   {
       //System.out.println("Running");
       String tempTwo[];
       int size = 0;
       int total = 0;
       
       //System.out.println("PARAMETER: " + this.parameter);
       
       // ...16|8|4|2 powers of 2
       tempTwo = this.parameter.split("");

       size = tempTwo.length;
       for(int i = 0; i < tempTwo.length; i++)
       {
           size--;
           if(tempTwo[i].equals("1"))
           {
               if(size == 0)
                   total += 1;
               else
                   total += Math.pow(2.0, (double)size);
           }
           
           try
           {
               /**
                * Let the thread sleep to show the conversion in 
                * order of size...the largest number should finish last
                */
               Thread.sleep(10);
           }
           catch(InterruptedException e)
           {
                System.out.println("Interrupted.");   
           }
       }
       System.out.println("Conversion of binary number("+ this.parameter
                        + ") = " + total);
   }
}

class BinaryArithmetic
{
   public static void main(String args[])
   {     
       System.out.println("Running");
       
       Runnable firstConversion = 
               new ConvertToBinary("1011000100101110101");
       Thread threadOne = new Thread(firstConversion);
       //System.out.println("Starting first thread...");
       threadOne.start();
       
       Runnable secondConversion = 
               new ConvertToBinary("101100001111100001101");
       Thread threadTwo = new Thread(secondConversion);
       //System.out.println("Starting second thread...");
       threadTwo.start();
       
       Runnable thirdConversion = 
               new ConvertToBinary("1011001100001111110100111");
       Thread threadThree = new Thread(thirdConversion);
       //System.out.println("Starting third thread...");
       threadThree.start();
       
       Runnable fourthConversion = 
               new ConvertToBinary("101100010010111111000011");
       Thread threadFour = new Thread(fourthConversion);
       //System.out.println("Starting fourth thread...");
       threadFour.start();
       
       Runnable fifthConversion = 
               new ConvertToBinary("110000111101011010100101110");
       Thread threadFive = new Thread(fifthConversion);
       //System.out.println("Starting fifth thread...");
       threadFive.start();
       
       Runnable sixthConversion = 
               new ConvertToBinary("11010010");
       Thread threadSix = new Thread(sixthConversion);
       //System.out.println("Starting sixth thread...");
       threadSix.start();
       
       Runnable seventhConversion = 
               new ConvertToBinary("11010111010001011101010101");
       Thread threadSeven = new Thread(seventhConversion);
       //System.out.println("Starting seventh thread...");
       threadSeven.start();   
   }
}
