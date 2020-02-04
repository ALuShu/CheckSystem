package com.lushu.checksystem.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ALuShu
 * @date 2020/1/10
 * @throws
 * @since
 * @Description 用户实体类，包含spring security的一些字段
 */
@Data
public class User implements UserDetails, Serializable, Comparable<User> {

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String department;
    private String major;
    private String createTime;
    private String lastLoginTime;
    /**
     * boolean默认值是false，最好在更新用户界面附带checkbox以防返回时没有下面几个值导致返回默认false
     */
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    @Override
    public int compareTo(User o) {
        return id - o.getId();
    }
}
