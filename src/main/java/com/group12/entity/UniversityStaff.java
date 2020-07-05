package com.group12.entity;

/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: UniversityStaff entity using Builder pattern
 */


public class UniversityStaff {

    private String universityStaffID, universityStaffFirstName, universityStaffSurname, universityStaffCellPhone;


    private UniversityStaff(Builder builder) {

        this.universityStaffID = builder.universityStaffID;
        this.universityStaffFirstName = builder.universityStaffFirstName;
        this.universityStaffSurname = builder.universityStaffSurname;
        this.universityStaffCellPhone = builder.universityStaffCellPhone;

    }

    public String getUniversityStaffID() {
        return universityStaffID;
    }

    public String getUniversityStaffFirstName() {
        return universityStaffFirstName;
    }

    public String getUniversityStaffSurname() {
        return universityStaffSurname;
    }

    public String getUniversityStaffCellPhone() {
        return universityStaffCellPhone;
    }

    @Override
    public String toString() {
        return "UniversityStaff{" +
                "universityStaffID=" + universityStaffID +
                ", universityStaffCellPhone=" + universityStaffCellPhone +
                ", universityStaffFirstName='" + universityStaffFirstName + '\'' +
                ", universityStaffSurname='" + universityStaffSurname + '\'' +
                '}';
    }

    public static class Builder {

        private String universityStaffID, universityStaffFirstName, universityStaffSurname, universityStaffCellPhone;


        public Builder setUniversityStaffID(String universityStaffID) {
            this.universityStaffID = universityStaffID;
            return this;
        }

        public Builder setUniversityStaffFirstName(String universityStaffFirstName) {
            this.universityStaffFirstName = universityStaffFirstName;
            return this;
        }

        public Builder setUniversityStaffSurname(String universityStaffSurname) {
            this.universityStaffSurname = universityStaffSurname;
            return this;
        }

        public Builder setUniversityStaffCellPhone(String universityStaffCellPhone) {
            this.universityStaffCellPhone = universityStaffCellPhone;
            return this;
        }

        public Builder copy(UniversityStaff universityStaff) {
            this.universityStaffID = universityStaff.universityStaffID;
            this.universityStaffFirstName = universityStaff.universityStaffFirstName;
            this.universityStaffSurname = universityStaff.universityStaffSurname;
            this.universityStaffCellPhone = universityStaff.universityStaffCellPhone;

            return this;
        }

        public UniversityStaff build() {

            return new UniversityStaff(this);

        }
    }
}


