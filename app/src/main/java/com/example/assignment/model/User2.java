package com.example.assignment.model;

public class User2 {
        public String id;
        public String userName;
        public String password;
        public String fullName;

        public User2(String id, String UserName,String Password)
        {
            this.id=id;
            this.userName=UserName;
            this.password=Password;
        }
        //Parameter constructor containing all three parameters
        public User2(String id,String UserName,String Password, String FullName)
        {
            this.id=id;
            this.userName=UserName;
            this.password=Password;
            this.fullName=FullName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }
