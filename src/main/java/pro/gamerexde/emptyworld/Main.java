package pro.gamerexde.emptyworld;

import org.bukkit.*;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import pro.gamerexde.emptyworld.Commands.EmptyWorld;
import pro.gamerexde.emptyworld.Utils.BlockSpawner;
import pro.gamerexde.emptyworld.Utils.Generator;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin implements Listener {
    public static final String version = "1.0-SNAPSHOT";

    public List<BlockSpawner> blocks = new ArrayList<BlockSpawner>();
    Generator generator = new Generator(this);

    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return generator;
    }


    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if (getConfig().getBoolean("spawn-block.enabled")){
            int xCord = getConfig().getInt("spawn-block.x");
            int yCord = getConfig().getInt("spawn-block.y");
            int zCord = getConfig().getInt("spawn-block.z");
            int radius = Math.abs(getConfig().getInt("spawn-block.radius"));
            if (radius == 0) blocks.add(new BlockSpawner(xCord, yCord, zCord));
            else {
                for (int x = -radius; x <= radius; x++){
                    for (int z = -radius; z <= radius; z++){
                        blocks.add(new BlockSpawner(xCord + x, yCord, zCord + z));
                    }
                }
            }
        }

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        console.sendMessage(ChatColor.DARK_AQUA + "___________               __           __      __            .__       .___");
        console.sendMessage(ChatColor.DARK_AQUA + "\\_   _____/ _____ _______/  |_ ___.__./  \\    /  \\___________|  |    __| _/");
        console.sendMessage(ChatColor.DARK_AQUA + " |    __)_ /     \\\\____ \\   __<   |  |\\   \\/\\/   /  _ \\_  __ \\  |   / __ | ");
        console.sendMessage(ChatColor.DARK_AQUA + " |        \\  Y Y  \\  |_> >  |  \\___  | \\        (  <_> )  | \\/  |__/ /_/ | ");
        console.sendMessage(ChatColor.DARK_AQUA + "/_______  /__|_|  /   __/|__|  / ____|  \\__/\\  / \\____/|__|  |____/\\____ | ");
        console.sendMessage(ChatColor.DARK_AQUA + "        \\/      \\/|__|         \\/            \\/                         \\/ ");
        console.sendMessage(ChatColor.DARK_AQUA + "                                                     Version: " + version);
        console.sendMessage(ChatColor.DARK_AQUA + "");
        console.sendMessage(ChatColor.DARK_GRAY + "                No Blocks, No Animals, No Monsters, No Lag.");
        console.sendMessage(ChatColor.DARK_AQUA + "");
        console.sendMessage(ChatColor.GREEN + "[EmptyWorld]The plugin loaded correctly.");
        console.sendMessage(ChatColor.DARK_AQUA + "");

        getCommand("emptyworld").setExecutor(new EmptyWorld(this));
    }

    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        console.sendMessage(ChatColor.DARK_AQUA + "___________               __           __      __            .__       .___");
        console.sendMessage(ChatColor.DARK_AQUA + "\\_   _____/ _____ _______/  |_ ___.__./  \\    /  \\___________|  |    __| _/");
        console.sendMessage(ChatColor.DARK_AQUA + " |    __)_ /     \\\\____ \\   __<   |  |\\   \\/\\/   /  _ \\_  __ \\  |   / __ | ");
        console.sendMessage(ChatColor.DARK_AQUA + " |        \\  Y Y  \\  |_> >  |  \\___  | \\        (  <_> )  | \\/  |__/ /_/ | ");
        console.sendMessage(ChatColor.DARK_AQUA + "/_______  /__|_|  /   __/|__|  / ____|  \\__/\\  / \\____/|__|  |____/\\____ | ");
        console.sendMessage(ChatColor.DARK_AQUA + "        \\/      \\/|__|         \\/            \\/                         \\/ ");
        console.sendMessage(ChatColor.DARK_AQUA + "                                                     Version: " + version);
        console.sendMessage(ChatColor.DARK_AQUA + "");
        console.sendMessage(ChatColor.DARK_GRAY + "                No Blocks, No Animals, No Monsters, No Lag.");
        console.sendMessage(ChatColor.DARK_AQUA + "");
        console.sendMessage(ChatColor.GREEN + "[EmptyWorld] The plugin unloaded correctly.");
        console.sendMessage(ChatColor.DARK_AQUA + "");
    }



}
