package net.glubglub.apicall.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.glubglub.apicall.Helpers;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class Insult {
    public Insult(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("insult").executes((command) -> {
            String quote = Helpers.Insult();
            command.getSource().getPlayer().sendSystemMessage(Component.literal(quote));
            return 0;
        }));
    }
}
