package ar.edu.utn.frc.tup.lciii.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "DEVICE")
public class Device {

    @Id
    @Column(name = "HOSTNAME", unique = true)
    private String hostName;

    @OneToOne(mappedBy = "device")
    private Telemetry telemetry;

    @Column(name= "createdDate")
    private LocalDateTime createdDate;

    @Column
    private String os;

    @Column
    private String macAddress;

    @Column(name = "TYPE")
    private DeviceType type;

}
