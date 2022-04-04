class RecursionFactorial {
  public int factorial(int n) {
    if (n<1) {
      return -1;
    }
    if (n==0 || n==1) {
      return 1;
    }
    return n * factorial(n-1);
  }

  public static void main(String[] args) {
    RecursionFactorial recursion = new RecursionFactorial();
    var rec = recursion.factorial(-2);
    System.out.println(rec);
  }




}
