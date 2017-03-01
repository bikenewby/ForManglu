package com.scb.api.ent.resource2.impl;

/**
 * Created by ........ on .........
 */

import com.scb.api.common.framework.domain.exception.ErrorInfo;
import com.scb.api.common.framework.domain.exception.InputValidationException;
import com.scb.api.common.framework.domain.pagination.PagingResponse;
import com.scb.api.common.framework.utility.ELKLogger;
import com.scb.api.ent.resource2.domain.ReqDataModel;
import com.scb.api.ent.resource2.domain.ResDataModel;
import com.scb.api.ent.resource2.domain.ResDataModelWithPagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;

public class ResourceAPIDummyImpl {

	private static ELKLogger log = new ELKLogger(ResourceAPIDummyImpl.class);


    //--------------------------------------------------
    //------------------- Resource ---------------------
    //--------------------------------------------------

    public ResDataModelWithPagination getResources(String reqUID,
                                                   String ownerID,
                                                   String inputParam1,
                                                   Integer inputParam2,
                                                   Integer pagingOffSet,
                                                   Integer pagingLimit) throws Exception {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        // Perform custom input validation here
        // Example of cross-input fields validation (inputParam1 must be 00 AND inputParam2 must be 0)
        if (!((inputParam1.toUpperCase().equals("00")) && (inputParam2 == 0)))
            throw new InputValidationException(ErrorInfo.REST_REQUEST_ERROR,"custom validation error message", ErrorInfo.SeverityLevel.ERROR, "Description of this error ex.inputParam1 must be 00 AND inputParam2 must be 0", "More info of this error");
        //-------------------------------------

        ResDataModelWithPagination response = new ResDataModelWithPagination();
        ArrayList<ResDataModel> items = new ArrayList<ResDataModel>();

        // Create 1st record
        ResDataModel item = new ResDataModel(1,"resource2 - RecordAttribute#1", 999.99, new Date());
        items.add(item);
        // Create 2nd record
        item = new ResDataModel(2,"resource2 - RecordAttribute#2", 888.88, new Date());
        items.add(item);
        // Create 3rd record
        item = new ResDataModel(3,"resource2 - RecordAttribute#3", 777.77, new Date());
        items.add(item);
        // Create 4th record
        item = new ResDataModel(4,"resource2 - RecordAttribute#4", 666.66, new Date());
        items.add(item);
        response.setItems(items);

        // If request contain input query parameters for pagination, return pagination response as well.
        if ((pagingOffSet != null) && (pagingLimit != null))
            response.setPagination(new PagingResponse(pagingOffSet, pagingLimit, "/scb/rest/ent-api/v1/category/resources?", (pagingOffSet - pagingLimit), (pagingOffSet + pagingLimit), 0));

        return response;
    }

    public ResDataModel getResource(String reqUID,
                                    String ownerID,
                                    Integer attribute1) throws Exception {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        ResDataModel response = new ResDataModel(attribute1,"Record n-Attribute#2", 999.99, new Date());

        return response;
    }

    public ResDataModel updateResource(String reqUID,
                                       String ownerID,
                                       Integer attribute1,
                                       ReqDataModel requestBody) throws Exception {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        ResDataModel response = new ResDataModel(attribute1,"Record n-Attribute#2", 999.99, new Date());

        return response;
    }
}
