package org.leye.maven.pinitbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author leye
 * @version 1.0
 * @description: 测试数据库连接
 * @date 2024/12/24 02:38
 */
@SpringBootTest
public class DBConnectionTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        // 执行一个简单的 SQL 查询来验证连接
        String sql = "SELECT 1";
        Integer result = jdbcTemplate.queryForObject(sql, Integer.class);

        // 如果能成功执行查询，则说明连接成功
        assert result != null && result == 1;
    }
}
