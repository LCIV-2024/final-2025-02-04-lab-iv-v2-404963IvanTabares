package ar.edu.utn.frc.tup.lciii.controllers;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/telemetry")
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;

    @GetMapping("?hostname={Hostname}")
    public ResponseEntity<List<TelemetryDto>> getTelemetry(@PathVariable String Hostname) {
        return ResponseEntity.ok(telemetryService.getTelemetry(Hostname));
    }

    @PostMapping()
    public ResponseEntity<TelemetryDto> createTelemetry(@RequestBody TelemetryDto telemetry) {
        if (telemetry == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(telemetryService.postTelemetry(telemetry));
    }

}