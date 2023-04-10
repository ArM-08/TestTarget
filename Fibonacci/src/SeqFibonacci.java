import java.util.Scanner;

public class SeqFibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite um número: ");
	    int num = input.nextInt();
	    int fib1 = 0;
	    int fib2 = 1;
	    boolean pertence = false;
	    
	    while (fib2 <= num) {

	        if (fib2 == num) {
	            pertence = true;
	            break;
	        }
	        int temp = fib2;
	        fib2 = fib1 + fib2;
	        fib1 = temp;
	    }
	    int[] fibonacci = {0, 1};
	    while (fibonacci[fibonacci.length - 1] < num) {
	        int[] temp = new int[fibonacci.length + 1];
	        for (int i = 0; i < fibonacci.length; i++) {
	            temp[i] = fibonacci[i];
	        }
	        temp[temp.length - 1] = temp[temp.length - 2] + temp[temp.length - 3];
	        fibonacci = temp;
	    }
	    System.out.print("Sequência de Fibonacci até " + num + ": ");
	    for (int i = 0; i < fibonacci.length - 1; i++) {
	        System.out.print(fibonacci[i] + " ");
	    }
	    System.out.println();

	    if (pertence) {
	        System.out.println(num + " pertence à sequência de Fibonacci.");
	    } else {
	        System.out.println(num + " não pertence à sequência de Fibonacci.");
	    }
	    input.close();
	}

	}

