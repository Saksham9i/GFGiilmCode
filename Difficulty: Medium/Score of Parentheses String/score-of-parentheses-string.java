class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(score);
                score = 0;
            } else {
                int prev = stack.pop();
                score = prev + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}
        
