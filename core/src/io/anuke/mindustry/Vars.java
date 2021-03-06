package io.anuke.mindustry;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;
import io.anuke.mindustry.core.Control;
import io.anuke.mindustry.core.GameState;
import io.anuke.mindustry.core.Logic;
import io.anuke.mindustry.core.NetClient;
import io.anuke.mindustry.core.NetCommon;
import io.anuke.mindustry.core.NetServer;
import io.anuke.mindustry.core.Platform;
import io.anuke.mindustry.core.Renderer;
import io.anuke.mindustry.core.ThreadHandler;
import io.anuke.mindustry.core.UI;
import io.anuke.mindustry.core.World;
import io.anuke.mindustry.entities.Bullet;
import io.anuke.mindustry.entities.Player;
import io.anuke.mindustry.entities.TileEntity;
import io.anuke.mindustry.entities.effect.Shield;
import io.anuke.mindustry.entities.enemies.Enemy;
import io.anuke.mindustry.net.ClientDebug;
import io.anuke.mindustry.net.EditLog;
import io.anuke.mindustry.net.ServerDebug;
import io.anuke.ucore.UCore;
import io.anuke.ucore.entities.EffectEntity;
import io.anuke.ucore.entities.Entities;
import io.anuke.ucore.entities.EntityGroup;
import io.anuke.ucore.scene.ui.layout.Unit;
import io.anuke.ucore.util.OS;
import java.util.Locale;

public class Vars {
    //shorthand for whether or not this is running on android
    public static final boolean testMobile = false;
    public static final boolean mobile = (Gdx.app.getType() == ApplicationType.Android) ||
            Gdx.app.getType() == ApplicationType.iOS || testMobile;
    public static final boolean playerDisabled = mobile; // TODO: Change this value based on playerDisabled setting
    public static final boolean ios = Gdx.app.getType() == ApplicationType.iOS;
    public static final boolean android = Gdx.app.getType() == ApplicationType.Android;
    //shorthand for whether or not this is running on GWT
    public static final boolean gwt = (Gdx.app.getType() == ApplicationType.WebGL);
    //whether to send block state change events to players
    public static final boolean syncBlockState = false;
    //how far away from the player blocks can be placed
    public static final float placerange = 66;
    //respawn time in frames
    public static final float respawnduration = 60 * 4;
    //time between waves in frames (on normal mode)
    public static final float wavespace = 60 * 60 * (mobile ? 1 : 1);
    //waves can last no longer than 3 minutes, otherwise the next one spawns
    public static final float maxwavespace = 60 * 60 * 4f;
    //advance time the pathfinding starts at
    public static final float aheadPathfinding = 60 * 15;
    //how far away from spawn points the player can't place blocks
    public static final float enemyspawnspace = 65;
    //discord group URL
    public static final String discordURL = "https://discord.gg/BKADYds";

    public static final String releasesURL = "https://api.github.com/repos/Anuken/Mindustry/releases";
    public static final String macAppDir = UCore.getProperty("user.home") + "/Library/Application Support/";
    //directory for user-created map data
    public static final FileHandle customMapDirectory = gwt ? null : UCore.isAssets() ?
            Gdx.files.local("../../desktop/mindustry-maps") :
            OS.isMac ? (Gdx.files.absolute(macAppDir).child("maps/")) :
                    Gdx.files.local("mindustry-maps/");
    //save file directory
    public static final FileHandle saveDirectory = gwt ? null : UCore.isAssets() ?
            Gdx.files.local("../../desktop/mindustry-saves") :
            OS.isMac ? (Gdx.files.absolute(macAppDir).child("saves/")) :
                    Gdx.files.local("mindustry-saves/");
    //camera zoom displayed on startup
    public static final int baseCameraScale = Math.round(Unit.dp.scl(4));
    //how much the zoom changes every zoom button press (unused?)
    public static final int zoomScale = Math.round(Unit.dp.scl(1));
    public static final int saveSlots = 64;
    //amount of drops that are left when breaking a block
    public static final float breakDropAmount = 0.5f;
    public static final int tilesize = 8;
    public static final Locale[] locales = {new Locale("en"), new Locale("fr"), new Locale("ru"), new Locale("uk", "UA"), new Locale("pl"),
            new Locale("de"), new Locale("pt", "BR"), new Locale("ko"), new Locale("in", "ID"), new Locale("ita"), new Locale("es")};
    public static final Color[] playerColors = {
            Color.valueOf("000000"),
            Color.valueOf("1d2b53"),
            Color.valueOf("7e2553"),
            Color.valueOf("008751"),
            Color.valueOf("ab5236"),
            Color.valueOf("5f574f"),
            Color.valueOf("c2c3c7"),
            Color.valueOf("fff1e8"),
            Color.valueOf("ff004d"),
            Color.valueOf("ffa300"),
            Color.valueOf("ffff27"),
            Color.valueOf("00e756"),
            Color.valueOf("29adff"),
            Color.valueOf("83769c"),
            Color.valueOf("ff77a8"),
            Color.valueOf("ffccaa"),
    };
    //server port
    public static final int port = 6567;
    public static final int webPort = 6568;
    public static final GameState state = new GameState();
    public static final ThreadHandler threads = new ThreadHandler(Platform.instance.getThreadProvider());
    public static final ServerDebug serverDebug = new ServerDebug();
    public static final ClientDebug clientDebug = new ClientDebug();
    public static final EntityGroup<Player> playerGroup = Entities.addGroup(Player.class).enableMapping();
    public static final EntityGroup<Enemy> enemyGroup = Entities.addGroup(Enemy.class).enableMapping();
    public static final EntityGroup<TileEntity> tileGroup = Entities.addGroup(TileEntity.class, false);
    public static final EntityGroup<Bullet> bulletGroup = Entities.addGroup(Bullet.class);
    public static final EntityGroup<Shield> shieldGroup = Entities.addGroup(Shield.class, false);
    public static final EntityGroup<EffectEntity> effectGroup = Entities.addGroup(EffectEntity.class, false);
    //scale of the font
    public static float fontscale = Math.max(Unit.dp.scl(1f) / 2f, 0.5f);
    //if true, player speed will be increased, massive amounts of resources will be given on start, and other debug options will be available
    public static boolean debug = false;
    public static boolean debugNet = true;
    public static boolean console = false;
    //whether the player can clip through walls
    public static boolean noclip = false;
    //whether to draw chunk borders
    public static boolean debugChunks = false;
    //whether turrets have infinite ammo (only with debug)
    public static boolean infiniteAmmo = true;
    //whether to show paths of enemies
    public static boolean showPaths = false;
    //if false, player is always hidden
    public static boolean showPlayer = true;
    //whether to hide ui, only on debug
    public static boolean showUI = true;
    //whether to show block debug
    public static boolean showBlockDebug = false;
    public static boolean headless = false;
    public static float controllerMin = 0.25f;
    public static float baseControllerSpeed = 11f;
    public static Array<EditLog> currentEditLogs = new Array<>();
    //only if smoothCamera
    public static boolean snapCamera = true;
    public static Control control;
    public static Logic logic;
    public static Renderer renderer;
    public static UI ui;
    public static World world;
    public static NetCommon netCommon;
    public static NetServer netServer;
    public static NetClient netClient;
    public static Player player;
}
