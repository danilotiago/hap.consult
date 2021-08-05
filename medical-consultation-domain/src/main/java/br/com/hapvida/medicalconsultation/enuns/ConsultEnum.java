package br.com.hapvida.medicalconsultation.enuns;

import java.util.HashMap;
import java.util.Map;

public enum ConsultEnum {

    SCHEDULED(1),
    DONE(2),
    CANCELED(3);

    private Integer code;

    private static final Map<Integer, ConsultEnum> data = new HashMap<>();

    static {
        for (ConsultEnum sp : ConsultEnum.values()) {
            data.put(sp.getCode(), sp);
        }
    }

    private ConsultEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public static ConsultEnum get(Integer code) {
        return data.get(code);
    }
}
