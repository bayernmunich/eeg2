package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 29.9.2010 15:55:54 by Hibernate Tools 3.2.1.GA



import javax.persistence.*;
import java.sql.Timestamp;


/**
 * History generated by hbm2java
 */
@Entity
@javax.persistence.Table(name = "HISTORY")
public class History implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "HARDWARE_ID")
    private int historyId;
    @ManyToOne
    @JoinColumn(name = "EXPERIMENT_ID")
    private Experiment experiment;
    @ManyToOne
    @JoinColumn(name = "SCENARIO_ID")
    private Scenario scenario;
    @ManyToOne
    @JoinColumn(name = "DATA_FILE_ID")
    private DataFile dataFile;
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;
    @Column(name = "DATE_OF_DOWNLOAD")
    private Timestamp dateOfDownload;

    public History() {
    }


    public History(int historyId, Person person, Timestamp dateOfDownload) {
        this.historyId = historyId;
        this.person = person;
        this.dateOfDownload = dateOfDownload;
    }

    public History(int historyId, Experiment experiment, Scenario scenario, DataFile dataFile, Person person, Timestamp dateOfDownload) {
        this.historyId = historyId;
        this.experiment = experiment;
        this.scenario = scenario;
        this.dataFile = dataFile;
        this.person = person;
        this.dateOfDownload = dateOfDownload;
    }

    public int getHistoryId() {
        return this.historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Experiment getExperiment() {
        return this.experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public DataFile getDataFile() {
        return this.dataFile;
    }

    public void setDataFile(DataFile dataFile) {
        this.dataFile = dataFile;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Timestamp getDateOfDownload() {
        return this.dateOfDownload;
    }

    public void setDateOfDownload(Timestamp dateOfDownload) {
        this.dateOfDownload = dateOfDownload;
    }


}

