package multiplication10x10;

public class Multiplication10x10 {
  
    public static void main(String[] args) {
      
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
             
                int product = i * j;
               
                System.out.print(product + "\t");
            }
        
            System.out.println();
        }
    }
}

