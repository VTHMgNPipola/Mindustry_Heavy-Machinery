package io.anuke.mindustry.world.blocks.types.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import io.anuke.mindustry.entities.TileEntity;
import io.anuke.mindustry.graphics.Fx;
import io.anuke.mindustry.resource.Item;
import io.anuke.mindustry.world.BlockBar;
import io.anuke.mindustry.world.Tile;
import io.anuke.mindustry.world.blocks.types.PowerAcceptor;
import io.anuke.ucore.core.Effects;
import io.anuke.ucore.core.Timers;
import io.anuke.ucore.graphics.Draw;
import io.anuke.ucore.util.Mathf;
import io.anuke.ucore.util.Strings;
import java.util.Arrays;

import static io.anuke.mindustry.Vars.world;

public abstract class ElectricSmelter extends Generator implements Smelter {
    protected final int timerDump = timers++;
    protected final int timerCraft = timers++;
    protected final int timerGenerate = timers++;
    public int powerRange = 3;
    protected Item[] inputs;
    protected Item result;
    // Time in frames
    protected float craftTime = 20f; // Time to craft one item, so max 3 items per second by default, assuming steady 60fps
    protected float burnDuration = 3f; // Default burn duration consumes a lot of power
    protected int capacity = 20;

    public ElectricSmelter(String name) {
        super(name);
        powerCapacity = 50f; // Default power capacity of a Electric Smelter
        update = true;
        solid = true;
        hasLasers = false;
    }

    @Override
    public void init() {
        for (Item item : inputs) {
            bars.add(new BlockBar(Color.GREEN, true, tile -> (float) tile.entity.getItem(item) / capacity));
        }
    }

    @Override
    public void getStats(Array<String> list) {
        super.getStats(list);
        list.add("[craftinfo]Input: " + Arrays.toString(inputs));
        list.add("[craftinfo]Fuel: ");
        list.add("[craftinfo]Output: " + result);
        list.add("[craftinfo]Fuel Duration: " + Strings.toFixed(burnDuration / 60f, 1));
        list.add("[craftinfo]Max output/second: " + Strings.toFixed(60f / craftTime, 1));
        list.add("[craftinfo]Input Capacity: " + capacity);
        list.add("[craftinfo]Output Capacity: " + capacity);
        list.add("[powerinfo]Power range: " + powerRange);
    }

    @Override
    public void update(Tile tile) {
        distributePower(tile);

        PowerCrafterEntity entity = tile.entity();

        // Make sure it has all the items
        for (Item item : inputs) {
            if (!entity.hasItem(item)) {
                return;
            }
        }

        if (entity.timer.get(timerDump, 5) && entity.hasItem(result)) {
            tryDump(tile, -1, result);
        }

        // Add fuel (power, in this case)
        if (entity.power > 0 && entity.burnTime <= 0f) {
            entity.power -= 1;
            entity.burnTime += burnDuration;
            Effects.effect(Fx.laserSpark, entity.x + Mathf.range(2f), entity.y + Mathf.range(2f));
        }

        if (entity.getItem(result) >= capacity // Output full
                || entity.burnTime <= 0 // Not burning
                || !entity.timer.get(timerCraft, craftTime)) { // Not yet time
            return;
        }

        // Decrement burn time
        if (entity.burnTime > 0) {
            entity.burnTime -= Timers.delta();
        }

        for (Item item : inputs) {
            entity.removeItem(item, 1);
        }

        offloadNear(tile, result);
        Effects.effect(Fx.smelt, entity);

        selfUpdate();
    }

    @Override
    public boolean acceptItem(Item item, Tile tile, Tile source) {
        boolean isInput = false;

        for (Item req : inputs) {
            if (req == item) { // There are not multiple instances of one Item, but the same shared reference
                isInput = true;
                break;
            }
        }

        return (isInput && tile.entity.getItem(item) < capacity);
    }

    @Override
    public void draw(Tile tile) {
        super.draw(tile);

        PowerCrafterEntity entity = tile.entity();

        //draw glowing center
        if (entity.burnTime > 0) {
            Draw.color(1f, 1f, 1f, Mathf.absin(Timers.time(), 9f, 0.4f) + Mathf.random(0.03f));
            Draw.rect("smelter-middle", tile.worldx(), tile.worldy());
            Draw.color();
        }
    }

    @Override
    public void drawLayer(Tile tile) {
    }

    @Override
    public boolean acceptsPower(Tile tile) {
        PowerEntity entity = tile.entity();

        return entity.power + 0.001f <= powerCapacity;
    }

    @Override
    public TileEntity getEntity() {
        return new PowerCrafterEntity();
    }

    // TODO better distribution
    protected void distributePower(Tile tile) {
        PowerEntity p = tile.entity();

        if (!p.timer.get(timerGenerate, powerTime)) {
            return;
        }

        int acceptors = 0;
        float flow = 0f;

        for (int i = 0; i < 2; i++) {
            for (int x = -powerRange; x <= powerRange; x++) {
                for (int y = -powerRange; y <= powerRange; y++) {

                    if (x == 0 && y == 0) {
                        continue;
                    }

                    if (Vector2.dst(x, y, 0, 0) < powerRange) {
                        Tile dest = world.tile(tile.x + x, tile.y + y);
                        if (dest != null && dest.block() instanceof PowerAcceptor && ((PowerAcceptor) dest.block()).acceptsPower(dest)) {
                            if (i == 1) {
                                PowerAcceptor block = (PowerAcceptor) dest.block();

                                float transmission = Math.min(flow, p.power);

                                float amount = block.addPower(dest, transmission);
                                p.power -= amount;
                            } else {
                                acceptors++;
                            }
                        }
                    }
                }
            }

            // TODO better distribution scheme
            if (i == 0 && acceptors > 0) {
                flow = Mathf.clamp(p.power / acceptors, 0f, powerSpeed / acceptors * Timers.delta());
            }
        }
    }

    public class PowerCrafterEntity extends PowerEntity {
        public float burnTime;
    }
}
