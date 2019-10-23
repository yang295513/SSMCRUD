import com.qs304.dao.DepartmentMapper;
import com.qs304.dao.EmploveeMapper;
import com.qs304.entity.Department;
import com.qs304.entity.Emplovee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CRUDTest {
    @Autowired
    DepartmentMapper dept;

    @Autowired
    EmploveeMapper empl;

    @Test
    public void crud() {
        dept.selectByPrimaryKey(1);
        dept.insert(new Department("礼仪部"));
        for (int i = 0; i < 1000; i++) {
            empl.insertSelective(new Emplovee("我是哈哈"+i,"M","159@163.com",1));
        }
        Emplovee emplo=new Emplovee();
        emplo.setEmpName("我是哈哈");
        System.out.print(empl.selectByPrimaryKey(1).getEmpName());
        System.out.print(empl.selectByPrimaryKeyWithDept(1));
    }
    @Test
    public void crud1() {
        System.out.print(empl.selectByExampleWithDept(null));
    }
}
