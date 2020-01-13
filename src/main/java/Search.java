public class Search {
    public static int rabinKarp(String str, String pattern) {
        final int PRIME = 9973;
        int patternHash = 0;
        int strHash = 0;
        int h = 1;
        for (int i = 0; i < pattern.length() - 1; i++) {
            h = (h * 256) % PRIME;
        }

        for (int i = 0; i < pattern.length(); i++) {
            patternHash = (256 * patternHash + pattern.charAt(i)) % PRIME;
            strHash = (256 * strHash + str.charAt(i)) % PRIME;
        }

        for (int i = 0; i <= str.length() - pattern.length(); i++) {
            if (patternHash == strHash) {
                for (int j = 0; j < pattern.length(); j++) {
                    if (str.charAt(i + j) == pattern.charAt(j)) {
                        break;
                    }
                }

                return i;
            }

            if (i < str.length() - pattern.length()) {
                strHash = (256 * (strHash - str.charAt(i) * h) + str.charAt(i + pattern.length())) % PRIME;

                if (strHash < 0) {
                    strHash += PRIME;
                }
            }
        }

        return -1;
    }

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
