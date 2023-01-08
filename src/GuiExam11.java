import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;




class Sunguk  implements Serializable
{
	String idstr;
	String pwstr;
	String pwstr2;
	String namestr;
	String stdidstr ;
	String pnumstr ;
	String emailidstr ;
	String java ; 
	String html ;
	String database ;
	
}

public class GuiExam11 {
	int loginNum;
	int foundnum;
	
	ArrayList<Sunguk> list = new ArrayList<Sunguk>();
		
	String fileName;
	String fileadrees;
	
	JFrame jf = new JFrame();
	
	JPanel page2 = new JPanel(); //����ȭ�� �г�
	JPanel main = new JPanel(); //����ȭ�� �г�
	JPanel joinscreen[] = new JPanel[12];
	
	JPanel page4 = new JPanel();
	JPanel page5 = new JPanel();
	JPanel page6 = new JPanel();
	JPanel page7 = new JPanel();
	JPanel page8 = new JPanel();
	JPanel page9 = new JPanel();
	JPanel page10 = new JPanel();
	JPanel page11 = new JPanel(); //�г�11�� ��� �ϳ��� ������
	JPanel page12 = new JPanel(); //�г�12�� ��� �ϳ��� ������
	File newfile;
	
	
	GuiExam11()
	{

		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Temp\\data.txt"));
			list = (ArrayList<Sunguk>)ois.readObject();//���Ͽ��� ArrayList�б�
			ois.close();
		} catch (Exception ex)
		{

		}

        /*for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).html);
            
        }*/
		
		page_2();
	}

	void page_2()
	{
		
		JButton join = new JButton("ȸ������"); //�����̵� 2�� ȸ������ ��ư ����
		JButton login = new JButton("�α���"); //�����̵� 2�� �α��� ��ư ����
	
		jf.setTitle("�������� ���α׷�");
		jf.setSize(600, 600); // ȭ��ũ��
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		jf.add(page2);
		page2.setLayout(null);
		page2.setSize(600,600);
		page2.add(main);
		
		//���� ȭ���� ��ư ��ġ �� ����
		main.setLayout(new BorderLayout()); 
		main.setSize(150,150);
		main.setLocation(220,200); //��ġ����
		main.add(join,"North");
		main.add(login,"South");
		
		//��ư �� ������ �� ����
		join.setPreferredSize(new Dimension(160,60));
		login.setPreferredSize(new Dimension(170,60));
		join.setBackground(Color.lightGray);
		login.setBackground(Color.lightGray);
		
		/////////////////////////////////////////////////////////////////
		//ȸ������

		
		JPanel joinsc = new JPanel();
		JPanel joininput = new JPanel();
		JPanel joinintext = new JPanel();//ID~��ȭ��ȣ������ textfild
		JPanel joinintext2 = new JPanel(); //e-������ ���̵� 
		JPanel joinintext3 = new JPanel(); //e-������ �����ּ�
		JPanel joinintext4 = new JPanel(); //�޺��ڽ�
		JPanel joinintext5 = new JPanel(); //������ſ���
		JPanel joinintext6 = new JPanel(); //�ߺ�Ȯ�� ��ư
		JPanel joinintext7 = new JPanel(); //����,�Ϸ� ��ư
		
		joinscreen[0] = joinsc;
		joinscreen[1] = joininput;
		joinscreen[2] = joinintext;
		joinscreen[3] = joinintext2;
		joinscreen[4] = joinintext3;
		joinscreen[5] = joinintext4;
		joinscreen[6] = joinintext5;
		joinscreen[7] = joinintext6;
		joinscreen[8] = joinintext7;
		
		for (int i = 0; i <=8 ; i++) {
			joinscreen[i].setVisible(false);
		}

		
		
		JLabel jointext = new JLabel("ȸ������");
		JLabel joinid = new JLabel("ID");
		JLabel joinpw = new JLabel("PW");
		JLabel joinpw2 = new JLabel("PW ���Է�");
		JLabel joinname = new JLabel("�̸�");
		JLabel joinstudid = new JLabel("�й�");
		JLabel joinpnum = new JLabel("��ȭ��ȣ");
		JLabel joinemail = new JLabel("e-mail");
		JLabel marketing = new JLabel("������ſ���");
		
		JTextField inputid = new JTextField();
		JTextField inputpw = new JTextField(10);
		JTextField inputpw2 = new JTextField(10);
		JTextField inputname = new JTextField();
		JTextField inputstdid = new JTextField();
		JTextField inputpnum = new JTextField();
		JTextField inputmail = new JTextField();
		
		joinsc.setSize(500,30);
		joinsc.setLocation(30,10); //��ġ����
		joinsc.add(jointext);
		
		//�Է� �г� ������ �� ���� ����
		joininput.setSize(100,450);
		joininput.setLocation(30,60);
		
		//�� �߰� �� ��ġ ����
		joininput.setLayout(new GridLayout(8,0,0,0));
		joininput.add(joinid);
		joininput.add(joinpw);
		joininput.add(joinpw2);
		joininput.add(joinname);
		joininput.add(joinstudid);
		joininput.add(joinpnum);
		joininput.add(joinemail);
		joininput.add(marketing);
		
		//�Է� �г� ������ �� ���� ����2
		joinintext.setSize(300,320);
		joinintext.setLocation(140,65);
		
		joinintext.setLayout(new GridLayout(6,0,10,10));
		joinintext.add(inputid);
		joinintext.add(inputpw);
		joinintext.add(inputpw2);
		joinintext.add(inputname);
		joinintext.add(inputstdid);
		joinintext.add(inputpnum);
		
		//�Է��г� ������ �� ���� ����3(�̸����� ���̵�)
		joinintext2.setSize(150,40);
		joinintext2.setLocation(140,400);
		
		joinintext2.setLayout(new GridLayout(1,0,0,0));
		joinintext2.add(inputmail);
		
		//�Է��г� ������ �� ���� ����4(@)
		JLabel at = new JLabel("@");
		joinintext3.setSize(20,40);
		joinintext3.setLocation(290,400);
		
		joinintext3.setLayout(new GridLayout(1,0,0,0));
		joinintext3.add(at);

		
		//�Է��г� ������ �� ��������5
		JComboBox email = new JComboBox();
		
		email.setModel(new DefaultComboBoxModel(new String[] {"naver.com","hanmain.net","gmail.com"}));
		email.setSelectedIndex(0);
		
		joinintext4.setSize(200,40);
		joinintext4.setLocation(320,400);
		joinintext4.setLayout(new GridLayout(1,0,0,0));
		joinintext4.add(email); //�޺��ڽ�
		
		
		
		for (int i = 0; i <= 8; i++) {
		     page2.add(joinscreen[i]);
		}
		
		
		//�Է��г� ������ �� ���� ���� 6
		ButtonGroup tf = new ButtonGroup(); //�ߺ����õ����ʰ� ������ư �׷�ȭ ����
		JRadioButton t = new JRadioButton("����");
		JRadioButton f = new JRadioButton("�̵���");
		tf.add(t);
		tf.add(f); //������ư �׷�ȭ
		
		joinintext5.setSize(180,40);
		joinintext5.setLocation(140,460);
		joinintext5.setLayout(new GridLayout(1,4,0,0));
		joinintext5.add(t);
		joinintext5.add(f);
		
		
		//�ߺ�Ȯ�� ��ư
		JButton equal = new JButton("�ߺ�Ȯ��");
		joinintext6.setSize(100,40);
		joinintext6.setLocation(460,70);
		joinintext6.setLayout(new FlowLayout());
		joinintext6.add(equal);
		
		//����, �Ϸ� ��ư
		JButton re = new JButton("����");
		JButton next = new JButton("�Ϸ�");
		joinintext7.setSize(520,40);
		joinintext7.setLocation(30,510);
		joinintext7.setLayout(new BorderLayout());
		joinintext7.add(re,"West");
		joinintext7.add(next,"East");
		
		equal.setBackground(Color.lightGray);
		re.setBackground(Color.lightGray);
		next.setBackground(Color.lightGray);
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("ȸ������")) {
					main.setVisible(false);
					for (int i = 0; i <=8 ; i++) {
						joinscreen[i].setVisible(true);
					}
					page4.setVisible(false);
					
				}
				
			}
		});
		
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("�α���")) {
					page2.setVisible(false);
					main.setVisible(false);
					page4.setVisible(true);
					login();	
				}
				
			}
		});
		
		
		re.addActionListener(new ActionListener() {  //������ư
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("����")) {
					main.setVisible(true);
					for (int i = 0; i <=8 ; i++) {
						joinscreen[i].setVisible(false);
					}
				     inputid.setText("");
			         inputpw.setText("");
			         inputpw2.setText("");
			         inputname.setText("");
			         inputpnum.setText("");
			         inputstdid.setText("");
			         inputmail.setText("");
			         equal.setEnabled(true);
			         inputid.setEnabled(true);

				}
				
			}
		});
		
		equal.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {

				 boolean stop = true;
				if (e.getActionCommand().equals("�ߺ�Ȯ��")) {
					
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).idstr.equals(inputid.getText()))
						{
							JOptionPane.showMessageDialog(null,"���Ұ����� ���̵��Դϴ�.");
							 stop = false;
						}
						
					}
					 if(inputid.getText().equals("")) {
						 JOptionPane.showMessageDialog(null,"ID�� �Է��ϼ���.");
					 }else if( stop){
						 JOptionPane.showMessageDialog(null,"��밡���� ���̵��Դϴ�."); //�̰ž��ϸ� for���̶� ã���� �� ��� ������  
						 equal.setEnabled(false);
						 inputid.setEnabled(false);
						 
				       }
				}
			}
		});
		
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Sunguk sj = new  Sunguk();
				if (e.getActionCommand().equals("�Ϸ�")) {
					
						if(inputid.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"ID�� �Է��ϼ���.");
						}else if(inputname.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
						}else if(inputpw.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"PW�� �Է��ϼ���");
						}else if(inputpw2.getText().equals("")!=inputpw.getText().equals("")){
							JOptionPane.showMessageDialog(null, "��й�ȣ ��Ȯ���� �ʿ��մϴ�.");
						}else if(inputstdid.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���.");
						}else if(inputpnum.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "�޴�����ȣ�� �Է��ϼ���.");
						}else if(inputmail.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "�̸����� �Է��ϼ���.");
						}else if(email.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸����� �����ϼ���.");
						}else if(inputpw.getText().length() >= 7) {
							JOptionPane.showMessageDialog(null, "�ִ� 8�� ���� �Է��� �����մϴ�.");
						}else if(inputpw.getText().contains(inputpw2.getText()) == false || inputpw2.getText().contains(inputpw.getText()) == false){
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						}else if(tf.isSelected(null)){
							JOptionPane.showMessageDialog(null, "������ŵ��ǿ��θ� Ȯ���ϼ���.");
						}else if(equal.isEnabled()){
							JOptionPane.showMessageDialog(null, "�ߺ�Ȯ���� �ʿ��մϴ�.");
						}else {	
							for (int i = 0; i <= 8; i++) {
							joinscreen[i].setVisible(false);
						}
							sj.idstr = inputid.getText();
							sj.pwstr = inputpw.getText();
							sj.pwstr2 = inputpw2.getText();
							sj.namestr = inputname.getText();
							sj.stdidstr = inputstdid.getText();
							sj.pnumstr = inputpnum.getText();
							sj.emailidstr = inputmail.getText() + "@"+email.getSelectedItem().toString();
							
							list.add(sj);
							  try
								{
									ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
									oos.writeObject(list);//���Ͽ� ArrayList ����
									oos.close();
								} catch (Exception ex)
								{

								}
							page4.setVisible(true);
							login();
							page2.setVisible(false);
							page_12();
							page12.setVisible(false);
						}
					
				
				}
			}
		});	
	}
			
	/*	next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Sunguk sj = new  Sunguk();
				if (e.getActionCommand().equals("�Ϸ�")) {
					sj.idstr = inputid.getText();
					sj.pwstr = inputpw.getText();
					sj.pwstr2 = inputpw2.getText();
					sj. namestr = inputname.getText();
					sj. stdidstr = inputstdid.getText();
					sj. pnumstr = inputpnum.getText();
					sj. emailidstr = inputmail.getText() + "@"+email.getSelectedItem().toString();
					
						if(sj.idstr.equals("")) {
							JOptionPane.showMessageDialog(null,"ID�� �Է��ϼ���.");
						}else if(sj.pwstr.equals("")) {
							JOptionPane.showMessageDialog(null,"PW�� �Է��ϼ���");
						}else if(sj.pwstr2.equals("")){
							JOptionPane.showMessageDialog(null, "��й�ȣ ��Ȯ���� �ʿ��մϴ�.");
						}else if(sj.namestr.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
						}else if(sj.stdidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���.");
						}else if(sj.pnumstr.equals("")) {
							JOptionPane.showMessageDialog(null, "�޴�����ȣ�� �Է��ϼ���.");
						}else if(sj.emailidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸����� �Է��ϼ���.");
						}else if(email.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸����� �����ϼ���.");
						}else if(sj.pwstr.length() >= 7) {
							JOptionPane.showMessageDialog(null, "�ִ� 8�� ���� �Է��� �����մϴ�.");
						}else if(sj.pwstr.contains(sj.pwstr2) == false ) {
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						}else {	
							for (int i = 0; i <= 8; i++) {
							joinscreen[i].setVisible(false);
						}
							list.add(sj);
							  try
								{
									ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
									oos.writeObject(list);//���Ͽ� ArrayList ����
									oos.close();
								} catch (Exception ex)
								{

								}
							page4.setVisible(true);
							login();
							page2.setVisible(false);
						}
					
				
				}
			}
		});
			
	/*	next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Sunguk sj = new  Sunguk();
				if (e.getActionCommand().equals("�Ϸ�")) {
					sj.idstr = inputid.getText();
					sj.pwstr = inputpw.getText();
					sj.pwstr2 = inputpw2.getText();
					sj. namestr = inputname.getText();
					sj. stdidstr = inputstdid.getText();
					sj. pnumstr = inputpnum.getText();
					sj. emailidstr = inputmail.getText() + "@"+email.getSelectedItem().toString();
					
						if(sj.idstr.equals("")) {
							JOptionPane.showMessageDialog(null,"ID�� �Է��ϼ���.");
						}else if(sj.pwstr.equals("")) {
							JOptionPane.showMessageDialog(null,"PW�� �Է��ϼ���");
						}else if(sj.pwstr2.equals("")){
							JOptionPane.showMessageDialog(null, "��й�ȣ ��Ȯ���� �ʿ��մϴ�.");
						}else if(sj.namestr.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
						}else if(sj.stdidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���.");
						}else if(sj.pnumstr.equals("")) {
							JOptionPane.showMessageDialog(null, "�޴�����ȣ�� �Է��ϼ���.");
						}else if(sj.emailidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸����� �Է��ϼ���.");
						}else if(email.equals("")) {
							JOptionPane.showMessageDialog(null, "�̸����� �����ϼ���.");
						}else if(sj.pwstr.length() >= 7) {
							JOptionPane.showMessageDialog(null, "�ִ� 8�� ���� �Է��� �����մϴ�.");
						}else if(sj.pwstr.contains(sj.pwstr2) == false ) {
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						}else {	
							for (int i = 0; i <= 8; i++) {
							joinscreen[i].setVisible(false);
						}
							list.add(sj);
							  try
								{
									ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
									oos.writeObject(list);//���Ͽ� ArrayList ����
									oos.close();
								} catch (Exception ex)
								{

								}
							page4.setVisible(true);
							login();
							page2.setVisible(false);
						}
					
				
				}
			}
		});	*/

	
	//==============================================================================================page2
	
void login() {
		
		JLabel jid = new JLabel("ID");
		JLabel jpw = new JLabel("PW");
		JTextField txid = new JTextField();
		JTextField txpw = new JTextField();
		JButton jbLogin = new JButton("�α���");
		JButton jbSign = new JButton("ȸ������");
		JButton jbid = new JButton("ID ã��");
		JButton jbpw = new JButton("PW ã��");
		
		String id = "";
		String pw = "";
		String adminid = "admin";
		String adminpassword = "1111";
		
		jf.setTitle("�α���");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setLayout(null);
		//jf.setContentPane(page4);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jf.add(page4);
		page4.setLayout(null);
		page4.setSize(jf.getWidth(),jf.getHeight());
		
	

		jid.setBounds(125, 167, 57, 25); //ID ��ġ ���� : x, y, width, height
		page4.add(jid);
		txid.setText(id);
		txid.setBounds(150, 170, 167, 21); //ID textField ��ġ ����
		page4.add(txid);
		txid.setColumns(15); //text �Է� ĭ ���� ����
		
		txid.setFocusTraversalKeysEnabled(false);
		txid.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB){
					txpw.requestFocus();}
			}
		});

		jpw.setBounds(120, 193, 57, 25); //PW ��ġ ����
		page4.add(jpw);
		txpw.setText(pw);
		txpw.setBounds(150, 195, 167, 21); //PW textField ��ġ ����
		page4.add(txpw);
		txpw.setColumns(15); //text �Է� ĭ ���� ����

		page4.add(jbLogin);
		jbLogin.setBounds(350, 170, 102, 46); //�α��� ��ư ��ġ
		jbLogin.setBackground(Color.lightGray); //�α��� ��ư ����
		jbLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {  //�α����ϸ� 9����������

			
				
				for (int j = 0; j < list.size(); j++) {
					if(e.getSource() == jbLogin && list.get(j).idstr.equals(txid.getText()) && list.get(j).pwstr.equals(txpw.getText()))
					{		
						loginNum = j;  //10�������� ���� �α��������� ������ �̸��̶߰Բ�
					}
				}
				if(txid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.");
				}else if(txpw.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.");
				}else if(e.getSource() == jbLogin && adminid.equals(txid.getText()) && adminpassword.equals(txpw.getText()) )
				{
					page4.setVisible(false);
					page_12();	
					page12.setVisible(true);
					txid.setText("");
					txpw.setText("");
					
			    }else if(!txid.getText().equals(list.get(loginNum).idstr)) {
					JOptionPane.showMessageDialog(null, "��ġ�ϴ� ���̵� �����ϴ�.");
				}else if (!txpw.getText().equals(list.get(loginNum).pwstr)) {
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			    }else{
			    	page4.setVisible(false);
					page_9();  //�ڵ������� ��ȯ�ǰԲ� ����	
					page9.setVisible(true);
					txid.setText("");
					txpw.setText("");
				}
				
				
				
				
			}
				
			
		});

		page4.add(jbSign);
		jbSign.setBounds(350, 250, 102, 30); //ȸ������ ��ư ��ġ
		jbSign.setBackground(Color.lightGray); //ȸ������ ��ư ����
		jbSign.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == jbSign) {
					page4.setVisible(false);
					page_2();	
					page2.setVisible(true);
					for (int i = 0; i <=8 ; i++) {
						joinscreen[i].setVisible(true);
						txid.setText("");
						txpw.setText("");
					}
					
				}

			}
		});

		page4.add(jbid);
		jbid.setBounds(120, 250, 102, 30); //ID ã�� ��ư ��ġ
		jbid.setBackground(Color.lightGray); //ID ã�� ��ư ����
		jbid.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource() == jbid) {
						
					page2.setVisible(false);
					page4.setVisible(false);
					findId();
					page5.setVisible(true);
					txid.setText("");
					txpw.setText("");
				}

			}
		});

		page4.add(jbpw);
		jbpw.setBounds(235, 250, 102, 30); //PW ã�� ��ư ��ġ
		jbpw.setBackground(Color.lightGray); //PW ã�� ��ư ����
		jbpw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbpw) {
					page7.setVisible(true);
					findPw();
					page4.setVisible(false);
					txid.setText("");
					txpw.setText("");
				}

			}
		});
	}

	void findId() {
		JLabel jName = new JLabel("�̸�");
		JLabel jNum = new JLabel("�й�");
		JTextField txName = new JTextField();
		JTextField txNum = new JTextField();
		JButton jbIdCom = new JButton("�Ϸ�");
		JButton jbIdBack = new JButton("����");
		
	
		
		jf.setTitle("ID ã��");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setLayout(null);
		//jf.setContentPane(page5);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jf.add(page5);
		page5.setLayout(null);
		page5.setSize(jf.getWidth(),jf.getHeight());

		jName.setBounds(120, 177, 90, 25);
		page5.add(jName);
		//txName.setText("");
		txName.setBounds(150, 179, 167, 21);
		page5.add(txName);
		txName.setColumns(15);

		jNum.setBounds(120, 210, 32, 25);
		page5.add(jNum);
		//txNum.setText("");
		txNum.setBounds(150, 212, 167, 21);
		page5.add(txNum);
		txNum.setColumns(15);
		
		page5.add(jbIdCom);
		jbIdCom.setBounds(350, 170, 105, 70);
		jbIdCom.setBackground(Color.lightGray);
		jbIdCom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < list.size(); i++)
				{
					 if (e.getSource() == jbIdCom  && list.get(i).namestr.equals(txName.getText()) && list.get(i).stdidstr.equals(txNum.getText())  ) {					
						foundnum = i;				
					}
				}
				if(txName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
				}else if(txNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���.");
				}else if(!(txName.getText().equals(list.get(foundnum).namestr))) {
					JOptionPane.showMessageDialog(null, "�̸��� ��ġ���� �ʽ��ϴ�.");
				}else if(!(txNum.getText().equals(list.get(foundnum).stdidstr))) {
					JOptionPane.showMessageDialog(null, "�й��� ��ġ���� �ʽ��ϴ�.");
			    }else {
			    	page6.setVisible(true);
					page5.setVisible(false);
					txName.setText("");
					txNum.setText("");
					foundId();
				}
				
				
				
			}
		});
		
		page5.add(jbIdBack);
		jbIdBack.setBounds(235, 250, 102, 30);
		jbIdBack.setBackground(Color.lightGray);
		
		jbIdBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbIdBack) {
					page4.setVisible(true);
					login();
					page5.setVisible(false);
					txName.setText("");
					txNum.setText("");
				}
				
			}
		});
	}
	
	void foundId() {
		JLabel jlFId = new JLabel("ID");
		JButton jbFIdBack = new JButton("�α��� ȭ������ �̵�");
		JTextField tt = new JTextField("");
		tt.setText("");
		tt.setText(list.get(foundnum).idstr.toString());
		
		jf.add(page6);
		
		jlFId.setBounds(120, 193, 57, 25);
		page6.add(jlFId);
		
		tt.setBounds(180, 193, 300, 25);
		tt.setFont(new Font(null, Font.BOLD, 20));
		tt.setEditable(false);
		
		
		page6.add(tt);
		tt.setBorder(new LineBorder(Color.black));
		page6.setLayout(null);
		page6.setSize(jf.getWidth(),jf.getHeight());
		
		jf.setTitle("ã�� ID");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setLayout(null);
		//jf.setContentPane(page6);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		
		page6.add(jbFIdBack);
		jbFIdBack.setBounds(200, 250, 170, 30);
		jbFIdBack.setBackground(Color.lightGray);
		jbFIdBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbFIdBack) {
					tt.setText("");
					page4.setVisible(true);
					login();
					page6.setVisible(false);
				}
				
			}
		});
		
		

	}

	void findPw() {
		JLabel jId = new JLabel("ID ");
		JLabel jlName = new JLabel("�̸�");
		JLabel jlNum = new JLabel("�й�");
		JTextField txtId = new JTextField();
		JTextField txtName = new JTextField();
		JTextField txtNum = new JTextField();
		JButton jbPwCom = new JButton("�Ϸ�");
		JButton jbPwBack = new JButton("����");
		
		String pwId = "";
		String pwName = "";
		String pwNum = "";
		
		jf.setTitle("PW ã��");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setLayout(null);
		//jf.setContentPane(page7);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jf.add(page7);
		
		page7.setLayout(null);
		page7.setSize(jf.getWidth(),jf.getHeight());
		
		jId.setBounds(125, 167, 90, 25);
		page7.add(jId);
		txtId.setText(pwId);
		txtId.setBounds(150, 170, 167, 21);
		page7.add(txtId);
		txtId.setColumns(15);
		
		jlName.setBounds(120, 193, 57, 25);
		page7.add(jlName);
		txtName.setText(pwId);
		txtName.setBounds(150, 195, 167, 21);
		page7.add(txtName);
		txtName.setColumns(15);
		
		jlNum.setBounds(120, 220, 32, 25);
		page7.add(jlNum);
		txtNum.setText(pwId);
		txtNum.setBounds(150, 220, 167, 21);
		page7.add(txtNum);
		txtNum.setColumns(15);
		
		page7.add(jbPwCom);
		jbPwCom.setBounds(350, 170, 105, 70);
		jbPwCom.setBackground(Color.lightGray);
		jbPwCom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < list.size(); i++)
				{
					if (e.getSource() == jbPwCom && list.get(i).idstr.equals(txtId.getText()) && list.get(i).namestr.equals(txtName.getText()) && list.get(i).stdidstr.equals(txtNum.getText())) {  //�Ϸ��ư				
						foundnum = i;					
					}
				}
				
				if(txtId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ID�� �Է��ϼ���.");
				}else if(txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
		      	}else if(txtNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�й��� �Է��ϼ���.");
			    }else if(!(txtId.getText().equals(list.get(foundnum).idstr))) {
					JOptionPane.showMessageDialog(null, "ID�� ��ġ���� �ʽ��ϴ�.");
				}else if(!(txtName.getText().equals(list.get(foundnum).namestr))) {
					JOptionPane.showMessageDialog(null, "�̸��� ��ġ���� �ʽ��ϴ�.");
				}else if(!(txtNum.getText().equals(list.get(foundnum).stdidstr))) {
					JOptionPane.showMessageDialog(null, "�й��� ��ġ���� �ʽ��ϴ�.");
				}else {
						page8.setVisible(true);
						foundPw();
						page7.setVisible(false);
						txtId.setText("");
						txtName.setText("");
						txtNum.setText("");					
						
					}
				

				
			}
		});
		
		page7.add(jbPwBack);
		jbPwBack.setBounds(235, 250, 102, 30);
		jbPwBack.setBackground(Color.lightGray);
		
		jbPwBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //������ư
				
				if (e.getSource() == jbPwBack) {
					page4.setVisible(true);
					login();
					page7.setVisible(false);
					txtId.setText("");
					txtName.setText("");
					txtNum.setText("");
				}

				
			}
		});
	}
	
	void foundPw() {
		
		JLabel jlFPwId = new JLabel("ID");
		JLabel jlFPwpw = new JLabel("PW");
		JButton jbFPWBack = new JButton("�α��� ȭ������ �̵�");
		JTextField t3 = new JTextField("");
		JTextField t4 = new JTextField("");
		t3.setText(""); //pw textField
		t4.setText(""); //id textField
		t3.setText(list.get(foundnum).pwstr.toString());
		t4.setText(list.get(foundnum).idstr.toString());
		
		
		jf.setTitle("ã�� PW");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setLayout(null);
		//jf.setContentPane(page8);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.add(page8);
		
		t3.setBounds(180, 193, 300, 25);
		t3.setFont(new Font(null, Font.BOLD, 20));
		t3.setEditable(false);
		t4.setBounds(180, 165, 300, 25);
		t4.setFont(new Font(null, Font.BOLD, 20));
		t4.setEditable(false);
		
		page8.add(t3);
		page8.add(t4);
		t3.setBorder(new LineBorder(Color.black));
		t4.setBorder(new LineBorder(Color.black));
		page8.setLayout(null);
		page8.setSize(jf.getWidth(),jf.getHeight());
		
		jlFPwId.setBounds(125, 167, 90, 25);
		page8.add(jlFPwId);
		
		jlFPwpw.setBounds(120, 193, 57, 25);
		page8.add(jlFPwpw);
		
		page8.add(jbFPWBack);
		jbFPWBack.setBounds(200, 250, 170, 30);
		jbFPWBack.setBackground(Color.lightGray);
		
		jbFPWBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == jbFPWBack) {
					t3.setText("");
					t4.setText("");
					page4.setVisible(true);
					login();
					page8.setVisible(false);
				}

				
			}
		});
	}
	
	void page_9() {      // �����Է�, ��������� 2���� ��ư�� ���� �޼ҵ� (9�� �����̵�) 
		
		JButton bt1 = new JButton("�����Է�"); 
		JButton bt2 = new JButton("�������");
		
		jf.add(page9);
		jf.setLayout(null);
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		
		page9.setLayout(new BorderLayout());
		page9.setSize(150,150);
		page9.setLocation(220,200);
		
		page9.add(bt1,"North");
		page9.add(bt2,"South");
		
		bt1.setPreferredSize(new Dimension(160,60));
		bt2.setPreferredSize(new Dimension(170,60));
		bt1.setBackground(Color.lightGray);
		bt2.setBackground(Color.lightGray);
		
		ActionListener act1 = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				page9.setVisible(false);
				page_10();
				page10.setVisible(true);			
			}
		};
		
		ActionListener act2 = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				page10.setVisible(false);
				page9.setVisible(false);
				page_11();
				page11.setVisible(true);	 			
			}
		};
	
		bt1.addActionListener(act1);
		bt2.addActionListener(act2);
		
		
		
	}
	
	void page_10() {     // �����Է��� ���� �޼ҵ� (10�� �����̵�) 
		
		JPanel pn2 = new JPanel();     // �̸��� �й��� �Է��ϴ� â
		JPanel pn4 = new JPanel();     // 3���� ���� ���� ������ �Է��ϴ� â
		JPanel pn5 = new JPanel();

		JButton bt1 = new JButton("����");
		JButton bt2 = new JButton("�Ϸ�");
		JLabel lb1 =new JLabel("�����Է�");
		JLabel lb2 =new JLabel("�̸�");
		JLabel lb3 =new JLabel("�й�");
		JLabel lb4 =new JLabel("java");
		JLabel lb5 =new JLabel("html");
		JLabel lb6 =new JLabel("database");
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		
		jf.setTitle("�����Է�");
		jf.add(page10);
		jf.setLayout(null);	
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setSize(600, 600);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		page10.setLayout(null);
		page10.setSize(600,600); 
		
		lb1.setFont(new Font(null, Font.BOLD, 30));  // Ÿ��Ʋ : �����Է�
		lb1.setBounds(200, 10, 200, 60);
		page10.add(lb1);
		
		pn2.setLayout(new GridLayout(2,2));          // �̸��� �й��� �Է��ϴ� ����
		pn2.setBounds(80, 75, 400, 100);			
		pn2.add(lb2);
		pn2.add(t4);
		//pn2.add(new JTextField(list.get(loginNum).namestr.toString()));   ///////
		pn2.add(lb3);
		pn2.add(t5);
		//pn2.add(new JTextField(list.get(loginNum).stdidstr.toString()));   //////
		lb2.setFont(new Font(null, Font.BOLD, 20));
		lb3.setFont(new Font(null, Font.BOLD, 20));
		page10.add(pn2);
		
		t4.setText(list.get(loginNum).namestr.toString());
		t4.setEditable(false);
		t5.setText(list.get(loginNum).stdidstr.toString());
		t5.setEditable(false);
		
		
		            
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		
		t1.setText("");
		t2.setText("");
		t3.setText("");
		
		pn4.setLayout(new GridLayout(3,2));          // 3���� ���� ���� ������ �Է��ϴ� ����
		pn4.setBounds(80, 270, 400, 150);
		pn4.add(lb4);
		pn4.add(t1);
		pn4.add(lb5);
		pn4.add(t2);
		pn4.add(lb6);
		pn4.add(t3);
		lb4.setFont(new Font(null, Font.BOLD, 20));
		lb5.setFont(new Font(null, Font.BOLD, 20));
		lb6.setFont(new Font(null, Font.BOLD, 20));
		page10.add(pn4);
	
		bt1.setBounds(80, 470, 200, 50);     // ��ư : ����
		bt1.setBackground(Color.lightGray);
		page10.add(bt1);

		bt2.setBounds(300, 470,200, 50);     // ��ư : �Ϸ�
		bt2.setBackground(Color.lightGray);
		page10.add(bt2);

	
		
		pn5.setBounds(40,240,480,300);
		pn5.setBackground(Color.GRAY);
		page10.add(pn5);
		
		lb2.setHorizontalAlignment(0);   // ��� ����
		lb3.setHorizontalAlignment(0);
		lb4.setHorizontalAlignment(0);
		lb5.setHorizontalAlignment(0);
		lb6.setHorizontalAlignment(0);
		
		ActionListener act1 = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {  //����
				page10.setVisible(false);
				page_9();
				page9.setVisible(true);
				t1.setText("");
				t2.setText("");
				t3.setText("");
			}
		};
		
		ActionListener act2 = new ActionListener() {	
			
			
			public void actionPerformed(ActionEvent e) {
				/*
				try {
					
	                File file = new File("C:\\Temp\\"+fileName+".txt");//////////////////////////////////////////
	               FileWriter fw = new FileWriter(file,true);
	               
	               if(file.exists()) {
	                  String java = "java : "+t1.getText()+"�� \n";
	                  String html = "html : "+t2.getText()+"�� \n";
	                  String database = "database : "+t3.getText()+"�� \n";               
	                  fw.write(java);
	                  fw.write(html);
	                  fw.write(database);
	                  fw.close();
	               }
	            }catch(Exception exp){
	            }*/
			
				
				int a = Integer.parseInt(t1.getText());
				int b = Integer.parseInt(t2.getText());
				int c = Integer.parseInt(t3.getText());
				if(!(a<=100 && b<=100 && c<=100 && a>=0 && b>=0 && c>=0)) {
					JOptionPane.showMessageDialog(null,"0�̻�, 100 ������ ������ �Է��ϼ���.");
				}else if(t1.getText().equals("")) {    // �����Է¶��� ��ĭ�� �� 
					JOptionPane.showMessageDialog(null,"java������ �Է��ϼ���.");
				}else if(t2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"html������ �Է��ϼ���");
				}else if(t3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "database������ �Է��ϼ���.");
				}else if(!t1.getText().matches("^[0-9]+$")||!t2.getText().matches("^[0-9]+$")||!t3.getText().matches("^[0-9]+$")){
					JOptionPane.showMessageDialog(null,"���ڷ� �ԷµǾ�� �մϴ�.");
				}else{
					
					
			   
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
                    oos.writeObject(list);//���Ͽ� ArrayList ����
                    oos.close();
                } catch (Exception ex)
                {
        
                }
                list.get(loginNum).java = t1.getText();
				list.get(loginNum).html = t2.getText();
				list.get(loginNum).database = t3.getText();
				page10.setVisible(false);
				page_9();
				page9.setVisible(true);	
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
                }
			}
		};
		
		
		bt1.addActionListener(act1);
		bt2.addActionListener(act2);

	}
	
	//=====================================================================================page45678
	
	void page_11()
	{		
			
		
		
		jf.setTitle("������ȸ");
		JPanel page11_1 = new JPanel();
		JButton bt = new JButton("�α׾ƿ�");
		JButton bt2 = new JButton("����");
		JLabel[] lb  = new JLabel[4]; // 0 1 2 3
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		
		jf.setSize(600, 600); // ȭ��ũ��
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
		for (int i = 0; i < lb.length; i++) {
			 lb[i] = new JLabel();
		}
		
		jf.add(page11);
		page11.setLayout(null);
		page11.setSize(jf.getWidth(),jf.getHeight());
		
		page11_1.setBackground(Color.LIGHT_GRAY);
		page11_1.setBounds(20,200,545,300);
		page11_1.setLayout(null);
		page11.add(page11_1);
		
		page11_1.add(t2);   //���ڷ� �ؽ�Ʈ ����
		t2.setBounds(120,30,300,50);
		t2.setEditable(false);
		t2.setBorder(new LineBorder(Color.black));
		page11_1.add(t3);   //���ڷ� �ؽ�Ʈ ����
		t3.setBounds(120,90,300,50);
		t3.setEditable(false);
		t3.setBorder(new LineBorder(Color.black));
		page11_1.add(t4);   //���ڷ� �ؽ�Ʈ ����
		t4.setBounds(120,160,300,50);
		t4.setBorder(new LineBorder(Color.black));
		t4.setEditable(false);
		
		t2.setText("�ڹټ���: " + list.get(loginNum).java);
		t3.setText("html����: " + list.get(loginNum).html);
		t4.setText("database����: " + list.get(loginNum).database);
		
		t2.setHorizontalAlignment(0);
		t3.setHorizontalAlignment(0);
		t4.setHorizontalAlignment(0);
		
		page11_1.add(bt);
		bt.setSize(100,60);
		bt.setLocation(435,230);
		bt.setBackground(Color.LIGHT_GRAY);
		
		page11_1.add(bt2);
		bt2.setSize(100,60);
		bt2.setLocation(12,230);
		bt2.setBackground(Color.LIGHT_GRAY);
								
		int Ypoint = 60; //�� y�� ��ǥ��

		page11.add(lb[0]);
//		lb[0].setText(list.get(loginNum).namestr.toString());
//		lb[0].setOpaque(true);
//		lb[0].setBorder(new LineBorder(Color.black));
//		lb[0].setBackground(Color.white);
//		lb[0].setBounds(30,Ypoint,200,40);
//		lb[0].setFont(new Font(null, Font.BOLD, 30));
		
		page11.add(t1);
		t1.setText(list.get(loginNum).namestr.toString());
		t1.setBounds(30,Ypoint,200,40);
		t1.setFont(new Font(null, Font.BOLD, 30));
		t1.setEditable(false);
		
		
		
		page11.add(lb[1]);
//		lb[1].setText("����");
//		lb[1].setBounds(150,Ypoint,70,40);
//		lb[1].setFont(new Font(null, Font.BOLD, 30));
		
		page11.add(lb[2]);
		
//		lb[2].setOpaque(true);
//		lb[2].setBorder(new LineBorder(Color.black));
//		lb[2].setBackground(Color.white);
//		lb[2].setBounds(220,Ypoint,70,40);
//		lb[2].setFont(new Font(null, Font.BOLD, 30));
//		
		page11.add(lb[3]);
		lb[3].setText("���� ���� �����");
		lb[3].setBounds(270,Ypoint,270,40);
		lb[3].setFont(new Font(null, Font.BOLD, 30));
		
		
		
		
					
	
		
		bt.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {  //�α׾ƿ�
				if(e.getSource() == bt)
				{
					page11.setVisible(false);
					login();
					page4.setVisible(true);
				
				}
				
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == bt2)
				{
					page11.setVisible(false);
					page_9();
					page9.setVisible(true);
				
				}
			}
		});
	}
	
	
	void page_12()
	{
		
		jf.setTitle("������");
		JPanel page12_1 = new JPanel();  //�ؽ�Ʈ ��Ƴ��� �ڽ�
		JPanel page12_contour = new JPanel(); //���м� 
		
		JButton bt = new JButton("�Ϸ�");
		JButton bt2 = new JButton("����");
		JButton bt3 = new JButton("���� Ȯ��");
		
		JLabel lb  = new JLabel("������"); 
		JLabel lb2 = new JLabel("���� Ȯ��");
		
		JTextArea te = new JTextArea();
		JScrollPane sp = new JScrollPane(te);
	
		JComboBox bo = new JComboBox();
		
		jf.setSize(600, 600); // ȭ��ũ��
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		bo.addItem("��ü����");
		for (int i = 0; i < list.size(); i++) {
			bo.addItem(list.get(i).idstr);
		}
				
		jf.add(page12);
		page12.setLayout(null);
		page12.setSize(jf.getWidth(),jf.getHeight());
		
		page12.add(lb);
		lb.setBounds(225, 20, 130, 80);
		lb.setFont(new Font(null, Font.BOLD, 40));	
		
		page12.add(lb2);
		lb2.setBounds(415, 30, 130, 80);
		lb2.setFont(new Font(null, Font.BOLD, 25));
		
		page12.add(bt);  //�Ϸậư
		bt.setSize(100,50);
		bt.setLocation(465,505);
		bt.setBackground(Color.LIGHT_GRAY);
		
		//page12.add(bt2);  //������ư
		bt2.setSize(100,50);
		bt2.setLocation(20,505);
		bt2.setBackground(Color.LIGHT_GRAY);
		
		//page12.add(bt3);  //����Ȯ��
		bt3.setSize(150,50);
		bt3.setLocation(415,30);
		bt3.setBackground(Color.LIGHT_GRAY);
		
		page12.add(bo);  //�޺���
		bo.setBounds(20,32,150,50);
		bo.setBackground(Color.LIGHT_GRAY);
		bo.setFont(new Font(null, Font.BOLD, 20));
		
		page12_1.setBackground(Color.LIGHT_GRAY);
		page12_1.setBounds(20,120,545,380);
		page12_1.setLayout(new BorderLayout());
		page12.add(page12_1);
		page12_1.add(sp);  //�ؽ�Ʈ �Է� ĭ
		
		page12_contour.setBackground(Color.black); //���м�
		page12_contour.setBounds(20,100,545,2);
		page12_contour.setLayout(null);
		page12.add(page12_contour);
		
		
		
		bo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//JComboBox jcb =(JComboBox)e.getSource();
                int index= bo.getSelectedIndex();
               // System.out.println(bo.getItemCount());   
                //System.out.println(index);
                
                if(index == bo.getSelectedIndex())
                {
                	if(index == 0)
                	{
                	te.setText("");
            		for (int i = 0; i < list.size(); i++) {
            			te.append("�̸�: "+list.get(i).namestr+"\n");
            			te.append("�й�: "+list.get(i).stdidstr+"\n");
            			te.append("�̸���: "+ list.get(i).emailidstr+"\n");
            			te.append("�ڹ�����: "+list.get(i).java+"\n");
            			te.append("html����: "+list.get(i).html+"\n");
            			te.append("�����ͺ��̽�����: "+list.get(i).database+"\n");
            			te.append("��������������������������������������������������������������������������\n");
            		}
                	}
                	else if (!(index == 0))
                    {
                    	te.setText("");
                    	te.append("�̸�: "+list.get(index-1).namestr+"\n");
            			te.append("�й�: "+list.get(index-1).stdidstr+"\n");
            			te.append("�̸���: "+ list.get(index-1).emailidstr+"\n");
            			te.append("�ڹ�����: "+list.get(index-1).java+"\n");
            			te.append("html����: "+list.get(index-1).html+"\n");
            			te.append("�����ͺ��̽�����: "+list.get(index-1).database+"\n");
            			te.append("��������������������������������������������������������������������������\n");
                    }
                	
                	//System.out.println(index);
                	
                }
              

			}
		});
		
		
		
		
		
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //�Ϸ��ư
				
				if(e.getSource() == bt)
				{
					page12.setVisible(false);
					login();
					page4.setVisible(true);
					te.setText("");
					
					
				}
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		  new GuiExam11();
	}
}
