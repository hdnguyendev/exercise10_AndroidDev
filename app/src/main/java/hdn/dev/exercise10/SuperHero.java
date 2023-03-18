
package hdn.dev.exercise10;

import com.google.gson.annotations.SerializedName;

public class SuperHero {

    @SerializedName("name")
    private String name;

    public SuperHero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}