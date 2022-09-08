package net.glubglub.apicall.events;

import net.glubglub.apicall.ApiCalls;
import net.glubglub.apicall.commands.Get;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = ApiCalls.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new Get(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

}
