package io.anuke.mindustry.world.blocks;

import io.anuke.mindustry.world.Block;
import io.anuke.mindustry.world.blocks.types.distribution.Conduit;
import io.anuke.mindustry.world.blocks.types.distribution.Conveyor;
import io.anuke.mindustry.world.blocks.types.distribution.Junction;
import io.anuke.mindustry.world.blocks.types.distribution.LiquidJunction;
import io.anuke.mindustry.world.blocks.types.distribution.LiquidRouter;
import io.anuke.mindustry.world.blocks.types.distribution.PowerBooster;
import io.anuke.mindustry.world.blocks.types.distribution.PowerLaser;
import io.anuke.mindustry.world.blocks.types.distribution.PowerLaserRouter;
import io.anuke.mindustry.world.blocks.types.distribution.Router;
import io.anuke.mindustry.world.blocks.types.distribution.Sorter;
import io.anuke.mindustry.world.blocks.types.distribution.Teleporter;
import io.anuke.mindustry.world.blocks.types.distribution.TunnelConveyor;

public class DistributionBlocks {

    public static final Block conduit = new Conduit("conduit") {{
        health = 45;
    }},

    pulseConduit = new Conduit("pulseconduit") {{
        liquidCapacity = 16f;
        flowfactor = 4.9f;
        health = 65;
    }},

    liquidRouter = new LiquidRouter("liquidrouter") {{
    }},

    conveyor = new Conveyor("conveyor") {{
    }},

    steelConveyor = new Conveyor("steelconveyor") {{
        health = 55;
        speed = 0.04f;
    }},

    pulseConveyor = new Conveyor("poweredconveyor") {{
        health = 75;
        speed = 0.09f;
    }},

    expressConveyor = new Conveyor("expressconveyor") {{
        health = 100;
        speed = 0.14f;
    }},

    router = new Router("router") {{
    }},

    junction = new Junction("junction") {{
    }},

    tunnel = new TunnelConveyor("conveyortunnel") {{
    }},

    liquidJunction = new LiquidJunction("liquidjunction") {{
    }},

    powerBooster = new PowerBooster("powerbooster") {{
        powerRange = 4;
    }},

    powerLaser = new PowerLaser("powerlaser") {{
    }},

    powerLaserRouter = new PowerLaserRouter("powerlaserrouter") {{
    }},

    powerLaserCorner = new PowerLaserRouter("powerlasercorner") {{
        laserDirections = 2;
    }},

    highPowerLaser = new PowerLaser("highpowerlaser") {{
        laserRange *= 2;
        powerSpeed *= 2;
        powerCapacity *= 3;
    }},

    highPowerLaserRouter = new PowerLaserRouter("highpowerlaserrouter") {{
        laserRange *= 2;
        powerSpeed *= 2;
        powerCapacity *= 3;
    }},

    highPowerLaserCorner = new PowerLaserRouter("highpowerlasercorner") {{
        laserRange *= 2;
        powerSpeed *= 2;
        powerCapacity *= 3;
        laserDirections = 2;
    }},

    veryHighPowerLaser = new PowerLaser("veryhighpowerlaser") {{
        laserRange *= 3;
        powerSpeed *= 3;
        powerCapacity *= 4;
    }},

    veryHighPowerLaserRouter = new PowerLaserRouter("veryhighpowerlaserrouter") {{
        laserRange *= 3;
        powerSpeed *= 3;
        powerCapacity *= 4;
    }},

    veryHighPowerLaserCorner = new PowerLaserRouter("veryhighpowerlasercorner") {{
        laserRange *= 3;
        powerSpeed *= 3;
        powerCapacity *= 4;
        laserDirections = 2;
    }},

    teleporter = new Teleporter("teleporter") {{
    }},

    sorter = new Sorter("sorter") {{
    }};
}
