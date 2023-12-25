package com.injob.back.enums;

public enum JobApplyStatusEnum {
    ACCEPTED("Accepté"),
    PENDING("En attente"),
    REJECTED("Rejeté");

    private final String value;

    JobApplyStatusEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
