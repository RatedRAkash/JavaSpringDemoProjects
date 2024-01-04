package com.psl.wso2.np.repository;

import com.psl.wso2.np.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
