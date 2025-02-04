package ar.edu.utn.frc.tup.lciii.services;


import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TelemetryService {


    List<TelemetryDto> getTelemetry(String hostname);

    TelemetryDto postTelemetry(TelemetryDto telemetry);

    DeviceDto postDevice(DeviceDto device);

    List<DeviceDto> getDevice(String type);

    DeviceDto getDeviceByCpu(Double lowThreshold, Double upThreshold);
}
