package io.github.thebusybiscuit.hotbarpets.groups;

import io.github.thebusybiscuit.hotbarpets.PetTexture;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.hotbarpets.HotbarPet;
import io.github.thebusybiscuit.hotbarpets.HotbarPets;
import io.github.thebusybiscuit.hotbarpets.PetGroup;
import io.github.thebusybiscuit.hotbarpets.pets.IronGolemPet;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public final class PassiveMobs implements PetGroup {

    public PassiveMobs(HotbarPets plugin) {
        load(plugin);
    }

    @Override
    public String getName() {
        return "&e怪物 (被动)";
    }

    @Override
    public void load(HotbarPets plugin) {
        // @formatter:off
        new IronGolemPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_IRON_GOLEM", PetTexture.IRON_GOLEM_PET.getHash(), "&7铁傀儡 &f宠物", getName(), "&7喜欢的食物: 铁锭", "", "&f右键: &7获得抗性提升"), new ItemStack(Material.IRON_INGOT), new ItemStack[]{
                new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.PUMPKIN), new ItemStack(Material.IRON_BLOCK),
                new ItemStack(Material.IRON_INGOT), new ItemStack(Material.EMERALD), new ItemStack(Material.IRON_INGOT),
                new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_16K, new ItemStack(Material.IRON_INGOT)
        }).register(plugin);

        new HotbarPet(plugin.getItemGroup(), new SlimefunItemStack("HOTBAR_PET_SLIME", PetTexture.SLIME_PET.getHash(), "&a史莱姆 &f宠物", getName(), "&7喜欢的食物: 萤石粉", "", "&f免疫掉落伤害"), new ItemStack(Material.GLOWSTONE_DUST), new ItemStack[]{
                new ItemStack(Material.SLIME_BALL), new ItemStack(Material.DIAMOND), new ItemStack(Material.SLIME_BALL),
                new ItemStack(Material.SLIME_BALL), new ItemStack(Material.EMERALD), new ItemStack(Material.SLIME_BALL),
                SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_20K
        }).register(plugin);
        // @formatter:on
    }

}
