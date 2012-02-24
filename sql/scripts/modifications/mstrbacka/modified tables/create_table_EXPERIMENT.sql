CREATE TABLE "EXPERIMENT" (
	"EXPERIMENT_ID" INTEGER NOT NULL ,
	"ARTEFACT_ID",
	"SUBJECT_PERSON_ID" INTEGER NOT NULL ,
	"SUBJECT_GROUP_ID",
	"OWNER_ID" INTEGER NOT NULL ,
	"SCENARIO_ID" INTEGER NOT NULL ,
	"WEATHER_ID" INTEGER NOT NULL ,
	"RESEARCH_GROUP_ID" INTEGER NOT NULL ,
	"START_TIME" DATE,
	"END_TIME" DATE,
	"TEMPERATURE" SMALLINT,
	"ENVIRONMENT_NOTE" VARCHAR2 (255),
	"PRIVATE" INTEGER DEFAULT 0 NOT NULL ,
	"ELECTRODE_CONF_ID" INTEGER NOT NULL ,
	"DIGITALIZATION_ID" INTEGER NOT NULL ,
PRIMARY KEY ("EXPERIMENT_ID")
)
;