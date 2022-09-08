package net.glubglub.apicall.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.glubglub.apicall.Helpers;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class Anime {
    public Anime(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("anime").executes((command) -> {
            String quote = Helpers.Anime();
            command.getSource().getPlayer().sendSystemMessage(Component.literal(quote));
            return 0;
        }));
    }
}
