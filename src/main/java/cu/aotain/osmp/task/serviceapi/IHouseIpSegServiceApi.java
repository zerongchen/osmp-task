package cu.aotain.osmp.task.serviceapi;

import com.aotain.cu.serviceapi.dto.HouseIPSegmentInforDTO;
import com.aotain.cu.serviceapi.dto.HouseInformationDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.model.PageResult;
import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/29
 */
@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface IHouseIpSegServiceApi {

    @RequestLine("POST /serviceapi/pre/house/ipSegment/query")
    PageResult<HouseIPSegmentInforDTO> queryIpSeg(@RequestParam HouseIPSegmentInforDTO rack);

    @RequestLine("POST /serviceapi/pre/house/ipSegment/insert")
    ResultDto insertData(@RequestParam List<HouseIPSegmentInforDTO> ipSegments);

    @RequestLine("POST /serviceapi/pre/house/ipSegment/update")
    ResultDto updateData(@RequestParam List<HouseIPSegmentInforDTO> ipSegments);

    @RequestLine("POST /serviceapi/pre/house/ipSegment/delete")
    ResultDto deleteData(@RequestParam List<HouseIPSegmentInforDTO> ipSegments);

    @RequestLine("POST /serviceapi/pre/house/listHouseInfo")
    PageResult<HouseInformationDTO> listHouseInfo(@RequestParam HouseInformationDTO dto);
}
