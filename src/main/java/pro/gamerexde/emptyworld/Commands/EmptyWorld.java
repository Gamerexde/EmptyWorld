package pro.gamerexde.emptyworld.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pro.gamerexde.emptyworld.Main;

public class EmptyWorld implements CommandExecutor {
    Main main;
    public EmptyWorld(Main instance) {
        main = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (label.equalsIgnoreCase("EmptyWorld")) {
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("reload")){
                    if (sender.hasPermission("emptyworld.reload")) {
                        sender.sendMessage("§3§lEmptyWorld> §7The configuration file has been correctly reloaded.");
                        main.reloadConfig();
                    }
                    else {
                        sender.sendMessage("§3§lEmptyWorld> §7Access Denied.");
                    }
                    return false;
                }
            }
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("world")){
                    if (sender.hasPermission("emptyworld.world")) {
                        sender.sendMessage("§3§lEmptyWorld> §7To create a world using Multiverse use §a/mv create <worldname> <normal,nether,end> -g EmptyWorld§7.");
                        sender.sendMessage("§3§lEmptyWorld> §7To create a world using bukkit.yml change the generator to §a'generator: EmptyWorld'§7.");
                    }
                    else {
                        sender.sendMessage("§3§lEmptyWorld> §7Access Denied.");
                    }
                    return false;
                }
            }
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("cords")){

                    if (sender.hasPermission("emptyworld.cords")) {
                        sender.sendMessage("§3§lEmptyWorld> §7Default spawn location for EmptyWorld Generation is §3X:" + main.getConfig().getInt("spawn-block.x") + " §3Y:" + main.getConfig().getInt("spawn-block.y") + " §3Z:" + main.getConfig().getInt("spawn-block.z") );
                    }
                    else {
                        sender.sendMessage("§3§lEmptyWorld> §7Access Denied.");
                    }
                    return false;
                }
            }

            if (!(sender instanceof Player)) {
                sender.sendMessage("(!) You need to be a player in order to execute that command...");
                return false;
            }

            Player player = (Player) sender;

            player.sendMessage("§a         §8§l§m--[--(--§3 EmptyWorld §8§l§m--)--]--");
            player.sendMessage("                             §8§b" + Main.version + "§8     ");
            player.sendMessage("");
            player.sendMessage("§7 - §a/emptyworld world §8-> §7Shows how to create a EmptyWorld.");
            player.sendMessage("§7 - §a/emptyworld cords §8-> §7Shows default spawn cords for EmptyWorld Generation.");
            player.sendMessage("");


            return true;
        }

        return false;
    }

}
