package edu.miu.lab4.Repository;

import edu.miu.lab4.Entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Integer> {
}
