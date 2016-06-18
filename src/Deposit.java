
public class Deposit implements Runnable{
	Balance b;
	long a;
	public Deposit(Balance b, long a){
		this.b=b;
		this.a=a;
	}
	@Override
	public void run() {
		b.deposit(a);
	}
}