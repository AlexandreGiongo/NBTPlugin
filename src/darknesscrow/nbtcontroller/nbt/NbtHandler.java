package darknesscrow.nbtcontroller.nbt;

import darknesscrow.nbtcontroller.config.ConfigManager;
import me.dpohvar.powernbt.PowerNBT;
import me.dpohvar.powernbt.api.NBTCompound;
import me.dpohvar.powernbt.api.NBTManager;
import org.bukkit.entity.Player;

public class NbtHandler {
    private static final NbtHandler instance = new NbtHandler();
    private final NBTManager manager = PowerNBT.getApi();

    private NbtHandler() {
    }

    public void setBdy(Player player, int value) {
        NBTCompound forgeData = this.manager.readForgeData(player);
        NBTCompound playerPersisted = forgeData.getCompound("PlayerPersisted");
        if (playerPersisted == null) {
            playerPersisted = new NBTCompound();
        }

        playerPersisted.put("jrmcBdy", value);
        forgeData.put("PlayerPersisted", playerPersisted);
        this.manager.writeForgeData(player, forgeData);
    }

    public void setEnrgy(Player player, int value) {
        NBTCompound forgeData = this.manager.readForgeData(player);
        NBTCompound playerPersisted = forgeData.getCompound("PlayerPersisted");
        if (playerPersisted == null) {
            playerPersisted = new NBTCompound();
        }

        playerPersisted.put("jrmcEnrgy", value);
        forgeData.put("PlayerPersisted", playerPersisted);
        this.manager.writeForgeData(player, forgeData);
    }

    public int getBdy(Player player) {
        NBTCompound forgeData = this.manager.readForgeData(player);
        NBTCompound playerPersisted = forgeData.getCompound("PlayerPersisted");
        if (playerPersisted == null) {
            return 0;
        } else if (playerPersisted.get("jrmcBdy") == null) {
            return 0;
        } else {
            int bdy;
            bdy = (Integer)playerPersisted.get("jrmcBdy");
            return bdy;
        }
    }

    public int getEnrgy(Player player) {
        NBTCompound forgeData = this.manager.readForgeData(player);
        NBTCompound playerPersisted = forgeData.getCompound("PlayerPersisted");
        if (playerPersisted == null) {
            return 0;
        } else if (playerPersisted.get("jrmcEnrgy") == null) {
            return 0;
        } else {
            return (int) (Integer)playerPersisted.get("jrmcEnrgy");
        }
    }

    public int getMaxBdy(Player player) {
        NBTCompound forgeData = this.manager.readForgeData(player);
        NBTCompound playerPersisted = forgeData.getCompound("PlayerPersisted");
        if (playerPersisted == null) {
            return 0;
        } else if (playerPersisted.get("jrmcCnsI") == null) {
            return 0;
        } else {
            return (int)((double)(Integer)playerPersisted.get("jrmcCnsI") * ConfigManager.getBodyMultiplier());
        }
    }

    public int getMaxEnrgy(Player player) {
        NBTCompound forgeData = this.manager.readForgeData(player);
        NBTCompound playerPersisted = forgeData.getCompound("PlayerPersisted");
        if (playerPersisted == null) {
            return 0;
        } else if (playerPersisted.get("jrmcCncI") == null) {
            return 0;
        } else {
            return (int)((double)(Integer)playerPersisted.get("jrmcCncI") * ConfigManager.getEnrgyMultiplier());
        }
    }

    public static NbtHandler getInstance() {
        return instance;
    }
}