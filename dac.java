//Divide and conquer
import  java.util.Arrays;
public class dac{
  //Binary search
  public static int binarySearch(int[] sortedArray, int x){
   return  binarySearch(sortedArray, x, 0);
  }

  public static int binarySearch(int[] sortedArray, int x, int pos){
    if(sortedArray.length == 0){
      return -1;
    }
    int middle = (sortedArray.length-1)/2;
    int pivot = sortedArray[middle];
    if (pivot == x){
        return pos;
    }
    else if(x<pivot){
      return binarySearch(Arrays.copyOfRange(sortedArray,0,middle),x,pos);
    }
    return binarySearch(Arrays.copyOfRange(sortedArray,middle+1,sortedArray.length),x,pos+middle+1);
  }

  public static void main(String[] args){
    System.out.println("Hitta 55:s position i [-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878]");
    int[] arrayen = {-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878};
    System.out.println(binarySearch(arrayen, 55));

    System.out.println("\nHitta 500:s position i [-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878]");
    System.out.println(binarySearch(arrayen, 500));


  }



}
