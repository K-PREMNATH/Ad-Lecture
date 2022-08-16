package com.controller.imp;

import com.business.VehicleBusiness;
import com.controller.VehicleController;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.CommonResponse;
import com.dto.response.VehicleCategoriesRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleControllerImpl implements VehicleController {

    @Autowired
    VehicleBusiness vehicleBusiness;

    @Override
    @PostMapping("/vehicle/create/category")
    public CommonResponse createVehicleCategory(@RequestBody VehicleCategoryReq vehicleCategoryReq) {
        return vehicleBusiness.createVehicleCategory(vehicleCategoryReq);
    }

    @Override
    @PostMapping("/vehicle/get/categories")
    public List<VehicleCategoriesRes> getVehicleCategories() {
        return vehicleBusiness.getVehicleCategories();
    }
}
