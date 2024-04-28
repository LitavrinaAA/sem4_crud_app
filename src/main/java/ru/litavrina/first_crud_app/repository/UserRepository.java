package ru.litavrina.first_crud_app.repository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.litavrina.first_crud_app.config.DbQueries;
import ru.litavrina.first_crud_app.model.User;


import java.util.List;

@Repository

public class UserRepository {

    private final JdbcTemplate jdbc;

    private final DbQueries db;

    public UserRepository(JdbcTemplate jdbc, DbQueries db) {
        this.jdbc = jdbc;
        this.db = db;
    }

    RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
    public List<User> findAll() {
        return jdbc.query(db.getFindAll(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(db.getSave(), user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id) {
        jdbc.update(db.getDelete(), id);
    }
    public void updateById( User user) {
        jdbc.update(db.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }
}
