package darknesscrow.nbtcontroller.config;


import darknesscrow.nbtcontroller.NBTController;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
    static FileConfiguration config;
    static double bodyMultiplier;
    static double enrgyMultiplier;

    public ConfigManager() {
    }

    public static double getBodyMultiplier() {
        return bodyMultiplier;
    }

    public static double getEnrgyMultiplier() {
        return enrgyMultiplier;
    }

    public static void customConfigLoad() {
        config = new YamlConfiguration();
        File file = new File(NBTController.getInstance().getDataFolder() + File.separator + "config.yml");

        try {
            config.loadFromString(Files.toString(file, StandardCharsets.UTF_8));
        } catch (InvalidConfigurationException | IOException var2) {
            var2.printStackTrace();
        }

    }

    public static FileConfiguration getConfig() {
        return config;
    }

    static {
        final NBTController instance = NBTController.getInstance();
        config = ((NBTController)NBTController.getPlugin(NBTController.class)).getConfig();
        bodyMultiplier = config.getDouble("Attributes.Multiplier.BODY");
        enrgyMultiplier = config.getDouble("Attributes.Multiplier.ENERGY");
    }
}