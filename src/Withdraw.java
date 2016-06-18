
public class Withdraw implements Runnable{
	Balance b;
	long a;
	public Withdraw(Balance b, long a){
		this.b=b;
		this.a=a;
	}
	@Override
	public void run() {
		b.withdraw(a);
	}
}