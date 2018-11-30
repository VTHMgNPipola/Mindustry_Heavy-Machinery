package io.anuke.mindustry.net;

import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import io.anuke.mindustry.net.Packets.AdministerRequestPacket;
import io.anuke.mindustry.net.Packets.BlockConfigPacket;
import io.anuke.mindustry.net.Packets.BlockDestroyPacket;
import io.anuke.mindustry.net.Packets.BlockLogRequestPacket;
import io.anuke.mindustry.net.Packets.BlockSyncPacket;
import io.anuke.mindustry.net.Packets.BlockTapPacket;
import io.anuke.mindustry.net.Packets.BlockUpdatePacket;
import io.anuke.mindustry.net.Packets.BreakPacket;
import io.anuke.mindustry.net.Packets.BulletPacket;
import io.anuke.mindustry.net.Packets.ChatPacket;
import io.anuke.mindustry.net.Packets.ConnectConfirmPacket;
import io.anuke.mindustry.net.Packets.ConnectPacket;
import io.anuke.mindustry.net.Packets.CustomMapPacket;
import io.anuke.mindustry.net.Packets.DisconnectPacket;
import io.anuke.mindustry.net.Packets.EnemyDeathPacket;
import io.anuke.mindustry.net.Packets.EntityRequestPacket;
import io.anuke.mindustry.net.Packets.EntitySpawnPacket;
import io.anuke.mindustry.net.Packets.FriendlyFireChangePacket;
import io.anuke.mindustry.net.Packets.GameOverPacket;
import io.anuke.mindustry.net.Packets.ItemOffloadPacket;
import io.anuke.mindustry.net.Packets.ItemSetPacket;
import io.anuke.mindustry.net.Packets.ItemTransferPacket;
import io.anuke.mindustry.net.Packets.KickPacket;
import io.anuke.mindustry.net.Packets.MapAckPacket;
import io.anuke.mindustry.net.Packets.NetErrorPacket;
import io.anuke.mindustry.net.Packets.PlacePacket;
import io.anuke.mindustry.net.Packets.PlayerAdminPacket;
import io.anuke.mindustry.net.Packets.PlayerDeathPacket;
import io.anuke.mindustry.net.Packets.PositionPacket;
import io.anuke.mindustry.net.Packets.RollbackRequestPacket;
import io.anuke.mindustry.net.Packets.ShootPacket;
import io.anuke.mindustry.net.Packets.StateSyncPacket;
import io.anuke.mindustry.net.Packets.SyncPacket;
import io.anuke.mindustry.net.Packets.TracePacket;
import io.anuke.mindustry.net.Packets.UpgradePacket;
import io.anuke.mindustry.net.Packets.WeaponSwitchPacket;
import io.anuke.mindustry.net.Packets.WorldData;
import io.anuke.mindustry.net.Streamable.StreamBegin;
import io.anuke.mindustry.net.Streamable.StreamChunk;

public class Registrator {
    private static Class<?>[] classes = {
            StreamBegin.class,
            StreamChunk.class,
            WorldData.class,
            SyncPacket.class,
            PositionPacket.class,
            ShootPacket.class,
            PlacePacket.class,
            BreakPacket.class,
            StateSyncPacket.class,
            BlockLogRequestPacket.class,
            RollbackRequestPacket.class,
            BlockSyncPacket.class,
            BulletPacket.class,
            EnemyDeathPacket.class,
            BlockUpdatePacket.class,
            BlockDestroyPacket.class,
            ConnectPacket.class,
            DisconnectPacket.class,
            ChatPacket.class,
            KickPacket.class,
            UpgradePacket.class,
            WeaponSwitchPacket.class,
            BlockTapPacket.class,
            BlockConfigPacket.class,
            EntityRequestPacket.class,
            ConnectConfirmPacket.class,
            GameOverPacket.class,
            FriendlyFireChangePacket.class,
            PlayerDeathPacket.class,
            CustomMapPacket.class,
            MapAckPacket.class,
            EntitySpawnPacket.class,
            ItemTransferPacket.class,
            ItemSetPacket.class,
            ItemOffloadPacket.class,
            NetErrorPacket.class,
            PlayerAdminPacket.class,
            AdministerRequestPacket.class,
            TracePacket.class
    };
    private static ObjectIntMap<Class<?>> ids = new ObjectIntMap<>();

    static {
        if (classes.length > 127) throw new RuntimeException("Can't have more than 127 registered classes!");
        for (int i = 0; i < classes.length; i++) {
            if (!ClassReflection.isAssignableFrom(Packet.class, classes[i]) &&
                    !ClassReflection.isAssignableFrom(Streamable.class, classes[i]))
                throw new RuntimeException("Not a packet: " + classes[i]);
            ids.put(classes[i], i);
        }
    }

    public static Class<?> getByID(byte id) {
        return classes[id];
    }

    public static byte getID(Class<?> type) {
        return (byte) ids.get(type, -1);
    }

    public static Class<?>[] getClasses() {
        return classes;
    }
}
