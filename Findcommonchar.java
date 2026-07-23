public class Findcommonchar {
    public List<String> commonChars(String[] words) {

        List<String> ans = new ArrayList<>();
        int[] minCount = new int[26];

        // Initialize with a large value
        for (int i = 0; i < 26; i++) {
            minCount[i] = 100;
        }

        // Check each word
        for (int i = 0; i < words.length; i++) {

            int[] count = new int[26];

            // Count letters in the current word
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                count[ch - 'a']++;
            }

            // Store the minimum count
            for (int k = 0; k < 26; k++) {
                if (count[k] < minCount[k]) {
                    minCount[k] = count[k];
                }
            }
        }

        // Add common letters to the answer
        for (int i = 0; i < 26; i++) {
            while (minCount[i] > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
                minCount[i]--;
            }
        }

        return ans;
    }
}