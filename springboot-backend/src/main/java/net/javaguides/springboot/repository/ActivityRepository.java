package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

}
