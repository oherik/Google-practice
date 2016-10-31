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


  //Merge sort
  public static int[] mergeSort(int[] unsorted){
    if(unsorted.length<2){
      return unsorted;
    }
      int pivot = (int) Math.floor(Math.random()*unsorted.length);
      return merge(mergeSort(Arrays.copyOfRange(unsorted,0,pivot)), mergeSort(Arrays.copyOfRange(unsorted,pivot,unsorted.length)));
  }

  public static int[] merge(int[] a, int[] b){
      int[] res = new int[a.length+b.length];
      int aPointer,bPointer;
      aPointer = bPointer = 0;
      for(int i = 0; i<res.length; i++){
        if(bPointer >= b.length || (aPointer < a.length && a[aPointer]<b[bPointer] )){
          res[i]=a[aPointer];
          aPointer++;
        } else {
          res[i]=b[bPointer];
          bPointer++;
        }
    }
    return res;
  }


  public static void main(String[] args){
    System.out.println("Hitta 55:s position i [-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878]");
    int[] arrayen = {-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878};
    System.out.println(binarySearch(arrayen, 55));

    System.out.println("\nHitta 500:s position i [-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878]");
    System.out.println(binarySearch(arrayen, 500));

    System.out.println("\nSortera [54,2,7,9,445,8,9,34,-54,-56,-5,0,1231]");
    int[] mergeArray = {54,2,7,9,445,8,9,34,-54,-56,-5,0,1231};
    for(int i : mergeSort(mergeArray)) System.out.print("   " + i);


  }



}
