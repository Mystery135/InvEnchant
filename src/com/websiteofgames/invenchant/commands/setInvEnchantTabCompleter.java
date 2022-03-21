package com.websiteofgames.invenchant.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class setInvEnchantTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 1){
            List<String> bools = new ArrayList<>();
            bools.add("true");
            bools.add("false");
            return bools;
        }

        return null;
    }
}
