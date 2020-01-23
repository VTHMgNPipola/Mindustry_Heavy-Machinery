package io.anuke.mindustry.world.blocks;

import io.anuke.mindustry.graphics.Fx;
import io.anuke.mindustry.world.Block;
import io.anuke.mindustry.world.blocks.types.Wall;
import io.anuke.mindustry.world.blocks.types.defense.Door;
import io.anuke.mindustry.world.blocks.types.defense.RepairTurret;
import io.anuke.mindustry.world.blocks.types.defense.ShieldBlock;
import io.anuke.mindustry.world.blocks.types.defense.ShieldedWallBlock;

public class DefenseBlocks {
    static final int wallHealthMultiplier = 4;

    public static final Block stoneWall = new Wall("stonewall") {{
        health = 40 * wallHealthMultiplier;
    }},

    ironWall = new Wall("ironwall") {{
        health = 80 * wallHealthMultiplier;
    }},

    steelWall = new Wall("steelwall") {{
        health = 110 * wallHealthMultiplier;
    }},

    titaniumWall = new Wall("titaniumwall") {{
        health = 150 * wallHealthMultiplier;
    }},

    diriumWall = new Wall("duriumwall") {{ // "durium"?
        health = 190 * wallHealthMultiplier;
    }},

    compositeWall = new Wall("compositewall") {{
        health = 270 * wallHealthMultiplier;
    }},

    steelWallLarge = new Wall("steelwall-large") {{
        health = 110 * 4 * wallHealthMultiplier;
        width = height = 2;
    }},

    titaniumWallLarge = new Wall("titaniumwall-large") {{
        health = 150 * 4 * wallHealthMultiplier;
        width = height = 2;
    }},

    diriumWallLarge = new Wall("duriumwall-large") {{
        health = 190 * 4 * wallHealthMultiplier;
        width = height = 2;
    }},

    titaniumShieldWall = new ShieldedWallBlock("titaniumshieldwall") {{
        health = 150 * wallHealthMultiplier;
    }},

    repairTurret = new RepairTurret("repairturret") {
        {
            range = 30;
            reload = 20f;
            health = 60;
            powerUsed = 0.08f;
        }
    },

    megaRepairTurret = new RepairTurret("megarepairturret") {
        {
            range = 44;
            reload = 12f;
            health = 90;
            powerUsed = 0.13f;
        }
    },

    shieldGenerator = new ShieldBlock("shieldgenerator") {
        {
            health = 100 * wallHealthMultiplier;
        }
    },

    advancedShieldGenerator = new ShieldBlock("advancedshieldgenerator") {
        {
            health = 250 * wallHealthMultiplier;
            shieldRadius = maxRadius = 60f;
            powerCapacity = 50f;
            powerDrain = 0.0075f;
            powerPerDamage = 0.075f;
        }
    },

    extremeShieldGenerator = new ShieldBlock("extremeshieldgenerator") {
        {
            health = 600 * wallHealthMultiplier;
            shieldRadius = maxRadius = 90f;
            powerCapacity = 100f;
            powerDrain = 0.01f;
            powerPerDamage = 0.1f;
        }
    },

    door = new Door("door") {{
        health = 90 * wallHealthMultiplier;
    }},

    largeDoor = new Door("door-large") {{
        openfx = Fx.doorOpenLarge;
        closefx = Fx.doorCloseLarge;
        health = 90 * 4 * wallHealthMultiplier;
        width = height = 2;
    }};
}
