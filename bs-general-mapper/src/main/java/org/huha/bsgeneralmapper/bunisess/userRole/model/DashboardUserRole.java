package org.huha.bsgeneralmapper.bunisess.userRole.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author WangKun
 * @create 2019-01-03
 * @desc
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardUserRole implements Serializable {
    private static final long serialVersionUID = 5138775649878309082L;

    @Id
    public Long userRoleId;
    public String userId;
    public String roleId;
}
