package net.SD.springboot.tutorial.repository;

import java.util.ArrayList;
import java.util.List;

import net.SD.springboot.tutorial.entity.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessService
{
    @Autowired
    AssessmentRepo assessrepo;
    //getting all student records
    public List<Assessment> getAllStudent()
    {
        List<Assessment> assessments = new ArrayList<Assessment>();
        assessrepo.findAll().forEach(assessment -> assessments.add(assessment));
        return assessments;
    }
    public List<Assessment> findAll() {
        return (List<Assessment>) assessrepo.findAll();
    }
    //getting a specific record
    public Assessment getAssessmentdata(int id)
    {
        return assessrepo.findById(id).get();
    }
    public void saveOrUpdate(Assessment student)
    {
        assessrepo.save(student);
    }
    //deleting a specific record
    public void delete(int id)
    {
        assessrepo.deleteById(id);
    }
}