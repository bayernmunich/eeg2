package cz.zcu.kiv.eegdatabase.logic.controller;

import cz.zcu.kiv.eegdatabase.data.dao.GenericDao;
import cz.zcu.kiv.eegdatabase.data.dao.PersonDao;
import cz.zcu.kiv.eegdatabase.data.pojo.DataFile;
import cz.zcu.kiv.eegdatabase.data.pojo.History;
import cz.zcu.kiv.eegdatabase.data.pojo.Person;
import cz.zcu.kiv.eegdatabase.logic.controller.util.ControllerUtils;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * This controller loads a data object for the view which serves the downloading of the data file
 *
 * @author Jindra
 */
public class MeasurationDataOutputController extends AbstractController {

  private GenericDao<DataFile, Integer> dataFileDao;
  private GenericDao<History, Integer> historyDao;
  private Log log = LogFactory.getLog(getClass());
  private PersonDao personDao;

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
   // ModelAndView mav = new ModelAndView("binaryView");
    // There should always be set integer value in this field - it is generated by view, not by user
    int fileId = Integer.parseInt(request.getParameter("fileId"));
    DataFile data = dataFileDao.read(fileId);
    Blob b = data.getFileContent();
    byte[] br = b.getBytes(1,(int) b.length());
    Person user = personDao.getPerson(ControllerUtils.getLoggedUserName());
    Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    History history = new History();
    log.debug("Setting downloading data file");
    history.setDataFile(data);
    log.debug("Setting user");
    history.setPerson(user);
    log.debug("Setting time of download");
    history.setDateOfDownload(currentTimestamp);
    log.debug("Saving download history");
    historyDao.create(history);
    response.setHeader("Content-Type", data.getMimetype());
    response.setHeader("Content-Disposition", "attachment;filename=" + data.getFilename());
    response.getOutputStream().write(br);
  //  mav.addObject("dataObject", dataFileDao.read(fileId));
    return null;
  }

  public GenericDao<DataFile, Integer> getDataFileDao() {
    return dataFileDao;
  }

  public void setDataFileDao(GenericDao<DataFile, Integer> dataFileDao) {
    this.dataFileDao = dataFileDao;
  }
   public GenericDao<History, Integer> getHistoryDao() {
    return historyDao;
  }

  public void setHistoryDao(GenericDao<History, Integer> historyDao) {
    this.historyDao = historyDao;
  }

  public PersonDao getPersonDao() {
    return personDao;
  }

  public void setPersonDao(PersonDao personDao) {
    this.personDao = personDao;
  }
}
