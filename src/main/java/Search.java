public class Search {
    public static int kmp(String str, String pattern) {
        int j = 0; // Index in str
        int k = 0; // Index in pattern
        int[] kmpTable = generateKMPTable(pattern);
        while (j < str.length()) {
            if (pattern.charAt(k) == str.charAt(j)) {
                j++;
                k++;
                if (k == pattern.length()) {
                    return j - k;
                }
            } else {
                k = kmpTable[k];
                if (k < 0) {
                    j++;
                    k++;
                }
            }
        }

        return -1;
    }

    private static int[] generateKMPTable(String pattern) {
        int[] kmpTable = new int[pattern.length() + 1];
        int i = 1;
        int j = 0;
        kmpTable[0] = -1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                kmpTable[i] = kmpTable[j];
            } else {
                kmpTable[i] = j;
                j = kmpTable[j];
                while (j >= 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = kmpTable[j];
                }
            }

            i++;
            j++;
        }

        kmpTable[i] = j;
        return kmpTable;
    }
}
