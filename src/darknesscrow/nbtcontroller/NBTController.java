package darknesscrow.nbtcontroller;



import darknesscrow.nbtcontroller.command.NBTCommand;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class NBTController extends JavaPlugin {
    private static NBTController instance;

    public NBTController() {
    }

    public void onEnable() {
        instance = getPlugin(NBTController.class);
        if (!(new File(this.getDataFolder(), "config.yml")).exists()) {
            this.saveDefaultConfig();

        }
        getLogger().info("darknessnbt iniciado");
        this.getCommand("jrmcnbt").setExecutor(new NBTCommand());
    }

    public void onDisable() {
        getLogger().info("darknessnbt desabilitado");
    }

    public static NBTController getInstance() {
        return instance;
    }
}