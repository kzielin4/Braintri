package pl.braintri.company.dtos;

public enum  Operation {
    LIKE("like"), CONTAINS("cont"), EQ(":"), GT(">"), ST("<");

    private final String operation;

    Operation(String text) {
        this.operation = text;
    }

    @Override
    public String toString() {
        return operation;
    }
}
