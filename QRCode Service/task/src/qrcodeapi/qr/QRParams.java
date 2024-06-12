package qrcodeapi.qr;

public record QRParams(Integer size,
                       String type,
                       String contents,
                       CORRECTION_LEVEL correction) {

}
