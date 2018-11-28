package cu.aotain.osmp.task.service.ipsegmanage.impl;

import com.aotain.cu.serviceapi.dto.HouseIPSegmentInforDTO;
import com.aotain.cu.serviceapi.dto.ResultDto;
import com.aotain.cu.serviceapi.model.HouseIPSegmentInformation;
import com.aotain.cu.serviceapi.utils.BaseFeignBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cu.aotain.osmp.task.service.ipsegmanage.IpSegManageService;
import cu.aotain.osmp.task.service.ipsegmanage.IpSegService;
import cu.aotain.osmp.task.service.ipsegmanage.Ipv6SegService;
import cu.aotain.osmp.task.serviceapi.HouseIpSegServiceApiHystrix;
import cu.aotain.osmp.task.serviceapi.IHouseIpSegServiceApi;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/28
 */
@Service
public class IpSegManageServiceImpl implements IpSegManageService{

    private static final Logger logger = LoggerFactory.getLogger(IpSegManageServiceImpl.class);

    @Autowired
    private IpSegService ipSegService;

    @Autowired
    private Ipv6SegService ipv6SegService;

    @Override
    public List<HouseIPSegmentInforDTO> getDataFromISMS() {
        List<HouseIPSegmentInformation> ipv4Seg = ipSegService.ipQueryResult();
        List<HouseIPSegmentInformation> ipv6Seg = ipv6SegService.ipv6QueryResult();

        List<HouseIPSegmentInforDTO> houseIPSegmentInforDTOList = Lists.newArrayList();
        ipv4Seg.addAll(ipv6Seg);
        if (ipv4Seg==null){
            return houseIPSegmentInforDTOList;
        }
        ipv4Seg.forEach(item->{
            HouseIPSegmentInforDTO houseIPSegmentInformationDTO = new HouseIPSegmentInforDTO();
            BeanCopier copier = BeanCopier.create(HouseIPSegmentInformation.class,HouseIPSegmentInforDTO.class,false);
            copier.copy(item,houseIPSegmentInformationDTO,null);
            houseIPSegmentInforDTOList.add(houseIPSegmentInformationDTO);
        });
        return houseIPSegmentInforDTOList;
    }

    @Override
    public List<HouseIPSegmentInforDTO> getDataFromDb() {

        IHouseIpSegServiceApi houseIpSegServiceApi = BaseFeignBuilder.getCacheFeign(
                IHouseIpSegServiceApi.class, "myclient", new HouseIpSegServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);
        HouseIPSegmentInforDTO houseIPSegmentInforDTO = new HouseIPSegmentInforDTO();
        houseIPSegmentInforDTO.setIsPaging(0);
        houseIPSegmentInforDTO.setAuthFilter(true);
        return houseIpSegServiceApi.queryIpSeg(houseIPSegmentInforDTO).getRows();

    }

    @Override
    public Map<String,List<HouseIPSegmentInforDTO>> combineData(){
        Map<String,List<HouseIPSegmentInforDTO>> map = Maps.newHashMap();

        List<HouseIPSegmentInforDTO> webServiceData = getDataFromISMS();
        List<HouseIPSegmentInforDTO> dbData = getDataFromDb();
        logger.info("the total data from db is "+dbData.size()+",and the webService data length is "+webServiceData.size());
        List<HouseIPSegmentInforDTO> addList =
                (List<HouseIPSegmentInforDTO>)CollectionUtils.subtract(webServiceData,dbData);
        List<HouseIPSegmentInforDTO> updateList =
                (List<HouseIPSegmentInforDTO>)CollectionUtils.intersection(webServiceData,dbData);
        List<HouseIPSegmentInforDTO> deleteList =
                (List<HouseIPSegmentInforDTO>)CollectionUtils.subtract(dbData,webServiceData);
        map.put("1",addList);
        map.put("2",updateList);
        map.put("3",deleteList);
        logger.info("there is "+addList.size()+"record need to add to db,and "+updateList.size()+" record need to update to db,"
            +"there is "+deleteList.size()+" record need to delete from db");
        return map;
    }

    @Override
    public Map<String,ResultDto> synchDb() {
        Map<String,ResultDto> result = Maps.newHashMap();

        IHouseIpSegServiceApi houseIpSegServiceApi = BaseFeignBuilder.getCacheFeign(
                IHouseIpSegServiceApi.class, "myclient", new HouseIpSegServiceApiHystrix(), BaseFeignBuilder.EncodeDecodeType.EDT_JSON_JSON);

        Map<String, List<HouseIPSegmentInforDTO>> map = combineData();
        List<HouseIPSegmentInforDTO> addList = map.get("1");
        List<HouseIPSegmentInforDTO> updateList = map.get("2");
        List<HouseIPSegmentInforDTO> deleteList = map.get("3");
        if (!deleteList.isEmpty()){
            ResultDto deleteResultDto = houseIpSegServiceApi.deleteData(deleteList);
            result.put("addResult",deleteResultDto);
//            if (deleteResultDto!=null && !deleteResultDto.getAjaxValidationResultMap().isEmpty()){
//                result.put("addResult",deleteResultDto);
//            }

        }

        if (!updateList.isEmpty()){
            ResultDto updateResultDto = houseIpSegServiceApi.updateData(updateList);
            result.put("updateResult",updateResultDto);
//            if (updateResultDto!=null && !updateResultDto.getAjaxValidationResultMap().isEmpty()){
//                result.put("updateResult",updateResultDto);
//            }

        }

        if (!addList.isEmpty()){
            ResultDto addResultDto = houseIpSegServiceApi.insertData(addList);
            result.put("addResult",addResultDto);
//            if (addResultDto!=null && !addResultDto.getAjaxValidationResultMap().isEmpty()){
//                result.put("addResult",addResultDto);
//            }

        }

        return result;
    }

    public static void main(String[] args) {
        List<HouseIPSegmentInforDTO> list = Lists.newArrayList();
        List<HouseIPSegmentInforDTO> list1 = Lists.newArrayList();
        HouseIPSegmentInforDTO houseIPSegmentInformation = new HouseIPSegmentInforDTO();
        houseIPSegmentInformation.setHouseId(11L);
        houseIPSegmentInformation.setStartIP("1.1.1.1");
        houseIPSegmentInformation.setEndIP("1.1.1.2");
        list.add(houseIPSegmentInformation);

        HouseIPSegmentInforDTO houseIPSegmentInforDTO = new HouseIPSegmentInforDTO();
        houseIPSegmentInforDTO.setHouseId(22L);
        houseIPSegmentInforDTO.setStartIP("1.1.1.1");
        houseIPSegmentInforDTO.setEndIP("1.1.1.2");
        list1.add(houseIPSegmentInforDTO);
        List<HouseIPSegmentInformation> result = (List<HouseIPSegmentInformation>)CollectionUtils.disjunction(list,list1);
        System.out.println("======"+result.size());
    }
}
