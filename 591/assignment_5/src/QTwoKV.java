

public class QTwoKV {
	private String UniqueCarrier;
	private String CancellationCode; 

	public QTwoKV(String uc, String cc) {
		this.UniqueCarrier = uc;
		this.CancellationCode = cc;
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
	 * @return the cancellationCode
	 */
	public String getCancellationCode() {
		return CancellationCode;
	}

	/**
	 * @param cancellationCode the cancellationCode to set
	 */
	public void setCancellationCode(String cancellationCode) {
		CancellationCode = cancellationCode;
	}
	
	
}

