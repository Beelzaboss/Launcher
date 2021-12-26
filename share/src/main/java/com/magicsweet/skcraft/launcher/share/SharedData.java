package com.magicsweet.skcraft.launcher.share;

import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class SharedData {
	public static File getFileChooseDefaultDir() {
		JFileChooser chooser = new JFileChooser();
		FileSystemView fsv = chooser.getFileSystemView();
		return fsv.getDefaultDirectory();
	}
}
