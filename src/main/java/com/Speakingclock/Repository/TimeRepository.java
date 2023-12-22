package com.Speakingclock.Repository;

// TimeRepository.java
import com.Speakingclock.Entity.TimeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends CrudRepository<TimeEntity, Long> {
    // Implement repository methods if needed
}

