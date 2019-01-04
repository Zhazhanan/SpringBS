package org.huha.bsgeneralmapper.bunisess.user;

import org.huha.bsgeneralmapper.bunisess.user.mapper.DashboardUserMapper;
import org.huha.bsgeneralmapper.bunisess.user.model.DashboardUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author WangKun
 * @create 2019-01-04
 * @desc
 **/
@RestController
public class UserController {

    @Autowired
    private DashboardUserMapper dashboardUserMapper;

    @GetMapping("/list")
    public List<DashboardUser> list() {
        return dashboardUserMapper.selectAll();
    }
}
