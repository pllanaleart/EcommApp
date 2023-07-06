package com.example.ecommapp.dashboard;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;



public class DashboardController implements Initializable {
    @FXML
    Label nameLbl;

    @FXML
    StackPane stackPane;
    @FXML
    ImageView imageView;
    @FXML
    private Button buyButton;
    @FXML
    public void onBuyButtonClick(ActionEvent event) {
        // Your purchase entity creation logic here.
        PurchaseEntity purchaseEntity = new PurchaseEntity("id", new Product("Phone","Iphone 14",1400), 2, 100.0);

        // Your database connection and query execution logic here.
        String jdbcUrl = "jdbc:mysql://localhost:3306/ecommerce";
        String jdbcUsername = "leart";
        String jdbcPassword = "continum";
        String query = "INSERT INTO purchase (id, product_id, units, purchase_price) VALUES (?, ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword)) {
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, purchaseEntity.getId());
                statement.setString(2, purchaseEntity.getProduct().getName());
                statement.setInt(3, purchaseEntity.getUnits());
                statement.setDouble(4, purchaseEntity.getPurchasePrice());

                statement.executeUpdate(); // For INSERT, UPDATE & DELETE statements.
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

        private static final String[] IMAGE_URLS = {
            "com/example/ecommapp/images/1589583203-ekster-wallet-1589583184.jpg",
            "com/example/ecommapp/images/1589583203-ekster-wallet-1589583184.jpg",
            "com/example/ecommapp/images/1589583203-ekster-wallet-1589583184.jpg"

    };

    private static final int SLIDESHOW_DELAY = 2000; // Delay in milliseconds

    private int currentIndex = 0;
    private UserEntity userEntity;

    public DashboardController(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

            imageView = new ImageView();
            stackPane = new StackPane(imageView);

            // Load the first imag

        }

    private void loadImage(ImageView imageView, InputStream stream) {
        Image image = new Image(stream);
        imageView.setImage(image);
    }
    public void onLblClick(){
        nameLbl.setText("Label clicked");
    }
}


