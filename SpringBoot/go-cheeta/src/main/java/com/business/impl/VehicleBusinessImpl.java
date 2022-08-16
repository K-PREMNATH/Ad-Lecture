package com.business.impl;

import com.business.VehicleBusiness;
import com.dao.VehicleDAO;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.CommonResponse;
import com.dto.response.VehicleCategoriesRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBusinessImpl implements VehicleBusiness {

    @Autowired
    VehicleDAO vehicleDAO;

    @Override
    public CommonResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq) {
        return vehicleDAO.createVehicleCategory(vehicleCategoryReq);
    }

    @Override
    public List<VehicleCategoriesRes> getVehicleCategories() {
        return vehicleDAO.getVehicleCategories();
    }
}
