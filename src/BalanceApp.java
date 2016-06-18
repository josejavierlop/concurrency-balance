import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BalanceApp {
	public static void main(String[] args) throws InterruptedException, IOException{
		ExecutorService executor = Executors.newFixedThreadPool(50);
		Balance b = new Balance();
		long[] values1 = new long[100];
		long[] values2 = new long[100];
		for(int i = 0; i < 100; i++){
			values1[i] = (long) (Math.random()*100);
			values2[i] = (long) (Math.random()*100);
			System.out.println(values1[i]);
			System.out.println(values2[i]);
		}
		for(int i = 0; i < 100; i++){
			executor.execute(new Deposit(b,values1[i]));
			executor.execute(new Withdraw(b,values2[i]));
		}
		executor.shutdown();
		while(!executor.isTerminated()){
			Thread.sleep(1000);
		}
		b.report(null);
	}
	
	
}

