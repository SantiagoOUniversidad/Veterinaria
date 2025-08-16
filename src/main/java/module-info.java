module co.edu.uniquindio.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;


    opens co.edu.uniquindio.veterinaria to javafx.fxml;
    exports co.edu.uniquindio.veterinaria;
    exports co.edu.uniquindio.veterinaria.Controladores;
    opens co.edu.uniquindio.veterinaria.Controladores to javafx.fxml;
}