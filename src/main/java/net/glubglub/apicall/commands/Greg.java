package net.glubglub.apicall.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.glubglub.apicall.Helpers;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class Greg {
    // takes in arguments
    public Greg(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("greg").then(Commands.argument("name", StringArgumentType.string()).executes((command) -> {
            Helpers.Upload(StringArgumentType.getString(command, "name"));
            return 0;
        })));
    }
}
