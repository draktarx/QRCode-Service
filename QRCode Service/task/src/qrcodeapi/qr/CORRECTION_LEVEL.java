package qrcodeapi.qr;

public enum CORRECTION_LEVEL {
    L,
    M,
    Q,
    H,
    NOT_SUPPORTED;

    public static CORRECTION_LEVEL parse(String str) {
        return switch (str.toUpperCase()) {
            case "L" -> L;
            case "M" -> M;
            case "Q" -> Q;
            case "H" -> H;
            default -> NOT_SUPPORTED;
        };
    }
}
