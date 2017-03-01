package com.scb.api.ent.resource2.impl;

/**
 * Created by ...... on .......
 */

import com.scb.api.common.framework.domain.exception.ErrorInfo;
import com.scb.api.common.framework.domain.exception.InputValidationException;
import com.scb.api.common.framework.utility.ELKLogger;
import com.scb.api.ent.resource2.domain.ReqDataModel;
import com.scb.api.ent.resource2.domain.ResDataModel;
import com.scb.api.ent.resource2.domain.ResDataModelWithPagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceAPIImpl {

    private static ELKLogger log = new ELKLogger(ResourceAPIImpl.class);

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
            throw new InputValidationException(ErrorInfo.REST_REQUEST_ERROR,"message of this error", ErrorInfo.SeverityLevel.ERROR, "Description of this error", "More info of this error");
        //-------------------------------------

        ResDataModelWithPagination response = new ResDataModelWithPagination();

        // BUSINESS LOGIC GOES HERE...

        return response;
    }

    public ResDataModel getResource(String reqUID,
                                    String ownerID,
                                    Integer attribute1) throws Exception {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        // Perform custom input validation here
        //-------------------------------------

        ResDataModel response = new ResDataModel();

        // BUSINESS LOGIC GOES HERE...

        return response;
    }

    public ResDataModel updateResource(String reqUID,
                                       String ownerID,
                                       Integer attribute1,
                                       ReqDataModel requestBody) throws Exception {

        log.info(this.getClass().getSimpleName() + " INITIATED...");

        // Perform custom input validation here
        //-------------------------------------

        ResDataModel response = new ResDataModel();

        // BUSINESS LOGIC GOES HERE...

        return response;
    }
}
