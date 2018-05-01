package me.runescapejon.ElytraTails.Listener;

import java.util.concurrent.ThreadLocalRandom;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.world.World;

import me.runescapejon.ElytraTrails.Main;

public class TailsListener {

	// personally think there a better way of doing this but it's the only thing i
	// can think of
	// possible Spawn the particles find the locations then check if player flying
	// with Elytra but due to how sponge works i will have to do this
	// TODO: animations effects when flying with Elytra
	@Listener
	public void onMove(MoveEntityEvent event, @Root Player player) {
		World w = player.getWorld();
		if (Main.fireworks.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(ParticleEffect.builder().type(ParticleTypes.FIREWORKS_SPARK).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.hearts.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(ParticleEffect.builder().type(ParticleTypes.HEART).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.FERTILIZER.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(ParticleEffect.builder().type(ParticleTypes.FERTILIZER).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.dust.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(
						ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
								.option(ParticleOptions.COLOR, getRainbowColor()).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.dragon.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(
						ParticleEffect.builder().type(ParticleTypes.DRAGON_BREATH).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.flames.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(
						ParticleEffect.builder().type(ParticleTypes.FLAME).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.villager.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(
						ParticleEffect.builder().type(ParticleTypes.ANGRY_VILLAGER).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		} else if (Main.redstone.contains(player.getUniqueId())) {
			if (player.get(Keys.IS_ELYTRA_FLYING).get()) {
				w.spawnParticles(
						ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).build(),
						player.getLocation().getPosition().add(0, 0.1, 0));
			}
		}

	}

	private Color getRainbowColor() {
		int random = ThreadLocalRandom.current().nextInt(8);
		if (random == 0) {
			return Color.BLUE;
		} else if (random == 1) {
			return Color.CYAN;
		} else if (random == 2) {
			return Color.LIME;
		} else if (random == 3) {
			return Color.MAGENTA;
		} else if (random == 4) {
			return Color.PINK;
		} else if (random == 5) {
			return Color.PURPLE;
		} else if (random == 6) {
			return Color.RED;
		} else { // color == 7
			return Color.YELLOW;
		}
	}

}
