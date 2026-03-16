import java.util.*;

class Solution {

    static boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }

    static int countBalanced(String arr[]){

        int prefix = 0;
        int ans = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        for(String s : arr){

            int vowels = 0;
            int cons = 0;

            for(char c : s.toCharArray()){
                if(isVowel(c))
                    vowels++;
                else
                    cons++;
            }

            int diff = vowels - cons;
            prefix += diff;

            if(map.containsKey(prefix))
                ans += map.get(prefix);

            map.put(prefix, map.getOrDefault(prefix,0) + 1);
        }

        return ans;
    }
}