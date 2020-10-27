package com.group12.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Department {


    @Id
    private String depid;
    private String depName;

    private Department(Builder builder) {
        this.depid = builder.depid;
        this.depName = builder.depName;
    }

    public String getDepName() {
        return depName;
    }

    public String getDepid() {
        return depid;
    }



    public static class Builder {

        private String depid;
        private String depName;




        public Builder setDepid(String depid) {
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