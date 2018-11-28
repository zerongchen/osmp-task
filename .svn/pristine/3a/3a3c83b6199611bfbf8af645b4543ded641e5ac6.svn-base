package cu.aotain.osmp.task.serviceapi;

import com.aotain.cu.serviceapi.dto.HouseFrameInformationDTO;
import com.aotain.cu.serviceapi.dto.HouseInformationDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.model.UserInformation;
import feign.Headers;
import feign.RequestLine;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface HouseRackServiceApi {

    /**
     * 查询所有机架数据
     *
     * @param rack
     * @return
     */
    @RequestLine("POST /serviceapi/pre/house/rack/query")
    public PageResult<HouseFrameInformationDTO> queryRack(@RequestParam HouseFrameInformationDTO rack);

    /**
     * 查询所有机房数据
     *
     * @param dto
     * @return
     */
    @RequestLine("POST /serviceapi/pre/house/listHouseInfo")
    public PageResult<HouseInformationDTO> listHouseInfo(@RequestParam HouseInformationDTO dto);


    @RequestLine("POST /serviceapi/pre/house/rack/insert")
    public ResultDto insertRack(@RequestParam List<HouseFrameInformationDTO> racks);

    @RequestLine("POST /serviceapi/pre/house/rack/update")
    public ResultDto updateRack(@RequestParam List<HouseFrameInformationDTO> racks);

    @RequestLine("POST /serviceapi/pre/house/rack/delete")
    public ResultDto deleteRack(@RequestParam List<HouseFrameInformationDTO> racks);

}


