package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.DeviceType;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Telemetrymapper
{
    public Device mapDeviceDtoToEntity(DeviceDto deviceDto) {

        return Device.builder()
                .os(deviceDto.getOs())
                .hostName(deviceDto.getHostname())
                .type(DeviceType.valueOf(deviceDto.getType()))
                .macAddress(deviceDto.getMacAddress())
                .build();

    }
    public DeviceDto mapDeviceEntityToDto(Device deviceEntity) {
        return DeviceDto.builder()
                .os(deviceEntity.getOs())
                .hostname(deviceEntity.getHostName())
                .type(deviceEntity.getType().toString())
                .macAddress(deviceEntity.getMacAddress())

                .build();
    }

    public Telemetry maptelemetryDtoToEntity(TelemetryDto telemetryDto) {

        return Telemetry.builder()
                .cpuUsage(telemetryDto.getCpuUsage())
                .hostname(telemetryDto.getHostname())
                .HostDiskFree(telemetryDto.getHostDiskFree())
                .microphoneState(telemetryDto.getMicrophoneState())
                .screenCaptureAllowed(false)
                .audioCaptureAllowed(false)
                .dataDate(telemetryDto.getDataDate())
                .build();

    }
    public TelemetryDto mapTelemetryEntityToDto(Telemetry telemetryEntity) {
        return TelemetryDto.builder()
                .cpuUsage(telemetryEntity.getCpuUsage())
                .hostname(telemetryEntity.getHostname())
                .hostDiskFree(telemetryEntity.getHostDiskFree())
                .microphoneState(telemetryEntity.getMicrophoneState())
                .screenCaptureAllowed(false)
                .audioCaptureAllowed(false)
                .dataDate(telemetryEntity.getDataDate())
                .build();
    }

}
