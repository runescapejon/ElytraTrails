package me.runescapejon.ElytraTrails;

import java.util.ArrayList;
import java.util.UUID;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import me.runescapejon.ElytraTails.Listener.TailsListener;

@Plugin(id = "elytratrails", name = "ElytraTrails", authors = {
		"runescapejon" }, description = "Wearing Elytra and fly with Particles!", version = "1.0")
public class Main {
	private static Main instance;
	public static Main getInstance() {
		return instance;
	}

	public static ArrayList<UUID> fireworks = new ArrayList<>();
	public static ArrayList<UUID> hearts = new ArrayList<>();
	public static ArrayList<UUID> FERTILIZER = new ArrayList<>();
	public static ArrayList<UUID> dust = new ArrayList<>();
	public static ArrayList<UUID> dragon = new ArrayList<>();
	public static ArrayList<UUID> flames = new ArrayList<>();
	public static ArrayList<UUID> villager = new ArrayList<>();
	public static ArrayList<UUID> redstone = new ArrayList<>();
	
	
	@Listener
	public void onGameInitlization(GameInitializationEvent event) {
		instance = this;
		Sponge.getEventManager().registerListeners(this, new GuiCommand());
		Sponge.getEventManager().registerListeners(this, new TailsListener());
		CommandSpec guiSpec = CommandSpec.builder()
				.description(Text.of("Simple Gui that provides ElytraTrails particles")).permission("elyratrails.gui")
				.executor(new GuiCommand()).build();
		Sponge.getCommandManager().register(this, guiSpec, "elyratails", "et");
	}
}
