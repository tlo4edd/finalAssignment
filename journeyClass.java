public class journeyClass {
	private String startPos;
	private String endPos;
	private String time;
	private String obstacles; // journey class fields
	private String security;

	public journeyClass(String pStartPos, String pEndPos, String pTime, String pObstacles, String pSecurity) {
		startPos = pStartPos;
		endPos = pEndPos;
		time = pTime;
		obstacles = pObstacles;
		security = pSecurity; // constructor
	}

	public journeyClass() {
		startPos = null;
		endPos = null; // default constructor
		time = null;
		obstacles = null;
		security = null;
	}

	public String getStart() {
		return startPos;
	}

	public String getEnd() {
		return endPos;
	}

	public String getTime() {
		return time;
	}

	public String getObstacles() {
		return obstacles;
	}

	public String getSecurity() { // getters
		return security;
	}

	public void setStart(String pStart) {
		startPos = pStart; // setters
	}

	public void setEnd(String pEnd) {
		endPos = pEnd;
	}

	public void setTime(String pTime) {
		time = pTime;
	}

	public void setObstacles(String pObstacles) {
		obstacles = pObstacles;
	}

	public void setSecurity(String pSecurity) {
		security = pSecurity;
	}

	public String toString() {
		String x = ("From " + startPos + " To " + endPos + " Time is " + time + " Avoid " + obstacles
				+ " Security level is " + security);	//tostring method
		return x;
	}

}
