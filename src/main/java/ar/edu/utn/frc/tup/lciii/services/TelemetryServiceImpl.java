package ar.edu.utn.frc.tup.lciii.services;

import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import ar.edu.utn.frc.tup.lciii.repositories.DeviceJpaRepository;
import ar.edu.utn.frc.tup.lciii.repositories.TelemetryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TelemetryServiceImpl  implements TelemetryService{

    private final Telemetrymapper telemetryMapper;
    private final DeviceJpaRepository DeviceRepository;
    private final TelemetryJpaRepository TelemetryRepository;



    @Override
    public List<TelemetryDto> getTelemetry(String hostname) {
        List<Telemetry> list = new ArrayList<>();
        if(hostname==null || hostname.isEmpty()){
            list = TelemetryRepository.findAll();
        }
        else{
            list= TelemetryRepository.findAllByhostname(hostname);
        }
        List<TelemetryDto> TelemetryDtos = new ArrayList<>();
        for (Telemetry telemetry : list) {
            TelemetryDtos.add(telemetryMapper.mapTelemetryEntityToDto(telemetry));
        }
        return TelemetryDtos;
    }

    @Override
    public TelemetryDto postTelemetry(TelemetryDto telemetry) {
        if(DeviceRepository.findByhostName(telemetry.getHostname()) == null){
            return null;
        }
        Telemetry TelemetryEntity = telemetryMapper.maptelemetryDtoToEntity(telemetry);
        TelemetryEntity = TelemetryRepository.save(TelemetryEntity);
        return telemetryMapper.mapTelemetryEntityToDto(TelemetryEntity);
    }

    @Override
    public DeviceDto postDevice(DeviceDto device) {
        Device DeviceEntity = telemetryMapper.mapDeviceDtoToEntity(device);
        DeviceEntity = DeviceRepository.save(DeviceEntity);
        return telemetryMapper.mapDeviceEntityToDto(DeviceEntity);
    }

    @Override
    public List<DeviceDto> getDevice(String type) {
        List<Device> list = DeviceRepository.findBytype(type);
        List<DeviceDto> deviceDtos = new ArrayList<>();
        for (Device device : list) {
                deviceDtos.add(telemetryMapper.mapDeviceEntityToDto(device));
        }
        return deviceDtos;
    }

    @Override
    public DeviceDto getDeviceByCpu(Double lowThreshold, Double upThreshold) {
        Telemetry telemetry = TelemetryRepository.findAll().get(-1);
        Device device = DeviceRepository.findByhostName(telemetry.getHostname());
        return telemetryMapper.mapDeviceEntityToDto(device);
    }
}
