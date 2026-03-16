class Solution {
    public int count(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0 && freq[i] % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}