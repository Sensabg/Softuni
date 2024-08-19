package hotelreservation;

enum Season {
    AUTUMN(1, "Autumn"),
    SPRING(2, "Spring"),
    WINTER(3, "Winter"),
    SUMMER(4, "Summer");

    private final int multiplier;
    private final String season;

    Season(int multiplier, String friendlyName) {
        this.multiplier = multiplier;
        this.season = friendlyName;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public String getSeason() {
        return season;
    }

    public static Season parseString(String season) {
        return switch (season) {
            case "Autumn" -> AUTUMN;
            case "Spring" -> SPRING;
            case "Winter" -> WINTER;
            case "Summer" -> SUMMER;
            default -> throw new IllegalArgumentException(String.format("%s not a season!", season));
        };
    }
}