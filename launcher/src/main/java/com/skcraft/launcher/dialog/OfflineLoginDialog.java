package com.skcraft.launcher.dialog;

import com.skcraft.launcher.Launcher;
import com.skcraft.launcher.auth.OfflineSession;
import com.skcraft.launcher.auth.Session;
import com.skcraft.launcher.dialog.LoginDialog.ReloginDetails;
import com.skcraft.launcher.swing.FormPanel;
import com.skcraft.launcher.swing.LinedBoxPanel;
import com.skcraft.launcher.util.SharedLocale;
import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import javax.swing.*;
import lombok.Getter;
import lombok.NonNull;

public class OfflineLoginDialog extends JDialog {
	
	FormPanel formPanel = new FormPanel();
	
	@Getter private Session session;
	
	private final JTextField usernameText = new JTextField();
	private final LinedBoxPanel buttonsPanel = new LinedBoxPanel(true);
	private final JButton loginButton = new JButton(SharedLocale.tr("login.playOffline"));
	private final JButton cancelButton = new JButton(SharedLocale.tr("button.cancel"));
	
	public OfflineLoginDialog(Window owner, @NonNull Launcher launcher) {
		super(owner, ModalityType.DOCUMENT_MODAL);
		
		
		setTitle(SharedLocale.tr("login.offline.title"));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponents();
		setMinimumSize(new Dimension(420, 0));
		setResizable(false);
		pack();
		setLocationRelativeTo(owner);
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				dispose();
			}
		});
	}
	
	private void initComponents() {
		usernameText.setEditable(true);
		
		formPanel.addRow(new JLabel(SharedLocale.tr("login.username")), usernameText);
		
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(26, 13, 13, 13));
		
		buttonsPanel.addElement(loginButton);
		buttonsPanel.addElement(cancelButton);
		
		loginButton.addActionListener(event -> {
			session = new OfflineSession(usernameText.getText());
			dispose();
		});
		
		add(formPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		
	}
	
	public static Session show(Window owner, Launcher launcher) {
		OfflineLoginDialog dialog = new OfflineLoginDialog(owner, launcher);
		dialog.setVisible(true);
		return dialog.getSession();
	}
}
