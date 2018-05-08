package diploma.com.database;

public enum PaymentState {
    PREPARED("prepared"), SENT("sent");
    private String name;

    PaymentState(String name) {
        this.name = name;
    }

    public static PaymentState getRole(diploma.com.model.PaymentState paymentState) {
        String state = paymentState.getStateName();
        return PaymentState.PREPARED.getName().equals(state) ? PaymentState.PREPARED : PaymentState.SENT;
    }

    public String getName() {
        return this.name;
    }
}