module eus.ehu.pokemon {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires com.google.gson;
    requires okhttp3;

    opens eus.ehu.pokemon to javafx.fxml;
    exports eus.ehu.pokemon;
    opens eus.ehu.pokemon.domain to com.google.gson;
}