package cu.aotain.osmp.task.service;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-08-25 10:55
 */
@Service
@Setter
@Getter
@Scope("singleton")
public class VerificationInfo {

    private HashMap<String, HashMap<String, Object>> verificationMap = Maps.newHashMap();

    private Map<String,String> icosVerificationMap= new ConcurrentHashMap<>();
}
