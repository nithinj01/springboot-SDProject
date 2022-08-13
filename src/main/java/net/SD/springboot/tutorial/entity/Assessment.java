package net.SD.springboot.tutorial.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//mark class as an Entity
@Entity
//defining class name as Table name
@Table(name="Assessment")
public class Assessment
{
    //mark id as primary key
    @Id
//defining id as column name
    @Column
    private int id;
    //defining name as column name
    @Column
    private String StationId;
    //defining age as column name
    @Column
    private String Target;
    //defining email as column name
    @Column
    private String Variance;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getStationId() {
        return StationId;
    }

    public void setStationId(String stationId) {
        StationId = stationId;
    }

    public String getTarget() {
        return Target;
    }

    public void setTarget(String target) {
        Target = target;
    }

    public String getVariance() {
        return Variance;
    }

    public void setVariance(String variance) {
        Variance = variance;
    }
}