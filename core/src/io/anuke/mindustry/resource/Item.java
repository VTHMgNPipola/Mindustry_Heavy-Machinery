package io.anuke.mindustry.resource;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import io.anuke.ucore.graphics.Draw;
import io.anuke.ucore.util.Bundles;

public class Item {
    public static final Item
            stone = new Item("stone"),
            iron = new Item("iron"),
            coal = new Item("coal"),
            steel = new Item("steel"),
            titanium = new Item("titanium"),
            dirium = new Item("dirium"),
            uranium = new Item("uranium"),
            sand = new Item("sand");
    private static Array<Item> items;
    public final int id;
    public final String name;
    //public float explosiveness = 0f;
    //public float flammability = 0f;
    public TextureRegion region;
    //silicon = new Item("silicon");

    public Item(String name) {
        if (items == null) {
            items = new Array<>();
        }

        this.id = items.size;
        this.name = name;

        items.add(this);
    }

    public static Array<Item> getAllItems() {
        return Item.items;
    }

    public static Item getByID(int id) {
        return items.get(id);
    }

    public void init() {
        this.region = Draw.region("icon-" + name);
    }

    public String localizedName() {
        return Bundles.get("item." + this.name + ".name");
    }

    @Override
    public String toString() {
        return localizedName();
    }
}
