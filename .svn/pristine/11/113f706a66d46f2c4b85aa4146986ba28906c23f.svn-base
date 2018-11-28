package cu.aotain.osmp.task.service;

import com.aotain.cu.serviceapi.dto.UserInformationDTO;
import com.aotain.cu.serviceapi.model.PageResult;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApi;
import cu.aotain.osmp.task.serviceapi.UserInfoServiceApiHystrix;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-30 11:09
 */
@Service
public class UserNameUserIdCacheService {

    @Cacheable("userIdNameCache")
    public String getUserIdByUserName(String customerName) {

        return getUserInfoFromDb(customerName);
    }

    public String getUserInfoFromDb(String customerName) {

        /**
         * 查询所有用户
         */
        UserInfoServiceApi UserInfoServiceApi = BaseFeignBuilder.getCacheFeign(UserInfoServiceApi.class, "myclient", new UserInfoServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        UserInformationDTO userInfo = new UserInformationDTO();
        userInfo.setIsPaging(0);
        PageResult<UserInformationDTO> allUser = UserInfoServiceApi.getAllUser(userInfo);

        if (allUser != null && allUser.getRows().size() > 0) {
            for (UserInformationDTO model : allUser.getRows()) {
                if (model.getUnitName().equals(customerName)) {
                    return model.getUserId() + "";
                }
            }
        }
        return null;
    }

}
