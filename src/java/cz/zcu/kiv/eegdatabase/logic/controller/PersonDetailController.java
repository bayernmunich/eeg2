package cz.zcu.kiv.eegdatabase.logic.controller;

import cz.zcu.kiv.eegdatabase.data.pojo.Person;
import cz.zcu.kiv.eegdatabase.data.dao.GenericDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author JiPER
 */
public class PersonDetailController extends AbstractController {

    private Log log = LogFactory.getLog(getClass());
    private GenericDao<Person, Integer> personDao;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("people/detail");

        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("personId"));
        } catch (Exception e) {
        }
        Person p = personDao.read(id);

        mav.addObject("personDetail", p);

        return mav;
    }

    public GenericDao<Person, Integer> getPersonDao() {
        return personDao;
    }

    public void setPersonDao(GenericDao<Person, Integer> personDao) {
        this.personDao = personDao;
    }
}
