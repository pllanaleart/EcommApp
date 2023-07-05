package com.example.ecommapp.dashboard;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;



public class DashboardController implements Initializable {
    @FXML
    Label nameLbl;

    @FXML
    StackPane stackPane;
    @FXML
    ImageView imageView;
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
