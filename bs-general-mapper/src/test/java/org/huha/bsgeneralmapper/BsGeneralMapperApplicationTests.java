package org.huha.bsgeneralmapper;

import org.huha.bsgeneralmapper.bunisess.user.mapper.DashboardUserMapper;
import org.huha.bsgeneralmapper.bunisess.userRole.mapper.UserRoleMapper;
import org.huha.bsgeneralmapper.bunisess.userRole.model.DashboardUserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BsGeneralMapperApplicationTests {

    @Autowired
    DashboardUserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Test
    public void contextLoads() {
        List<DashboardUserRole> dashboardUserRoles = userRoleMapper.selectAll();
        System.out.println(dashboardUserRoles);
        System.out.println(userMapper.selectAll());
    }

}

