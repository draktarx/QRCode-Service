package qrcodeapi.qr.services;

import org.springframework.http.ResponseEntity;
import qrcodeapi.qr.QRParams;

import java.io.IOException;

public interface IQRCodeService {

    ResponseEntity<byte[]> getQrCode(QRParams qrParams) throws IOException;

}
