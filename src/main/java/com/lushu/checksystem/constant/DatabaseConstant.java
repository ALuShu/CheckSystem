package com.lushu.checksystem.constant;

/**
 * @author ALuShu
 * @Description
 * @date 2020/2/12
 */
public interface DatabaseConstant {


    /**
     * 系统的角色枚举
     */
    enum Role implements DatabaseConstant{
        //三个角色
        ROLE_ADMIN("ROLE_ADMIN"),
        ROLE_TEACHER("ROLE_TEACHER"),
        ROLE_STUDENT("ROLE_STUDENT");
        private String role;

        Role(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }
    }

    enum Authority implements DatabaseConstant{
        //角色权限
        MANAGE_USER("MANAGE_USER"),
        MANAGE_FILE("MANAGE_FILE"),
        MANAGE_ROLE("MANAGE_ROLE"),
        BASIC("BASIC");
        private String authority;

        Authority(String authority) {
            this.authority = authority;
        }

        public String getAuthority() {
            return authority;
        }
    }

    enum File implements DatabaseConstant{
        //文件夹和word文档
        DIRECTORY_FILE(0),
        WORD_FILE(1),

        //文档文件的status字段
        UNCHECKED(0),
        PASSED(1),
        CHECKED(2),
        UNPASSED(-1);

        private Integer flag;

        File(Integer flag) {
            this.flag = flag;
        }

        public Integer getFlag() {
            return flag;
        }
    }


}
