//Java implementation to count number of
// increasing subsequences of size k
package com.eos.test;

class Test {

  public static void main(String[] args) {
    String s = "abcde";
    s=swap(1, 3, s.toCharArray());
    System.out.println(s);

  }

  private static String swap(int i, int j, char[] chars) {
    char temp = chars[i];
    chars[i] = chars[j];
    chars[j] = temp;
    return String.valueOf(chars);
  }
}





