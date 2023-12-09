package com.kriptografi.demo;

public class VignereCipher {

    private String plaintext;
    private String ciphertext;
    private String key;

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    // This function generates the key in
    // a cyclic manner until it's length isi'nt
    // equal to the length of original text
    String generateKey(String plaintext, String key) {
        int x = plaintext.length();

        for (int i = 0;; i++) {
            if (x == i)
                i = 0;
            if (key.length() == plaintext.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    // This function returns the encrypted text
    // generated with the help of the key
    String cipherText(String plaintext, String key) {
        String cipher_text = "";

        for (int i = 0; i < plaintext.length(); i++) {
            // converting in range 0-25
            int x = (plaintext.charAt(i) + key.charAt(i)) % 26;

            // convert into alphabets(ASCII)
            x += 'A';

            cipher_text += (char) (x);
        }
        return cipher_text;
    }

    // This function decrypts the encrypted text
    // and returns the original text
    String originalText(String cipher_text, String key) {
        String orig_text = "";
        int keyLength = key.length();

        for (int i = 0; i < cipher_text.length(); i++) {
            // repeating the key if it's shorter than the ciphertext
            char keyChar = key.charAt(i % keyLength);

            // converting in range 0-25
            int x = (cipher_text.charAt(i) - keyChar + 26) % 26;

            // convert into alphabets(ASCII)
            x += 'A';
            orig_text += (char) (x);
        }

        return orig_text;
    }

    // This function will convert the lower case character to Upper case
    static String LowerToUpper(String s) {
        StringBuffer plaintext = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                plaintext.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = plaintext.toString();
        return s;
    }

    @Override
    public String toString() {
        return "CipherData{" +
                "plaintext='" + plaintext + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
