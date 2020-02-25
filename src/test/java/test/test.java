package test;

import com.alibaba.fastjson.JSON;
import com.baizhi.entity.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class test {
    @Test
//    public void test1(){
//        User u=new User("1","张三",18);
//        String s = JSON.toJSONString(u);
//        System.out.println(s);
//    }
//    public void test2(){
//        String [] s={"jjj","lll"};
//        String s1 = JSON.toJSONString(s);
//        System.out.println(s1);
//    }
   /* public void test3(){
        User u1=new User("1","张三",18);
        User u2=new User("2","张4",18);
        User u3=new User("3","张5",18);
        List<User>list=new ArrayList<User>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }*/
   public void test4(){
        User u1=new User("1","张三",18);
        User u2=new User("2","张4",18);
        User u3=new User("3","张5",18);
        Map<String, User>maps=new HashMap<String,User>();
        maps.put("1",u1);
        maps.put("2",u2);
        maps.put("3",u3);
        String s = JSON.toJSONString(maps);
        System.out.println(s);
        System.out.println("diyici");
System.out.println("diyier");




        System.out.println("分支2");
        System.out.println("分支ccc");
        System.out.println("分支ccc2");
    }
}
