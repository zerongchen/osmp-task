package cu.aotain.osmp.task.serviceapi.hystrix;


import com.aotain.cu.serviceapi.dto.*;
import com.aotain.cu.serviceapi.model.PageResult;
import cu.aotain.osmp.task.serviceapi.HouseRackServiceApi;
import org.apache.log4j.Logger;

import java.util.List;

public class HouseRackServiceApiHystrix implements HouseRackServiceApi {

    protected static final Logger LOG = Logger.getLogger(HouseRackServiceApiHystrix.class);

    @Override
    public PageResult<HouseFrameInformationDTO> queryRack(HouseFrameInformationDTO rack) {
        LOG.error("queryRack request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public PageResult<HouseInformationDTO> listHouseInfo(HouseInformationDTO dto) {
        LOG.error("listHouseInfo request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto insertRack(List<HouseFrameInformationDTO> racks) {
        LOG.error("insertRack request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto updateRack(List<HouseFrameInformationDTO> racks) {
        LOG.error("updateRack request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto deleteRack(List<HouseFrameInformationDTO> racks) {
        LOG.error("deleteRack request fail  : " + this.getClass().getName());
        return null;
    }

}
