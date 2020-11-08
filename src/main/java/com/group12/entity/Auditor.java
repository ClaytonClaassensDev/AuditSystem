package com.group12.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: Auditor entity using Builder pattern
 */

//change to class, noted as entity, constructor modified to 'protected', map to make PK--make equals() and hashcode()
@Entity
public class Auditor {

    @Id
    private String auditorID;
    private String auditorFirstName, auditorSurname, auditorCellPhone;

    protected Auditor() {
    }

    private Auditor(Builder builder) {

        this.auditorID = builder.auditorID;
        this.auditorFirstName = builder.auditorFirstName;
        this.auditorSurname = builder.auditorSurname;
        this.auditorCellPhone = builder.auditorCellPhone;

    }

    public String getAuditorID() {
        return auditorID;
    }

    public String getAuditorFirstName() {
        return auditorFirstName;
    }

    public String getAuditorSurname() {
        return auditorSurname;
    }

    public String getAuditorCellPhone() {
        return auditorCellPhone;
    }

    @Override
    public String toString() {
        return "Auditor{" +
                "auditorID=" + auditorID +
                ", auditorCellPhone=" + auditorCellPhone +
                ", auditorFirstName='" + auditorFirstName + '\'' +
                ", auditorSurname='" + auditorSurname + '\'' +
                '}';
    }

    public static class Builder {


        private String auditorID, auditorFirstName, auditorSurname, auditorCellPhone;


        public Builder setAuditorID(String auditorID) {
            this.auditorID = auditorID;
            return this;
        }

        public Builder setAuditorFirstName(String auditorFirstName) {
            this.auditorFirstName = auditorFirstName;
            return this;
        }

        public Builder setAuditorSurname(String auditorSurname) {
            this.auditorSurname = auditorSurname;
            return this;
        }

        public Builder setAuditorCellPhone(String auditorCellPhone) {
            this.auditorCellPhone = auditorCellPhone;
            return this;
        }

        public Builder copy(com.group12.entity.Auditor auditor) {
            this.auditorID = auditor.auditorID;
            this.auditorFirstName = auditor.auditorFirstName;
            this.auditorSurname = auditor.auditorSurname;
            this.auditorCellPhone = auditor.auditorCellPhone;
            return this;
        }

        public Auditor build() {

            return new Auditor(this);

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.group12.entity.Auditor auditor = (com.group12.entity.Auditor) o;
        return auditorID.equals(auditor.auditorID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auditorID);
    }
}



