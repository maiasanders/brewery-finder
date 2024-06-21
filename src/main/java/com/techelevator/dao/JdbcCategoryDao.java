package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Category;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class JdbcCategoryDao implements CategoryDao {
    private JdbcTemplate template;
    private final String SELECT_STATEMENT = "SELECT c.category_id, category_name FROM category AS c ";
    private final String CANNOT_CONNECT_MSG = "Unable to connect to database";

    public JdbcCategoryDao(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Category getCategoryByName(String categoryName, boolean wild) {
        if (wild) categoryName = "%" + categoryName + "%";
        try {
            return template.queryForObject(SELECT_STATEMENT + "WHERE category_name ILIKE ?;", this::mapRowToCategory, categoryName);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(CANNOT_CONNECT_MSG, e);
        }
    }

    @Override
    public List<Category> getCategoriesByEventId(int id) {
        try {
            return template.query(SELECT_STATEMENT + "JOIN event_category AS ec ON c.category_id = ec.category WHERE event_id = ?;", this::mapRowToCategory, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException(CANNOT_CONNECT_MSG, e);
        }
    }

    private Category mapRowToCategory (ResultSet results, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(results.getInt("category_id"));
        category.setCategoryName(results.getString("category_name"));
        return category;
    }
}
