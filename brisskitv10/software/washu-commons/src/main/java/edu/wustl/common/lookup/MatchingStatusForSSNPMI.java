package edu.wustl.common.lookup;

/**
 * MatchingStatusForSSNPMI enum.
 *
 */
public enum MatchingStatusForSSNPMI
{
	/**
	 * MatchingStatusForSSNPMI enum valueues.
	 */
	EXACT("EXACT"), ONEMATCHOTHERNULL("ONEMATCHOTHERNULL"),ONEMATCHOTHERMISMATCH("ONEMATCHOTHERMISMATCH"), NOMATCH("NOMATCH");

	private String value;

	MatchingStatusForSSNPMI(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

	public static MatchingStatusForSSNPMI toMatchingStatusForSSNPMI(String value) {
		MatchingStatusForSSNPMI result = null;
		if(EXACT.toString().equals(value)){
			result = EXACT;
		}else if(ONEMATCHOTHERNULL.toString().equals(value)){
			result = ONEMATCHOTHERNULL;
		}else if(ONEMATCHOTHERMISMATCH.toString().equals(value)){
			result = ONEMATCHOTHERMISMATCH;
		}else if(NOMATCH.toString().equals(value)){
			result = NOMATCH;
		}
		return result;
	}
}
