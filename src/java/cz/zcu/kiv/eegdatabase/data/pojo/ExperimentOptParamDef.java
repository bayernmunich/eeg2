package cz.zcu.kiv.eegdatabase.data.pojo;
// Generated 19.1.2010 23:18:53 by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Entity;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Fields;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

/**
 * ExperimentOptParamDef generated by hbm2java
 */
@Indexed
@Entity
public class ExperimentOptParamDef implements java.io.Serializable {
@DocumentId
  private int experimentOptParamDefId;
  @Fields({
    @Field(index = Index.TOKENIZED), //same property indexed multiple times
    @Field(name = "paramName")}) //use a different field name
  private String paramName;
  @Fields({
    @Field(index = Index.TOKENIZED), //same property indexed multiple times
    // @Field(store=Store.YES),
    @Field(name = "paramDataType")}) //use a different field name
  private String paramDataType;
  private Set<ExperimentOptParamVal> experimentOptParamVals = new HashSet<ExperimentOptParamVal>(0);

  public ExperimentOptParamDef() {
  }

  public ExperimentOptParamDef(int experimentOptParamDefId, String paramName, String paramDataType) {
    this.experimentOptParamDefId = experimentOptParamDefId;
    this.paramName = paramName;
    this.paramDataType = paramDataType;
  }

  public ExperimentOptParamDef(int experimentOptParamDefId, String paramName, String paramDataType, Set<ExperimentOptParamVal> experimentOptParamVals) {
    this.experimentOptParamDefId = experimentOptParamDefId;
    this.paramName = paramName;
    this.paramDataType = paramDataType;
    this.experimentOptParamVals = experimentOptParamVals;
  }

  public int getExperimentOptParamDefId() {
    return this.experimentOptParamDefId;
  }

  public void setExperimentOptParamDefId(int experimentOptParamDefId) {
    this.experimentOptParamDefId = experimentOptParamDefId;
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

  public Set<ExperimentOptParamVal> getExperimentOptParamVals() {
    return this.experimentOptParamVals;
  }

  public void setExperimentOptParamVals(Set<ExperimentOptParamVal> experimentOptParamVals) {
    this.experimentOptParamVals = experimentOptParamVals;
  }
}


