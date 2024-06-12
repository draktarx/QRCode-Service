package qrcodeapi.qr.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.qr.CORRECTION_LEVEL;
import qrcodeapi.qr.QRParams;
import qrcodeapi.qr.services.QRCodeService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class QrCodeRestController {

    private final QRCodeService qrCodeService;

    @Autowired public QrCodeRestController(QRCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @GetMapping(value = "/qrcode", produces = {
            MediaType.IMAGE_PNG_VALUE,
            MediaType.IMAGE_JPEG_VALUE,
            MediaType.IMAGE_GIF_VALUE}
    )
    public ResponseEntity<byte[]> getQrCode(
            @RequestParam(required = false, defaultValue = "250") Integer size,
            @RequestParam(required = false, defaultValue = "png") String type,
            @RequestParam String contents,
            @RequestParam(required = false, defaultValue = "L") String correction)
            throws IOException
    {
        return qrCodeService.getQrCode(new QRParams(size,
                                                    type,
                                                    contents,
                                                    CORRECTION_LEVEL.parse(correction)));
    }

}
