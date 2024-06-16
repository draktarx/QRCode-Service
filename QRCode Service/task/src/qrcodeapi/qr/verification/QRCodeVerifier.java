package qrcodeapi.qr.verification;

import org.springframework.stereotype.Component;
import qrcodeapi.qr.QRParams;
import qrcodeapi.qr.services.ImageFormat;

import java.util.*;

@Component
public class QRCodeVerifier implements IQRCodeVerifier {

    private static final Integer MIN_SIZE = 150;

    private static final Integer MAX_SIZE = 350;

    @Override
    public QRStatus verify(QRParams qrParams) {
        List<QRStatus> list = new ArrayList<>();
        if (sizeOutOfBounds(qrParams)) {
            list.add(QRStatus.SIZE_OUT_OF_BOUNDS);
        }
        if (!isImageFormatSupported(qrParams.type())) {
            list.add(QRStatus.MEDIATYPE_NOT_SUPPORTED);
        }
        if (contentIsEmpty(qrParams.contents()))
            list.add(QRStatus.CONTENT_EMPTY);
        if (list.isEmpty())
            return QRStatus.VALID;
        else {
            return list.stream()
                       .max(Comparator.comparing(QRStatus::getPriority))
                       .orElseThrow(() -> new IllegalStateException("No QRStatus found"));
        }
    }

    private boolean contentIsEmpty(String contents) {
        return contents.isBlank() || contents.isEmpty();
    }

    private static boolean sizeOutOfBounds(QRParams qrParams) {
        return Objects.isNull(qrParams.size()) ||
               Objects.isNull(qrParams.type()) ||
               !isSizeInRange(qrParams.size());
    }

    private static boolean isSizeInRange(Integer size) {
        return MIN_SIZE <= size && size <= MAX_SIZE;
    }

    private static boolean isImageFormatSupported(String type) {
        return Arrays.stream(ImageFormat.values())
                     .anyMatch(format -> format.name().equalsIgnoreCase(type));
    }

}
