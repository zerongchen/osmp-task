package cu.aotain.osmp.task.serviceapi;

import com.aotain.cu.serviceapi.dto.HouseIPSegmentInforDTO;
import com.aotain.cu.serviceapi.dto.HouseInformationDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.model.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/29
 */
public class HouseIpSegServiceApiHystrix implements IHouseIpSegServiceApi{

    private static final Logger logger = LoggerFactory.getLogger(HouseIpSegServiceApiHystrix.class);

    @Override
    public PageResult<HouseIPSegmentInforDTO> queryIpSeg(HouseIPSegmentInforDTO rack) {
        logger.error(" query ipSeg request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto insertData(List<HouseIPSegmentInforDTO> ipSegments) {
        logger.error(" insert ipSeg request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto updateData(List<HouseIPSegmentInforDTO> ipSegments) {
        logger.error(" update ipSeg request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto deleteData(List<HouseIPSegmentInforDTO> ipSegments) {
        logger.error(" delete ipSeg request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public PageResult<HouseInformationDTO> listHouseInfo(HouseInformationDTO dto){
        logger.error(" delete ipSeg request fail  : " + this.getClass().getName());
        return null;
    }
}
