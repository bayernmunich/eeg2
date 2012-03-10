package cz.zcu.kiv.eegdatabase.logic.semantic;

import cz.zcu.kiv.eegdatabase.data.dao.GenericDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import tools.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Factory for transforming POJO object to resources of semantic web
 * User: pbruha
 * Date: 24.2.11
 * Time: 13:36
 */
public class SimpleSemanticFactory implements InitializingBean, ApplicationContextAware, SemanticFactory {

    private Resource ontology;
    private Log log = LogFactory.getLog(getClass());
    private ApplicationContext context;
    private List<GenericDao> gDaoList = new ArrayList<GenericDao>();
    private List dataList = new ArrayList();
    private JenaBeanExtension jenaBean;
    private JenaBeanExtension jenaBeanStructure;

    /**
     * Creates list of instances of DAO
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        String[] beanNamesForType = context.getBeanNamesForType(GenericDao.class);
        for(String name : beanNamesForType) {
            gDaoList.add((GenericDao) context.getBean(name));
            break; // ???
        }
    }


    /**
     * Generates an ontology document from POJO objects.<br>
     * This method returns a serialization of the Jena's ontology model
     * of POJO objects in a specified syntax.
     * @param syntax - required syntax of the ontology document
     * @return  is - ontology document
     * @throws IOException - if an I/O error occurs.
     */
    public InputStream generateOntology(String syntax) throws IOException {
        return generateOntology(syntax, false);
    }


    @Override
    public InputStream generateOntology(String syntax, boolean structureOnly) throws IOException {
        InputStream is;
        String lang;

        if (syntax == null || syntax.equalsIgnoreCase("owl"))
            syntax = Syntax.RDF_XML;
        lang = syntax.toUpperCase();
        if (structureOnly && lang.equals(Syntax.RDF_XML))
            lang = Syntax.RDF_XML_ABBREV;

        is = creatingJenaBean(structureOnly).getOntologyDocument(lang);
        return is;
    }


    /**
     * Generates an ontology document from POJO objects.<br>
     * This method gets a serialization of the Jena's ontology model in a default
     * syntax and transforms it using Owl-Api. The Owl-Api's output syntax
     * is specified by the syntax parameter.
     * @param syntax - param from user (rdf, owl, ttl)
     * @return is - generated ontology document (rdf, owl, ttl)
     * @throws IOException - if an I/O error occurs.
     * @throws OWLOntologyCreationException - if an error occurs in Owl-Api while loading the ontology.
     * @throws OWLOntologyStorageException - if an error occurs in Owl-Api while creating the output.
     */
    public InputStream generateOntologyOwlApi(String syntax) throws IOException,
                                    OWLOntologyCreationException, OWLOntologyStorageException {
        InputStream is;
        OwlApi owlApi;

        is = creatingJenaBean(false).getOntologyDocument();
        owlApi = new OwlApiTool(is);
        is = owlApi.convertToSemanticStandard(syntax);

        return is;
    }


    /**
     * Creates JenaBeanExtensionTool for transforming POJO objects into an ontology document.
     * @param  structureOnly - if true no data are loaded (only their structure)
     * @return jenaBean - Jena bean
     */
    private JenaBeanExtension creatingJenaBean(boolean structureOnly) {
        JenaBeanExtension jbe = structureOnly ? jenaBeanStructure : jenaBean;

        // uchovavani instance JenaBeanu je prozatimni reseni - casem vhodne pravidelne generovani
        if (jbe == null) {
            loadData();
            jbe = new JenaBeanExtensionTool();
            try {
                jbe.loadStatements(ontology.getInputStream());
            } catch (IOException e) {
                log.error("Could not open the input stream associated with the ontology " +
                        "configuration document: " + ontology.getFilename(), e);
            }
            jbe.loadOOM(dataList, structureOnly);
            if (structureOnly)
                jenaBeanStructure = jbe;
            else
                jenaBean = jbe;
        }
        return jbe;
    }


    /**
     * Loads date for transforms POJO object to resouces of semantic web.
     */
    private void loadData() {
         for (GenericDao gDao : gDaoList) {
            dataList.addAll(gDao.getAllRecords());
         }
    }

    /**
     * Sets application context.
     * @param ac - application context
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        context = ac;
    }

    /**
     * Sets resource with static ontology statements.
     * @param ontology - resource in rdf/xml
     */
    public void setOntology(Resource ontology) {
        this.ontology = ontology;
    }
}


