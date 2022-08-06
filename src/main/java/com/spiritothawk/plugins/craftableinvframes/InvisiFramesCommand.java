package com.spiritothawk.plugins.craftableinvframes;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvisiFramesCommand implements CommandExecutor, TabCompleter
{
    private CraftableInvFrames craftableinvframes;
    
    public InvisiFramesCommand(CraftableInvFrames craftableinvframes)
    {
        this.craftableinvframes = craftableinvframes;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length == 0 || args[0].equalsIgnoreCase("get"))
        {
            giveItem(sender);
            return true;
        }
        else if(args[0].equalsIgnoreCase("reload"))
        {
            if(!sender.hasPermission("craftableinvframes.reload"))
            {
                sendNoPermissionMessage(sender);
                return true;
            }
            craftableinvframes.reload();
            sender.sendMessage(ChatColor.GREEN + "Reloaded!");
            return true;
        }
        else if(args[0].equalsIgnoreCase("force-recheck"))
        {
            if(!sender.hasPermission("craftableinvframes.forcerecheck"))
            {
                sendNoPermissionMessage(sender);
                return true;
            }
            craftableinvframes.forceRecheck();
            sender.sendMessage(ChatColor.GREEN + "Rechecked invisible item frames");
            return true;
        }
        else if(args[0].equalsIgnoreCase("setitem"))
        {
            if(!sender.hasPermission("craftableinvframes.setitem"))
            {
                sendNoPermissionMessage(sender);
                return true;
            }
            if(!(sender instanceof Player))
            {
                sender.sendMessage(ChatColor.RED + "Sorry, you must be a player to use this command!");
                return true;
            }
            ItemStack item = ((Player) sender).getInventory().getItemInMainHand();
            craftableinvframes.setRecipeItem(item);
            sender.sendMessage(ChatColor.GREEN + "Recipe item updated!");
            return true;
        }
        return false;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args)
    {
        if(args.length != 1)
        {
            return Collections.emptyList();
        }
        List<String> options = new ArrayList<>();
        if(sender.hasPermission("craftableinvframes.get"))
        {
            options.add("get");
        }
        if(sender.hasPermission("craftableinvframes.reload"))
        {
            options.add("reload");
        }
        if(sender.hasPermission("craftableinvframes.forcerecheck"))
        {
            options.add("force-recheck");
        }
        if(sender.hasPermission("craftableinvframes.setitem"))
        {
            options.add("setitem");
        }
        List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], options, completions);
        Collections.sort(completions);
        return completions;
    }
    
    private void sendNoPermissionMessage(CommandSender sender)
    {
        sender.sendMessage(ChatColor.RED + "Sorry, you don't have permission to run this command");
    }
    
    private void giveItem(CommandSender sender)
    {
        if(!sender.hasPermission("craftableinvframes.get"))
        {
            sendNoPermissionMessage(sender);
            return;
        }
        if(!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "Sorry, you must be a player to use this command!");
            return;
        }
        
        Player player = (Player) sender;
        player.getInventory().addItem(craftableinvframes.generateInvisibleItemFrame());
        player.sendMessage(ChatColor.GREEN + "Added an invisible item frame to your inventory");
    }
}
