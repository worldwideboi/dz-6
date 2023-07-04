import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] words = {"мама", "папа", "їж їжак желе"};
        Map<Character, Integer> characterCounts = findCharacterCounts(words);
        System.out.println(characterCounts);
    }

    public static Map<Character, Integer> findCharacterCounts(String[] words) {
        Map<Character, Integer> characterCounts = new HashMap<>();
        int count = 0;

        // Використання циклу for для перебору слів
        for (String word : words) {
            int[] characterCount = new int[26];  // Масив для підрахунку кількості символів
            for (char c : word.toCharArray()) {
                int index = Character.toLowerCase(c) - 'а';  // Індекс символу у масиві
                if (index >= 0 && index < 26) {
                    characterCount[index]++;
                }
            }
            boolean hasEvenCount = true;
            for (int countValue : characterCount) {
                if (countValue % 2 != 0) {
                    hasEvenCount = false;
                    break;
                }
            }
            if (hasEvenCount) {
                // Використання циклу while для знаходження унікальних символів у слові та оновлення кількостей
                int i = 0;
                while (i < word.length()) {
                    char character = word.charAt(i);
                    characterCounts.put(character, characterCounts.getOrDefault(character, 0) + 1);
                    i++;
                }
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        return characterCounts;
    }
}
