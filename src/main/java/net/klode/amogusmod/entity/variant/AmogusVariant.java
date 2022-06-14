package net.klode.amogusmod.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum AmogusVariant {
    RED(0),
    BLUE(1),
    GREEN(2),
    PINK(3),
    ORANGE(4),
    YELLOW(5),
    GRAY(6),
    LILAC(7),
    BLACK(8),
    WHITE(9),
    PURPLE(10),
    BROWN(11),
    CYAN(12),
    LIME(13),
    TAN(14),
    SALMON(15);

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
