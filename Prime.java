import java.util.*;
public class Prime extends Thread {
    private int max_limit;

    public Prime(int max_limit) {
        this.max_limit = max_limit;
    }

    //used the sieve of eratosthenes for efficient solution
    public void SmallerPrimeNumbers() {
        boolean[] prime = new boolean[max_limit + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= max_limit; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= max_limit; j += i)
                    prime[j] = false;
            }
        }
        for (int i = 2; i <= max_limit; i++) {
            if (prime[i]) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number upto which prime numbers have to be found : ");
        int num = sc.nextInt();
        sc.close();
        Prime thread = new Prime(num);//creating thread
        thread.start();//starting thread
        Thread.yield();
        thread.SmallerPrimeNumbers();
    }
}