import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 500);
        Kuluarvestaja k1 = new Kuluarvestaja();
        Label juhis = new Label("Sisesta lahtrisse palk");

        TextField palk = new TextField();
        palk.setTranslateY(30);

        Button submit = new Button("Salvesta palk");
        submit.setTranslateY(60);

        Label juhis2 = new Label("Sisesta kulu nimetus");
        juhis2.setTranslateY(100);

        TextField kulu = new TextField();
        kulu.setTranslateY(130);

        Label juhis3 = new Label("Sisesta kulu suurus");
        juhis3.setTranslateY(160);

        TextField kulu2 = new TextField();
        kulu2.setTranslateY(190);

        Button submit2 = new Button("Sisesta kulu");
        submit2.setTranslateY(220);

        Label suurimkulu = new Label();
        suurimkulu.setTranslateY(250);

        Label info = new Label();
        info.setTranslateY(280);

        Label loobumine = new Label();
        loobumine.setTranslateY(310);

        pane.getChildren().addAll(juhis, palk, submit, juhis2, kulu, submit2, kulu2, juhis3, suurimkulu, info, loobumine);
        primaryStage.setScene(scene);
        primaryStage.show();

        submit.setOnMouseClicked(event -> {
            k1.nulliAndmed();
            info.setText("Uus palk salvestatud!");
            suurimkulu.setText("");
            loobumine.setText("");
            k1.setPalk(Integer.parseInt(palk.getText()));
        });

        submit2.setOnMouseClicked(event -> {
            info.setText(k1.sisestaKulu(kulu.getText(), kulu2.getText()));
            suurimkulu.setText(k1.kulu());
            loobumine.setText(k1.pakuLoobumist());
            kulu.clear();
            kulu2.clear();
        });

    }
}