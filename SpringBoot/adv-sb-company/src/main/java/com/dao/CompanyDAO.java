package com.dao;

import com.dto.request.UserInsertReq;
import com.dto.request.UserUpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

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
}
