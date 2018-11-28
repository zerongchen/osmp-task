package cu.aotain.osmp.task.serviceapi.hystrix;

import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.model.UserInformation;
import cu.aotain.osmp.task.serviceapi.UserInfoService;
import org.apache.log4j.Logger;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-27 16:42
 */
public class UserInfoServiceHystrix implements UserInfoService {

    protected static final Logger LOG = Logger.getLogger(UserInfoServiceHystrix.class);

    @Override
    public PageResult<UserInformationDTO> listUserInfo(UserInformationDTO ubean) {
        LOG.error("listUserInfo request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto insert(UserInformationDTO user) {
        LOG.error("insert request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto delete(String ids) {

        LOG.error("delete request fail  : " + this.getClass().getName());
        return null;
    }

    @Override
    public ResultDto changeUserNature(UserInformation userInformation) {

        LOG.error("changeUserNature request fail  : " + this.getClass().getName());
        return null;
    }
}
