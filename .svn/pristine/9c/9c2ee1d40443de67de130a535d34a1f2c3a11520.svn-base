package cu.aotain.osmp.task.util;

import com.csvreader.CsvReader;
import cu.aotain.osmp.task.service.impl.CrmsProcessServiceImpl;
import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileTools {


    private static Logger logger = LoggerFactory.getLogger(CrmsProcessServiceImpl.class);

    public static CsvReader createCsvReader(File file){
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(file));
            InputStreamReader read = new InputStreamReader( input, CharEncoding.UTF_8);
            CsvReader csvReader = new CsvReader(read);
            return csvReader;
        } catch (FileNotFoundException e) {
            logger.error("",e);
        } catch (UnsupportedEncodingException e) {
            logger.error("",e);
        }
        return null;
    }
}
