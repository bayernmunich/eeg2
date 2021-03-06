package cz.zcu.kiv.eegdatabase.data.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: stebjan
 * Date: 20.2.12
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
@Entity
@javax.persistence.Table(name="DIGITIZATION")
public class Digitization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DIGITIZATION_ID")
    private int digitizationId;
    @Column(name = "GAIN")
    private float gain;
    @Column(name = "FILTER")
    private String filter;
    @Column(name = "SAMPLING_RATE")
    private float samplingRate;
    @OneToMany(mappedBy = "digitization")
    private Set<Experiment> experiments = new HashSet<Experiment>(0);
    private Set<ResearchGroup> researchGroups = new HashSet<ResearchGroup>(0);

    public Digitization() {
    }

    public Digitization(int digitizationId, float gain, String filter, float samplingRate, Set<Experiment> experiments) {
        this.digitizationId = digitizationId;
        this.gain = gain;
        this.filter = filter;
        this.samplingRate = samplingRate;
        this.experiments = experiments;
    }

    public int getDigitizationId() {
        return digitizationId;
    }

    public void setDigitizationId(int digitizationId) {
        this.digitizationId = digitizationId;
    }

    public float getGain() {
        return gain;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public float getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(float samplingRate) {
        this.samplingRate = samplingRate;
    }

    public Set<Experiment> getExperiments() {
        return experiments;
    }

    public void setExperiments(Set<Experiment> experiments) {
        this.experiments = experiments;
    }

    public Set<ResearchGroup> getResearchGroups() {
        return researchGroups;
    }

    public void setResearchGroups(Set<ResearchGroup> researchGroups) {
        this.researchGroups = researchGroups;
    }
}
