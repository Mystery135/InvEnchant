package com.websiteofgames.invenchant.events;

import com.websiteofgames.invenchant.InvEnchant;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Repairable;

import java.awt.*;
import java.util.*;
import java.util.List;

public class EBookOverEnchantableItem implements Listener {


    @EventHandler
public void onPlayerClickInvSlot(InventoryClickEvent event){




String trueorfalse = (String) InvEnchant.getPlugin().getConfig().get("invenchant");
        if (!trueorfalse.equals("true")){
            return;
        }

if (event.getCurrentItem() == null){

    return;

}

if (event.getCursor().getType().equals(Material.ENCHANTED_BOOK)){



    ItemStack book = event.getCursor();
    EnchantmentStorageMeta bookmeta = (EnchantmentStorageMeta) book.getItemMeta();
    Map<Enchantment, Integer> bookenchants = bookmeta.getStoredEnchants();
    Map<Enchantment, Integer> itemenchants = event.getCurrentItem().getEnchantments();








    try{



    if (event.getCurrentItem() == null){

        return;

    }




    if (event.getCurrentItem().getItemMeta() == null){
        return;

    }






    Set<Enchantment> bookkeySet = bookenchants.keySet();
    List<Enchantment> booklistOfKeys = new ArrayList<>(bookkeySet);


    Set<Enchantment> itemkeySet = itemenchants.keySet();
    List<Enchantment> itemlistOfKeys = new ArrayList<>(itemkeySet);
    Boolean applied = false;
        Boolean bookchanged= false;
    for (int i = 0; i<booklistOfKeys.size(); i++){


        for (int u = 0; u<itemlistOfKeys.size(); u++){


if (itemlistOfKeys.get(u) != booklistOfKeys.get(i)){


    if (itemlistOfKeys.get(u).conflictsWith(booklistOfKeys.get(i))){





        EnchantmentStorageMeta currentbookmeta = (EnchantmentStorageMeta) event.getCursor().getItemMeta();

        assert currentbookmeta != null;
        currentbookmeta.removeStoredEnchant(booklistOfKeys.get(i));



event.getCursor().setItemMeta(currentbookmeta);



bookchanged = true;



    }
}






        }


        if(event.getCurrentItem().getItemMeta().hasEnchant(booklistOfKeys.get(i))) {



            if (bookenchants.get(booklistOfKeys.get(i)) == event.getCurrentItem().getItemMeta().getEnchantLevel(booklistOfKeys.get(i))){

                if (booklistOfKeys.get(i).getMaxLevel() > bookenchants.get(booklistOfKeys.get(i))){


                    event.getCurrentItem().addEnchantment(booklistOfKeys.get(i), bookenchants.get(booklistOfKeys.get(i))+1);
                    Repairable currentMeta = (Repairable) event.getCurrentItem().getItemMeta();
                    Bukkit.broadcastMessage("rpcostbf: " + String.valueOf(currentMeta.getRepairCost()));





                    switch (currentMeta.getRepairCost()){
                        case 0:currentMeta.setRepairCost(1); Bukkit.broadcastMessage("eee"); break;
                        case 1:currentMeta.setRepairCost(3); Bukkit.broadcastMessage("eee2"); break;
                        case 3:currentMeta.setRepairCost(7); Bukkit.broadcastMessage("eee3"); break;
                        case 7:currentMeta.setRepairCost(15); Bukkit.broadcastMessage("eee3"); break;
                        case 15:currentMeta.setRepairCost(31); Bukkit.broadcastMessage("eee4"); break;
                        case 31:currentMeta.setRepairCost(63); Bukkit.broadcastMessage("eee5"); break;
                    }
                    event.getCurrentItem().setItemMeta((ItemMeta) currentMeta);
                    Bukkit.broadcastMessage("rpcost: " + String.valueOf(currentMeta.getRepairCost()));
                        event.setCancelled(true);
                        applied = true;


                }



            }


           else if (bookenchants.get(booklistOfKeys.get(i)) < event.getCurrentItem().getItemMeta().getEnchantLevel(booklistOfKeys.get(i))){

            }

            else if (bookenchants.get(booklistOfKeys.get(i)) < event.getCurrentItem().getItemMeta().getEnchantLevel(booklistOfKeys.get(i)) && booklistOfKeys.size() >1){



            }else if (bookenchants.get(booklistOfKeys.get(i)) < event.getCurrentItem().getItemMeta().getEnchantLevel(booklistOfKeys.get(i)) && booklistOfKeys.size() ==1){





            }


            else{




applied = true;
                    event.setCancelled(true);


            }


        }else{

            try {





                ItemStack currentbook = event.getCursor();
                EnchantmentStorageMeta currentbookmeta = (EnchantmentStorageMeta) currentbook.getItemMeta();
                Map<Enchantment, Integer> currentbookenchants = currentbookmeta.getStoredEnchants();
                Set<Enchantment> currentbookkeySet = currentbookenchants.keySet();
                List<Enchantment> currentbooklistOfKeys = new ArrayList<>(currentbookkeySet);


                Repairable currentrMeta = (Repairable) event.getCurrentItem().getItemMeta();
                Repairable cursorRmeta = (Repairable) event.getCursor().getItemMeta();
                currentrMeta.hasRepairCost();
                int enchcost = 0;




                if (currentrMeta.hasRepairCost() || Objects.requireNonNull(cursorRmeta).hasRepairCost()){

                    for (Enchantment enchantment:currentbooklistOfKeys) {

                        if (enchantment == Enchantment.PROTECTION_EXPLOSIONS || enchantment == Enchantment.OXYGEN || enchantment == Enchantment.DEPTH_STRIDER ||
                                enchantment == Enchantment.WATER_WORKER || enchantment == Enchantment.FIRE_ASPECT || enchantment == Enchantment.LOOT_BONUS_MOBS
                                || enchantment == Enchantment.LOOT_BONUS_BLOCKS || enchantment == Enchantment.ARROW_KNOCKBACK || enchantment == Enchantment.ARROW_FIRE ||
                                enchantment == Enchantment.LUCK || enchantment == Enchantment.LURE || enchantment == Enchantment.FROST_WALKER || enchantment == Enchantment.MENDING
                                || enchantment == Enchantment.RIPTIDE || enchantment == Enchantment.MULTISHOT || enchantment == Enchantment.SWEEPING_EDGE
                        ) {

                            enchcost += (currentbookenchants.get(currentbooklistOfKeys.get(i)) * 2);
                            Bukkit.broadcastMessage("ee");
                        } else if (enchantment == Enchantment.THORNS || enchantment == Enchantment.SILK_TOUCH || enchantment == Enchantment.ARROW_INFINITE || enchantment == Enchantment.BINDING_CURSE
                                || enchantment == Enchantment.VANISHING_CURSE || enchantment == Enchantment.CHANNELING || enchantment == Enchantment.SOUL_SPEED
                        ) {

                            enchcost += (currentbookenchants.get(currentbooklistOfKeys.get(i)) * 4);
                            Bukkit.broadcastMessage("ee33");


                        } else {
                            enchcost += currentbookenchants.get(currentbooklistOfKeys.get(i));
                            Bukkit.broadcastMessage("e4444e");

                        }



                    }
                    enchcost += (currentrMeta.getRepairCost()+cursorRmeta.getRepairCost());



                }else{

                    for (Enchantment enchantment:currentbooklistOfKeys) {

                        if (enchantment == Enchantment.PROTECTION_EXPLOSIONS || enchantment == Enchantment.OXYGEN || enchantment == Enchantment.DEPTH_STRIDER ||
                                enchantment == Enchantment.WATER_WORKER || enchantment.equals(Enchantment.FIRE_ASPECT) || enchantment == Enchantment.LOOT_BONUS_MOBS
                                || enchantment == Enchantment.LOOT_BONUS_BLOCKS || enchantment == Enchantment.ARROW_KNOCKBACK || enchantment == Enchantment.ARROW_FIRE ||
                                enchantment == Enchantment.LUCK || enchantment == Enchantment.LURE || enchantment == Enchantment.FROST_WALKER || enchantment == Enchantment.MENDING
                                || enchantment == Enchantment.RIPTIDE || enchantment == Enchantment.MULTISHOT || enchantment == Enchantment.SWEEPING_EDGE
                        ) {

                            enchcost += (currentbookenchants.get(currentbooklistOfKeys.get(i)) * 2);
                            Bukkit.broadcastMessage("ee");
                        } else if (enchantment == Enchantment.THORNS || enchantment == Enchantment.SILK_TOUCH || enchantment == Enchantment.ARROW_INFINITE || enchantment == Enchantment.BINDING_CURSE
                                || enchantment == Enchantment.VANISHING_CURSE || enchantment == Enchantment.CHANNELING || enchantment == Enchantment.SOUL_SPEED
                        ) {

                            enchcost += (currentbookenchants.get(currentbooklistOfKeys.get(i)) * 4);
                            Bukkit.broadcastMessage("ee33");


                        } else {
                            enchcost += currentbookenchants.get(currentbooklistOfKeys.get(i));
                            Bukkit.broadcastMessage("e4444e");

                        }


                    }


                }
                if ((event.getWhoClicked().getExpToLevel() <enchcost)) {
                    event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou need " + (enchcost-event.getWhoClicked().getExpToLevel()) + " more levels!"));
                    return;
                }

                event.getCurrentItem().addEnchantment(currentbooklistOfKeys.get(i), currentbookenchants.get(currentbooklistOfKeys.get(i)));
                event.setCancelled(true);
                applied = true;


                Bukkit.broadcastMessage(String.valueOf(enchcost));

                Player player = (Player) event.getWhoClicked();
                player.setLevel(player.getLevel()-enchcost);





                    Repairable currentMeta = (Repairable) event.getCurrentItem().getItemMeta();
                    Bukkit.broadcastMessage("rpcostbf: " + String.valueOf(currentrMeta.getRepairCost()));





                    switch (currentMeta.getRepairCost()){
                        case 0:currentMeta.setRepairCost(1); Bukkit.broadcastMessage("eee"); break;
                        case 1:currentMeta.setRepairCost(3); Bukkit.broadcastMessage("eee2"); break;
                        case 3:currentMeta.setRepairCost(7); Bukkit.broadcastMessage("eee3"); break;
                        case 7:currentMeta.setRepairCost(15); Bukkit.broadcastMessage("eee3"); break;
                        case 15:currentMeta.setRepairCost(31); Bukkit.broadcastMessage("eee4"); break;
                        case 31:currentMeta.setRepairCost(63); Bukkit.broadcastMessage("eee5"); break;
                    }
                    event.getCurrentItem().setItemMeta((ItemMeta) currentMeta);
                    Bukkit.broadcastMessage("rpcost: " + String.valueOf(currentMeta.getRepairCost()));






            }catch (Exception e){
System.out.println(e);
            }





        }
    }



if (applied){
    event.getWhoClicked().getWorld().playSound(event.getWhoClicked().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 5);
    event.getCursor().setAmount(0);

}else if (bookchanged){

    event.getCursor().setItemMeta(bookmeta);



}







}catch (Exception e){

}







}




    }


}
