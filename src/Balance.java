import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Balance {
	private long balanceAmount = 0;
	private Collection<BalanceMovement> movements = Collections.synchronizedCollection(new ArrayList<>());
	private Lock lock = new ReentrantLock();
	
	public void deposit(long amount){
		try{
			lock.lock();
			System.out.println("deposit: "+amount);
			addMovement(balanceAmount,amount,0);
			balanceAmount +=amount;
		}finally{
			lock.unlock();
		}
	}
	
	public boolean withdraw(long amount){
		try{
			lock.lock();
			if(balanceAmount >= amount){
				System.out.println("withdraw: "+amount);
				addMovement(balanceAmount,0l,amount);
				balanceAmount -=amount;
				return true;
			}else{
				System.out.println("withdraw ERROR");
				return false;
			}
		}finally{
			lock.unlock();
		}
	}
	

	private void addMovement(long balanceAmount, long add, long substract) {
		movements.add(new BalanceMovement(balanceAmount,balanceAmount+add-substract,add,substract,new Date()));
	}

	public void report(final Writer out) throws IOException{
		lock.lock();
		for(BalanceMovement m : movements){
			System.out.print(m.getInitialAmount()+"\t");
			System.out.print(m.getFinalAmount()+"\t");
			System.out.print(m.getDeposited()+"\t");
			System.out.print(m.getWithdrawn()+"\t");
			System.out.print(m.getMovementDate()+"\t\n");
		}
		lock.unlock();
	}
	
}
