class Solution {
    public int[] createFootpath(int n, int m, int[][] a, int q, int[][] queries) {

        int INF = Integer.MAX_VALUE;

        int[][] tl = new int[n][m];
        int[][] tr = new int[n][m];
        int[][] bl = new int[n][m];
        int[][] br = new int[n][m];

        // Top Left
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = a[i][j];
                if(i>0) val = Math.min(val, tl[i-1][j]);
                if(j>0) val = Math.min(val, tl[i][j-1]);
                tl[i][j] = val;
            }
        }

        // Top Right
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                int val = a[i][j];
                if(i>0) val = Math.min(val, tr[i-1][j]);
                if(j<m-1) val = Math.min(val, tr[i][j+1]);
                tr[i][j] = val;
            }
        }

        // Bottom Left
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                int val = a[i][j];
                if(i<n-1) val = Math.min(val, bl[i+1][j]);
                if(j>0) val = Math.min(val, bl[i][j-1]);
                bl[i][j] = val;
            }
        }

        // Bottom Right
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int val = a[i][j];
                if(i<n-1) val = Math.min(val, br[i+1][j]);
                if(j<m-1) val = Math.min(val, br[i][j+1]);
                br[i][j] = val;
            }
        }

        int[] ans = new int[q];

        for(int k=0;k<q;k++){
            int r = queries[k][0] - 1;
            int c = queries[k][1] - 1;

            int sum = 0;

            // Top Left
            if(r-1 >= 0 && c-1 >= 0)
                sum += tl[r-1][c-1];

            // Top Right
            if(r-1 >= 0 && c+1 < m)
                sum += tr[r-1][c+1];

            // Bottom Left
            if(r+1 < n && c-1 >= 0)
                sum += bl[r+1][c-1];

            // Bottom Right
            if(r+1 < n && c+1 < m)
                sum += br[r+1][c+1];

            ans[k] = sum;
        }

        return ans;
    }
}