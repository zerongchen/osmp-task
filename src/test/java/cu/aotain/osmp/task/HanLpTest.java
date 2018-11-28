package cu.aotain.osmp.task;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import org.mortbay.util.ajax.JSON;

import java.util.List;

public class HanLpTest {

    public static void main(String[] args){

        String testLine ="深圳市南山高新中二路";

        Segment segment = HanLP.newSegment().enableCustomDictionary(true);

        CustomDictionary.add("深圳市");

        List<Term> sge = segment.seg(testLine);

        System.out.println(JSON.toString(sge));

    }
}
