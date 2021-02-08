class Solution_2 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }

        int l = 0, r = 1;
        int ans = arr[0] == arr[1] ? 1 : 2;

        while (r < arr.length - 1) {
            r += 1;

            if (arr[r] == arr[r - 1]) {
                l = r;
                continue;
            }

            int a = arr[r] - arr[r - 1];
            int b = arr[r - 1] - arr[r - 2];

            if (!((a < 0 && b > 0) || (a > 0 && b < 0))) {
                l = r - 1;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}