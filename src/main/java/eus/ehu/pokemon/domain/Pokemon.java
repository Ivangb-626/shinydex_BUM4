package eus.ehu.pokemon.domain;

import com.google.gson.annotations.SerializedName;


public class Pokemon {

    String name;
    Integer id;
    Integer weight;
    Integer height;

    //create a getter method for the name field
    public String getName() {
        return name;
    }
    //create a getter method for the id field
    public Integer getId() {
        return id;
    }
    //create a getter method for the weight field
    public Integer getWeight() {
        return weight;
    }
    //create a getter method for the height field
    public Integer getHeight() {
        return height;
    }
    public String getSprite() {
        return sprites.other.officialArtwork.front_shiny;
    }



    class Types{
        Integer slot;
        class Type{
            String name;
            //generate a toString method for Type class
            @Override
            public String toString() {
                return "Type{" +
                        "name='" + name + '\'' +
                        '}';
                    }
            }
        Type type;
        //generate a toString method for Types class
        @Override
        public String toString() {
            return "Types{" +
                    "slot=" + slot +
                    ", type=" + type +
                    '}';
                 }
    }
    Types[] types;
    //create a generator method for the types field
    public Pokemon () {
        Types[] types = new Types[2];
        types[0] = new Types();
        types[1] = new Types();
    }
    public String getTypes() {
        StringBuilder typesString = new StringBuilder();
        if (types != null && types.length > 0) {
            typesString.append(types[0].type.name);
            if (types.length > 1 && types[1] != null && types[1].type != null) {
                typesString.append(", ").append(types[1].type.name);
            } else {
                typesString.append(", none");
            }
        } else {
            typesString.append("none, none");
        }
        return typesString.toString();
    }
    class SpriteWrapper {
        String front_default;
        String back_default;
        String front_shiny;
        String back_shiny;
        class Other {
            class OfficialArtwork {
                String front_shiny;
                //generate a toString method for OfficialArtwork class
                @Override
                public String toString() {
                    return "OfficialArtwork{" +
                            "front_shiny='" + front_shiny + '\'' +
                            '}';
                }
            }
            @SerializedName("official-artwork")
            OfficialArtwork officialArtwork;
            //generate a toString method for Other class
            @Override
            public String toString() {
                return "Other{" +
                        "officialArtwork=" + officialArtwork +
                        '}';
            }
        }
        Other other;
        //generate a toString method for OfficialArtwork class
        @Override
        public String toString() {
            return "SpriteWrapper{" +
                    "front_default='" + front_default + '\'' +
                    ", back_default='" + back_default + '\'' +
                    ", front_shiny='" + front_shiny + '\'' +
                    ", back_shiny='" + back_shiny + '\'' +
                    ", other=" + other +
                    '}';
        }

    }


    SpriteWrapper sprites;




//generate a toString method for Pokemon class
@Override
public String toString() {
    StringBuilder typesString = new StringBuilder();
    if (types != null) {
        for (Types type : types) {
            if (type != null && type.type != null) {
                if (typesString.length() > 0) {
                    typesString.append(", ");
                }
                typesString.append(type.type.name);
            }
        }
    }
    return "Pokemon{" +
            "name='" + name + '\'' +
            ", id=" + id +
            ", weight=" + weight +
            ", height=" + height +
            ", sprites=" + sprites +
            ", types=" + typesString +
            '}';
}





}
