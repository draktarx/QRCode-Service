package qrcodeapi.qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import qrcodeapi.qr.QRParams;
import qrcodeapi.qr.QrErrorMessage;
import qrcodeapi.qr.mappers.IQRCodeMapper;
import qrcodeapi.qr.renders.IQRCodeRenderer;
import qrcodeapi.qr.verification.IQRCodeVerifier;
import qrcodeapi.qr.verification.QRStatus;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class QRCodeService implements IQRCodeService {

    private final IQRCodeRenderer qrCodeRenderer;

    private final IQRCodeMapper qrCodeMapper;

    private final IQRCodeVerifier qrCodeVerifier;

    @Autowired
    public QRCodeService(IQRCodeRenderer qrCodeRenderer,
                         IQRCodeMapper qrCodeMapper,
                         IQRCodeVerifier qrCodeVerifier) {
        this.qrCodeRenderer = qrCodeRenderer;
        this.qrCodeMapper = qrCodeMapper;
        this.qrCodeVerifier = qrCodeVerifier;
    }

    @Override
    public ResponseEntity<byte[]> getQrCode(QRParams qrParams) throws IOException {
        QRStatus qrStatus = qrCodeVerifier.verify(qrParams);
        return switch (qrStatus) {
            case VALID -> buildQrCodeResponse(qrParams);
            case SIZE_OUT_OF_BOUNDS, MEDIATYPE_NOT_SUPPORTED, CONTENT_EMPTY, CORRECTION_LEVEL_NOT_SUPPORTED ->
                    buildBadRequestResponse(qrStatus);
        };
    }

    private ResponseEntity<byte[]> buildBadRequestResponse(QRStatus qrStatus) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new QrErrorMessage(qrStatus.getErrorMessage()).createErrorBody());
    }

    private ResponseEntity<byte[]> buildQrCodeResponse(QRParams qrParams) throws IOException {
        BufferedImage qrCode = qrCodeRenderer.renderQRCode(qrParams);
        byte[] qrCodeBytes = qrCodeMapper.mapQRCodeToBytes(qrCode, qrParams.type());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("image/" + qrParams.type()));
        return new ResponseEntity<>(qrCodeBytes, headers, HttpStatus.OK);
    }

}

