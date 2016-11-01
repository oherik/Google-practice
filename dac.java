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

  //Quicksort, funkar men tar mycket space, speciellt för uppdelning och merge. Finns inbyggda funktioner? TODO: kolla på det.
  public static int[] quickSort(int[] unsorted){
    if(unsorted.length<2){
      return unsorted;
    }

    int pivotPlace = (int) Math.floor(Math.random()*unsorted.length);
    int pivot = unsorted[pivotPlace];


    int aSize = 0;
    int bSize = 0;
    int midSize = 0;

    for(int i : unsorted){
      if(i<pivot){
        aSize++;
      } else if(i>pivot) {
        bSize++;
      } else {
        midSize++;
      }
    }

    int[] a = new int[aSize];
    int[] b = new int[bSize];
    int[] mid = new int[midSize];
    int aPointer, bPointer, midPointer;
    aPointer = bPointer = midPointer = 0;

    for(int i : unsorted){
      if(i<pivot){
        a[aPointer] = i;
        aPointer++;
      } else if (i>pivot){
        b[bPointer] = i;
        bPointer++;
      } else {
        mid[midPointer] = i;
        midPointer++;
      }
    }

    int[] result = new int[unsorted.length];
    int[] aRes = quickSort(a);
    int[] bRes = quickSort(b);
    for(int i = 0; i<aRes.length; i++){
      result[i] = aRes[i];
    }
    for(int i = 0; i<mid.length; i++){
      result[i+aRes.length] = mid[i];
    }
    for(int i = 0; i<bRes.length; i++){
      result[i+aRes.length+mid.length] = bRes[i];
  }

    return result;

  }

  //Median
  public static int median(int[] input){
    return selection(input, input.length/2);
  }

  //Selection
  public static int selection(int[] input, int k){
      int pivotPlace = (int) Math.floor(Math.random() * input.length);
      int pivot = input[pivotPlace];
      int pivotRank = getRank(input, pivot);
      if (pivotRank==k){
        return pivot;
      }

      int[] removedPivot = new int[input.length-1];
      for(int i = 0; i<pivotPlace; i++){
        removedPivot[i] = input[i];
      }
      for(int i = pivotPlace; i<removedPivot.length; i++){
        removedPivot[i] = input[i+1];
      }

      if(pivotRank<k){
        int[] larger = new int[removedPivot.length-pivotRank];
        int pointer = 0;
        for(int i:removedPivot){
          if(i>=pivot){
            larger[pointer] = i;
            pointer++;
          }
        }
        return selection(larger, k-pivotRank-1); // ty tar bort pivoten, därför -1 TODO fatta det! :D :/ :|
      }
      else{
        int[] smaller = new int[pivotRank];
        int pointer = 0;
        for(int i:removedPivot){
          if(i<pivot){
            smaller[pointer] = i;
            pointer++;
          }
        }
        return selection(smaller, k);
      }
  }

  public static int getRank(int[] input, int x){
      int rank = 0;
      for(int i : input){
        if(i<x){
          rank++;
        }
      }
      return rank;
  }


  public static void main(String[] args){
    System.out.println("Hitta 55:s position i [-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878]");
    int[] arrayen = {-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878};
    System.out.println(binarySearch(arrayen, 55));

    System.out.println("\nHitta 500:s position i [-4,3,4,8,12,54,55,56,122,123,124,125,177,777,878]");
    System.out.println(binarySearch(arrayen, 500));

    System.out.println("\nSortera [54,2,7,9,445,8,9,34,-54,-56,-5,0,1231] med merge sort");
    int[] mergeArray = {54,2,7,9,445,8,9,34,-54,-56,-5,0,1231};
    for(int i : mergeSort(mergeArray)) System.out.print("   " + i);
    System.out.println();

    System.out.println("\nSortera [54,2,7,9,445,8,9,34,-54,-56,-5,0,1231] med quick sort");
    for(int i : quickSort(mergeArray)) System.out.print("   " + i);
    System.out.println();

    System.out.println("\nHitta medianen i [54,2,7,9,445,8,9,34,-54,-56,-5,0,1231] (ska bli 8)");
    System.out.println(median(mergeArray));

    System.out.println("\nHitta minsta värdet, dvs rank 0, i [54,2,7,9,445,8,9,34,-54,-56,-5,0,1231] (ska bli -56)");
    System.out.println(selection(mergeArray,0));

  }



}
