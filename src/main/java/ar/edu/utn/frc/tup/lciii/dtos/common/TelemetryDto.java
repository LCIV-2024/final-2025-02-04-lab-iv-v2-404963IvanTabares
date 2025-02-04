package ar.edu.utn.frc.tup.lciii.dtos.common;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Builder
public class TelemetryDto {
    private LocalDateTime dataDate;
    private double cpuUsage;
    private double hostDiskFree;
    private String microphoneState;
    private boolean screenCaptureAllowed;
    private boolean audioCaptureAllowed;
    private String hostname;
}
