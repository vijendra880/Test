// Java program to check whether a given array
// represents a max-heap or not


class Test {

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.numSquares(12));
    }

    public int numSquares(int n) {
        int[] mem = new int[n + 1];
        mem[1] = 1;
        mem[0] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            boolean isUpdated = false;
            for (int j = 1; j <= i / 2; j++) {
                if (j * j == i) {
                    mem[i] = 1;
                    isUpdated = true;
                    break;
                } else {
                    min = Math.min(min, mem[j] + mem[i - j]);
                }
            }
            if (!isUpdated) {
                mem[i] = min;
            }
        }
        return mem[n];
    }


}






