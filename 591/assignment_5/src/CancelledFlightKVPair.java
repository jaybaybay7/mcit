
public class CancelledFlightKVPair {
	private String UniqueCarrier;
	private int Cancelled; 
	
	public CancelledFlightKVPair(String uc, int cancelled) {
		this.UniqueCarrier = uc;
		this.Cancelled = cancelled;
	}

	/**
	 * @return the uniqueCarrier
	 */
	public String getUniqueCarrier() {
		return UniqueCarrier;
	}

	/**
	 * @param uniqueCarrier the uniqueCarrier to set
	 */
	public void setUniqueCarrier(String uniqueCarrier) {
		UniqueCarrier = uniqueCarrier;
	}

	/**
	 * @return the cancelled
	 */
	public int getCancelled() {
		return Cancelled;
	}

	/**
	 * @param cancelled the cancelled to set
	 */
	public void setCancelled(int cancelled) {
		Cancelled = cancelled;
	}
	
	
}
