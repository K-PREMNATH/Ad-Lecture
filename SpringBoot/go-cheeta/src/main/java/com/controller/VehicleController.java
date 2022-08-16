package com.controller;

import com.dto.request.VehicleCategoryReq;
import com.dto.response.CommonResponse;
import com.dto.response.VehicleCategoriesRes;

import java.util.List;

public interface VehicleController {
    /**
     * createVehicleCategory
     * create a new category
     */
    public CommonResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq);

    /**
     * getVehicleCategories
     * dropdown -  list of categories
     */
    public List<VehicleCategoriesRes> getVehicleCategories();

}
