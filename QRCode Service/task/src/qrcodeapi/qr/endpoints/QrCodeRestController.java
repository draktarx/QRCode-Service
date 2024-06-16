package qrcodeapi.qr.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.qr.QRParams;
import qrcodeapi.qr.services.QRCodeService;
import qrcodeapi.qr.verification.IQRCodeVerifier;
import qrcodeapi.qr.verification.QRStatus;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class QrCodeRestController {

    private final QRCodeService qrCodeService;
    private final IQRCodeVerifier qrCodeVerifier;

    @Autowired
    public QrCodeRestController(QRCodeService qrCodeService,
                                IQRCodeVerifier qrCodeVerifier) {
        this.qrCodeService = qrCodeService;
        this.qrCodeVerifier = qrCodeVerifier;
    }

    @GetMapping(value = "/qrcode",
            produces = {MediaType.IMAGE_PNG_VALUE,
                    MediaType.IMAGE_JPEG_VALUE,
                    MediaType.IMAGE_GIF_VALUE})
    public ResponseEntity<byte[]> getQrCode(@RequestParam Integer size,
                                       @RequestParam String type, @RequestParam String contents) throws IOException {
        return qrCodeService.getQrCode(new QRParams(size, type, contents));
    }

}
