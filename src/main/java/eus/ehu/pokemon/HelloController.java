package eus.ehu.pokemon;

import com.google.gson.Gson;
import eus.ehu.pokemon.domain.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {

        @FXML
        private TextArea content;

        @FXML
        private ImageView icon;

        @FXML
        private TextField name;

        @FXML
        private TextArea pokemonname;

        @FXML
        private TextArea pokemontype;

        @FXML
        private TextArea pokemonweight;

        @FXML
        void actionGet (ActionEvent  event) {
            Gson gson = new Gson();
            if (name.getText().isEmpty()) {
                content.setText("Please enter a Pokemon name");
            }
            else if (!name.getText().isEmpty()) {
                String json = Utils.query("https://pokeapi.co/api/v2/pokemon/" + name.getText().toLowerCase());
                //String json =  Utils.readFile("2025-03-10T190102.200.json");
                if (isValidJsonObject(json)) {
                    Pokemon pokemon = gson.fromJson(json, Pokemon.class);

                    String url = pokemon.getSprite();
                    icon.setImage(new Image(url));
                    content.setText(pokemon.toString());
                    pokemonname.setText(pokemon.getName().toUpperCase() + " (" + pokemon.getId() + ")");
                    pokemontype.setText("Type: " + pokemon.getTypes());
                    pokemonweight.setText("Weight: " + pokemon.getWeight() + "hg (hectograms) \nHeight: " + pokemon.getHeight() + "dm (decimeters)");
                }

            else{
                    content.setText("Please enter a valid Pokemon name");
                }
            }
        }

        @FXML
        void next (ActionEvent  event){
            Gson gson = new Gson();
            //get the id number of the pokemon from the text field and increment it by 1
            String pokemonNameText = pokemonname.getText();
            Pattern pattern = Pattern.compile("\\((\\d+)\\)");
            Matcher matcher = pattern.matcher(pokemonNameText);
            int id = 1;
            if (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));
                if (id < 1025) {
                    id++;
                }
                else {
                    id = 1;
                }
                // Now you have the id number extracted from the pokemonname TextArea
            }
            String json = Utils.query("https://pokeapi.co/api/v2/pokemon/"+ id );
            //String json =  Utils.readFile("2025-03-10T190102.200.json");
            Pokemon pokemon = gson.fromJson(json, Pokemon.class);

            String url= pokemon.getSprite();
            icon.setImage(new Image(url));
            content.setText(pokemon.toString());
            pokemonname.setText(pokemon.getName().toUpperCase() + " ("  + pokemon.getId() + ")");
            pokemontype.setText("Type: " + pokemon.getTypes());
            pokemonweight.setText("Weight: " + pokemon.getWeight() + "hg (hectograms) \nHeight: " + pokemon.getHeight() + "dm (decimeters)");
        }

        @FXML
        void previous (ActionEvent  event){
            Gson gson = new Gson();

            String pokemonNameText = pokemonname.getText();
            Pattern pattern = Pattern.compile("\\((\\d+)\\)");
            Matcher matcher = pattern.matcher(pokemonNameText);
            int id = 1;
            if (matcher.find()) {
                id = Integer.parseInt(matcher.group(1));
                if (id > 1) {
                    id--;
                }
                else {
                    id = 1025;
                }
                // Now you have the id number extracted from the pokemonname TextArea
            }
            String json = Utils.query("https://pokeapi.co/api/v2/pokemon/"+ id);
            //String json =  Utils.readFile("2025-03-10T190102.200.json");
            Pokemon pokemon = gson.fromJson(json, Pokemon.class);

            String url= pokemon.getSprite();
            icon.setImage(new Image(url));
            content.setText(pokemon.toString());
            pokemonname.setText(pokemon.getName().toUpperCase() + " ("  + pokemon.getId() + ")");
            pokemontype.setText("Type: " + pokemon.getTypes());
            pokemonweight.setText("Weight: " + pokemon.getWeight() + "hg (hectograms) \nHeight: " + pokemon.getHeight() + "dm (decimeters)");
        }

    private boolean isValidJsonObject(String json) {
        try {
            new Gson().fromJson(json, Object.class);
            return json.trim().startsWith("{");
        } catch (Exception e) {
            return false;
        }
    }

        @FXML
        void initialize() {

        }

    }