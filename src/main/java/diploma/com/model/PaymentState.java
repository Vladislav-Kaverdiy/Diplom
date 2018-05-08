package diploma.com.model;

public class PaymentState {
	private int stateId;
	private String stateName;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "PaymentState [stateId=" + stateId + ", stateName=" + stateName
				+ "]";
	}

}
