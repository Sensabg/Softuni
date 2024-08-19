package hotelreservation;

enum DiscountType {
    VIP(20, "VIP"),
    SECOND_VISIT(10, "SecondVisit"),
    NONE(0, "None");

    private final int discountPercentage;
    private final String status;

    DiscountType(int discountPercentage, String status) {
        this.discountPercentage = discountPercentage;
        this.status = status;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public String getClientStatus() {
        return status;
    }
    public static DiscountType parseString(String status) {
        return switch (status) {
            case "VIP" -> VIP;
            case "SecondVisit" -> SECOND_VISIT;
            case "None" -> NONE;
            default -> throw new IllegalArgumentException(String.format("%s not a valid status!", status));
        };
    }

}