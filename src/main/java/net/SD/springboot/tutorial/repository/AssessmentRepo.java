package net.SD.springboot.tutorial.repository;

import net.SD.springboot.tutorial.entity.Assessment;
import org.springframework.data.repository.CrudRepository;

public interface AssessmentRepo extends CrudRepository<Assessment, Integer>
{
}