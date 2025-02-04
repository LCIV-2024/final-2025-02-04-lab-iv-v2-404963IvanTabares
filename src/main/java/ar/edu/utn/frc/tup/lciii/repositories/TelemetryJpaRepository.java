package ar.edu.utn.frc.tup.lciii.repositories;

import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelemetryJpaRepository extends JpaRepository<Telemetry, Long> {

    public List<Telemetry> findAllByhostname(String hostname);
}
