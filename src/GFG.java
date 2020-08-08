// Java program to build the smallest number
// by removing n digits from a given number
class GFG
{

  // class variable is used because Java is
  // strictly pass by value so "wrapper won't work"
  // as res is passed by reference
  static String res = "";

  // A recursive function that removes
  // 'n' characters from 'str' to store
  // the smallest possible number in 'res'
  static void buildLowestNumberRec(String str, int n)
  {

    // If there are 0 characters to remove from str,
    // append everything to result
    if (n == 0)
    {
      res.concat(str);
      return;
    }

    int len = str.length();

    // If there are more characters to
    // remove than string length,
    // then append nothing to result
    if (len <= n)
      return;

    // Find the smallest character among
    // first (n+1) characters of str.
    int minIndex = 0;
    for (int i = 1; i <= n; i++)
      if (str.charAt(i) < str.charAt(minIndex))
        minIndex = i;

    // Append the smallest character to result
    res += str.charAt(minIndex);

    // substring starting from
    // minIndex+1 to str.length() - 1.
    String new_str = str.substring(minIndex + 1);

    // Recur for the above substring
    // and n equals to n-minIndex
    buildLowestNumberRec(new_str, n - minIndex);
  }

  // Driver Code
  public static void main(String[] args)
  {
    String str = "4325043";
    int n = 3;
    buildLowestNumberRec(str, n);
    System.out.println(res);
  }
}

// This code is contributed by
// sanjeev2552
