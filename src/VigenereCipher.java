public class VigenereCipher {
    private String alphabet;
    private String key;
    public VigenereCipher(String key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }
    public String getKey() { return key; }

    public String getAlphabet() { return alphabet; }
    public String encode(String text) {
        String newString = "";
        for (int i=0; i<text.length(); i++) {
            char shift = key.charAt(i % key.length());;

            // Check if it is in alphabet
            boolean flag = false;
            for (int j=0; j<52; j++) {
                if (alphabet.charAt(j) == text.charAt(i)) flag = true;
            }
            if (!flag) {
                newString += text.charAt(i);
                continue;
            }

            // Convert to encoded
            if ((text.charAt(i) + shift - 'a') > 'z') {
                char added = (char) (text.charAt(i) + shift - 'a');
                while (added > 'z') {
                    added -= 26;
                }
                newString += (char) added;
            }
            else { newString += (char) (text.charAt(i) + shift - 'a'); }
        }
        return newString;
    }

    public String decode(String text) {
        String newString = "";
        for (int i=0; i<text.length(); i++) {
            char shift = key.charAt(i % key.length());;

            // Check if it is in alphabet
            boolean flag = false;
            for (int j=0; j<52; j++) {
                if (alphabet.charAt(j) == text.charAt(i)) flag = true;
            }
            if (flag == false) {
                newString += text.charAt(i);
                continue;
            }

            // Convert to decoded
            if ((text.charAt(i) - (shift - 'a')) < 'a') {
                char added = (char) (text.charAt(i) - (shift - 'a'));
                while (added < 'a') {
                    added += 26;
                }
                newString += (char) added;
            }
            else { newString += (char) (text.charAt(i) - (shift - 'a')); }
        }
        return newString;
    }
}