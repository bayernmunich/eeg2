package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA

/**
 * ResearchGroupMembership generated by hbm2java
 */
public class ResearchGroupMembership implements java.io.Serializable {
  private ResearchGroupMembershipId id;
  private ResearchGroup researchGroup;
  private Person person;
  private String authority;

  public ResearchGroupMembership() {
  }

  public ResearchGroupMembership(ResearchGroupMembershipId id, ResearchGroup researchGroup, Person person, String authority) {
    this.id = id;
    this.researchGroup = researchGroup;
    this.person = person;
    this.authority = authority;
  }

  public ResearchGroupMembershipId getId() {
    return this.id;
  }

  public void setId(ResearchGroupMembershipId id) {
    this.id = id;
  }

  public ResearchGroup getResearchGroup() {
    return this.researchGroup;
  }

  public void setResearchGroup(ResearchGroup researchGroup) {
    this.researchGroup = researchGroup;
  }

  public Person getPerson() {
    return this.person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public String getAuthority() {
    return this.authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}


