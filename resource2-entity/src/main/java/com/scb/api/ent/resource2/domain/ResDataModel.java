package com.scb.api.ent.resource2.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scb.api.common.framework.utility.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Created by ....... on ......
 */

// Define information of this data model to be shown on Swagger
@ApiModel(value = "ResDataModel", description = "Description of this data model...")
// Only generate JSON element that value is not NULL
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResDataModel {

    private Integer attribute1;     // Use class instead of primitive data type (Integer instead of int) to allow null value
    private String attribute2;
    private Double attribute3;      // Use class instead of primitive data type (Double instead of double) to allow null value
    private Date attribute4;

    public ResDataModel(Integer attribute1, String attribute2, Double attribute3, Date attribute4) {
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
        this.attribute4 = attribute4;
    }

    // Add dummy constructor to support Jackson de-serialization of the RequestBody
    public ResDataModel() {
    }

    // Define name of JSON data element to be created
    @JsonProperty(value = "attribute1", required = true)
    // Define information of this data element to be shown on Swagger
    @ApiModelProperty(position = 1, required = true, dataType = "Integer", example = "1", notes = "Attribute1 (1: possible value#1, 2: possible value#2, 3: possible value#3)")
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
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    // Define name of JSON data element to be created
    @JsonProperty(value = "attribute3", required = false)
    // Define information of this data element to be shown on Swagger
    @ApiModelProperty(position = 3, required = false, dataType = "Double", example = "199.98", notes = "Attribute3")
    public Double getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(Double attribute3) {
        this.attribute3 = attribute3;
    }

    // Define name of JSON data element to be created
    @JsonProperty(value = "attribute4", required = false)
    // Define information of this data element to be shown on Swagger
    @ApiModelProperty(position = 4, required = false, dataType = "Double", example = "199.98", notes = "Attribute3")
    // Ensure date data element to be returned as String (for string UTC date representation in JSON
    // Use DateUtil.dateTimestampToUTCString(Date dte) from SCB API Framework to convert Date data type to string data type with ISO-8601 UTC date format
    // Use DateUtil.simpleDateToString(Date dte) from SCB API Framework to convert Date data type to string data type with ISO-8601 date format (without timestamp)
    public String getAttribute4() {
        return DateUtil.dateTimestampToUTCString(attribute4);
    }

    public void setAttribute4(Date attribute4) {
        this.attribute4 = attribute4;
    }

    // Generate the toString() to allow logging data model as application trace/debug
    @Override
    public String toString() {
        return "ResDataModel{" +
                "attribute1=" + attribute1 +
                ", attribute2='" + attribute2 + '\'' +
                ", attribute3=" + attribute3 +
                ", attribute4=" + attribute4 +
                '}';
    }
}