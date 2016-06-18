import java.util.Date;

public class BalanceMovement {
	private long initialAmount = 0;
	private long finalAmount = 0;
	private long deposited = 0;
	private long withdrawn = 0;
	
	private Date movementDate = null;

	public BalanceMovement(long initialAmount, long finalAmount, long deposited, long withdrawn, Date movementDate) {
		super();
		this.initialAmount = initialAmount;
		this.finalAmount = finalAmount;
		this.deposited = deposited;
		this.withdrawn = withdrawn;
		this.movementDate = movementDate;
	}

	public long getInitialAmount() {
		return initialAmount;
	}

	public long getFinalAmount() {
		return finalAmount;
	}

	public long getDeposited() {
		return deposited;
	}

	public long getWithdrawn() {
		return withdrawn;
	}

	public Date getMovementDate() {
		return movementDate;
	}
	
}
