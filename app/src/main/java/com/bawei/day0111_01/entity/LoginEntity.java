package com.bawei.day0111_01.entity;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01
 * ClassName:   LoginEntity
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:42
 */
public class LoginEntity {

    /**
     * result : {"headPic":"http://mobile.bwstudent.com/images/small/default/user.jpg","nickName":"NO_17t8b","phone":"15933383759","sessionId":"157881131292727804","sex":1,"userId":27804}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://mobile.bwstudent.com/images/small/default/user.jpg
         * nickName : NO_17t8b
         * phone : 15933383759
         * sessionId : 157881131292727804
         * sex : 1
         * userId : 27804
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String sessionId;
        private int sex;
        private int userId;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
