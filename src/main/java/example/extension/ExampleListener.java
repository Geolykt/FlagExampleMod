package example.extension;

import java.lang.reflect.Constructor;

import de.geolykt.starloader.api.NamespacedKey;
import de.geolykt.starloader.api.event.EventHandler;
import de.geolykt.starloader.api.event.Listener;
import de.geolykt.starloader.api.event.lifecycle.RegistryRegistrationEvent;
import de.geolykt.starloader.api.registry.Registry;
import de.geolykt.starloader.mod.Extension;

import snoddasmannen.galimulator.FlagItem.BuiltinSymbols;

public class ExampleListener implements Listener {

    private final Extension extension;

    public ExampleListener(Extension extension) {
        this.extension = extension;
    }

    @EventHandler
    public void onRegistration(RegistryRegistrationEvent event) {
        if (event.getName().equals(RegistryRegistrationEvent.REGISTRY_FLAG_SYMBOL)) {
            Registry<BuiltinSymbols> registry = (Registry<BuiltinSymbols>) event.getRegistry();
            try {
                Constructor<BuiltinSymbols> constructor = BuiltinSymbols.class.getConstructor(String.class, int.class, String.class, boolean.class, int.class, int.class);
                BuiltinSymbols symbol = constructor.newInstance("DIAMOND", registry.getValues().length, "diamond.png", false, 0, 0);
                registry.register(new NamespacedKey(extension, "diamond"), symbol);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
