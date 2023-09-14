package com.test.kms;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.*;

public class AESStringTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {

        if (!StringUtils.isEmpty(parameter)) {
            parameter = AWSCipher.encrypt(parameter);
        }
        ps.setString(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {

        String value = rs.getString(columnName);

        if (StringUtils.isEmpty(value)) {
            return null;
        } else {
            return AWSCipher.decrypt(value);
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        String columnName = rsmd.getCatalogName(columnIndex);
        String value = rs.getString(columnIndex);

        if (StringUtils.isEmpty(value)) {
            return null;
        } else {
            return AWSCipher.decrypt(value);
        }
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        ResultSet rs = cs.getResultSet();

        ResultSetMetaData rsmd = rs.getMetaData();
        String columnName = rsmd.getCatalogName(columnIndex);
        String value = rs.getString(columnIndex);

        if (StringUtils.isEmpty(value)) {
            return null;
        } else {
            return AWSCipher.decrypt(value);
        }
    }
}
