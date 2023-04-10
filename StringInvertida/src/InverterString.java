import java.util.Scanner;


public class InverterString {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Digite uma palavra: ");
        String original = sc.nextLine();
        sc.close();
        String invertida = inverteString(original);
        System.out.println(invertida);
    }
    
    public static String inverteString(String original) {
        char[] chars = original.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }
}