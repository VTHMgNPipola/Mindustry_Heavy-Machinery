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

    public static final Block

            conduit = new Conduit("conduit") {{
        health = 45;
    }},

    pulseconduit = new Conduit("pulseconduit") {{
        liquidCapacity = 16f;
        flowfactor = 4.9f;
        health = 65;
    }},

    liquidrouter = new LiquidRouter("liquidrouter") {{

    }},

    conveyor = new Conveyor("conveyor") {{
    }},

    steelconveyor = new Conveyor("steelconveyor") {{
        health = 55;
        speed = 0.04f;
    }},

    pulseconveyor = new Conveyor("poweredconveyor") {{
        health = 75;
        speed = 0.09f;
    }},

    router = new Router("router") {{

    }},

    junction = new Junction("junction") {{

    }},
            tunnel = new TunnelConveyor("conveyortunnel") {{
            }},
            liquidjunction = new LiquidJunction("liquidjunction") {{

            }},
            powerbooster = new PowerBooster("powerbooster") {{
                powerRange = 4;
            }},
            powerlaser = new PowerLaser("powerlaser") {{
            }},
            powerlaserrouter = new PowerLaserRouter("powerlaserrouter") {{
            }},
            powerlasercorner = new PowerLaserRouter("powerlasercorner") {{
                laserDirections = 2;
            }},
            teleporter = new Teleporter("teleporter") {{
            }},
            sorter = new Sorter("sorter") {{
            }};
}
