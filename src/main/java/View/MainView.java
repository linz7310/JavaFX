package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * ClassName GameBoardView
 * Package View
 * Description:
 *
 * @Author: Lin
 * @Creat: 2023/11/20
 */
public class MainView extends Application{
    public static void main(String[] args) {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // 添加游戏板、得分板等组件
        // GameBoardView gameBoardView = new GameBoardView();
        // root.setCenter(gameBoardView);

        // 配置和显示舞台
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Simon's Obstacle Course");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   


       


    }

