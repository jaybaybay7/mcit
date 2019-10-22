

public class DataObj {
	private String DayOfMonth;
	private String DayOfWeek;
	private String FlightDate;
	private String UniqueCarrier;
	private String TailNum;
	private String OriginAirportID;
	private String Origin;
	private String OriginStateName;
	private String DestAirportID;
	private String Dest;
	private String DestStateName;
	private String DepTime;
	private String DepDelay;
	private String WheelsOff;
	private String WheelsOn;
	private String ArrTime;
	private String ArrDelay;
	private String Cancelled;
	private String CancellationCode;
	private String Diverted;
	private String AirTime;
	private String Distance;

	public DataObj(String dom, String dow, String fd, String uc, String tn, String oaid, String org, String osn, 
			String daid, String dest, String dsn, String dtime, String depdelay, String woff, String won, String arrtime,
			String arrdelay, String cancel, String ccode, String divert, String airtime, String dist) {
		
		this.DayOfMonth = dom;
		this.DayOfWeek = dow;
		this.FlightDate = fd;
		this.UniqueCarrier = uc;
		this.TailNum = tn;
		this.OriginAirportID = oaid;
		this.Origin = org;
		this.OriginStateName = osn;
		this.DestAirportID = daid;
		this.Dest = dest;
		this.DestStateName = dsn;
		this.DepTime = dtime;
		this.DepDelay = depdelay;
		this.WheelsOff = woff;
		this.WheelsOn = won;
		this.ArrTime = arrtime;
		this.ArrDelay = arrdelay;
		this.Cancelled = cancel;
		this.CancellationCode = ccode;
		this.Diverted = divert;
		this.AirTime = airtime;
		this.Distance = dist;	
		
	}

	/**
	 * @return the dayOfMonth
	 */
	public String getDayOfMonth() {
		return DayOfMonth;
	}

	/**
	 * @param dayOfMonth the dayOfMonth to set
	 */
	public void setDayOfMonth(String dayOfMonth) {
		DayOfMonth = dayOfMonth;
	}

	/**
	 * @return the dayOfWeek
	 */
	public String getDayOfWeek() {
		return DayOfWeek;
	}

	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(String dayOfWeek) {
		DayOfWeek = dayOfWeek;
	}

	/**
	 * @return the flightDate
	 */
	public String getFlightDate() {
		return FlightDate;
	}

	/**
	 * @param flightDate the flightDate to set
	 */
	public void setFlightDate(String flightDate) {
		FlightDate = flightDate;
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
	 * @return the tailNum
	 */
	public String getTailNum() {
		return TailNum;
	}

	/**
	 * @param tailNum the tailNum to set
	 */
	public void setTailNum(String tailNum) {
		TailNum = tailNum;
	}

	/**
	 * @return the originAirportID
	 */
	public String getOriginAirportID() {
		return OriginAirportID;
	}

	/**
	 * @param originAirportID the originAirportID to set
	 */
	public void setOriginAirportID(String originAirportID) {
		OriginAirportID = originAirportID;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return Origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		Origin = origin;
	}

	/**
	 * @return the originStateName
	 */
	public String getOriginStateName() {
		return OriginStateName;
	}

	/**
	 * @param originStateName the originStateName to set
	 */
	public void setOriginStateName(String originStateName) {
		OriginStateName = originStateName;
	}

	/**
	 * @return the destAirportID
	 */
	public String getDestAirportID() {
		return DestAirportID;
	}

	/**
	 * @param destAirportID the destAirportID to set
	 */
	public void setDestAirportID(String destAirportID) {
		DestAirportID = destAirportID;
	}

	/**
	 * @return the dest
	 */
	public String getDest() {
		return Dest;
	}

	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		Dest = dest;
	}

	/**
	 * @return the destStateName
	 */
	public String getDestStateName() {
		return DestStateName;
	}

	/**
	 * @param destStateName the destStateName to set
	 */
	public void setDestStateName(String destStateName) {
		DestStateName = destStateName;
	}

	/**
	 * @return the depTime
	 */
	public String getDepTime() {
		return DepTime;
	}

	/**
	 * @param depTime the depTime to set
	 */
	public void setDepTime(String depTime) {
		DepTime = depTime;
	}

	/**
	 * @return the depDelay
	 */
	public String getDepDelay() {
		return DepDelay;
	}

	/**
	 * @param depDelay the depDelay to set
	 */
	public void setDepDelay(String depDelay) {
		DepDelay = depDelay;
	}

	/**
	 * @return the wheelsOff
	 */
	public String getWheelsOff() {
		return WheelsOff;
	}

	/**
	 * @param wheelsOff the wheelsOff to set
	 */
	public void setWheelsOff(String wheelsOff) {
		WheelsOff = wheelsOff;
	}

	/**
	 * @return the wheelsOn
	 */
	public String getWheelsOn() {
		return WheelsOn;
	}

	/**
	 * @param wheelsOn the wheelsOn to set
	 */
	public void setWheelsOn(String wheelsOn) {
		WheelsOn = wheelsOn;
	}

	/**
	 * @return the arrTime
	 */
	public String getArrTime() {
		return ArrTime;
	}

	/**
	 * @param arrTime the arrTime to set
	 */
	public void setArrTime(String arrTime) {
		ArrTime = arrTime;
	}

	/**
	 * @return the arrDelay
	 */
	public String getArrDelay() {
		return ArrDelay;
	}

	/**
	 * @param arrDelay the arrDelay to set
	 */
	public void setArrDelay(String arrDelay) {
		ArrDelay = arrDelay;
	}

	/**
	 * @return the cancelled
	 */
	public String getCancelled() {
		return Cancelled;
	}

	/**
	 * @param cancelled the cancelled to set
	 */
	public void setCancelled(String cancelled) {
		Cancelled = cancelled;
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

	/**
	 * @return the diverted
	 */
	public String getDiverted() {
		return Diverted;
	}

	/**
	 * @param diverted the diverted to set
	 */
	public void setDiverted(String diverted) {
		Diverted = diverted;
	}

	/**
	 * @return the airTime
	 */
	public String getAirTime() {
		return AirTime;
	}

	/**
	 * @param airTime the airTime to set
	 */
	public void setAirTime(String airTime) {
		AirTime = airTime;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return Distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		Distance = distance;
	}

}