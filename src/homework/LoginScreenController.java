/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework;

import com.jfoenix.controls.JFXTextField;
import homework.Helper.UserAlerts;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Larry
 */
public class LoginScreenController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField password;
    DBConnection dc = new DBConnection();
    @FXML
    private StackPane stackPane;
    UserAlerts alert = new UserAlerts();
    private double x = 0, y = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeDragable();
    }

    @FXML
    public void loginOnMouseClicked(MouseEvent event) {
        String sql = "SELECT * FROM user";
        Image image = new Image("img/delete.png");
        Connection con = dc.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (username.getText().trim().toString().equals(rs.getString("username"))) {
                    if (password.getText().toString().equals(rs.getString("password"))) {
                        Stage stage = new Stage();
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("HomeWork.fxml"));
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            Stage current = (Stage) password.getScene().getWindow();
                            current.hide();
                            stage.setMaxWidth(1300);
//                            stage.minWidthProperty().bind(scene.heightProperty().multiply(0.5));
//                            stage.minHeightProperty().bind(scene.widthProperty().multiply(0.5));
                            stage.show();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        alert.notifyUser(image, "ERROR!", "Password wrong");
                    }
                } else {
                    if (!password.getText().toString().equals(rs.getString("password"))) {
                        alert.notifyUser(image, "ERROR!", "Username and Password wrong");
                    } else {
                        alert.notifyUser(image, "ERROR!", "Username wrong");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void loginOnKeyPressed(KeyEvent e) {
        MouseEvent event = null;
        if (e.getCode().equals(KeyCode.ENTER)) {
            loginOnMouseClicked(event);
        }
    }

    @FXML
    public void exitApplication(MouseEvent event) {
        alert.exitConfirmation(stackPane);
    }

    public void makeDragable() {
        stackPane.setOnMousePressed((event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        stackPane.setOnMouseDragged((event) -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            Stage stage = (Stage) stackPane.getScene().getWindow();
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
    }
}
