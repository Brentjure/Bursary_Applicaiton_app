package com.brent.Bursary.dto;

import com.brent.Bursary.entity.BursaryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class BursaryResponseBody {
    @Valid
    @JsonProperty("employee")
    private BursaryEntity bursary;

    @JsonProperty("bursaryStatus")
    private String bursaryStatus;

    @JsonProperty("message")
    private String message;

    public BursaryResponseBody(@Valid BursaryEntity bursaryEntity, String bursaryStatus, String message) {
        this.bursary = bursaryEntity;
        this.bursaryStatus = bursaryStatus;
        this.message = message;
    }

    // Add getter for employee field
    public BursaryEntity getBursary() {
        return bursary; }

    @Override
    public String toString() {
        return "BursaryResponseBody{" +
                "employee=" + bursary +
                ", employeeStatus='" +
                bursaryStatus + '\'' + ", message='" + message + '\'' + '}'; }

}
