package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.services.TelemetryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/Device")
public class DeviceController {


    @Autowired
    private TelemetryService telemetryService;

    @GetMapping("?type={type}")
    public ResponseEntity<List<DeviceDto>> getDivicebyType(@PathVariable String type) {
        return ResponseEntity.ok(telemetryService.getDevice(type));
    }

    @PostMapping()
    public ResponseEntity<DeviceDto> createTelemetry(@RequestBody DeviceDto device) {
        return ResponseEntity.ok(telemetryService.postDevice(device));
    }
    @GetMapping("lowThreshold={}&upThreshold={}")
    public ResponseEntity<DeviceDto> getDivicebyType(@PathVariable Double lowThreshold, @PathVariable Double upThreshold) {
        return ResponseEntity.ok(telemetryService.getDeviceByCpu(lowThreshold,upThreshold));
    }

}