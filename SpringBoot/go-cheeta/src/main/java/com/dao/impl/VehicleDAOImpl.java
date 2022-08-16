package com.dao.impl;

import com.dao.VehicleDAO;
import com.dto.request.VehicleCategoryReq;
import com.dto.response.CommonResponse;
import com.dto.response.VehicleCategoriesRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public CommonResponse createVehicleCategory(VehicleCategoryReq vehicleCategoryReq) {
        CommonResponse commonResponse = null;
        int isInserted = 0;
        try{
            isInserted = jdbcTemplate.update(ApplicationDAOContant.IVehicle.INSERT_VEHICLE_CATEGORY,
                    vehicleCategoryReq.getVehicleCategoryName());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        commonResponse = new CommonResponse();
        commonResponse.setRes(isInserted == 1? true : false);
        commonResponse.setStatusCode(isInserted == 1? 1000 : 1036);
        commonResponse.setMessage(isInserted == 1? "Success" : "Unable to create the category, please try again...!");

        return commonResponse;
    }

    @Override
    public List<VehicleCategoriesRes> getVehicleCategories() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<VehicleCategoriesRes> list = new ArrayList<>();
        try {
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ApplicationDAOContant.IVehicle.GET_VEHICLE_CATEGORIES);
            while (resultSet.next()){
                VehicleCategoriesRes res = new VehicleCategoriesRes();
                res.setVehicleCategoryId(resultSet.getInt(1));
                res.setVehicleCategoryName(resultSet.getString(2));

                list.add(res);
            }
        }catch (SQLException exception){

        }catch (Exception exception){

        }
        return list;
    }
}
