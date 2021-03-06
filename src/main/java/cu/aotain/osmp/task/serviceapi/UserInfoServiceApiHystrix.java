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
import org.apache.log4j.Logger;
import sun.security.util.Resources_de;

import java.util.List;

public class UserInfoServiceApiHystrix implements UserInfoServiceApi {

    protected static final Logger LOG = Logger.getLogger(DemoServiceHystrix.class);

    @Override
    public PageResult<UserInformationDTO> getAllUser( UserInformationDTO dto) {
        LOG.error("get all user data error");
        return null;
    }

    @Override
    public PageResult<UserBandwidthInformationDTO> getAllUserBind(UserBandwidthInformationDTO dto) {
        LOG.error("get all user bind data error");
        return null;
    }

    @Override
    public List<ResultDto> updateUsers( List<UserInformationDTO> dto ) {
        return null;
    }

    @Override
    public List<ResultDto> insertsUser( List<UserInformationDTO> dtos ) {
        return null;
    }

    @Override
    public ResultDto deleteUsers( List<UserInformationDTO> dtos ) {
        return null;
    }

    @Override
    public ResultDto delete(List<UserInformationDTO> deleteList) {
        return null;
    }

    @Override
    public ResultDto updateUserBinds( List<UserBandwidthInformationDTO> dto ) {
        return null;
    }

    @Override
    public ResultDto insertsUserBinds( List<UserBandwidthInformationDTO> dto ) {
        return getErrorResult();
    }

    @Override
    public ResultDto deleteUsersBinds( List<Long> ids ) {
        return getErrorResult();
    }

    @Override
    public PageResult<UserServiceInformationDTO> getServices( UserServiceInformationDTO dto ) {
        return null;
    }

    @Override
    public ResultDto insertServices( List<UserServiceInformationDTO> dto ) {
        return null;
    }

    @Override
    public ResultDto updateServices( List<UserServiceInformationDTO> dto ) {
        return null;
    }

    @Override
    public ResultDto deleteServices( List<UserServiceInformationDTO> dto ) {
        return null;
    }

    @Override
    public List<IdcJcdmXzqydm> getAreaCode( Integer code ) {
        return null;
    }

    @Override
    public List<String> getAreaDic() {
        return null;
    }

    protected ResultDto getErrorResult(){
        ResultDto resultDto = new ResultDto();
        resultDto.setResultCode(ResultDto.ResultCodeEnum.ERROR.getCode());
        return resultDto;
    }
}
