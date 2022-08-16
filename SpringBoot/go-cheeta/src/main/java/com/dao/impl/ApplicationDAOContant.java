package com.dao.impl;

public class ApplicationDAOContant {
    interface IVehicle{
        String INSERT_VEHICLE_CATEGORY = "insert into vehiclecategory(VehicleCategoryName) VALUES (?)";
        String GET_VEHICLE_CATEGORIES = "select VehicleCategoryId,VehicleCategoryName from vehiclecategory";
    }
}
