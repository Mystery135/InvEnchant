package com.websiteofgames.invenchant.commands;

import com.websiteofgames.invenchant.InvEnchant;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class setInvEnchant implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("setinvenchant")){
            if (args.length == 1){

                try {
                    if (!(args[0].equals("true") || args[0].equals("false"))){
                        commandSender.sendMessage("§c/setinvenchant <true/false>");
                        return true;

                    }

                    InvEnchant.getPlugin().getConfig().set("invenchant", args[0]);
                    InvEnchant.getPlugin().saveConfig();
//                    InvEnchant.getPlugin().reloadConfig();
                    commandSender.sendMessage("§aInvEnchant is now " + InvEnchant.getPlugin().getConfig().get("invenchant") );

                }catch (Exception e){
                    commandSender.sendMessage("§c/setinvenchant <true/false>");


                }


            }else if (args.length == 0){

                commandSender.sendMessage("§aInvEnchant is currently " +InvEnchant.getPlugin().getConfig().get("invenchant") );
            }
            else{

                commandSender.sendMessage("§c/setinvenchant <true/false>");

            }



        }

        return true;
    }
}
