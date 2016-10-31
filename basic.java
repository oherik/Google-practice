//Write a function to reverse a string.
public class basic{
  public static String reverse(String s){
    int l  = s.length();
    char[] charSequence = s.toCharArray();
    char[] result = new char[l];
    for(int i = 0; i<l; i++){
      result[l-1-i] = charSequence[i];
    }
    return new String(result);
  }

//Write function to compute Nth fibonacci number:
  public static int fibonacci(int n){
    if(n<=1){
      return n;
    }
    return fibonacci(n-1)+fibonacci(n-2);
  }

// Print out the grade-school multiplication table up to 12x12
  public static void mult(){
    for(int i = 1; i<13; i++){
      for(int j = 1; j<13; j++){
        System.out.print(i*j + "\t");
      }
      System.out.println();
    }
  }

  //Write a function that sums up integers from a text file, one int per line.   TODO svår denna
  /*
  public static int sumUp(String fileName){
  BufferedReader br = new BufferedReader(new FileReader(fileName));
  int sum = 0;
  while(true){
    try{
      String s = br.readLine();
      sum+=Integer.parseInt(s);
    }catch(Exception e){}
    }
  br.close();
  return sum;
}
*/

// Write function to print the odd numbers from 1 to 99.
public static void odd(){
  for(int i=1; i<100; i+=2){
    System.out.print(i+"  ");
  }
}

//Find the largest int value in an int array.
public static int largest(int[] input){
  int max = input[0];
  for(int i: input){
    max = i>max? i : max;
  }
  return max;
}

// Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.
public static String rgbToHex(int r, int g, int b){
  String rs = Integer.toHexString(r);
  if(rs.length()<2) rs = "0" + rs;

  String gs = Integer.toHexString(g);
  if(gs.length()<2) gs = "0" + gs;

  String bs = Integer.toHexString(b);
  if(bs.length()<2) bs = "0" + bs;


  return rs+gs+bs;  

}

  public static void main(String[] args){
    System.out.println("Skriv ut \"hej på dig\" baklänges");
    System.out.println(reverse("hej på dig"));

    System.out.println("\nSkriv ut det åttonde fibonacci-numret");
    System.out.println(fibonacci(8));

    System.out.println("\nSkriv ut multiplikationstabellen upp till 12x12");
    mult();

  //  System.out.println("Lägg ihop siffrorna");
    //sumUp("basic_numbers.txt");

    System.out.println("\nSkriv ut udda siffror upp till 99");
    odd();
    System.out.print("\n");

    System.out.println("\nHitta största siffran i [-2, 4, -5, 10, -43, 0]");
    int[] arrayen = {-2, 4, -5, 10, -43, 0};
    System.out.println(largest(arrayen));

    System.out.println("\nHexa 255,255,0");
    System.out.print(rgbToHex(255,255,0));


  }
}
