package qrcodeapi.qr.mappers;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class QRCodeMapper implements IQRCodeMapper {

    @Override
    public byte[] mapQRCodeToBytes(BufferedImage qrCode,
                                   String type) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(qrCode, type, baos);
            return baos.toByteArray();
        }
    }

}
