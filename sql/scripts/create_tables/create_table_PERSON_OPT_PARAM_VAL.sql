CREATE TABLE "PERSON_OPT_PARAM_VAL" (
	"PARAM_VALUE" VARCHAR2 (30) NOT NULL ,
	"PERSON_ID" INTEGER NOT NULL ,
	"PERSON_OPT_PARAM_DEF_ID" INTEGER NOT NULL ,
PRIMARY KEY ("PERSON_ID","PERSON_OPT_PARAM_DEF_ID")
)
;