package example.extension;

import de.geolykt.starloader.api.Galimulator;
import de.geolykt.starloader.api.event.EventManager;
import de.geolykt.starloader.mod.Extension;

public class ExampleExtension extends Extension {

    @Override
    public void initialize() {
        getLogger().info("Hello from the example plugin!");
        EventManager.registerListener(new ExampleListener(this));
        Galimulator.saveFile("sprites/diamond.png", getClass().getClassLoader().getResourceAsStream("diamond.png"));
    }

    @Override
    public void terminate() {
        // Please be very careful when implementing the terminate method
        // If you are not careful and a deadlock occurs, then the VM might deadlock too
        // As such, do not rely on any other threads in the terminate function and code everything async-safe
    }
}
