package chat.view;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import chat.controller.ChatController;
import chat.controller.IOController;
import java.awt.GridLayout;

public class ChatPanel extends JPanel
{
	private SpringLayout appLayout;
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton searchTwitterButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private JPanel buttonPanel;
	private ImageIcon saveIcon;
	private ImageIcon loadIcon;
	private ImageIcon checkIcon;
	private ImageIcon chatIcon;
	private ImageIcon tweetIcon;
	private ImageIcon searchTwitterIcon;
	
	/**
	 * @wbp.nonvisual location=-30,-9
	 */
	private final JPanel panel = new JPanel();

	public ChatPanel(ChatController app)
	{
		super();

		this.appController = app;
		appLayout = new SpringLayout();
		
		saveIcon = new ImageIcon(getClass().getResource("chat/view/images/uhh ohh.jpeg"));
		loadIcon = new ImageIcon(getClass().getResource("chat/view/images/water gun.png"));
		checkIcon = new ImageIcon(getClass().getResource("chat/view/images/sully.jpg"));
		tweetIcon = new ImageIcon(getClass().getResource("chat/view/images/tweet.Im-just-a-bill"));
		searchTwitterIcon = new ImageIcon(getClass().getResource("chat/view/images/shook.jpeg"));

		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("chat");
		checkerButton = new JButton("Check Text");
		tweetButton = new JButton("Send tweet");
		searchTwitterButton = new JButton("Search twitter");
		
		buttonPanel = new JPanel(new GridLayout(1,0));

		chatField = new JTextField("Talk to the bot here, 50");
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
		setupButtonPanel();

	}
	
	private void setupButtonPanel()
	{

		buttonPanel.add(chatButton);

		buttonPanel.add(checkerButton);

		buttonPanel.add(tweetButton);

		buttonPanel.add(saveButton);

		buttonPanel.add(loadButton);
	}
	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);

		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		chatButton = new JButton("Chat");
		chatPane.setColumnHeaderView(chatButton);
		checkerButton = new JButton("Check Text");
		chatPane.setRowHeaderView(checkerButton);
	}
	
	private String getPath(String choice)
	{
		String path = ".";
		int result = -99;
		JFileChooser fileChooser = new JFileChooser();
		if (choice.equals("save"))
		{
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);;
			result = fileChooser.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
			path = fileChooser.getCurrentDirectory().getAbsolutePath();
		}
	}
	else
	{
		result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			path = fileChooser.getSelectedFile().getAbsolutePath();
		}
		
	}
		return path;
	}
	private void setupLayout()
	{

	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800,800));
		this.setBackground(Color.BLUE);
		buttonPanel.setPreferredSize(new Dimension(600,100));
		buttonPanel.setBackground(Color.CYAN);
		this.add(buttonPanel);
		this.add(loadButton);
		this.add(saveButton);
		this.add(chatField);
		this.add(chatPane);
	}

	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String input = chatField.getText();
				String output = "";
				output = appController.interactWithChatbot(input);
				chatArea.append(output);
				chatField.setText("");
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
			}

		});
		
		
		loadButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				String chatText = chatArea.getText();
				String path = ".";
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat saved!");
				}
				});
		saveButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		}
		});
		chatButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		}
		});
		checkerButton.addActionListener(new ActionListener()
		{
	public void actionPerformed(ActionEvent click)
	{
		}
		});

	}
}
