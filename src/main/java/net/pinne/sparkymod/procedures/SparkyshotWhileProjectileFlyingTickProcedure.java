package net.pinne.sparkymod.procedures;

import net.minecraft.world.entity.Entity;

public class SparkyshotWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
	}
}
