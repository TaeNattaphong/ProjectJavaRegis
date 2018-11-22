package sample;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox {
    public static void display(String title, String massage, double width, double height) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(width);
        window.setMinHeight(height);

        Label label = new Label();
        Label label1 = new Label();
        label.setText(massage);
        label.setTextFill(Paint.valueOf("#ffffff"));
        Button button = new Button("X");
        button.setPrefSize(25,25);
        button.setStyle(
                "-fx-background-radius: 15; " +
                        "-fx-background-color: #ff0000");
        button.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #404040;");
        layout.getChildren().addAll(label, label1 ,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();

    }

    public static void displayAccount(String title, String name, String studentID, double width, double height, Button b) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(width);
        window.setMinHeight(height);

        Label label = new Label();
        Label label1 = new Label();
        label.setText("ชื่อ - นามสกุล :   " + name);
        label1.setText("รหัสนิสิต :      " + studentID);
        label.setTextFill(Paint.valueOf("#ffffff"));
        label1.setTextFill(Paint.valueOf("#ffffff"));
        Button button = new Button("X");
        button.setPrefSize(25,25);
        button.setStyle(
                "-fx-background-radius: 15; " +
                        "-fx-background-color: #ff0000");
        button.setOnAction(e -> window.close());

        GridPane layout = new GridPane();
        layout.add(new Label("   "), 0, 0);
        layout.add(new Label("           "), 0, 1);
        layout.add(label, 1, 1);
        layout.add(new Label("           "), 1, 2);
        layout.add(new Label("           "), 0, 3);
        layout.add(label1, 1, 3);
        layout.add(new Label("  "), 1, 4);
        layout.add(button, 2, 4);
        layout.setStyle("-fx-background-color: #373737;");

        Scene scene = new Scene(layout);
        window.initStyle(StageStyle.UNDECORATED);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
        b.setStyle("-fx-background-color: #404040;");
    }
}
