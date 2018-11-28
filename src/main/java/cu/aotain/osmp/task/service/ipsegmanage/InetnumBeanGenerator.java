package cu.aotain.osmp.task.service.ipsegmanage;

import com.aotain.common.utils.tools.Random;
import com.aotain.common.utils.tools.Tools;
import com.google.common.collect.Lists;
import cu.aotain.osmp.task.model.Inetnum;
import cu.aotain.osmp.task.model.Ipv6Inetnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于生成测试数据
 *
 * @author bang
 * @date 2018/08/30
 */
public class InetnumBeanGenerator {

    private static final int[] a = {2,7,8,9};

    private static final int[] areaList = {660,751,755,756,754,757,200,662,663,668};

    private static final int LIST_LENGTH = 50;

    public static Inetnum getInetnum(){
        java.util.Random random = new java.util.Random();

        Inetnum inetnum = new Inetnum();
        Inetnum.BasicInfo basicInfo = new Inetnum.BasicInfo();
        basicInfo.setStartIp(getIpFormatData());
        basicInfo.setEndIp(getIpFormatData());
        while(Tools.ip2long(basicInfo.getEndIp())<Tools.ip2long(basicInfo.getStartIp())){
            basicInfo.setEndIp(getIpFormatData());
        }
        inetnum.setBasicInfo(basicInfo);

        Inetnum.IPInfo ipInfo = new Inetnum.IPInfo();
        ipInfo.setUserSubject(Random.getRandomString());

        int month = getRoundData(1,12);
        int day = getRoundData(1,30);
        ipInfo.setFprq(getRoundData(1900,1999)+"-"+(month<10?("0"+month):month)+"-"+(day<10?("0"+day):day));
        inetnum.setIPInfo(ipInfo);

        Inetnum.BackInfo backInfo = new Inetnum.BackInfo();
        backInfo.setSydwzjlx(2);
        IdCardGenerator idCardGenerator = new IdCardGenerator();
        backInfo.setSydwzjhm(idCardGenerator.generate());
        backInfo.setShiid(areaList[random.nextInt(10)]);
        inetnum.setBackInfo(backInfo);

        return inetnum;
    }

    public static List<Inetnum> getInetnumList(){
        List<Inetnum> inetnumList = Lists.newArrayList();
        for (int i=0; i<LIST_LENGTH; i++){
            Inetnum inetnum = getInetnum();
            inetnumList.add(inetnum);
        }
        return inetnumList;
    }

    public static Ipv6Inetnum getIpv6Inetnum(){
        java.util.Random random = new java.util.Random();

        Ipv6Inetnum ipv6Inetnum = new Ipv6Inetnum();
        Inetnum.BasicInfo basicInfo = new Inetnum.BasicInfo();

        basicInfo.setStartIp(getIpv6FormatData());
        basicInfo.setEndIp(getIpv6FormatData());
        while(Tools.ipv6toInt(basicInfo.getEndIp()).subtract(Tools.ipv6toInt(basicInfo.getStartIp())).signum()==-1){
            basicInfo.setEndIp(getIpv6FormatData());
        }
        Ipv6Inetnum.AllocatedInfo allocatedInfo = new Ipv6Inetnum.AllocatedInfo();
        Inetnum inetnum = new Inetnum();
        inetnum.setBasicInfo(basicInfo);
        allocatedInfo.setInetnum(inetnum);
        ipv6Inetnum.setAllocatedInfo(allocatedInfo);


        Ipv6Inetnum.UseInfo useInfo = new Ipv6Inetnum.UseInfo();
        useInfo.setUserSubject(Random.getRandomString());
        int month = getRoundData(1,12);
        int day = getRoundData(1,30);
        useInfo.setRealUseDate(getRoundData(1900,1999)+"-"+(month<10?("0"+month):month)+"-"+(day<10?("0"+day):day));
        ipv6Inetnum.setUseInfo(useInfo);

        Ipv6Inetnum.BackInfo backInfo = new Ipv6Inetnum.BackInfo();
        backInfo.setSydwzjlx(2);
        IdCardGenerator idCardGenerator = new IdCardGenerator();
        backInfo.setSydwzjhm(idCardGenerator.generate());
        backInfo.setShiid(areaList[random.nextInt(10)]);
        ipv6Inetnum.setBackInfo(backInfo);

        return ipv6Inetnum;
    }

    public static List<Ipv6Inetnum> getIpv6InetnumList(){
        List<Ipv6Inetnum> inetnumList = Lists.newArrayList();
        for (int i=0; i<LIST_LENGTH; i++){
            Ipv6Inetnum inetnum = getIpv6Inetnum();
            inetnumList.add(inetnum);
        }
        return inetnumList;
    }

    private static String getIpFormatData(){
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder("");
        sb.append(192+"."+168+"."+random.nextInt(255)+"."+random.nextInt(255));
        return sb.toString();
    }

    private static String getIpv6FormatData(){
        StringBuilder sb = new StringBuilder("");
        sb.append("0000:0000:0000:0000:0000:0000:0000"+":"+getDefinedLegthStr());
        return sb.toString();
    }

    private static int getRoundData(int begin,int end){
        int b = (int)((end-begin)*Math.random())+begin;
        return b;
    }

    private static String getCharForIpv6(){
        java.util.Random random = new java.util.Random();
        String[] a = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        return a[random.nextInt(16)];
    }

    private static String getDefinedLegthStr(){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i=0;i<4;i++){
            stringBuilder.append(getCharForIpv6());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Ipv6Inetnum inetnum = getIpv6Inetnum();
        System.out.println(inetnum);
    }

}
