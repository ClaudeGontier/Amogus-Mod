package net.klode.amogusmod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum AmogusVariant {
    RED(0),
    GREEN(1),
    BLUE(2);

    private static final AmogusVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(AmogusVariant::getId)).toArray(AmogusVariant[]::new);
    private final int id;

    AmogusVariant(int p_30984_) {
        this.id = p_30984_;
    }

    public int getId() {
        return this.id;
    }

    public static AmogusVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
