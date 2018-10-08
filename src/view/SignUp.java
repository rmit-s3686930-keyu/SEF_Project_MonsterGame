package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.SQL;
import model.User;

public class SignUp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	User _user;

	JFrame frame = new JFrame("Sign Up");

	public SignUp() {
		// TODO Auto-generated constructor stub
	}

	public void signUp0() {
		// SignUp signUp = new SignUp();
		// Setting the width and height of frame
		frame.setSize(350, 200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		// frame.setDefaultCloseOperation();
		/*
		 * ������壬��������� HTML �� div ��ǩ ���ǿ��Դ��������岢�� JFrame ��ָ��λ�� ��������ǿ��������ı��ֶΣ���ť�����������
		 */
		JPanel panel = new JPanel();
		// �������
		frame.add(panel);
		/*
		 * �����û�����ķ�����������������
		 */
		placeComponents(panel);

		// ���ý���ɼ�
		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		// ���� JLabel
		JLabel userLabel = new JLabel("User:");
		/*
		 * ������������������λ�á� setBounds(x, y, width, height) x �� y ָ�����Ͻǵ���λ�ã��� width �� height
		 * ָ���µĴ�С��
		 */
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);

		/*
		 * �����ı��������û�����
		 */
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);

		// ����������ı���
		JLabel passwordLabel0 = new JLabel("Password:");
		passwordLabel0.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel0);
		// �������������ı���
		JLabel passwordLabel1 = new JLabel("Retype:");
		passwordLabel1.setBounds(10, 80, 80, 25);
		panel.add(passwordLabel1);
		/*
		 * �����������������ı��� �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
		 */
		JPasswordField passwordText0 = new JPasswordField(10);
		passwordText0.setBounds(100, 50, 165, 25);
		panel.add(passwordText0);
		JPasswordField passwordText1 = new JPasswordField(10);
		passwordText1.setBounds(100, 80, 165, 25);
		panel.add(passwordText1);
		// ����ע�ᰴť
		JButton signButton = new JButton("sign up");
		signButton.setBounds(130, 110, 90, 25);
		panel.add(signButton);
		// ע����Ϣ

		signButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = userText.getText();
				char[] pwd0 = passwordText0.getPassword();
				char[] pwd1 = passwordText1.getPassword();
				System.out.println(pwd0);
				System.out.println(pwd1);
				if (pwdCompare(pwd0, pwd1)) {
					User user = new User(userName, pwd0);
					_user = user;
					panel.remove(signButton);
					returnButton(panel);
					panel.repaint();
				} else {
					return;
				}
				userText.setText("");
				passwordText0.setText("");
				passwordText1.setText("");
				System.out.println(_user.getUserName()+" regsited");
				Login.control.addUser(_user);
				SQL.insertUser(_user);
			}
		});

	}

	private void returnButton(JPanel panel) {

		JButton returnButton = new JButton("sign up success, click to return");
		returnButton.setBounds(50, 110, 250, 25);
		panel.add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
	}

	public boolean pwdCompare(char[] pwd0, char[] pwd1) {
		if (pwd0.length != pwd1.length || pwd0.length == 0 || pwd1.length == 0) {
			return false;
		}
		for (int i = 0; i < pwd0.length; i++) {
			if (pwd0[i] != pwd1[i]) {
				return false;
			}
		}
		return true;
	}
}