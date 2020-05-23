/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework.Helper;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import org.controlsfx.control.Notifications;

/**
 *
 * @author Larry
 */
public class UserAlerts {
    
    public void notifyUser(Image image, String title, String text){
        Notifications.create()
                            .title(title)                               
                            .text(text)
                            .position(Pos.BOTTOM_CENTER)
                            .graphic(new ImageView(image))
                            .darkStyle()
                            .show();
    }
    
    public void exitConfirmation(StackPane stackPane){
        JFXButton ok = new JFXButton("OK");
        JFXButton cancel = new JFXButton("Cancel");
        JFXDialogLayout dialogLayout = new JFXDialogLayout();
        dialogLayout.setHeading(new Text("Exit"));
        dialogLayout.setBody(new Text("Do you want to exit Application?"));
        dialogLayout.setStyle("-fx-Background-color: #D8D8D8; -fx-Background-radius: 10px");
        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);
        
        ok.setOnAction((e)->{
            System.exit(0);
        });
        
        cancel.setOnAction((e)->{
            dialog.close();
        });
        dialogLayout.setActions(ok, cancel);
        dialog.show();
    }
}
