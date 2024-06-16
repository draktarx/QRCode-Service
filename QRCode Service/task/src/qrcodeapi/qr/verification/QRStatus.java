package qrcodeapi.qr.verification;

public enum QRStatus {
    VALID(1, ""),
    SIZE_OUT_OF_BOUNDS(2,"Image size must be between 150 and 350 pixels"),
    MEDIATYPE_NOT_SUPPORTED(1,"Only png, jpeg and gif image types are supported"),
    CONTENT_EMPTY(3,"Contents cannot be null or blank");

    private final Integer priority;
    private final String errorMessage;

    QRStatus(Integer priority, String errorMessage) {
        this.priority = priority;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getPriority() {
        return priority;
    }
}
