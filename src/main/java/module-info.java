module co.edu.uniquindio.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.veterinaria to javafx.fxml;
    exports co.edu.uniquindio.veterinaria;
    exports co.edu.uniquindio.veterinaria.Controladores;
    opens co.edu.uniquindio.veterinaria.Controladores to javafx.fxml;
}