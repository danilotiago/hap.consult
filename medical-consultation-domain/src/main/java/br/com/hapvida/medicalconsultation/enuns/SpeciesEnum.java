package br.com.hapvida.medicalconsultation.enuns;

import java.util.HashMap;
import java.util.Map;

public enum SpeciesEnum {

    DOG(1),
    CAT(2),
    COW(3),
    CHICKEN(4),
    HORSE(5),
    TURTLE(6),
    OTHERS(7);

    private Integer code;

    private static final Map<Integer, SpeciesEnum> data = new HashMap<>();

    static {
        for (SpeciesEnum sp : SpeciesEnum.values()) {
            data.put(sp.getCode(), sp);
        }
    }

    private SpeciesEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public static SpeciesEnum get(Integer code) {
        return data.get(code);
    }
}
