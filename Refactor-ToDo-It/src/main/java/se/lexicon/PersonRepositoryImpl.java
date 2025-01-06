package se.lexicon;

import se.lexicon.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {
    private final Connection connection;

    public PersonRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person findById(int id) {
        String query = "SELECT * FROM People WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    // Other methods (findAll, save, deleteById)...
}
