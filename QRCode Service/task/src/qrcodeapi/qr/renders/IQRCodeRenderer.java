package qrcodeapi.qr.renders;

import qrcodeapi.qr.QRParams;

import java.awt.image.BufferedImage;

public interface IQRCodeRenderer {

    BufferedImage renderQRCode(QRParams qrParams);

}
