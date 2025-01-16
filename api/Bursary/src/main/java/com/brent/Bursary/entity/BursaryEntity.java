package com.brent.Bursary.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name = "applications")
public class BursaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String first_name;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String last_name;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phone_number;

    @Column(name="gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name="kcse_grade")
    @JsonProperty("kcse_grade")
    private String kcse_grade;

    @Column(name="school")
    @JsonProperty("school")
    private String school;

    @Column(name="programe_fees")
    @JsonProperty("programe_fees")
    private String programe_fees;

    public BursaryEntity(){}

    public String toString() {
        return "EmployeeRequestBody{" +
                "firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", gender='" + gender + '\'' +
                ", kcse_grade='" + kcse_grade + '\'' +
                ", school='" + school + '\'' +
                ", programe_fees='" + programe_fees + '\'' +
                '}';
    }


}
