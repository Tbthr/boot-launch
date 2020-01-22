package com.power.bootlaunch;

import com.power.bootlaunch.config.EmployeeConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpELTest {

    @Autowired
    EmployeeConfig employeeConfig;

    @Test
    public void employee(){
        System.out.println(employeeConfig.toString());
    }
}
