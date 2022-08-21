package com.dao.impl;

import com.dao.UserDAO;
import com.dto.request.UserRegistrationReq;
import com.dto.response.GeneralResponse;
import com.dto.response.UserRegistrationRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public GeneralResponse userRegistration(UserRegistrationReq userRegistrationReq) {
        GeneralResponse response = null;
        int isInserted = 0;
        try {
            String INSERT_USER_SQL = "insert into userdetail(FirstName, LastName, EmailAddress, Address, MobileNumber, UserPassword, UserType)" +
                    " VALUES (?,?,?,?,?,?,?)";

            isInserted =
                    jdbcTemplate.update(INSERT_USER_SQL,
                            userRegistrationReq.getFirstName(),
                            userRegistrationReq.getLastName(),
                            userRegistrationReq.getEmailAddress(),
                            userRegistrationReq.getAddress(),
                            userRegistrationReq.getMobileNumber(),
                            passcodeEncrypt(passcodeEncrypt(userRegistrationReq.getUserPassword())),
                            2
                            );

            if(isInserted == 1){
                response = GeneralResponse.generateResponse(
                        getUserByEmail(userRegistrationReq.getEmailAddress()),
                        1000,
                        "Success"
                );
            }else {
                response = GeneralResponse.generateResponse(null,1001,"Failed to register the Customer...!");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            response = GeneralResponse.generateResponse(null,1001,"Failed to register the Customer...!");
        }
        return response;
    }

    public UserRegistrationRes getUserByEmail(String emailAddress) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        UserRegistrationRes registrationRes = null;
        try {
            String SELECT_USER_BY_EMAIL = "select * from userdetail where EmailAddress = '"+emailAddress+"'";
            connection = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_USER_BY_EMAIL);
            while (resultSet.next()){
                registrationRes = new UserRegistrationRes();
                registrationRes.setUserId(resultSet.getInt("UserDetailId"));
                registrationRes.setUserType(resultSet.getInt("UserType"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {}
        }
        return registrationRes;
    }

    public String passcodeEncrypt(String passcode) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(
                passcode.getBytes(StandardCharsets.UTF_8)).toString();
    }
}
