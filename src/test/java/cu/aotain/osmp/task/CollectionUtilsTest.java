package cu.aotain.osmp.task;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
public class CollectionUtilsTest{

    /**
     * 集合交集测试 A ∩ B
     */
    // output A== B==
    @Test
    public void testInter(){
        List<String> lista = Lists.newArrayList();
        List<String> listb = Lists.newArrayList();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        listb.add("A");
        listb.add("B");
        listb.add("D");
        List<String> result = (List<String>) CollectionUtils.intersection(lista,listb);
        result.forEach(item-> System.out.println(item+"=="));
    }

    /**
     * 集合并集测试 A U B
     */
    //output  A== B== C== D==
    @Test
    public void testUnion(){
        List<String> lista = Lists.newArrayList();
        List<String> listb = Lists.newArrayList();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        listb.add("A");
        listb.add("B");
        listb.add("D");
        List<String> result = (List<String>) CollectionUtils.union(lista,listb);
        result.forEach(item-> System.out.println(item+"=="));
    }

    /**
     * 集合差集操作 A-B
     */
    //output  C==
    @Test
    public void testSub(){
        List<String> lista = Lists.newArrayList();
        List<String> listb = Lists.newArrayList();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        listb.add("A");
        listb.add("B");
        listb.add("D");
        List<String> result = (List<String>) CollectionUtils.subtract(lista,listb);
        result.forEach(item-> System.out.println(item+"=="));
    }

    /**
     * (A U B)-(A ∩ B)
     */
    // output C== D==
    @Test
    public void test(){
        List<String> lista = Lists.newArrayList();
        List<String> listb = Lists.newArrayList();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        listb.add("A");
        listb.add("B");
        listb.add("D");
        List<String> result = (List<String>) CollectionUtils.disjunction(lista,listb);
        result.forEach(item-> System.out.println(item+"=="));
    }

    //    对象交并补

    /**
     * 测试对象的交集 需要重写对象的hashCode和equals方法
     */
    @Test
    public void testObjInter(){
        List<Student> list1 = Lists.newArrayList();
        List<Student> list2 = Lists.newArrayList();
        // 学生id相同即认为对象相等
        Student s1 = new Student();
        s1.setId(11);
        s1.setName("aaa");
        Student s2 = new Student();
        s2.setId(22);
        s2.setName("bbb");
        list1.add(s1);
        list1.add(s2);
        Student s3 = new Student();
        s3.setId(11);
        s3.setName("ccc");
        Student s4 = new Student();
        s4.setId(33);
        s4.setName("ddd");
        list2.add(s3);
        list2.add(s4);
        List<Student> result = (List<Student>)CollectionUtils.intersection(list1,list2);
        result.forEach(item-> System.out.println(item+"====="));
    }

    @Test
    public void testHashSet(){
        Set<String> lista = new HashSet<>();
        Set<String> listb = new HashSet<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("C");

        listb.add("A");
        listb.add("B");
        listb.add("D");
        List<String> result = (List<String>) CollectionUtils.intersection(lista,listb);
        System.out.println("A和B的交集");
        result.forEach(item-> System.out.println(item));
        System.out.println("------------------------------------------");
        List<String> result2 = (List<String>) CollectionUtils.subtract(lista,listb);
        System.out.println("A和B的差集");
        result2.forEach(item-> System.out.println(item));
        System.out.println("------------------------------------------");

        List<String> result3 = (List<String>) CollectionUtils.subtract(listb,lista);
        System.out.println("B和A的差集");
        result3.forEach(item-> System.out.println(item));
        System.out.println("------------------------------------------");

    }
}
