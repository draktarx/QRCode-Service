package qrcodeapi.qr.verification;

import qrcodeapi.qr.QRParams;

public interface IQRCodeVerifier {

    QRStatus verify(QRParams qrParams);

}
