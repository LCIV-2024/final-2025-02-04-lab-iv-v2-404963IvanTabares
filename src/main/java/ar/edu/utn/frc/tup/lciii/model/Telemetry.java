package ar.edu.utn.frc.tup.lciii.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TELEMETRY")
@EqualsAndHashCode
public class Telemetry {

    @Id
    @SequenceGenerator(name = "telemetry_seq", sequenceName = "TELEMETRY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telemetry_seq")
    @Column(name = "ID")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HOSTNAME", referencedColumnName = "HOSTNAME", insertable = false, updatable = false)
    private Device device;

    @Column(name = "dataDate")
    private LocalDateTime dataDate;

    @Column(name = "HostDiskFree")
    private double HostDiskFree;

    @Column(name = "CpuUsage")
    private double cpuUsage;

    @Column(name = "MicrophoneState")
    private String microphoneState;

    @Column(name = "ScreenCaptureAllowed")
    private boolean screenCaptureAllowed;

    @Column(name = "AudioCaptureAllowed")
    private boolean audioCaptureAllowed;

    @Column(name = "Hostname")
    private String hostname;
}
