import java.util.*;
class Fibonacci extends Thread {
    private int[] fibonacci;
    private int n;

    public Fibonacci(int n, int[] arr) {
        this.fibonacci = arr;
        this.n = n;
    }

    //dynamic programming based iterative solution
    public void run() {
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++)
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of fibonacci numbers to be generated : ");
        int n = sc.nextInt();
        sc.close();
        int[] arr = new int[n];
        Fibonacci thread = new Fibonacci(n, arr); // creating thread
        thread.start(); // starting thread
        //using the try-catch because join() can throw Interrupted Exception
        try {
            thread.join(); // waiting for child thread to finish
        } catch (InterruptedException ie) {
            //We can ignore the InterruptedException error
        }
        for (int i = 0; i < n; i++)
            System.out.print(String.valueOf(arr[i]) + ' ');
    }
}


