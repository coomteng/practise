import java.util.HashMap;

/** Created by zhouti8 on 2/4/2017. */
public class LongestSubStringWORepeatChar {

  public static String lengthOfLongestSubstring(String s) {
    if (s.length() == 0) {
      return "";
    }
    HashMap<Character, Integer> charMap = new HashMap<>();
    charMap.put(s.charAt(0), 0);
    int lo = 0;
    int hi = 1;
    String result = "";
    int maxLen = 0;
    while (true) {
      int currentMaxLen = hi - lo;
      if (currentMaxLen > maxLen) {
        // update results
        maxLen = currentMaxLen;
        result = s.substring(lo, hi);
      }
      if (hi == s.length()) break;

      char hichar = s.charAt(hi);
      if (charMap.containsKey(hichar)) {
        int oldhi = charMap.get(hichar);
        // remove elements from [lo, oldhi]
        for (int i = lo; i <= oldhi; i++) {
          charMap.remove(s.charAt(i));
        }
        lo = oldhi + 1;
      }

      charMap.put(hichar, hi);
      hi++;
    }
    return result;
  }

  public static void test() {
    String test1 = "eedfababcabcde";
    System.out.println(lengthOfLongestSubstring(test1));
  }
}
