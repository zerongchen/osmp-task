package cu.aotain.osmp.task.aop;

import cu.aotain.osmp.task.service.impl.IcosSystemRackListServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author chenym@aotain.com
 * @create 2018-09-07 9:14
 */
@Component
@Aspect
public class GreetAspectj {

    private static final Logger LOG = LoggerFactory.getLogger(GreetAspectj.class);

    @Around("execution(* cu.aotain.osmp.task.service.impl.IcosSystemRackListServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint ponit) throws Throwable {
        String methodName = ponit.getSignature().getName();
        Long t1 = System.currentTimeMillis();
        Object result = ponit.proceed();
        Long t2 = System.currentTimeMillis();
        if (LOG.isDebugEnabled()) {
            LOG.debug("execute " + methodName + " take time:" + (t2 - t1) / 1000 + " seconds");
        }
        return result;
    }

}
