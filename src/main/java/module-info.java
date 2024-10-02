module es.ieslosmontecillos.ejemplopathtransition {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.ejemplopathtransition to javafx.fxml;
    exports es.ieslosmontecillos.ejemplopathtransition;
}