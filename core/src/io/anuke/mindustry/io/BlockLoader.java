package io.anuke.mindustry.io;

import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.ObjectIntMap;
import io.anuke.mindustry.world.Block;
import io.anuke.mindustry.world.blocks.Blocks;
import io.anuke.mindustry.world.blocks.DefenseBlocks;
import io.anuke.mindustry.world.blocks.DistributionBlocks;
import io.anuke.mindustry.world.blocks.ProductionBlocks;
import io.anuke.mindustry.world.blocks.SpecialBlocks;
import io.anuke.mindustry.world.blocks.WeaponBlocks;
import io.anuke.ucore.util.Log;

public class BlockLoader {
    static final ObjectIntMap<String> defaultMap = map(
            "air", 0,
            "blockpart", 1,
            "deepwater", 2,
            "water", 3,
            "lava", 4,
            "oil", 5,
            "stone", 6,
            "blackstone", 7,
            "iron", 8,
            "coal", 9,
            "titanium", 10,
            "uranium", 11,
            "dirt", 12,
            "sand", 13,
            "ice", 14,
            "snow", 15,
            "grass", 16,
            "sandblock", 17,
            "snowblock", 18,
            "stoneblock", 19,
            "blackstoneblock", 20,
            "grassblock", 21,
            "mossblock", 22,
            "shrub", 23,
            "rock", 24,
            "icerock", 25,
            "blackrock", 26,
            "dirtblock", 27,
            "stoneWall", 28,
            "ironWall", 29,
            "steelWall", 30,
            "titaniumWall", 31,
            "duriumwall", 32,
            "compositeWall", 33,
            "steelWall-large", 34,
            "titaniumWall-large", 35,
            "duriumwall-large", 36,
            "titaniumShieldWall", 37,
            "repairTurret", 38,
            "megaRepairTurret", 39,
            "shieldGenerator", 40,
            "door", 41,
            "door-large", 42,
            "conduit", 43,
            "pulseConduit", 44,
            "liquidRouter", 45,
            "conveyor", 46,
            "steelConveyor", 47,
            "poweredconveyor", 48,
            "router", 49,
            "junction", 50,
            "conveyortunnel", 51,
            "liquidJunction", 52,
            "liquiditemjunction", 53,
            "powerBooster", 54,
            "powerLaser", 55,
            "powerLaserRouter", 56,
            "powerLaserCorner", 57,
            "teleporter", 58,
            "sorter", 59,
            "core", 60,
            "pump", 61,
            "fluxpump", 62,
            "smelter", 63,
            "crucible", 64,
            "coalpurifier", 65,
            "titaniumpurifier", 66,
            "oilrefinery", 67,
            "stoneformer", 68,
            "lavasmelter", 69,
            "stonedrill", 70,
            "irondrill", 71,
            "coaldrill", 72,
            "uraniumdrill", 73,
            "titaniumdrill", 74,
            "omnidrill", 75,
            "coalgenerator", 76,
            "thermalgenerator", 77,
            "combustiongenerator", 78,
            "rtgenerator", 79,
            "nuclearreactor", 80,
            "turret", 81,
            "doubleturret", 82,
            "machineturret", 83,
            "shotgunturret", 84,
            "flameturret", 85,
            "sniperturret", 86,
            "mortarturret", 87,
            "laserturret", 88,
            "waveturret", 89,
            "plasmaturret", 90,
            "chainturret", 91,
            "titancannon", 92,
            "playerspawn", 93,
            "enemyspawn", 94
    );
    static final IntMap<Block> blockmap = new IntMap<>();

    public static void load() {

        Block[] blockClasses = {
                Blocks.air,
                DefenseBlocks.compositeWall,
                DistributionBlocks.conduit,
                ProductionBlocks.coaldrill,
                WeaponBlocks.chainturret,
                SpecialBlocks.enemySpawn
                //add any new block sections here
        };

        for (String string : defaultMap.keys()) {
            Block block = Block.getByName(string);
            blockmap.put(defaultMap.get(string, -1), block);
        }

        for (Block block : Block.getAllBlocks()) {
            block.init();
        }

        Log.info("Total blocks loaded: {0}", Block.getAllBlocks().size);
    }

    public static Block getByOldID(int id) {
        return blockmap.get(id);
    }

    private static ObjectIntMap<String> map(Object... objects) {
        ObjectIntMap<String> map = new ObjectIntMap<>();
        for (int i = 0; i < objects.length / 2; i++) {
            map.put((String) objects[i * 2], (int) objects[i * 2 + 1]);
        }
        return map;
    }
}
