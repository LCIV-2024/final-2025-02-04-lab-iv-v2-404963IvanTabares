package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceJpaRepository extends JpaRepository<Device,String> {
    public List<Device> findBytype(String type);
    public Device findByhostName(String hostname);

}
