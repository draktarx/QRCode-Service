package qrcodeapi.health.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    public ResponseEntity<String> check() {
        return new ResponseEntity<>("Service is operational", HttpStatus.OK);
    }

}
