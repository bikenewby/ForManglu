package com.scb.api.ent.resource2.controller;

/**
 * Created by ...... on ....
 */

import com.scb.api.common.framework.domain.exception.ErrorsList;
import com.scb.api.common.framework.utility.HostInfo;
import com.scb.api.common.framework.utility.ELKLogger;
import com.scb.api.ent.resource2.domain.ReqDataModel;
import com.scb.api.ent.resource2.domain.ResDataModel;
import com.scb.api.ent.resource2.domain.ResDataModelWithPagination;
import com.scb.api.ent.resource2.impl.ResourceAPIDummyImpl;
import com.scb.api.ent.resource2.impl.ResourceAPIImpl;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@EnableAutoConfiguration
@EnableDiscoveryClient
//@EnableCircuitBreaker
//@EnableFeignClients
@EnableSwagger2
// Define information of this Microservice for displaying on Swagger
@Api(tags = "Category.Resource", value = "/scb/rest/ent-api/v1/category/resource", description = "Description of this Resource APIs")
// Exclude the '/scb/rest/ent-api' since this prefix has already defined in application context path (see application.yml)
@RequestMapping(value = "/v1/category/resources")
public class ResourceAPI {
    // Define Logback

    private static ELKLogger log = new ELKLogger(ResourceAPI.class);

    // Comment the ResourceAPIDummyImpl and Uncomment ResourceAPIImpl for non-stub code.
    private ResourceAPIDummyImpl controllerImpl = new ResourceAPIDummyImpl();
    //private ResourceAPIImpl controllerImpl = new ResourceAPIImpl();

    //--------------------------------------------------
    //------------------- Resource ---------------------
    //--------------------------------------------------

    // GET: /scb/rest/ent-api/v1/category/resources

    // Define information of this API for displaying on Swagger
    @ApiOperation(value = "Get resources", nickname = "getResources", notes = "Description of this API")
    // Define information of HTTP response for this API for displaying on Swagger
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorsList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorsList.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorsList.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = ErrorsList.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorsList.class)})
    // RequestMapping to exclude context path '/scb/rest/ent-api' and the request mapping path specified at class level '/v1/category/resources'
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    ResDataModelWithPagination getResources(@RequestHeader(value = "requestUID", required = true) String reqUID,
                                            @RequestHeader(value = "resourceOwnerID", required = true) String ownerID, //TBD if this will be needed.
                                            // Define @ApiParam for specifying input parameter (for displaying on Swagger)
                                            @ApiParam(name = "inputParam1", value = "Description of inputParam1", required = true) @RequestParam(value = "inputParam1", required = true) String inputParam1,
                                            // Note: Simple data type validation & required field validation of input parameter (query parameter & path parameter will be performed automatically before reaching controller class.
                                            // Note: Custom validation must be implemented locally (see implementation class)
                                            @ApiParam(name = "inputParam2", value = "Description of inputParam2", required = true) @RequestParam(value = "inputParam2", required = true) Integer inputParam2,
                                            @ApiParam(name = "pagingOffset", value = "Starting record of the page") @RequestParam(value = "pagingOffset", required = false) Integer pagingOffSet,
                                            @ApiParam(name = "pagingLimit", value = "Maximum number of record to be fetched in each page. Default is 20.") @RequestParam(value = "pagingLimit", required = false) Integer pagingLimit,
                                            HttpServletRequest request) throws Exception {

        log.info(HostInfo.getHostAddressForLog() + " " + request.getMethod() + " " + HostInfo.getFullURL(request) + " INITIATED...");

        return controllerImpl.getResources(reqUID, ownerID, inputParam1, inputParam2, pagingOffSet, pagingLimit);
    }

    // GET: /scb/rest/ent-api/v1/category/resources/{attribute1}

    // Define information of this API for displaying on Swagger
    @ApiOperation(value = "Get a resource", nickname = "getResource", notes = "Description of this API")
    // Define information of HTTP response for this API for displaying on Swagger
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorsList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorsList.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorsList.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = ErrorsList.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorsList.class)})
    @RequestMapping(value = "/{attribute1}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    ResDataModel getResource(@RequestHeader(value = "requestUID", required = true) String reqUID,
                                            @RequestHeader(value = "resourceOwnerID", required = true) String ownerID, //TBD if this will be needed.
                                            @PathVariable(value = "attribute1") Integer attribute1,
                                            HttpServletRequest request) throws Exception {

        log.info(HostInfo.getHostAddressForLog() + " " + request.getMethod() + " " + HostInfo.getFullURL(request) + " INITIATED...");

        return controllerImpl.getResource(reqUID, ownerID, attribute1);
    }

    // PUT: /scb/rest/ent-api/v1/category/resource

    // Define information of this API for displaying on Swagger
    @ApiOperation(value = "Update a resource", nickname = "updateResource", notes = "Description of this API")
    // Define information of HTTP response for this API for displaying on Swagger
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorsList.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = ErrorsList.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ErrorsList.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = ErrorsList.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorsList.class)})
    @RequestMapping(value = "/{attribute1}", method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    ResDataModel updateResource(@RequestHeader(value = "requestUID", required = true) String reqUID,
                                               @RequestHeader(value = "resourceOwnerID", required = true) String ownerID, //TBD if this will be needed.
                                               @PathVariable(value = "attribute1") Integer attribute1,
                                               // Specify @Valid annotation to enable validation of request body
                                               // The validation is performed based on constraint defined in data model class (Bean validation concept)
                                                @Valid @RequestBody(required = true) ReqDataModel requestBody,
                                               HttpServletRequest request) throws Exception {

        log.info(HostInfo.getHostAddressForLog() + " " + request.getMethod() + " " + HostInfo.getFullURL(request) + " INITIATED...");

        return controllerImpl.updateResource(reqUID, ownerID, attribute1, requestBody);
    }
}