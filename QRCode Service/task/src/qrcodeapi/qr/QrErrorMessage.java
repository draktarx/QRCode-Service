package qrcodeapi.qr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public record QrErrorMessage(String error) {

    public byte[] createErrorBody() {
        QrErrorMessage errorMessage = new QrErrorMessage(this.error);
        try {
            return new ObjectMapper().writeValueAsBytes(errorMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert error message to JSON", e);
        }
    }

}
