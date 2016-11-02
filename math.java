public class math{

  //Order doesn't matter: combination
  public static int combinations(int n, int k){
    if(n==0  || k == 0 || k == n){
      return 1;
    }
    return combinations(n-1,k) + combinations(n-1,k-1);
  }

  //Order matters: permutations. Per muterar, då bryr han sig väldigt mycket om ordningen!
  public static int permutations(int n, int r){
    if(n==0){
      return 1;
    }
    if(n == r){
      return n*permutations(n-1,n-1);
    }
    return n*permutations(n-1, r)/(n-r);

  }


  public static void main(String[] args){
    System.out.println("Testa permutation: P(10,2), ska bli 90");
    System.out.println(permutations(10,2));
    System.out.println();

    System.out.println("Testa kombination: C(10,2), ska bli 45");
    System.out.println(combinations(10,2));
    System.out.println();

  }
}
