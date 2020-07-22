package top.shanwer;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public class resender extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("resend")) {
            Player player = (Player)sender;
            Chunk chunk = ((Player)sender).getLocation().getChunk();
                    World world = player.getWorld();
                    int x = chunk.getX();
                    int z = chunk.getZ();
                    world.refreshChunk(x - 1, z - 1);
                    world.refreshChunk(x - 1 - 1, z);
                    world.refreshChunk(x - 1, z + 1);
                    world.refreshChunk(x, z - 1);
                    world.refreshChunk(x, z);
                    world.refreshChunk(x + 1, z - 1);
                    world.refreshChunk(x + 1, z);
                    world.refreshChunk(x + 1, z + 1);
                try {
                    sender.sendMessage(this.getConfig().getString("Resend"));
                } catch (Exception e) {
                    e.printStackTrace();
                    sender.sendMessage("配置文件错误！");//Catch config format error;
                }return true;
            }return false;
        }
    }