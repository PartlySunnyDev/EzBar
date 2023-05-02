package me.partlysunny.ezbar;

public enum ServerVersion {

    v1_12_R1,
    v1_13_R1,
    v1_13_R2,
    v1_14_R1,
    v1_15_R1,
    v1_16_R1,
    v1_16_R2,
    v1_16_R3,
    v1_17_R1,
    v1_18_R1,
    v1_18_R2,
    v1_19_R1,
    v1_19_R2,
    v1_19_R3
    ;

    public static ServerVersion getServerVersion() {
        String version = org.bukkit.Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return ServerVersion.valueOf(version);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Your server version isn't supported by EzBar!");
        }
    }

    public static boolean isHigherThan(ServerVersion version) {
        return getServerVersion().ordinal() > version.ordinal();
    }

    public static boolean isHigherOrEqual(ServerVersion version) {
        return getServerVersion().ordinal() >= version.ordinal();
    }

    public static boolean isLowerThan(ServerVersion version) {
        return getServerVersion().ordinal() < version.ordinal();
    }

    public static boolean isLowerOrEqual(ServerVersion version) {
        return getServerVersion().ordinal() <= version.ordinal();
    }

    public static boolean is(ServerVersion version) {
        return getServerVersion().ordinal() == version.ordinal();
    }

    public static boolean isNot(ServerVersion version) {
        return getServerVersion().ordinal() != version.ordinal();
    }

    public static boolean isBetween(ServerVersion min, ServerVersion max) {
        return getServerVersion().ordinal() >= min.ordinal() && getServerVersion().ordinal() <= max.ordinal();
    }

    public static boolean isHigherThan(String version) {
        return getServerVersion().ordinal() > ServerVersion.valueOf(version).ordinal();
    }

    public static boolean isHigherOrEqual(String version) {
        return getServerVersion().ordinal() >= ServerVersion.valueOf(version).ordinal();
    }

    public static boolean isLowerThan(String version) {
        return getServerVersion().ordinal() < ServerVersion.valueOf(version).ordinal();
    }

    public static boolean isLowerOrEqual(String version) {
        return getServerVersion().ordinal() <= ServerVersion.valueOf(version).ordinal();
    }
}
