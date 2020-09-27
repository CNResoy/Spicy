/*******************************************************************************
 * This file is part of Minebot.
 *
 * Minebot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Minebot is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Minebot.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package net.famzangl.minecraft.minebot.ai.commands;

import net.famzangl.minecraft.minebot.ai.AIHelper;
import net.famzangl.minecraft.minebot.ai.command.AICommand;
import net.famzangl.minecraft.minebot.ai.command.AICommandInvocation;
import net.famzangl.minecraft.minebot.ai.command.AICommandParameter;
import net.famzangl.minecraft.minebot.ai.command.ParameterType;
import net.famzangl.minecraft.minebot.ai.command.SafeStrategyRule;
import net.famzangl.minecraft.minebot.ai.enchanting.XPFarmStrategy;
import net.famzangl.minecraft.minebot.ai.strategy.AIStrategy;

@AICommand(helpText = "Kill mobs in range and (optionally) enchant whatever you have in the inventory.", name = "minebot")
public class CommandXPFarm {
	@AICommandInvocation(safeRule = SafeStrategyRule.DEFEND)
	public static AIStrategy run(
			AIHelper helper,
			@AICommandParameter(type = ParameterType.FIXED, fixedName = "xpfarm", description = "") String nameArg,
			@AICommandParameter(type = ParameterType.FIXED, fixedName = "autoenchant", description = "", optional = true) String nameArg2,
			@AICommandParameter(type = ParameterType.NUMBER, description = "Maximum level", optional = true) Integer level) {
		boolean doEnchant = nameArg2 != null;
		return new XPFarmStrategy(doEnchant, level == null ? (doEnchant ? 30 : 100) : level);
	}

}
