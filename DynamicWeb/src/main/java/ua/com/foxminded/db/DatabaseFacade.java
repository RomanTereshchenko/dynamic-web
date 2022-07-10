package ua.com.foxminded.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade {
	public static List<String> getBooks() {
		List<String> result = new ArrayList<String>();

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1974")) {
			System.out.println("Java JDBC PostgreSQL GET Example");

			System.out.println("Connected to PostgreSQL database!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM books.books");
			while (resultSet.next()) {
				result.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
		return result;
	}

	public static void addBook(int id, String name) {

		String addBookRequest = "INSERT INTO books.books VALUES(?, ?)";

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1974")) {
			System.out.println("Java JDBC PostgreSQL POST Example");
			System.out.println("Connected to PostgreSQL database.");

			PreparedStatement addBookStatement = connection.prepareStatement(addBookRequest);
			addBookStatement.setInt(1, id);
			addBookStatement.setString(2, name);

			addBookStatement.executeUpdate();

			System.out.println("Book added.");

		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}

	public static void deleteBook(int id) {

		String deleteBookRequest = "DELETE FROM books.books WHERE id=?";

		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres", "1974")) {
			System.out.println("Java JDBC PostgreSQL DELETE Example");
			System.out.println("Connected to PostgreSQL database.");

			PreparedStatement deleteBookStatement = connection.prepareStatement(deleteBookRequest);
			deleteBookStatement.setInt(1, id);

			deleteBookStatement.executeUpdate();

			System.out.println("Book deleted.");
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}
}