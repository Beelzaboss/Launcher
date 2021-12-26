package com.magicsweet.skcraft.launcher.share;

import java.io.File;
import lombok.Getter;
import lombok.Setter;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

@ConfigSerializable
@Getter
@Setter
public class BootstrapConfig extends ConfigFile<BootstrapConfig> {
	
	File workingDirectory = new File(SharedData.getFileChooseDefaultDir(), ".mafiozi/launcher/data");
	
	public static BootstrapConfig get() {
		return get(BootstrapConfig.class, new File(SharedData.getFileChooseDefaultDir(), ".mafiozi/launcher/bootstrap.yml"));
	}
}
