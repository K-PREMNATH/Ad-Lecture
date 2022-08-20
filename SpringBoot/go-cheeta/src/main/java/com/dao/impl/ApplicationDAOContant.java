package com.dao.impl;

public class ApplicationDAOContant {
    interface IVehicle{
        String INSERT_VEHICLE_CATEGORY = "insert into vehiclecategory(VehicleCategoryName) VALUES (?)";
        String GET_VEHICLE_CATEGORIES = "select VehicleCategoryId,VehicleCategoryName from vehiclecategory";

        String INSERT_VEHICLE_DETAIL = "insert into vehicledetail(BrandName, ModelName, VehicleCategoryId) VALUES (?,?,?)";

        String GET_VEHICLE_DETAIL = "select vd.VehicleDetailid,vd.BrandName,vd.ModelName,v.VehicleCategoryName from vehicledetail vd inner join vehiclecategory v on vd.VehicleCategoryId = v.VehicleCategoryId where VehicleDetailId = ";

        String GET_VEHICLE_DETAIL_LIST = "select vd.BrandName,vd.ModelName,v.VehicleCategoryName from vehicledetail vd inner join vehiclecategory v on vd.VehicleCategoryId = v.VehicleCategoryId";
    }
}
