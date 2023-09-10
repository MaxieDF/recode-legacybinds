package io.github.homchom.recode.mod.features.keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.InputConstants.Type;
import io.github.homchom.recode.mod.config.Config;
import io.github.homchom.recode.mod.features.commands.CodeSearcher;
import io.github.homchom.recode.multiplayer.state.DF;
import io.github.homchom.recode.multiplayer.state.PlotMode;
import io.github.homchom.recode.sys.sidedchat.ChatShortcut;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;

import java.util.Objects;
import java.util.Optional;

public class Keybinds implements ClientModInitializer {

    final Minecraft mc = Minecraft.getInstance();

    public static KeyMapping showTags;

    @Override
    public void onInitializeClient() {
        // =======================================================
        // Initialize
        // =======================================================
        // set play mode
        KeyMapping play_mode = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.play_mode", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // set build mode
        KeyMapping build_mode = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.build_mode", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // set dev mode
        KeyMapping dev_mode = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.dev_mode", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // spawn
        KeyMapping spawn = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.spawn", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // =======

        // fs toggle
        KeyMapping toggleFsSlow = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.toggle_fs_slow", InputConstants.Type.KEYSYM, -1, "key.category.recode"));
        KeyMapping toggleFsMedium = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.toggle_fs_medium", InputConstants.Type.KEYSYM, -1, "key.category.recode"));
        KeyMapping toggleFsFast = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.toggle_fs_fast", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // =======

        // lagslayer
        KeyMapping lagslayer = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.lagslayer", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // rc
        KeyMapping rc = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.rc", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // rs
        KeyMapping rs = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.rs", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // plot spawn
        KeyMapping plotSpawn = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.plot_spawn", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // night vision
        KeyMapping nightvis = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.nightvis", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // fly
        KeyMapping fly = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.fly", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // search
        KeyMapping searchFunction = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.search", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // show tags

        showTags = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.showTags", Type.KEYSYM, -1, "key.category.recode"
        ));

        // chat global
        KeyMapping chatGlobal = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.chat_global", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // chat local
        KeyMapping chatLocal = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.chat_local", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // chat none
        KeyMapping chatNone = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.chat_none", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        // =======

        // Staff Keybinds
        KeyMapping modv = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.modv", InputConstants.Type.KEYSYM, -1, "key.category.recode"));
        KeyMapping supportAccept = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.support.accept", InputConstants.Type.KEYSYM, -1, "key.category.recode"));
        KeyMapping supportQueue = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.support.queue", InputConstants.Type.KEYSYM, -1, "key.category.recode"));

        KeyMapping node1 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node1", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping node2 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node2", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping node3 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node3", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping node4 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node4", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping node5 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node5", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping node6 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node6", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping node7 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.node7", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping beta = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.beta", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping dev = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.dev1", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping dev2 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.dev2", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));
        KeyMapping dev3 = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.recode.dev3", InputConstants.Type.KEYSYM, -1, "key.category.nodesel"));

        // register all the KeyMappings for the chat rooms
        for (ChatShortcut chatShortcut: ChatShortcut.values()) {
            ChatShortcut.addKeyMapping(KeyBindingHelper.registerKeyBinding(new KeyMapping(
                    chatShortcut.getTranslationKey(), -1, "key.category.recode"
            )), chatShortcut);
        }

        // =======================================================
        // Events
        // =======================================================

        // TODO: rework this with/after feature refactor
        FlightSpeedToggle fsToggle = new FlightSpeedToggle();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // toggle play dev
            while (play_mode.consumeClick()) {
                sendCommand("play");
            }

            // toggle play build
            while (build_mode.consumeClick()) {
                sendCommand("build");
            }

            // toggle dev mode
            while (dev_mode.consumeClick()) {
                sendCommand("dev");
            }

            // spawn
            while (spawn.consumeClick()) {
                sendCommand("s");
            }

            // toggle fs
            while (toggleFsSlow.consumeClick()) {
                sendCommand("fs 100");
            }

            while (toggleFsMedium.consumeClick()) {
                //fsToggle.toggleFlightSpeed(Config.getInteger("fsMed"));
                sendCommand("fs " + Config.getInteger("fsMed").toString());
            }

            while (toggleFsFast.consumeClick()) {
                //fsToggle.toggleFlightSpeed(Config.getInteger("fsFast"));
                sendCommand("fs " + Config.getInteger("fsFast").toString());
            }

            // lagslayer
            while (lagslayer.consumeClick()) {
                sendCommand("lagslayer");
            }

            // rc
            while (rc.consumeClick()) {
                sendCommand("rc");
            }

            // rs
            while (rs.consumeClick()) {
                sendCommand("rs");
            }

            // plot spawn
            while (plotSpawn.consumeClick()) {
                sendCommand("p s");
            }

            // nightvis
            while (nightvis.consumeClick()) {
                sendCommand("nightvis");
            }

            // fly
            while (fly.consumeClick()) {
                sendCommand("fly");
            }

            // chat global
            while (chatGlobal.consumeClick()) {
                sendCommand("chat global");
            }

            // chat local
            while (chatLocal.consumeClick()) {
                sendCommand("chat local");
            }

            // chat none
            while (chatNone.consumeClick()) {
                sendCommand("chat none");
            }

            // search
            while (searchFunction.consumeClick()) {
                if (DF.isInMode(DF.getCurrentDFState(), PlotMode.Dev.ID)) {
                    var hitLocation = mc.hitResult.getLocation().toVector3f();
                    var blockPos = new BlockPos((int) hitLocation.x, (int) hitLocation.y, (int) hitLocation.z);
                    BlockEntity blockEntity = mc.level.getBlockEntity(blockPos);

                    if (blockEntity != null) {
                        if (blockEntity instanceof SignBlockEntity signBlockEntity) {
                            CodeSearcher.beginSearch(signBlockEntity);
                        } else {
                            CodeSearcher.clearSearch();
                        }
                    } else {
                        CodeSearcher.clearSearch();
                    }
                }
            }

            while (modv.consumeClick()) {
                sendCommand("mod v");
            }

            while (supportAccept.consumeClick()) {
                sendCommand("support accept");
            }

            while (supportQueue.consumeClick()) {
                sendCommand("support queue");
            }

            while (node1.consumeClick()){
                sendCommand("server node1");
            }
            while (node2.consumeClick()){
                sendCommand("server node2");
            }
            while (node3.consumeClick()){
                sendCommand("server node3");
            }
            while (node4.consumeClick()){
                sendCommand("server node4");
            }
            while (node5.consumeClick()){
                sendCommand("server node5");
            }
            while (node6.consumeClick()){
                sendCommand("server node6");
            }
            while (node7.consumeClick()){
                sendCommand("server node7");
            }
            while (beta.consumeClick()){
                sendCommand("server beta");
            }
            while (dev.consumeClick()){
                sendCommand("server dev");
            }
            while (dev2.consumeClick()){
                sendCommand("server dev2");
            }
            while (dev3.consumeClick()){
                sendCommand("server dev3");
            }

            // chat shortcuts
            Optional<KeyMapping> pressedChatShortcut = ChatShortcut.KeyMappings().stream()
                    .filter(KeyMapping -> {
                        // filter which also needs to consume all of the wasPressed
                        // e.g. if multiple inputs went by before next frame was drawn
                        boolean pressed = false;
                        while (KeyMapping.consumeClick()) {
                            pressed = true;
                        }
                        return pressed;
                    })
                    // will only handle the first, if for some reason you bind multiple chats to one button
                    .findFirst();

            // if any chat shortcut was pressed
            if (pressedChatShortcut.isPresent()) {
                ChatShortcut chatShortcut = ChatShortcut.getFromKey(pressedChatShortcut.get());

                ChatShortcut.setCurrentChatShortcut(chatShortcut);
                mc.setScreen(new ChatScreen(""));
            }
        });
    }

    private void sendCommand(String message) {
        Objects.requireNonNull(mc.player).connection.sendUnsignedCommand(message);
    }
}