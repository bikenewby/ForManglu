package com.scb.api.ent.resource2.domain;

/**
 * Created by ....... on ......
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.scb.api.common.framework.domain.pagination.PagingResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "ResDataModelWithPagination", description = "Description of this data model...")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResDataModelWithPagination {

    private List<ResDataModel> items;
    private PagingResponse pagination;

    // Add dummy constructor to support Jackson de-serialization of the RequestBody
    public ResDataModelWithPagination() {
    }

    @JsonProperty(value = "items", required = true)
    @ApiModelProperty(position = 1, required = true, notes = "List of ResDataModel items")
    public List<ResDataModel> getItems() {
        return items;
    }

    public void setItems(List<ResDataModel> items) {
        this.items = items;
    }

    @JsonProperty(value = "pagination", required = false)
    @ApiModelProperty(position = 2, required = false, notes = "Pagination information")
    public PagingResponse getPagination() {
        return pagination;
    }

    public void setPagination(PagingResponse pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "ResDataModelWithPagination{" +
                "items=" + items +
                ", pagination=" + pagination +
                '}';
    }
}
