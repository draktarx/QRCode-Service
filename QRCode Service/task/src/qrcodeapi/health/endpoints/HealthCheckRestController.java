package qrcodeapi.health.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.health.services.HealthCheckService;

@RestController
@RequestMapping("/api")
public class HealthCheckRestController {

    private final HealthCheckService healthCheckService;

    public HealthCheckRestController(HealthCheckService healthCheckService) {
        this.healthCheckService = healthCheckService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        return this.healthCheckService.check();
    }

}
