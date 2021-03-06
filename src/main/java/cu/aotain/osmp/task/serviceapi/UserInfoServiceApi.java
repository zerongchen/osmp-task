package cu.aotain.osmp.task.serviceapi;


import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.dto.UserBandwidthInformationDTO;
import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.dto.UserServiceInformationDTO;
import com.aotain.cu.serviceapi.model.IdcJcdmXzqydm;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.model.UserInformation;
import feign.Headers;
import feign.RequestLine;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Headers({ "Content-Type: application/json", "Accept: application/json" })
public interface UserInfoServiceApi {


    @RequestLine("POST /serviceapi/pre/user/listUserInfo")
    public PageResult<UserInformationDTO> getAllUser( UserInformationDTO dto);

    @RequestLine("POST /serviceapi/pre/user/bandwidth/query")
    public PageResult<UserBandwidthInformationDTO> getAllUserBind(UserBandwidthInformationDTO dto);

    @RequestLine("POST /serviceapi/pre/user/update")
    public List<ResultDto> updateUsers( List<UserInformationDTO> dto);

    @RequestLine("POST /serviceapi/pre/user/insert")
    public List<ResultDto> insertsUser(List<UserInformationDTO> dtos);

    @RequestLine("POST /serviceapi/pre/user/delete")
    public ResultDto deleteUsers(List<UserInformationDTO> dtos);

    @RequestLine("POST /serviceapi/pre/user/delete")
    public ResultDto delete(List<UserInformationDTO> deleteList);


    @RequestLine("POST /serviceapi/pre/user/bandwidth/update")
    public ResultDto updateUserBinds( List<UserBandwidthInformationDTO> dto);

    @RequestLine("POST /serviceapi/pre/user/bandwidth/insert")
    public ResultDto insertsUserBinds(List<UserBandwidthInformationDTO> dto);

    @RequestLine("POST /serviceapi/pre/user/bandwidth/delete")
    public ResultDto deleteUsersBinds(List<Long> ids);

    @RequestLine("POST /serviceapi/pre/user/service/query")
    public PageResult<UserServiceInformationDTO> getServices( UserServiceInformationDTO dto);

    @RequestLine("POST /serviceapi/pre/user/service/insert")
    public ResultDto insertServices( List<UserServiceInformationDTO> dto);

    @RequestLine("POST /serviceapi/pre/user/service/update")
    public ResultDto updateServices( List<UserServiceInformationDTO> dto);

    @RequestLine("POST /serviceapi/pre/user/service/delete")
    public ResultDto deleteServices( List<UserServiceInformationDTO> dto);

    @RequestLine("POST /serviceapi/common/getAreaCode")
    public List<IdcJcdmXzqydm> getAreaCode( Integer code);

    @RequestLine("POST /serviceapi/common/getAreaDic")
    public List<String> getAreaDic();

}
