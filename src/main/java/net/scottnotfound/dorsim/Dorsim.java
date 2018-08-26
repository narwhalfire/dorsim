package net.scottnotfound.dorsim;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dimdev.riftloader.listener.InitializationListener;
import org.spongepowered.asm.mixin.Mixins;

public class Dorsim implements InitializationListener {

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialization() {
        LOGGER.info("Loading Dorsim!");

        Mixins.addConfiguration("mixins.dorsim.json");
    }



}
