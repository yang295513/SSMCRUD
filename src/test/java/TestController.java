import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qs304.entity.Emplovee;
import com.qs304.service.EmplService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestController {

    @Autowired
    EmplService service;

    @Test
    public void testPageHelper(){
        PageHelper.startPage(2,5);
        List<Emplovee> listservice=service.getEmploveeList(null);
        PageInfo page=new PageInfo(listservice);
        System.out.println(page.getTotal());
    }
}
