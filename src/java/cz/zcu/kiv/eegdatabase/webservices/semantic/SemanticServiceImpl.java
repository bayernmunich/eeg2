package cz.zcu.kiv.eegdatabase.webservices.semantic;

import cz.zcu.kiv.eegdatabase.logic.semantic.SemanticFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceException;
import java.io.*;

/**
 * Webservice for transforming POJO object to resources of semantic web
 * User: pbruha
 * Date: 17.3.11
 * Time: 18:39
 */
@WebService(endpointInterface = "cz.zcu.kiv.eegdatabase.webservices.semantic.SemanticService")
public class SemanticServiceImpl implements SemanticService {
    private SemanticFactory semanticFactory;
    private Log log = LogFactory.getLog(getClass());

    /**
     * Method just for checking web service availability
     *
     * @return
     */
    public boolean isServiceAvailable() {
        return true;
    }

    /**
     * Transforms POJO object to RDF
     *
     * @return
     * @throws WebServiceException
     * @throws IOException
     */
    public DataHandler generateRDF() throws SOAPException {
        InputStream is = null;
        byte[] bytes = null;
        ByteArrayDataSource rdf = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            int i;
            is = semanticFactory.generateRDF();
            while ((i = is.read()) > -1) {
                os.write(i);
            }
        } catch (IOException e) {
            log.error(e);
            throw new SOAPException(e);
        }
        rdf = new ByteArrayDataSource(os.toByteArray(), "fileBinaryStream");
        return new DataHandler(rdf);
    }

    /**
     * Transforms POJO object to resources of semantic web
     *
     * @param syntaxType - syntax (rdf,owl,ttl)
     * @return
     * @throws WebServiceException
     * @throws IOException
     * @throws OWLOntologyStorageException
     * @throws OWLOntologyCreationException
     */
    public DataHandler generateOWL(String syntaxType) throws SOAPException {
        InputStream is = null;
        byte[] bytes = null;
        ByteArrayDataSource owl = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            int i;
            is = semanticFactory.transformPOJOToSemanticResource(syntaxType);
            while ((i = is.read()) > -1) {
                os.write(i);
            }
        } catch (OWLOntologyStorageException e) {
            log.error(e);
            throw new SOAPException(e);
        } catch (OWLOntologyCreationException e) {
            log.error(e);
            throw new SOAPException(e);
        } catch (IOException e) {
            log.error(e);
            throw new SOAPException(e);
        }
        owl = new ByteArrayDataSource(os.toByteArray(), "fileBinaryStream");
        return new DataHandler(owl);
    }

    /**
     * Setting semantic factory
     * @param semanticFactory - semantic factory
     */
    public void setSemanticFactory(SemanticFactory semanticFactory) {
        this.semanticFactory = semanticFactory;
    }
}
