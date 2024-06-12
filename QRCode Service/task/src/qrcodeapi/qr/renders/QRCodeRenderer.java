package qrcodeapi.qr.renders;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Component;
import qrcodeapi.qr.CORRECTION_LEVEL;
import qrcodeapi.qr.QRParams;

import java.awt.image.BufferedImage;
import java.util.Map;

@Component
public class QRCodeRenderer implements IQRCodeRenderer {

    @Override
    public BufferedImage renderQRCode(QRParams qrParams) {
        BufferedImage image = null;

        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, CORRECTION_LEVEL> hints = Map.of(EncodeHintType.ERROR_CORRECTION,
                                                             qrParams.correction());
        try {
            image = MatrixToImageWriter.toBufferedImage(writer.encode(qrParams.contents(),
                                                                      BarcodeFormat.QR_CODE,
                                                                      qrParams.size(),
                                                                      qrParams.size(),
                                                                      hints));
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }

        return image;
    }

}
