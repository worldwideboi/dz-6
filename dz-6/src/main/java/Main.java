import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        dz6(new String[]{"мама", "папа", "їж їж їжак желе"});
    }

    private static void dz6(String[] args) {
        List<String> words = new ArrayList<String>();
        for (String s : args) {
            if (words.size() < 2) {
                String clone = s.replace(" ", "");
                char[] a = clone.toCharArray();
                Set<Character> chars = new HashSet<>();
                int i = 0;
                while (i < a.length) {
                    chars.add(a[i]);
                    i++;
                }
                boolean allCharsPaired = true;
                for (char c : chars) {
                    String test = clone.replace("" + c, "");
                    if ((clone.length() - test.length()) % 2 != 0) {
                        allCharsPaired = false;
                        break;
                    }
                }
                if (!allCharsPaired) continue;
                words.add(s);
            }
        }
        String bigWord = words.get(0) + words.get(1);
        Set<Character> chars = new HashSet<Character>();
        for (char c : bigWord.toCharArray()) {
            chars.add(c);
        }
        System.out.println(words);
        System.out.print("[");
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println("]");
    }
}
