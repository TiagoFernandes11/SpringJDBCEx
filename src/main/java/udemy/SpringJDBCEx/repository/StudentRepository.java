package udemy.SpringJDBCEx.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import udemy.SpringJDBCEx.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student s){
        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows);
    }

    public List<Student> findAll(){
        String sql = "select * from student";
        return jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}

