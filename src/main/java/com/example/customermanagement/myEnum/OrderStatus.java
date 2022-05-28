package com.example.customermanagement.myEnum;

public enum OrderStatus {
    DONE(1), NOTDONE(0), UNDEFINE(-2);

    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderStatus of(int value){
        for (OrderStatus status: OrderStatus.values()
        ) {
            if (status.getValue() == value){
                return status;
            }
        }
        return OrderStatus.UNDEFINE;
    }
}
