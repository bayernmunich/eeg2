package cz.zcu.kiv.eegdatabase.logic.controller.list.hardware;

import cz.zcu.kiv.eegdatabase.data.dao.AuthorizationManager;
import cz.zcu.kiv.eegdatabase.data.dao.HardwareDao;
import cz.zcu.kiv.eegdatabase.data.pojo.Hardware;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author JiPER
 */
public class HardwareListController extends AbstractController {

    private Log log = LogFactory.getLog(getClass());
    @Autowired
    private AuthorizationManager auth;
    @Autowired
    private HardwareDao hardwareDao;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("Processing hardware list controller");
        ModelAndView mav = new ModelAndView("lists/hardware/list");

        mav.addObject("userIsExperimenter", auth.userIsExperimenter());

        List<Hardware> list = hardwareDao.getItemsForList();
        mav.addObject("hardwareList", list);
        return mav;
    }
}
