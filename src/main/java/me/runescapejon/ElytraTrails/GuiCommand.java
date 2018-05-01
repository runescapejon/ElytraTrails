package me.runescapejon.ElytraTrails;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.item.inventory.property.SlotPos;
import org.spongepowered.api.item.inventory.query.QueryOperationTypes;
import org.spongepowered.api.text.Text;
//import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

public class GuiCommand implements CommandExecutor {
	// TODO: config to edit messages
	Inventory gui = Inventory.builder().of(InventoryArchetypes.CHEST)
			.property(InventoryDimension.PROPERTY_NAME, new InventoryDimension(9, 3))
			.property(InventoryTitle.PROPERTY_NAME,
					InventoryTitle.of(Text.builder("Elytra Trials").color(TextColors.AQUA).build()))
			.build(Main.getInstance());

	// Primary to add players to the list
	@Listener
	public void onInventoryClick(ClickInventoryEvent.Primary event, @First Player player) {
		if (event.getTargetInventory().getName().get().equals(this.gui.getName().get())) {
			Transaction<ItemStackSnapshot> clickTransaction = event.getTransactions().get(0);
			ItemStack item = clickTransaction.getOriginal().createStack();
			event.setCancelled(true);
			if (item.getType().equals(ItemTypes.FIREWORKS)) {
				if (player.hasPermission("elyratails.firework")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.fireworks.add(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.APPLE)) {
				if (player.hasPermission("elyratails.heart")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.add(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.EMERALD)) {
				if (player.hasPermission("elyratails.emerald")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					Main.FERTILIZER.add(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.BOOKSHELF)) {
				if (player.hasPermission("elyratails.rainbow")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					Main.FERTILIZER.remove(player.getUniqueId());
					Main.dust.add(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.DRAGON_BREATH)) {
				if (player.hasPermission("elyratails.dragon")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					Main.FERTILIZER.remove(player.getUniqueId());
					Main.dust.remove(player.getUniqueId());
					Main.dragon.add(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.FLINT_AND_STEEL)) {
				if (player.hasPermission("elyratails.flames")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					Main.FERTILIZER.remove(player.getUniqueId());
					Main.dust.remove(player.getUniqueId());
					Main.dragon.remove(player.getUniqueId());
					Main.flames.add(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.BOOK)) {
				if (player.hasPermission("elyratails.villager")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					Main.FERTILIZER.remove(player.getUniqueId());
					Main.dust.remove(player.getUniqueId());
					Main.dragon.remove(player.getUniqueId());
					Main.flames.remove(player.getUniqueId());
					Main.villager.add(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.REDSTONE)) {
				if (player.hasPermission("elyratails.redstone")) {
					player.playSound(SoundTypes.ENTITY_PLAYER_LEVELUP, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					Main.fireworks.remove(player.getUniqueId());
					Main.FERTILIZER.remove(player.getUniqueId());
					Main.dust.remove(player.getUniqueId());
					Main.dragon.remove(player.getUniqueId());
					Main.flames.remove(player.getUniqueId());
					Main.villager.remove(player.getUniqueId());
					Main.redstone.add(player.getUniqueId());
					player.closeInventory();
				}
			}
		}
	}

	// Secondary to remove them off the list, essentially toggle it off
	@Listener
	public void onInventoryClick(ClickInventoryEvent.Secondary event, @First Player player) {
		if (event.getTargetInventory().getName().get().equals(this.gui.getName().get())) {
			Transaction<ItemStackSnapshot> clickTransaction = event.getTransactions().get(0);
			ItemStack item = clickTransaction.getOriginal().createStack();
			event.setCancelled(true);
			if (item.getType().equals(ItemTypes.FIREWORKS)) {
				if (player.hasPermission("elyratails.firework")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.fireworks.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.APPLE)) {
				if (player.hasPermission("elyratails.heart")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.hearts.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.EMERALD)) {
				if (player.hasPermission("elyratails.emerald")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.FERTILIZER.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.BOOKSHELF)) {
				if (player.hasPermission("elyratails.rainbow")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.dust.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.DRAGON_BREATH)) {
				if (player.hasPermission("elyratails.dragon")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.dragon.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.FLINT_AND_STEEL)) {
				if (player.hasPermission("elyratails.flames")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.flames.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.BOOK)) {
				if (player.hasPermission("elyratails.villager")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.villager.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
			if (item.getType().equals(ItemTypes.REDSTONE)) {
				if (player.hasPermission("elyratails.redstone")) {
					player.playSound(SoundTypes.BLOCK_ANVIL_HIT, player.getLocation().getPosition(), 1);
					Main.villager.remove(player.getUniqueId());
					player.closeInventory();
				}
			}
		}
	}

	@Listener
	public void DropEvent(ClickInventoryEvent.Drop event) {
		if (event.getTargetInventory().getName().get().equals(this.gui.getName().get())) {
			event.setCancelled(true);
		}
	}

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		if (src instanceof Player) {
			Player p = (Player) src;

			ItemStack border = ItemStack.of(ItemTypes.STAINED_GLASS_PANE, 1);
			border.offer(Keys.DISPLAY_NAME, Text.of("Left Click to enable/Right Click to disable"));
			border.offer(Keys.DYE_COLOR, DyeColors.PURPLE);

			ItemStack fire = ItemStack.of(ItemTypes.FIREWORKS, 1);
			fire.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Fireworks Sparks Effect"));
			ItemStack hearts = ItemStack.of(ItemTypes.APPLE, 1);
			hearts.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Heats Effect"));

			ItemStack emerald = ItemStack.of(ItemTypes.EMERALD, 1);
			emerald.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Emerald Effect"));

			ItemStack bookshelf = ItemStack.of(ItemTypes.BOOKSHELF, 1);
			bookshelf.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "RainBow Effect!"));

			ItemStack sword = ItemStack.of(ItemTypes.DRAGON_BREATH, 1);
			sword.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Dragon Breath Effect"));

			ItemStack flames = ItemStack.of(ItemTypes.FLINT_AND_STEEL, 1);
			flames.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Flames Effect"));

			ItemStack book = ItemStack.of(ItemTypes.BOOK, 1);
			book.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Villager Effect"));

			ItemStack water = ItemStack.of(ItemTypes.REDSTONE, 1);
			water.offer(Keys.DISPLAY_NAME, Text.of(TextColors.WHITE, TextStyles.ITALIC, "Redstone Effect"));
			p.openInventory(gui);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 1))).set(fire);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 1))).set(hearts);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 1))).set(emerald);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 1))).set(bookshelf);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 1))).set(sword);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 1))).set(flames);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 1))).set(book);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 1))).set(water);

			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 1))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 1))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(9, 2))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(0, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(1, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(2, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(3, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(4, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(5, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(6, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(7, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(8, 0))).set(border);
			gui.query(QueryOperationTypes.INVENTORY_PROPERTY.of(SlotPos.of(9, 0))).set(border);
		}
		if (src instanceof ConsoleSource) {
			src.sendMessage(Text.of("Only ingame"));
		}
		return CommandResult.success();
	}
}
