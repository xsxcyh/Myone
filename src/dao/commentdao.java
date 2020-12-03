package dao;

import bean.comment;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;

public class commentdao {

    public List<comment> getallrw() throws Exception {
        Connection conn = DBHelper.connection();
        String sql = "select * from rw2 order by id";
        try {
            return new QueryRunner().query(
                    conn, sql, new BeanListHandler<comment>(comment.class));
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }


    public comment addrw(comment comm) throws Exception {
        Connection conn = DBHelper.connection();
        String sql = "insert into rw2 values(?,?)";
        try {
            QueryRunner run = new QueryRunner();
            BigDecimal res = run.insert(conn, sql, new ScalarHandler<BigDecimal>()
                    , comm.getName() , comm.getBody());
            comm.setId(res.intValue());
            return comm;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void delete(int id) throws Exception {
        Connection conn = DBHelper.connection();
        String sql = "delete from rw2 where id = ?";
        try {
            new QueryRunner().update(conn, sql, id);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

}
