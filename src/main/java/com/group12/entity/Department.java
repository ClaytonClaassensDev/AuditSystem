package com.group12.entity;

public class Department {

    private int depid;
    private String depName;

    private Department(Builder builder) {
        this.depid = depid;
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public int getDepid() {
        return depid;
    }



    public static class Builder {

        private int depid;
        private String depName;




        public Builder setDepid(int depid) {
            this.depid = depid;
            return this;
        }

        public Builder setDepName(String depName) {
            this.depName = depName;
            return this;
        }


        public Builder copy(Department department)
        {

            this.depid = department.depid;
            this.depName = department.depName;


            return this;

        }


        public Department build()
        {

            return new Department(this);

        }


    }



}
