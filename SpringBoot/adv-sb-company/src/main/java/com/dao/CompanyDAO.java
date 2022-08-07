package com.dao;

import com.dto.request.GetUserReq;
import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import com.dto.response.GetUserRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertUserRecord(UserInsertReq userInsertReq) {
        int isInserted = 0;
        try {
            String INSERT_USER_SQL = "insert into userdetail(FirstName, LastName, EmailAddress, MobileNumber, Password, Address) VALUES (?,?,?,?,?,?)";

            isInserted =
                    jdbcTemplate.update(INSERT_USER_SQL,
                            userInsertReq.getFirstName(),
                            userInsertReq.getLastName(),
                            userInsertReq.getEmailAddress(),
                            userInsertReq.getMobileNumber(),
                            passcodeEncrypt(passcodeEncrypt(userInsertReq.getPassword())),
                            userInsertReq.getAddress());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return isInserted;
    }

    public String passcodeEncrypt(String passcode) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(
                passcode.getBytes(StandardCharsets.UTF_8)).toString();
    }

    public int updateUserRecord(UserUpdateReq userUpdateReq) {
        int isInserted = 0;
        try {
            String UPDATE_USER_SQL = "update userdetail set FirstName = ? , LastName = ? , EmailAddress = ? , MobileNumber = ? , Password = ?, Address = ? where UserDetailId = ?";

            isInserted =
                    jdbcTemplate.update(UPDATE_USER_SQL,
                            userUpdateReq.getFirstName(),
                            userUpdateReq.getLastName(),
                            userUpdateReq.getEmailAddress(),
                            userUpdateReq.getMobileNumber(),
                            passcodeEncrypt(passcodeEncrypt(userUpdateReq.getPassword())),
                            userUpdateReq.getAddress(),
                            userUpdateReq.getUserDetailId());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return isInserted;
    }

    public GetUserRes getUserRecord(GetUserReq getUserReq) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        GetUserRes getUserRes = null;
        try {
            String SELECT_USER_BY_ID = "select UserDetailId, FirstName, LastName, EmailAddress, MobileNumber, Address from userdetail where UserDetailId ="+getUserReq.getUserDetailId();
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_USER_BY_ID);
            while (resultSet.next()){
                getUserRes = new GetUserRes();
                getUserRes.setUserDetailId(resultSet.getInt("UserDetailId"));
                getUserRes.setFirstName(resultSet.getString("FirstName"));
                getUserRes.setLastName(resultSet.getString("LastName"));
                getUserRes.setEmailAddress(resultSet.getString("EmailAddress"));
                getUserRes.setMobileNumber(resultSet.getString("MobileNumber"));
                getUserRes.setAddress(resultSet.getString("Address"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        return getUserRes;
    }

    public List<GetUserRes> getUserList() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<GetUserRes> list = new ArrayList<>();
        try {
            String SELECT_USERS = "select UserDetailId, FirstName, LastName, EmailAddress, MobileNumber, Address from userdetail";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_USERS);
            while (resultSet.next()){
                GetUserRes getUserRes = new GetUserRes();
                getUserRes.setUserDetailId(resultSet.getInt("UserDetailId"));
                getUserRes.setFirstName(resultSet.getString("FirstName"));
                getUserRes.setLastName(resultSet.getString("LastName"));
                getUserRes.setEmailAddress(resultSet.getString("EmailAddress"));
                getUserRes.setMobileNumber(resultSet.getString("MobileNumber"));
                getUserRes.setAddress(resultSet.getString("Address"));

                list.add(getUserRes);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }
        return list;
    }
}
