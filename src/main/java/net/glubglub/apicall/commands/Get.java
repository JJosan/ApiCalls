package net.glubglub.apicall.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.glubglub.apicall.Helpers;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class Get {
    public Get(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("test").executes((command) -> {
            String quote = Helpers.Get2();
            command.getSource().getPlayer().sendSystemMessage(Component.literal(quote));
            return 0;
        }));
    }
}
