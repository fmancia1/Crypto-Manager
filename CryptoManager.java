import java.util.Scanner;

public class CryptoManager {
	
  	public static boolean stringInBounds (String plainText) {
      	boolean flag = true;
		char LOWER_BOUND = 'A';
		char UPPER_BOUND = 'Z';
	  	for (int i = 0; i < plainText.length(); i++) {
          	char ch = plainText.charAt(i);
        	if (ch < LOWER_BOUND || ch > UPPER_BOUND) {
            	 flag = false;
            	 break;
            }
        }
      	return flag;
	}
  
    public static String encryptCaesar(String plainText, int key) {
        String encryptedMessage = "";
        char ch;
        for(int i = 0; i < plainText.length(); ++i) {
            ch = plainText.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch + key);
                if(ch > 'Z'){
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }

                encryptedMessage += ch;
            }
            else {
                encryptedMessage += ch;
            }
        }
        return encryptedMessage;
    }

    public static String decryptCaesar(String encryptedText, int key) {
        String decryptedMessage = "";
        //int key;
        for(int i = 0; i < encryptedText.length(); ++i){
            char ch = encryptedText.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch - key);

                if(ch < 'A'){
                    ch = (char)(ch + 'A' - 'Z' + 1);
                }

                decryptedMessage += ch;
            }
            else {
                decryptedMessage += ch;
            }
        }

        return decryptedMessage;

    }
    public static String encryptBellaso(String plainText, String bellasoStr) {
        int keylength = bellasoStr.length();
        int k = 0;
        String encryptedMessage = "";
        for(int i = 0; i < plainText.length(); ++i) {
            char ch = plainText.charAt(i);
      		if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch + bellasoStr.charAt(k) - 'A');
                k += 1;
                if (k == keylength) {
                    k=0;
                }
                if(ch  > 'Z') {
                    ch = (char)(ch - 'Z' + 'A' - 1);
                }

                encryptedMessage += ch;
            }
            else {
                encryptedMessage += ch;
            }
         }
      return encryptedMessage;
    }
  
    public static String decryptBellaso(String encryptedText, String bellasoStr) {
        int keylength = bellasoStr.length();
        int k= 0;
        String decryptedMessage = "";
        for(int i = 0; i < encryptedText.length(); ++i) {
            char ch;
            ch = encryptedText.charAt(i);
      		if(ch >= 'A' && ch <= 'Z') {
                ch = (char)(ch - bellasoStr.charAt(k) + 'A');
                k += 1;
                if (k == keylength) {
                    k=0;
                }
                if(ch < 'A'){
                    ch = (char)(ch + 'A' - 'Z' + 1);
                }

                decryptedMessage += ch;
            }
            else {
                decryptedMessage += ch;
            }
         }
      return decryptedMessage;
    }
  
    public static void main(String...s) {
        String encrypted = encryptCaesar("THIS IS ANOTHER TEST", 2);
        System.out.println(encrypted);
        String decrypted = decryptCaesar(encrypted, 2);
        System.out.println(decrypted);
        encrypted = encryptBellaso("THIS IS ANOTHER TEST", "HELLO");
        System.out.println(encrypted);
        decrypted = decryptBellaso(encrypted, "HELLO");
        System.out.println(decrypted);
        System.out.println("PROGRAMMER'S NAME: FATIMA MANCIA");
    }
}



