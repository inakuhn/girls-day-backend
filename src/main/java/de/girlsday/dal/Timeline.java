package de.girlsday.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.girlsday.model.TimelineItem;
import de.girlsday.model.User;

public interface Timeline  extends JpaRepository<TimelineItem, Long> {
	public List<TimelineItem> findByUser(User user);
	
}