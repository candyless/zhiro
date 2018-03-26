package zhiro;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.less.zhiro.dao.TestMapper;
import com.less.zhiro.entity.Test;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月22日 下午1:49:22
 */
public class StartTest {
    public static void main(String[] args) {
		 ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
		 cxa.start();
		 TestMapper map = (TestMapper)cxa.getBean("testMapper");
		 /*List<Test> list = map.selectAll();
		 for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}*/
	}
}
