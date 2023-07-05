package com.example.ecommapp;

import com.example.ecommapp.dashboard.DashboardController;
import com.example.ecommapp.dashboard.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginController {
    @FXML
    private TextField usernameTxt;
    @FXML
    private PasswordField passwotrdTxt;
    private Stage stage;
    private String jdbcUrl = "jdbc:mysql://localhost:3306/ecommerce";
    private String jdbcUsername = "leart";
    private String jdbcPassword = "continum";
    private UserEntity userEntity;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String query = "SELECT * from user where email = ? AND password = ?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1,usernameTxt.getText());
            statement.setString(2,passwotrdTxt.getText());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                userEntity= new UserEntity(resultSet.getInt("iduser"),resultSet.getString("name"),resultSet.getString("role"));
                switchToDashboard(event);

            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login error");
                alert.setContentText("Please write the right username and password ");
                alert.showAndWait();
            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }



    public void switchToDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dashboard-view.fxml"));
        DashboardController dashboardController = new DashboardController(userEntity);
        fxmlLoader.setController(dashboardController);
        Parent root1 = fxmlLoader.load();
        Node node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Dashboard");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}