class Solution {
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] time = new int[n];

        // Convert time to seconds
        for (int i = 0; i < n; i++) {
            String[] parts = arr[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);

            time[i] = h * 3600 + m * 60 + s;
        }

        Arrays.sort(time);

        int minDiff = Integer.MAX_VALUE;

        // Check consecutive differences
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, time[i] - time[i - 1]);
        }

        // Check circular difference (midnight wrap)
        minDiff = Math.min(minDiff, 86400 - time[n - 1] + time[0]);

        return minDiff;
    }
}

