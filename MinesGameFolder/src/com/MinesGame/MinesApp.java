package com.MinesGame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.awt.Color;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class MinesApp {

	int bombs;
	boolean GameActive = false;
	int mines = 25;
	int InitializeNum = 1;

	Random randomNums = new Random();
	Set<Integer> uniqueNumbers = new HashSet<>();

	private JFrame frame;
	private JTextField AmtOfMines;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MinesApp window = new MinesApp();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MinesApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 453);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel Title = new JLabel("Mines!");
		Title.setFont(new Font("Tahoma", Font.BOLD, 18));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(0, 0, 584, 23);
		frame.getContentPane().add(Title);

		JButton StartGameBtn = new JButton("Start Game!");
		StartGameBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = AmtOfMines.getText();
				try {
					bombs = Integer.parseInt(input);
					GameActive = true;
				} catch (NumberFormatException ex) {
					System.out.println("Invalid input for number of mines.");
					GameActive = false;
				}
			}
		});
		StartGameBtn.setBounds(221, 68, 142, 23);
		frame.getContentPane().add(StartGameBtn);

		AmtOfMines = new JTextField();
		AmtOfMines.setHorizontalAlignment(SwingConstants.CENTER);
		AmtOfMines.setText("Enter Amount Of Bombs");
		AmtOfMines.setBounds(221, 34, 142, 23);
		frame.getContentPane().add(AmtOfMines);
		AmtOfMines.setColumns(10);

		JLabel GameStartedTxt = new JLabel("Game Hasn't Started...");
		GameStartedTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GameStartedTxt.setForeground(new Color(255, 0, 0));
		GameStartedTxt.setHorizontalAlignment(SwingConstants.CENTER);
		GameStartedTxt.setBounds(10, 72, 563, 14);
		frame.getContentPane().add(GameStartedTxt);

		JPanel GameFrame = new JPanel();
		GameFrame.setBounds(127, 102, 373, 289);
		frame.getContentPane().add(GameFrame);
		GridBagLayout gbl_GameFrame = new GridBagLayout();
		gbl_GameFrame.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_GameFrame.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_GameFrame.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_GameFrame.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		GameFrame.setLayout(gbl_GameFrame);

		JLabel AmtOfMinesLbl = new JLabel("Mines: ");
		AmtOfMinesLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		AmtOfMinesLbl.setHorizontalAlignment(SwingConstants.CENTER);
		AmtOfMinesLbl.setBounds(10, 72, 161, 14);
		frame.getContentPane().add(AmtOfMinesLbl);

		JLabel AmtOfBombsLbl = new JLabel("Bombs: ");
		AmtOfBombsLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		AmtOfBombsLbl.setHorizontalAlignment(SwingConstants.CENTER);
		AmtOfBombsLbl.setBounds(10, 57, 161, 14);
		frame.getContentPane().add(AmtOfBombsLbl);

		JButton btn1 = new JButton("    Mine    ");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(1)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn1.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 0;
		GameFrame.add(btn1, gbc_btn1);

		JButton btn2 = new JButton("    Mine    ");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(2)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn2.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 0;
		GameFrame.add(btn2, gbc_btn2);

		JButton btn3 = new JButton("    Mine    ");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(3)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn3.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 0;
		GameFrame.add(btn3, gbc_btn3);

		JButton btn4 = new JButton("    Mine    ");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(4)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn4.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 3;
		gbc_btn4.gridy = 0;
		GameFrame.add(btn4, gbc_btn4);

		JButton btn5 = new JButton("    Mine    ");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(5)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn5.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 0;
		gbc_btn5.gridy = 1;
		GameFrame.add(btn5, gbc_btn5);

		JButton btn6 = new JButton("    Mine    ");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(6)) {
					System.out.print("Game Over");
					GameActive = false;
				} else {
					mines = mines - 1;
					btn6.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 1;
		gbc_btn6.gridy = 1;
		GameFrame.add(btn6, gbc_btn6);

		JButton btn7 = new JButton("    Mine    ");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(7)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn7.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 2;
		gbc_btn7.gridy = 1;
		GameFrame.add(btn7, gbc_btn7);

		JButton btn8 = new JButton("    Mine    ");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(8)) {
					System.out.print("Game Over");
					GameActive = false;
				} else {
					btn8.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 3;
		gbc_btn8.gridy = 1;
		GameFrame.add(btn8, gbc_btn8);

		JButton btn9 = new JButton("    Mine    ");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(9)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					mines = mines - 1;
					btn9.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 0;
		gbc_btn9.gridy = 2;
		GameFrame.add(btn9, gbc_btn9);

		JButton btn10 = new JButton("    Mine    ");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(10)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					mines = mines - 1;
					btn10.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btn10 = new GridBagConstraints();
		gbc_btn10.insets = new Insets(0, 0, 5, 5);
		gbc_btn10.gridx = 1;
		gbc_btn10.gridy = 2;
		GameFrame.add(btn10, gbc_btn10);

		JButton btn11 = new JButton("    Mine    ");
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(11)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn11.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn11 = new GridBagConstraints();
		gbc_btn11.insets = new Insets(0, 0, 5, 5);
		gbc_btn11.gridx = 2;
		gbc_btn11.gridy = 2;
		GameFrame.add(btn11, gbc_btn11);

		JButton btn12 = new JButton("    Mine    ");
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(12)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn12.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn12 = new GridBagConstraints();
		gbc_btn12.insets = new Insets(0, 0, 5, 5);
		gbc_btn12.gridx = 3;
		gbc_btn12.gridy = 2;
		GameFrame.add(btn12, gbc_btn12);

		JButton btn13 = new JButton("    Mine    ");
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(13)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn13.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn13 = new GridBagConstraints();
		gbc_btn13.insets = new Insets(0, 0, 5, 5);
		gbc_btn13.gridx = 0;
		gbc_btn13.gridy = 3;
		GameFrame.add(btn13, gbc_btn13);

		JButton btn14 = new JButton("    Mine    ");
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(14)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn14.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn14 = new GridBagConstraints();
		gbc_btn14.insets = new Insets(0, 0, 5, 5);
		gbc_btn14.gridx = 1;
		gbc_btn14.gridy = 3;
		GameFrame.add(btn14, gbc_btn14);

		JButton btn15 = new JButton("    Mine    ");
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(15)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn15.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn15 = new GridBagConstraints();
		gbc_btn15.insets = new Insets(0, 0, 5, 5);
		gbc_btn15.gridx = 2;
		gbc_btn15.gridy = 3;
		GameFrame.add(btn15, gbc_btn15);

		JButton btn16 = new JButton("    Mine    ");
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(16)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn16.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn16 = new GridBagConstraints();
		gbc_btn16.insets = new Insets(0, 0, 5, 5);
		gbc_btn16.gridx = 3;
		gbc_btn16.gridy = 3;
		GameFrame.add(btn16, gbc_btn16);

		JButton btn17 = new JButton("    Mine    ");
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(17)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn17.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn17 = new GridBagConstraints();
		gbc_btn17.insets = new Insets(0, 0, 5, 5);
		gbc_btn17.gridx = 0;
		gbc_btn17.gridy = 4;
		GameFrame.add(btn17, gbc_btn17);

		JButton btn18 = new JButton("    Mine    ");
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(18)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn18.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn18 = new GridBagConstraints();
		gbc_btn18.insets = new Insets(0, 0, 5, 5);
		gbc_btn18.gridx = 1;
		gbc_btn18.gridy = 4;
		GameFrame.add(btn18, gbc_btn18);

		JButton btn19 = new JButton("    Mine    ");
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(19)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn19.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn19 = new GridBagConstraints();
		gbc_btn19.insets = new Insets(0, 0, 5, 5);
		gbc_btn19.gridx = 2;
		gbc_btn19.gridy = 4;
		GameFrame.add(btn19, gbc_btn19);

		JButton btn20 = new JButton("    Mine    ");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(20)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn20.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn20 = new GridBagConstraints();
		gbc_btn20.insets = new Insets(0, 0, 5, 5);
		gbc_btn20.gridx = 3;
		gbc_btn20.gridy = 4;
		GameFrame.add(btn20, gbc_btn20);

		JButton btn21 = new JButton("    Mine    ");
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(21)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn21.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn21 = new GridBagConstraints();
		gbc_btn21.insets = new Insets(0, 0, 5, 5);
		gbc_btn21.gridx = 0;
		gbc_btn21.gridy = 5;
		GameFrame.add(btn21, gbc_btn21);

		JButton btn22 = new JButton("    Mine    ");
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(22)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn22.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn22 = new GridBagConstraints();
		gbc_btn22.insets = new Insets(0, 0, 5, 5);
		gbc_btn22.gridx = 1;
		gbc_btn22.gridy = 5;
		GameFrame.add(btn22, gbc_btn22);

		JButton btn23 = new JButton("    Mine    ");
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(23)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn23.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn23 = new GridBagConstraints();
		gbc_btn23.insets = new Insets(0, 0, 5, 5);
		gbc_btn23.gridx = 2;
		gbc_btn23.gridy = 5;
		GameFrame.add(btn23, gbc_btn23);

		JButton btn24 = new JButton("    Mine    ");
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(24)) {
					System.out.print("Game Over\n");
					GameActive = false;
				} else {
					btn24.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn24 = new GridBagConstraints();
		gbc_btn24.insets = new Insets(0, 0, 5, 5);
		gbc_btn24.gridx = 3;
		gbc_btn24.gridy = 5;
		GameFrame.add(btn24, gbc_btn24);

		JButton btn25 = new JButton("    Mine    ");
		btn25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uniqueNumbers.contains(25)) {
					GameActive = false;
					System.out.print("Game Over");
				} else {
					btn25.setEnabled(false);
					mines = mines - 1;
				}
			}
		});
		GridBagConstraints gbc_btn25 = new GridBagConstraints();
		gbc_btn25.insets = new Insets(0, 0, 5, 5);
		gbc_btn25.gridx = 0;
		gbc_btn25.gridy = 6;
		GameFrame.add(btn25, gbc_btn25);
		
		JLabel WinORLoseTxt = new JLabel("You Won!");
		WinORLoseTxt.setFont(new Font("Tahoma", Font.BOLD, 24));
		WinORLoseTxt.setHorizontalAlignment(SwingConstants.CENTER);
		WinORLoseTxt.setBounds(10, 391, 563, 23);
		frame.getContentPane().add(WinORLoseTxt);

		// Checks Game State
		AmtOfBombsLbl.setVisible(false);
		AmtOfMinesLbl.setVisible(false);
		GameStartedTxt.setBounds(364, 72, 209, 14);
		
		WinORLoseTxt.setVisible(false);

		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GameActive) {
					StartGameBtn.setVisible(false);
					GameFrame.setVisible(true);
					GameStartedTxt.setText("Game Has Started...");
					GameStartedTxt.setForeground(new Color(0, 255, 0));
					AmtOfMines.setEditable(false);
					AmtOfMinesLbl.setText("Mines Left: " + mines);
					WinORLoseTxt.setVisible(false);

					if (InitializeNum == 0) {
						if (Integer.parseInt(AmtOfMines.getText()) < 24) {
							InitializeNum = InitializeNum + 1;

							try {
								bombs = Integer.parseInt(AmtOfMines.getText());
								mines = mines - bombs;
								System.out.println(mines + " Safe Mines");
								AmtOfMinesLbl.setText("Mines Left: " + mines);
								AmtOfBombsLbl.setText("Bombs: " + bombs);
								AmtOfMinesLbl.setVisible(true);
								AmtOfBombsLbl.setVisible(true);

								while (uniqueNumbers.size() < bombs) {
									int randomNumber = randomNums.nextInt(25);
									uniqueNumbers.add(randomNumber);
								}

								int count = 1;
								for (int number : uniqueNumbers) {
									System.out.println("Random Number " + count + ": " + number);
									count++;
								}
							} catch (NumberFormatException ex) {

								System.out.println("Invalid input for number of mines.");
								GameActive = false;
							}
						} else {
							System.out.println("Enter Numbers Below 24 Only!");
							GameActive = false;
						}
					}
					if (mines == 0){
						System.out.println("You Won!");
						WinORLoseTxt.setVisible(true);
						WinORLoseTxt.setText("You Won!");
						WinORLoseTxt.setBounds(10,200,563,23);
						GameActive = false;
					}
				} else if (!GameActive) {
					AmtOfBombsLbl.setVisible(false);
					AmtOfMinesLbl.setVisible(false);
					GameFrame.setVisible(false);
					StartGameBtn.setVisible(true);
					GameStartedTxt.setText("Game Hasn't Started...");
					GameStartedTxt.setForeground(new Color(255, 0, 0));
					AmtOfMines.setEditable(true);
					InitializeNum = 0;
					uniqueNumbers.clear();
					mines = 25;

					btn1.setEnabled(true);
					btn2.setEnabled(true);
					btn3.setEnabled(true);
					btn4.setEnabled(true);
					btn5.setEnabled(true);
					btn6.setEnabled(true);
					btn7.setEnabled(true);
					btn8.setEnabled(true);
					btn9.setEnabled(true);
					btn10.setEnabled(true);
					btn11.setEnabled(true);
					btn12.setEnabled(true);
					btn13.setEnabled(true);
					btn14.setEnabled(true);
					btn15.setEnabled(true);
					btn16.setEnabled(true);
					btn17.setEnabled(true);
					btn18.setEnabled(true);
					btn19.setEnabled(true);
					btn20.setEnabled(true);
					btn21.setEnabled(true);
					btn22.setEnabled(true);
					btn23.setEnabled(true);
					btn24.setEnabled(true);
					btn25.setEnabled(true);
				}
			}
		});
		timer.start();
	}
}