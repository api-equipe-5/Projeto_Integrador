// package com.spring.gantt.GanttBubbleSort;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import org.springframework.dao.DataAccessException;
// import org.springframework.jdbc.core.PreparedStatementCallback;
// import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
// import org.springframework.jdbc.core.namedparam.SqlParameterSource;
// import org.springframework.jdbc.support.GeneratedKeyHolder;
// import org.springframework.jdbc.support.KeyHolder;
// import org.springframework.stereotype.Repository;

// public class ProjetoDao {

//     public ProjetoDao(NamedParameterJdbcTemplate template) {  
//         this.template = template;  
//     }  
    
//     NamedParameterJdbcTemplate template; 

//     public List<Projeto> findAll() {
//         return template.query("select * from projeto", new ProjetoRowMapper());
//     }

    
//     // public void insertEmployee(Employee emp) {
//     //     final String sql = "insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values(:employeeId,:employeeName,:employeeEmail,:employeeAddress)";
//     //         KeyHolder holder = new GeneratedKeyHolder();
//     //         SqlParameterSource param = new MapSqlParameterSource()
//     //             .addValue("employeeId", emp.getEmployeeId())
//     //             .addValue("employeeName", emp.getEmployeeName())
//     //             .addValue("employeeEmail", emp.getEmployeeEmail())
//     //             .addValue("employeeAddress", emp.getEmployeeAddress());
//     //                     template.update(sql,param, holder);
//     // }

// }