package chapter01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordQuery {

    private final Connection connection;

    public RecordQuery(Connection connection) {
        this.connection = connection;
    }

    public <T> T query(RowHandler<T> handler, String sql, Object... params) throws SQLException {

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int index = 1;
            for (Object param : params) {
                preparedStatement.setObject(index++, param);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            //调用RowHandler
            return handler.handle(resultSet);
        }
    }
}
