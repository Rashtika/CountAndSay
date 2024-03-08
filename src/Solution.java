import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static String countAndSay(int n) {
        if (n < 1) {
            return "Invalid number";
        }
        String basic = "1";
        if (n == 1) {
            return basic;
        }
        SortedMap<Integer, Integer> parovi = new TreeMap<>();
        ArrayList<String> say = new ArrayList<>();

        char[] charArray = countAndSay(n - 1).toCharArray();
        int[] intArray = new int[charArray.length];
        for (int j = 0; j < intArray.length; j++) {
            intArray[j] = (int) charArray[j] - 48;
        }
        int count = 0;
        for (int t = 0; t<intArray.length-1; t=t+count) {
            count = 1;
            for (int s = 1+t; s<intArray.length; s++) {
                if (intArray[t] == intArray[s]) {
                    count++;
                } else {
                    break;
                }
            }
            parovi.put(intArray[t], count);
            int howMany = parovi.get(intArray[t]);
            say.add(String.valueOf(howMany));
            say.add(String.valueOf(intArray[t]));
        }
        if (intArray.length==1 || (intArray[intArray.length-1] != intArray[intArray.length-2])) {
            parovi.put(intArray[intArray.length-1], 1);
            int howMany = parovi.get(intArray[intArray.length-1]);
            say.add(String.valueOf(howMany));
            say.add(String.valueOf(intArray[intArray.length-1]));
        }
        return String.join("", say);
    }
}
