package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA

import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.hibernate.annotations.Entity;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * Scenario generated by hbm2java
 */
@Entity
@Indexed
@Analyzer(impl = StandardAnalyzer.class)
public class Scenario implements java.io.Serializable {

  @DocumentId
  private int scenarioId;
  private Person person;
  private ResearchGroup researchGroup;
  @Fields({
    @Field(name = "TITLE"),
    @Field(store = Store.YES)}) //use a different field name
  private String title;
  private int scenarioLength;
  private Clob scenarioXml;
  @Fields({
    @Field(name = "DESCRIPTION"),
    @Field(store = Store.YES)}) //use a different field name
  private String description;
  private Set<Experiment> experiments = new HashSet<Experiment>(0);
  private Set<History> histories = new HashSet<History>(0);
  private boolean privateScenario;
  private boolean userMemberOfGroup;

  public Scenario() {
  }

  public Scenario(int scenarioId, Person person, ResearchGroup researchGroup) {
    this.scenarioId = scenarioId;
    this.person = person;
    this.researchGroup = researchGroup;
  }

  public Scenario(int scenarioId, Person person, ResearchGroup researchGroup, String title, int scenarioLength, Clob scenarioXml, String description, Set<Experiment> experiments) {
    this.scenarioId = scenarioId;
    this.person = person;
    this.researchGroup = researchGroup;
    this.title = title;
    this.scenarioLength = scenarioLength;
    this.scenarioXml = scenarioXml;
    this.description = description;
    this.experiments = experiments;
  }

  public int getScenarioId() {
    return this.scenarioId;
  }

  public void setScenarioId(int scenarioId) {
    this.scenarioId = scenarioId;
  }

  public Person getPerson() {
    return this.person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public ResearchGroup getResearchGroup() {
    return this.researchGroup;
  }

  public void setResearchGroup(ResearchGroup researchGroup) {
    this.researchGroup = researchGroup;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getScenarioLength() {
    return this.scenarioLength;
  }

  public void setScenarioLength(int scenarioLength) {
    this.scenarioLength = scenarioLength;
  }

  public Clob getScenarioXml() {
    return this.scenarioXml;
  }

  public void setScenarioXml(Clob scenarioXml) {
    this.scenarioXml = scenarioXml;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Experiment> getExperiments() {
    return this.experiments;
  }

  public void setExperiments(Set<Experiment> experiments) {
    this.experiments = experiments;
  }

  public void setPrivateScenario(boolean privateScenario) {
    this.privateScenario = privateScenario;
  }

  public boolean isPrivateScenario() {
    return this.privateScenario;
  }

  public void setUserMemberOfGroup(boolean userIsMember) {
    this.userMemberOfGroup = userIsMember;
  }

  public boolean isUserMemberOfGroup() {
    return userMemberOfGroup;
  }

  public Set<History> getHistories() {
    return histories;
  }

  public void setHistories(Set<History> histories) {
    this.histories = histories;
  }
}


