import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Assignment3 extends Application {

    @Override
    public void start(Stage stage) {

        // 1. Set ListView items
        ObservableList<String> data = FXCollections.observableArrayList("John","Emma","Liam");
        ListView<String> list = new ListView<>();
        list.setItems(data);

        // 2. Button click handler
        Button btn = new Button("Save");
        btn.setOnAction(e -> System.out.println("Saved"));
        btn.fire();

        // 3. Print TextField text
        TextField txt = new TextField("Java");
        System.out.println(txt.getText());

        // 4. Print ComboBox selected value
        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Java","Python","C++");
        combo.setValue("Python");
        System.out.println(combo.getValue());

        // 5. Delete "Emma"
        data.remove("Emma");

        // 6. Print Label text
        Label label = new Label("Welcome");
        label.setText("Hello");
        System.out.println(label.getText());

        // 7. TableView selected item
        TableView<String> table = new TableView<>();
        table.getItems().addAll("A","B","C");
        table.getSelectionModel().select(1);
        System.out.println(table.getSelectionModel().getSelectedItem());

        // 8. Disable button
        Button addBtn = new Button("Add");
        addBtn.setDisable(true);

        // 9. Add child to TreeItem
        TreeItem<String> root = new TreeItem<>("Courses");
        root.getChildren().add(new TreeItem<>("Java"));

        // 10. FilteredList starting with J
        ObservableList<String> names = FXCollections.observableArrayList("John","Joe","Emma");
        FilteredList<String> f = new FilteredList<>(names);
        f.setPredicate(name -> name.toLowerCase().startsWith("j"));

        // 11. Replace element at index 1
        ObservableList<String> data2 = FXCollections.observableArrayList("A","B","C");
        data2.set(1, "X");
        System.out.println(data2);

        // 12. TextField setText
        TextField field = new TextField();
        field.setText("JavaFX");
        field.appendText(" GUI");
        System.out.println(field.getText());

        // 13. TableView listener
        table.getSelectionModel().selectedItemProperty().addListener(
            (obs, oldVal, newVal) -> System.out.println(newVal)
        );

        // 14. ListChangeListener
        data.addListener((ListChangeListener<String>) change -> {
            System.out.println("Changed");
        });

        VBox rootPane = new VBox(list, btn, txt, combo, label, addBtn);
        stage.setScene(new Scene(rootPane, 300, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}