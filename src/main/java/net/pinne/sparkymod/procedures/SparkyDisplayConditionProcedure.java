package net.pinne.sparkymod.procedures;

import net.pinne.sparkymod.entity.SparkyEntity;

import net.minecraft.world.entity.Entity;

public class SparkyDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof SparkyEntity _datEntI ? _datEntI.getEntityData().get(SparkyEntity.DATA_charge) : 0) == 1) {
			return true;
		}
		return false;
	}
}
