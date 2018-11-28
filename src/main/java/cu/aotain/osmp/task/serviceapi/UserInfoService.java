package cu.aotain.osmp.task.serviceapi;

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
public interface UserInfoService {

    @RequestLine("POST /serviceapi/pre/user/insert")
    public ResultDto insert(@RequestBody UserInformationDTO user);

    @RequestLine("POST /serviceapi/pre/user/delete")
    public ResultDto delete(@RequestParam String ids);

    @RequestLine("POST /serviceapi/pre/user/changeUserNature")
    public ResultDto changeUserNature(@RequestParam UserInformation userInformation);

    @RequestLine("POST /serviceapi/pre/user/listUserInfo")
    public PageResult<UserInformationDTO> listUserInfo(@RequestParam UserInformationDTO ubean);

}


