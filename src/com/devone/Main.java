package com.devone;

public class Main {
    public static String encrypt(String string) {
        byte[] nameBytes = string.getBytes();

        char[][] table = new char[string.length()][string.length()];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (nameBytes[col] >= 97 && nameBytes[col] <= 122) {
                    table[row][col] = (char) (nameBytes[col] + row - 32);
                } else {
                    table[row][col] = (char) (nameBytes[col] + row);
                }
            }
        }

        char[] diagonal = new char[nameBytes.length];

        for (int row = 0; row < table.length; row++) {
            diagonal[row] = table[row][row];
        }

        return new String(diagonal);
    }

    public static String decrypt(String string) {
        byte[] diagonal = string.getBytes();

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < diagonal.length; i++) {
            byte bt = diagonal[i];
            char chr = (char)(bt - i);

            decrypted.append(chr);
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {
        String encrypted = encrypt("Marcos");
        String decrypted = decrypt(encrypted);

        System.out.println(encrypted);
        System.out.println(decrypted);
    }
}