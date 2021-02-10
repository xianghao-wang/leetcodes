class Solution_2 {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        k = k - 1; /* 规范k，使k从0开始 */

        boolean reversed = false;
        int sLength = (int) (Math.pow(2, n) + 0.5) - 1;
        while (sLength != 3) {
            if (k == sLength / 2) {
                return reversed ? '0' : '1';
            }

            if (k > sLength / 2) {
                k = sLength / 2 - (k - sLength / 2);
                reversed = !reversed;
            }

            sLength /= 2;
        }

        return (reversed ^ (k >= 1)) ? '1' : '0';
    }
}