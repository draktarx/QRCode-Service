package qrcodeapi.qr.renders;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;
import qrcodeapi.qr.QRParams;

import java.awt.image.BufferedImage;

@Component
public class QRCodeRenderer implements IQRCodeRenderer {

    @Override
    public BufferedImage renderQRCode(QRParams qrParams) {
        BufferedImage image = null;

        QRCodeWriter writer = new QRCodeWriter();
        try {
            image = MatrixToImageWriter.toBufferedImage(writer.encode(qrParams.contents(),
                                                                      BarcodeFormat.QR_CODE,
                                                                      qrParams.size(),
                                                                      qrParams.size()));
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }

        return image;
    }

}
