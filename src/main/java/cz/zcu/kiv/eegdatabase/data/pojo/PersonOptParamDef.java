package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * PersonOptParamDef generated by hbm2java
 */
@Entity
//@Indexed
@javax.persistence.Table(name = "PERSON_OPT_PARAM_DEF")
public class PersonOptParamDef implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_OPT_PARAM_DEF_ID")
    private int personOptParamDefId;
    //  @Fields({
//    @Field(index = Index.TOKENIZED), //same property indexed multiple times
//    @Field(name = "PERSONPARAMNAME")}) //use a different field name
    @Column(name = "PARAM_NAME")
    private String paramName;
    //  @Fields({
//    @Field(index = Index.TOKENIZED), //same property indexed multiple times
//    @Field(name = "PARAMDATATYPE")}) //use a different field name
    @Column(name = "PARAM_DATA_TYPE")
    private String paramDataType;
    @OneToMany(mappedBy = "personOptParamDef")
    private Set<PersonOptParamVal> personOptParamVals = new HashSet<PersonOptParamVal>(0);
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ResearchGroup> researchGroups = new HashSet<ResearchGroup>(0);
    @OneToMany(mappedBy = "personOptParamDef")
    private Set<PersonOptParamDefGroupRel> personOptParamDefGroupRels = new HashSet<PersonOptParamDefGroupRel>(0);
    @Column(name = "IS_DEFAULT")
    private int defaultNumber;

    public PersonOptParamDef() {
    }

    public PersonOptParamDef(int personOptParamDefId, String paramName, String paramDataType) {
        this.personOptParamDefId = personOptParamDefId;
        this.paramName = paramName;
        this.paramDataType = paramDataType;
    }

    public PersonOptParamDef(int personOptParamDefId, String paramName, String paramDataType, Set<PersonOptParamVal> personOptParamVals) {
        this.personOptParamDefId = personOptParamDefId;
        this.paramName = paramName;
        this.paramDataType = paramDataType;
        this.personOptParamVals = personOptParamVals;
    }

    public int getPersonOptParamDefId() {
        return this.personOptParamDefId;
    }

    public void setPersonOptParamDefId(int personOptParamDefId) {
        this.personOptParamDefId = personOptParamDefId;
    }

    public String getParamName() {
        return this.paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamDataType() {
        return this.paramDataType;
    }

    public void setParamDataType(String paramDataType) {
        this.paramDataType = paramDataType;
    }

    public Set<PersonOptParamVal> getPersonOptParamVals() {
        return this.personOptParamVals;
    }

    public void setPersonOptParamVals(Set<PersonOptParamVal> personOptParamVals) {
        this.personOptParamVals = personOptParamVals;
    }

    public Set<ResearchGroup> getResearchGroups() {
        return researchGroups;
    }

    public void setResearchGroups(Set<ResearchGroup> researchGroups) {
        this.researchGroups = researchGroups;
    }

    public Set<PersonOptParamDefGroupRel> getPersonOptParamDefGroupRels() {
        return personOptParamDefGroupRels;
    }

    public void setPersonOptParamDefGroupRels(Set<PersonOptParamDefGroupRel> personOptParamDefGroupRels) {
        this.personOptParamDefGroupRels = personOptParamDefGroupRels;
    }

    public int getDefaultNumber() {
        return defaultNumber;
    }

    public void setDefaultNumber(int defaultNumber) {
        this.defaultNumber = defaultNumber;
    }
}