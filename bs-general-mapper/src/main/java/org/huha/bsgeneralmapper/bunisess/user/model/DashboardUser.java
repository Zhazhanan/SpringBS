package org.huha.bsgeneralmapper.bunisess.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "dashboard_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardUser implements Serializable {
    private static final long serialVersionUID = -1056692916601357612L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "JDBC")
    private String userId;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_status")
    private String userStatus;
}