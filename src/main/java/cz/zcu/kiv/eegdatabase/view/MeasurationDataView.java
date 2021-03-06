package cz.zcu.kiv.eegdatabase.view;

import java.sql.Blob;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.view.AbstractView;
import cz.zcu.kiv.eegdatabase.data.pojo.DataFile;

/**
 * This view serves for downloading the data files.
 *
 * @author Jindra
 */
public class MeasurationDataView extends AbstractView {
    Log log = LogFactory.getLog(getClass());

    @Override
    protected void renderMergedOutputModel(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Loading the DataFile object loaded by Controller
        DataFile data = (DataFile) map.get("dataObject");
        Blob b = data.getFileContent();
        log.debug("Loading Data object - ID " + data.getDataFileId());

        /** Downloading the bytes for writing to output */
        byte[] br = b.getBytes(1,(int) b.length());

        // Setting the content type, so the download dialog opens and user is able to download data file
        /* TODO: load the original MIME type from database when the POJO object is ready */
        log.debug("Data MIME type is: " + data.getMimetype());
        response.setHeader("Content-Type", data.getMimetype());

        // Setting the original filename
        /* TODO: load the original filename from database when the POJO object is ready */
        log.debug("Data filename is: " + data.getFilename());
        response.setHeader("Content-Disposition", "attachment;filename=" + data.getFilename());

        // Writing the bytes to the output stream
        response.getOutputStream().write(br);
    }

}
