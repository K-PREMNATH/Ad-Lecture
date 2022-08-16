package com.dao;

import com.dto.request.VehicleCategoryReq;
import com.dto.response.CommonResponse;
import com.dto.response.VehicleCategoriesRes;

import java.util.List;

public interface VehicleDAO {
    CommonResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq);

    List<VehicleCategoriesRes> getVehicleCategories();
}
