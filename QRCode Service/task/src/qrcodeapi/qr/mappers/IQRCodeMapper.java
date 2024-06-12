package qrcodeapi.qr.mappers;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface IQRCodeMapper {

    byte[] mapQRCodeToBytes(BufferedImage qrCode, String type) throws IOException;

}
