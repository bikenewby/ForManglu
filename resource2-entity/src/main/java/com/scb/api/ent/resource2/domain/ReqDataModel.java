package com.scb.api.ent.resource2.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;

/**
 * Created by ....... on ......
 */

// Define information of this data model to be shown on Swagger
@ApiModel(value = "ReqDataModel", description = "Description of this data model...")
// Only generate JSON element that value is not NULL
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReqDataModel {

    private Integer attribute1;     // Use class instead of primitive data type (Integer instead of int) to allow null value
    private String attribute2;

    public ReqDataModel(Integer attribute1, String attribute2) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
    }

    // Add dummy constructor to support Jackson de-serialization of the RequestBody
    public ReqDataModel() {
    }

    // Define name of JSON data element to be created
    @JsonProperty(value = "attribute1", required = true)
    // Define information of this data element to be shown on Swagger
    @ApiModelProperty(position = 1, required = true, dataType = "Integer", example = "1", notes = "Attribute1 (1: possible value#1, 2: possible value#2, 3: possible value#3)")
    // For enforcing request body validation if this data element is required (mandatory field)
    // See https://spring.io/guides/gs/validating-form-input/ for example of Spring input validation based on Bean Validation concept
    @NotNull
    // For enforcing request body validation if this numbering data element has minimum and maximum value)
    @Min(1)
    @Max(3)
    public Integer getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(Integer attribute1) {
        this.attribute1 = attribute1;
    }

    // Define name of JSON data element to be created
    @JsonProperty(value = "attribute2", required = true)
    // Define information of this data element to be shown on Swagger
    @ApiModelProperty(position = 2, required = true, dataType = "String", example = "01", notes = "Attribute2 (00: possible value#1, 01: possible value#2, 02: possible value#3, 03: possible value#4)")
    @NotNull
    // For enforcing request body validation if this string data element limits input based on defined length (min & max length)
    @Size(min = 2, max = 2)
    // For enforcing request body validation if this string data element limits input based on defined possible values
    @Pattern(regexp = "^(00|01|02|03)")
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    // Generate the toString() to allow logging data model as application trace/debug
    @Override
    public String toString() {
        return "ReqDataModel{" +
                "attribute1=" + attribute1 +
                ", attribute2='" + attribute2 + '\'' +
                '}';
    }
}
