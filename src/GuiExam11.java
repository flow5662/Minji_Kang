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
	
	JPanel page2 = new JPanel(); //메인화면 패널
	JPanel main = new JPanel(); //메인화면 패널
	JPanel joinscreen[] = new JPanel[12];
	
	JPanel page4 = new JPanel();
	JPanel page5 = new JPanel();
	JPanel page6 = new JPanel();
	JPanel page7 = new JPanel();
	JPanel page8 = new JPanel();
	JPanel page9 = new JPanel();
	JPanel page10 = new JPanel();
	JPanel page11 = new JPanel(); //패널11을 담는 하나의 페이지
	JPanel page12 = new JPanel(); //패널12을 담는 하나의 페이지
	File newfile;
	
	
	GuiExam11()
	{

		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Temp\\data.txt"));
			list = (ArrayList<Sunguk>)ois.readObject();//파일에서 ArrayList읽기
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
		
		JButton join = new JButton("회원가입"); //슬라이드 2의 회원가입 버튼 생성
		JButton login = new JButton("로그인"); //슬라이드 2의 로그인 버튼 생성
	
		jf.setTitle("성적관리 프로그램");
		jf.setSize(600, 600); // 화면크기
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
		jf.add(page2);
		page2.setLayout(null);
		page2.setSize(600,600);
		page2.add(main);
		
		//메인 화면의 버튼 위치 및 정렬
		main.setLayout(new BorderLayout()); 
		main.setSize(150,150);
		main.setLocation(220,200); //위치지정
		main.add(join,"North");
		main.add(login,"South");
		
		//버튼 별 사이즈 및 색상
		join.setPreferredSize(new Dimension(160,60));
		login.setPreferredSize(new Dimension(170,60));
		join.setBackground(Color.lightGray);
		login.setBackground(Color.lightGray);
		
		/////////////////////////////////////////////////////////////////
		//회원가입

		
		JPanel joinsc = new JPanel();
		JPanel joininput = new JPanel();
		JPanel joinintext = new JPanel();//ID~전화번호까지의 textfild
		JPanel joinintext2 = new JPanel(); //e-메일의 아이디 
		JPanel joinintext3 = new JPanel(); //e-메일의 메일주소
		JPanel joinintext4 = new JPanel(); //콤보박스
		JPanel joinintext5 = new JPanel(); //광고수신여부
		JPanel joinintext6 = new JPanel(); //중복확인 버튼
		JPanel joinintext7 = new JPanel(); //이전,완료 버튼
		
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

		
		
		JLabel jointext = new JLabel("회원가입");
		JLabel joinid = new JLabel("ID");
		JLabel joinpw = new JLabel("PW");
		JLabel joinpw2 = new JLabel("PW 재입력");
		JLabel joinname = new JLabel("이름");
		JLabel joinstudid = new JLabel("학번");
		JLabel joinpnum = new JLabel("전화번호");
		JLabel joinemail = new JLabel("e-mail");
		JLabel marketing = new JLabel("광고수신여부");
		
		JTextField inputid = new JTextField();
		JTextField inputpw = new JTextField(10);
		JTextField inputpw2 = new JTextField(10);
		JTextField inputname = new JTextField();
		JTextField inputstdid = new JTextField();
		JTextField inputpnum = new JTextField();
		JTextField inputmail = new JTextField();
		
		joinsc.setSize(500,30);
		joinsc.setLocation(30,10); //위치지정
		joinsc.add(jointext);
		
		//입력 패널 사이즈 및 색상 지정
		joininput.setSize(100,450);
		joininput.setLocation(30,60);
		
		//라벨 추가 및 위치 지정
		joininput.setLayout(new GridLayout(8,0,0,0));
		joininput.add(joinid);
		joininput.add(joinpw);
		joininput.add(joinpw2);
		joininput.add(joinname);
		joininput.add(joinstudid);
		joininput.add(joinpnum);
		joininput.add(joinemail);
		joininput.add(marketing);
		
		//입력 패널 사이즈 및 색상 지정2
		joinintext.setSize(300,320);
		joinintext.setLocation(140,65);
		
		joinintext.setLayout(new GridLayout(6,0,10,10));
		joinintext.add(inputid);
		joinintext.add(inputpw);
		joinintext.add(inputpw2);
		joinintext.add(inputname);
		joinintext.add(inputstdid);
		joinintext.add(inputpnum);
		
		//입력패널 사이즈 및 색상 지정3(이메일의 아이디)
		joinintext2.setSize(150,40);
		joinintext2.setLocation(140,400);
		
		joinintext2.setLayout(new GridLayout(1,0,0,0));
		joinintext2.add(inputmail);
		
		//입력패널 사이즈 및 색상 지정4(@)
		JLabel at = new JLabel("@");
		joinintext3.setSize(20,40);
		joinintext3.setLocation(290,400);
		
		joinintext3.setLayout(new GridLayout(1,0,0,0));
		joinintext3.add(at);

		
		//입력패널 사이즈 및 색상지정5
		JComboBox email = new JComboBox();
		
		email.setModel(new DefaultComboBoxModel(new String[] {"naver.com","hanmain.net","gmail.com"}));
		email.setSelectedIndex(0);
		
		joinintext4.setSize(200,40);
		joinintext4.setLocation(320,400);
		joinintext4.setLayout(new GridLayout(1,0,0,0));
		joinintext4.add(email); //콤보박스
		
		
		
		for (int i = 0; i <= 8; i++) {
		     page2.add(joinscreen[i]);
		}
		
		
		//입력패널 사이즈 및 색상 지정 6
		ButtonGroup tf = new ButtonGroup(); //중복선택되지않게 라디오버튼 그룹화 선언
		JRadioButton t = new JRadioButton("동의");
		JRadioButton f = new JRadioButton("미동의");
		tf.add(t);
		tf.add(f); //라디오버튼 그룹화
		
		joinintext5.setSize(180,40);
		joinintext5.setLocation(140,460);
		joinintext5.setLayout(new GridLayout(1,4,0,0));
		joinintext5.add(t);
		joinintext5.add(f);
		
		
		//중복확인 버튼
		JButton equal = new JButton("중복확인");
		joinintext6.setSize(100,40);
		joinintext6.setLocation(460,70);
		joinintext6.setLayout(new FlowLayout());
		joinintext6.add(equal);
		
		//이전, 완료 버튼
		JButton re = new JButton("이전");
		JButton next = new JButton("완료");
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
				if(e.getActionCommand().equals("회원가입")) {
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
				if(e.getActionCommand().equals("로그인")) {
					page2.setVisible(false);
					main.setVisible(false);
					page4.setVisible(true);
					login();	
				}
				
			}
		});
		
		
		re.addActionListener(new ActionListener() {  //이전버튼
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getActionCommand().equals("이전")) {
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
				if (e.getActionCommand().equals("중복확인")) {
					
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).idstr.equals(inputid.getText()))
						{
							JOptionPane.showMessageDialog(null,"사용불가능한 아이디입니다.");
							 stop = false;
						}
						
					}
					 if(inputid.getText().equals("")) {
						 JOptionPane.showMessageDialog(null,"ID를 입력하세요.");
					 }else if( stop){
						 JOptionPane.showMessageDialog(null,"사용가능한 아이디입니다."); //이거안하면 for문이라 찾은거 왜 계속 없음뜸  
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
				if (e.getActionCommand().equals("완료")) {
					
						if(inputid.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"ID를 입력하세요.");
						}else if(inputname.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
						}else if(inputpw.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"PW를 입력하세요");
						}else if(inputpw2.getText().equals("")!=inputpw.getText().equals("")){
							JOptionPane.showMessageDialog(null, "비밀번호 재확인이 필요합니다.");
						}else if(inputstdid.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "학번을 입력하세요.");
						}else if(inputpnum.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "휴대폰번호를 입력하세요.");
						}else if(inputmail.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "이메일을 입력하세요.");
						}else if(email.equals("")) {
							JOptionPane.showMessageDialog(null, "이메일을 선택하세요.");
						}else if(inputpw.getText().length() >= 7) {
							JOptionPane.showMessageDialog(null, "최대 8자 까지 입력이 가능합니다.");
						}else if(inputpw.getText().contains(inputpw2.getText()) == false || inputpw2.getText().contains(inputpw.getText()) == false){
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						}else if(tf.isSelected(null)){
							JOptionPane.showMessageDialog(null, "광고수신동의여부를 확인하세요.");
						}else if(equal.isEnabled()){
							JOptionPane.showMessageDialog(null, "중복확인이 필요합니다.");
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
									oos.writeObject(list);//파일에 ArrayList 저장
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
				if (e.getActionCommand().equals("완료")) {
					sj.idstr = inputid.getText();
					sj.pwstr = inputpw.getText();
					sj.pwstr2 = inputpw2.getText();
					sj. namestr = inputname.getText();
					sj. stdidstr = inputstdid.getText();
					sj. pnumstr = inputpnum.getText();
					sj. emailidstr = inputmail.getText() + "@"+email.getSelectedItem().toString();
					
						if(sj.idstr.equals("")) {
							JOptionPane.showMessageDialog(null,"ID를 입력하세요.");
						}else if(sj.pwstr.equals("")) {
							JOptionPane.showMessageDialog(null,"PW를 입력하세요");
						}else if(sj.pwstr2.equals("")){
							JOptionPane.showMessageDialog(null, "비밀번호 재확인이 필요합니다.");
						}else if(sj.namestr.equals("")) {
							JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
						}else if(sj.stdidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "학번을 입력하세요.");
						}else if(sj.pnumstr.equals("")) {
							JOptionPane.showMessageDialog(null, "휴대폰번호를 입력하세요.");
						}else if(sj.emailidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "이메일을 입력하세요.");
						}else if(email.equals("")) {
							JOptionPane.showMessageDialog(null, "이메일을 선택하세요.");
						}else if(sj.pwstr.length() >= 7) {
							JOptionPane.showMessageDialog(null, "최대 8자 까지 입력이 가능합니다.");
						}else if(sj.pwstr.contains(sj.pwstr2) == false ) {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						}else {	
							for (int i = 0; i <= 8; i++) {
							joinscreen[i].setVisible(false);
						}
							list.add(sj);
							  try
								{
									ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
									oos.writeObject(list);//파일에 ArrayList 저장
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
				if (e.getActionCommand().equals("완료")) {
					sj.idstr = inputid.getText();
					sj.pwstr = inputpw.getText();
					sj.pwstr2 = inputpw2.getText();
					sj. namestr = inputname.getText();
					sj. stdidstr = inputstdid.getText();
					sj. pnumstr = inputpnum.getText();
					sj. emailidstr = inputmail.getText() + "@"+email.getSelectedItem().toString();
					
						if(sj.idstr.equals("")) {
							JOptionPane.showMessageDialog(null,"ID를 입력하세요.");
						}else if(sj.pwstr.equals("")) {
							JOptionPane.showMessageDialog(null,"PW를 입력하세요");
						}else if(sj.pwstr2.equals("")){
							JOptionPane.showMessageDialog(null, "비밀번호 재확인이 필요합니다.");
						}else if(sj.namestr.equals("")) {
							JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
						}else if(sj.stdidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "학번을 입력하세요.");
						}else if(sj.pnumstr.equals("")) {
							JOptionPane.showMessageDialog(null, "휴대폰번호를 입력하세요.");
						}else if(sj.emailidstr.equals("")) {
							JOptionPane.showMessageDialog(null, "이메일을 입력하세요.");
						}else if(email.equals("")) {
							JOptionPane.showMessageDialog(null, "이메일을 선택하세요.");
						}else if(sj.pwstr.length() >= 7) {
							JOptionPane.showMessageDialog(null, "최대 8자 까지 입력이 가능합니다.");
						}else if(sj.pwstr.contains(sj.pwstr2) == false ) {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						}else {	
							for (int i = 0; i <= 8; i++) {
							joinscreen[i].setVisible(false);
						}
							list.add(sj);
							  try
								{
									ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
									oos.writeObject(list);//파일에 ArrayList 저장
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
		JButton jbLogin = new JButton("로그인");
		JButton jbSign = new JButton("회원가입");
		JButton jbid = new JButton("ID 찾기");
		JButton jbpw = new JButton("PW 찾기");
		
		String id = "";
		String pw = "";
		String adminid = "admin";
		String adminpassword = "1111";
		
		jf.setTitle("로그인");
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
		
	

		jid.setBounds(125, 167, 57, 25); //ID 위치 선정 : x, y, width, height
		page4.add(jid);
		txid.setText(id);
		txid.setBounds(150, 170, 167, 21); //ID textField 위치 선정
		page4.add(txid);
		txid.setColumns(15); //text 입력 칸 길이 설정
		
		txid.setFocusTraversalKeysEnabled(false);
		txid.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB){
					txpw.requestFocus();}
			}
		});

		jpw.setBounds(120, 193, 57, 25); //PW 위치 선정
		page4.add(jpw);
		txpw.setText(pw);
		txpw.setBounds(150, 195, 167, 21); //PW textField 위치 선정
		page4.add(txpw);
		txpw.setColumns(15); //text 입력 칸 길이 설정

		page4.add(jbLogin);
		jbLogin.setBounds(350, 170, 102, 46); //로그인 버튼 위치
		jbLogin.setBackground(Color.lightGray); //로그인 버튼 색상
		jbLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {  //로그인하면 9번페이지로

			
				
				for (int j = 0; j < list.size(); j++) {
					if(e.getSource() == jbLogin && list.get(j).idstr.equals(txid.getText()) && list.get(j).pwstr.equals(txpw.getText()))
					{		
						loginNum = j;  //10번페이지 에서 로그인했을때 각자의 이름이뜨게끔
					}
				}
				if(txid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
				}else if(txpw.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
				}else if(e.getSource() == jbLogin && adminid.equals(txid.getText()) && adminpassword.equals(txpw.getText()) )
				{
					page4.setVisible(false);
					page_12();	
					page12.setVisible(true);
					txid.setText("");
					txpw.setText("");
					
			    }else if(!txid.getText().equals(list.get(loginNum).idstr)) {
					JOptionPane.showMessageDialog(null, "일치하는 아이디가 없습니다.");
				}else if (!txpw.getText().equals(list.get(loginNum).pwstr)) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다.");
			    }else{
			    	page4.setVisible(false);
					page_9();  //자동적으로 전환되게끔 생성	
					page9.setVisible(true);
					txid.setText("");
					txpw.setText("");
				}
				
				
				
				
			}
				
			
		});

		page4.add(jbSign);
		jbSign.setBounds(350, 250, 102, 30); //회원가입 버튼 위치
		jbSign.setBackground(Color.lightGray); //회원가입 버튼 색상
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
		jbid.setBounds(120, 250, 102, 30); //ID 찾기 버튼 위치
		jbid.setBackground(Color.lightGray); //ID 찾기 버튼 색상
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
		jbpw.setBounds(235, 250, 102, 30); //PW 찾기 버튼 위치
		jbpw.setBackground(Color.lightGray); //PW 찾기 버튼 색상
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
		JLabel jName = new JLabel("이름");
		JLabel jNum = new JLabel("학번");
		JTextField txName = new JTextField();
		JTextField txNum = new JTextField();
		JButton jbIdCom = new JButton("완료");
		JButton jbIdBack = new JButton("이전");
		
	
		
		jf.setTitle("ID 찾기");
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
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
				}else if(txNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요.");
				}else if(!(txName.getText().equals(list.get(foundnum).namestr))) {
					JOptionPane.showMessageDialog(null, "이름이 일치하지 않습니다.");
				}else if(!(txNum.getText().equals(list.get(foundnum).stdidstr))) {
					JOptionPane.showMessageDialog(null, "학번이 일치하지 않습니다.");
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
		JButton jbFIdBack = new JButton("로그인 화면으로 이동");
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
		
		jf.setTitle("찾은 ID");
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
		JLabel jlName = new JLabel("이름");
		JLabel jlNum = new JLabel("학번");
		JTextField txtId = new JTextField();
		JTextField txtName = new JTextField();
		JTextField txtNum = new JTextField();
		JButton jbPwCom = new JButton("완료");
		JButton jbPwBack = new JButton("이전");
		
		String pwId = "";
		String pwName = "";
		String pwNum = "";
		
		jf.setTitle("PW 찾기");
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
					if (e.getSource() == jbPwCom && list.get(i).idstr.equals(txtId.getText()) && list.get(i).namestr.equals(txtName.getText()) && list.get(i).stdidstr.equals(txtNum.getText())) {  //완료버튼				
						foundnum = i;					
					}
				}
				
				if(txtId.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ID를 입력하세요.");
				}else if(txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
		      	}else if(txtNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "학번을 입력하세요.");
			    }else if(!(txtId.getText().equals(list.get(foundnum).idstr))) {
					JOptionPane.showMessageDialog(null, "ID가 일치하지 않습니다.");
				}else if(!(txtName.getText().equals(list.get(foundnum).namestr))) {
					JOptionPane.showMessageDialog(null, "이름이 일치하지 않습니다.");
				}else if(!(txtNum.getText().equals(list.get(foundnum).stdidstr))) {
					JOptionPane.showMessageDialog(null, "학번이 일치하지 않습니다.");
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
			public void actionPerformed(ActionEvent e) { //이전버튼
				
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
		JButton jbFPWBack = new JButton("로그인 화면으로 이동");
		JTextField t3 = new JTextField("");
		JTextField t4 = new JTextField("");
		t3.setText(""); //pw textField
		t4.setText(""); //id textField
		t3.setText(list.get(foundnum).pwstr.toString());
		t4.setText(list.get(foundnum).idstr.toString());
		
		
		jf.setTitle("찾은 PW");
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
	
	void page_9() {      // 성적입력, 성적출력의 2가지 버튼을 위한 메소드 (9번 슬라이드) 
		
		JButton bt1 = new JButton("성적입력"); 
		JButton bt2 = new JButton("성적출력");
		
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
	
	void page_10() {     // 성적입력을 위한 메소드 (10번 슬라이드) 
		
		JPanel pn2 = new JPanel();     // 이름과 학번을 입력하는 창
		JPanel pn4 = new JPanel();     // 3가지 과목에 대한 점수를 입력하는 창
		JPanel pn5 = new JPanel();

		JButton bt1 = new JButton("이전");
		JButton bt2 = new JButton("완료");
		JLabel lb1 =new JLabel("성적입력");
		JLabel lb2 =new JLabel("이름");
		JLabel lb3 =new JLabel("학번");
		JLabel lb4 =new JLabel("java");
		JLabel lb5 =new JLabel("html");
		JLabel lb6 =new JLabel("database");
		JTextField t4 = new JTextField();
		JTextField t5 = new JTextField();
		
		jf.setTitle("성적입력");
		jf.add(page10);
		jf.setLayout(null);	
		jf.setBackground(Color.LIGHT_GRAY);
		jf.setSize(600, 600);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		page10.setLayout(null);
		page10.setSize(600,600); 
		
		lb1.setFont(new Font(null, Font.BOLD, 30));  // 타이틀 : 성적입력
		lb1.setBounds(200, 10, 200, 60);
		page10.add(lb1);
		
		pn2.setLayout(new GridLayout(2,2));          // 이름과 학번을 입력하는 공간
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
		
		pn4.setLayout(new GridLayout(3,2));          // 3가지 과목에 대한 점수를 입력하는 공간
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
	
		bt1.setBounds(80, 470, 200, 50);     // 버튼 : 이전
		bt1.setBackground(Color.lightGray);
		page10.add(bt1);

		bt2.setBounds(300, 470,200, 50);     // 버튼 : 완료
		bt2.setBackground(Color.lightGray);
		page10.add(bt2);

	
		
		pn5.setBounds(40,240,480,300);
		pn5.setBackground(Color.GRAY);
		page10.add(pn5);
		
		lb2.setHorizontalAlignment(0);   // 가운데 정렬
		lb3.setHorizontalAlignment(0);
		lb4.setHorizontalAlignment(0);
		lb5.setHorizontalAlignment(0);
		lb6.setHorizontalAlignment(0);
		
		ActionListener act1 = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {  //이전
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
	                  String java = "java : "+t1.getText()+"점 \n";
	                  String html = "html : "+t2.getText()+"점 \n";
	                  String database = "database : "+t3.getText()+"점 \n";               
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
					JOptionPane.showMessageDialog(null,"0이상, 100 이하의 성적을 입력하세요.");
				}else if(t1.getText().equals("")) {    // 성적입력란이 빈칸일 때 
					JOptionPane.showMessageDialog(null,"java성적을 입력하세요.");
				}else if(t2.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"html성적을 입력하세요");
				}else if(t3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "database성적을 입력하세요.");
				}else if(!t1.getText().matches("^[0-9]+$")||!t2.getText().matches("^[0-9]+$")||!t3.getText().matches("^[0-9]+$")){
					JOptionPane.showMessageDialog(null,"숫자로 입력되어야 합니다.");
				}else{
					
					
			   
                try
                {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Temp\\data.txt"));
                    oos.writeObject(list);//파일에 ArrayList 저장
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
			
		
		
		jf.setTitle("성적조회");
		JPanel page11_1 = new JPanel();
		JButton bt = new JButton("로그아웃");
		JButton bt2 = new JButton("이전");
		JLabel[] lb  = new JLabel[4]; // 0 1 2 3
		JTextField t1 = new JTextField();
		JTextField t2 = new JTextField();
		JTextField t3 = new JTextField();
		JTextField t4 = new JTextField();
		
		jf.setSize(600, 600); // 화면크기
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
		
		page11_1.add(t2);   //스코롤 텍스트 생성
		t2.setBounds(120,30,300,50);
		t2.setEditable(false);
		t2.setBorder(new LineBorder(Color.black));
		page11_1.add(t3);   //스코롤 텍스트 생성
		t3.setBounds(120,90,300,50);
		t3.setEditable(false);
		t3.setBorder(new LineBorder(Color.black));
		page11_1.add(t4);   //스코롤 텍스트 생성
		t4.setBounds(120,160,300,50);
		t4.setBorder(new LineBorder(Color.black));
		t4.setEditable(false);
		
		t2.setText("자바성적: " + list.get(loginNum).java);
		t3.setText("html성적: " + list.get(loginNum).html);
		t4.setText("database성적: " + list.get(loginNum).database);
		
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
								
		int Ypoint = 60; //라벨 y축 좌표수

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
//		lb[1].setText("님의");
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
		lb[3].setText("님의 시험 결과는");
		lb[3].setBounds(270,Ypoint,270,40);
		lb[3].setFont(new Font(null, Font.BOLD, 30));
		
		
		
		
					
	
		
		bt.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {  //로그아웃
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
		
		jf.setTitle("관리자");
		JPanel page12_1 = new JPanel();  //텍스트 담아놓은 박스
		JPanel page12_contour = new JPanel(); //구분선 
		
		JButton bt = new JButton("완료");
		JButton bt2 = new JButton("이전");
		JButton bt3 = new JButton("성적 확인");
		
		JLabel lb  = new JLabel("관리자"); 
		JLabel lb2 = new JLabel("성적 확인");
		
		JTextArea te = new JTextArea();
		JScrollPane sp = new JScrollPane(te);
	
		JComboBox bo = new JComboBox();
		
		jf.setSize(600, 600); // 화면크기
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		bo.addItem("전체성적");
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
		
		page12.add(bt);  //완료벼튼
		bt.setSize(100,50);
		bt.setLocation(465,505);
		bt.setBackground(Color.LIGHT_GRAY);
		
		//page12.add(bt2);  //이전벼튼
		bt2.setSize(100,50);
		bt2.setLocation(20,505);
		bt2.setBackground(Color.LIGHT_GRAY);
		
		//page12.add(bt3);  //성적확인
		bt3.setSize(150,50);
		bt3.setLocation(415,30);
		bt3.setBackground(Color.LIGHT_GRAY);
		
		page12.add(bo);  //콤보박
		bo.setBounds(20,32,150,50);
		bo.setBackground(Color.LIGHT_GRAY);
		bo.setFont(new Font(null, Font.BOLD, 20));
		
		page12_1.setBackground(Color.LIGHT_GRAY);
		page12_1.setBounds(20,120,545,380);
		page12_1.setLayout(new BorderLayout());
		page12.add(page12_1);
		page12_1.add(sp);  //텍스트 입력 칸
		
		page12_contour.setBackground(Color.black); //구분선
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
            			te.append("이름: "+list.get(i).namestr+"\n");
            			te.append("학번: "+list.get(i).stdidstr+"\n");
            			te.append("이메일: "+ list.get(i).emailidstr+"\n");
            			te.append("자바점수: "+list.get(i).java+"\n");
            			te.append("html점수: "+list.get(i).html+"\n");
            			te.append("데이터베이스점수: "+list.get(i).database+"\n");
            			te.append("─────────────────────────────────────\n");
            		}
                	}
                	else if (!(index == 0))
                    {
                    	te.setText("");
                    	te.append("이름: "+list.get(index-1).namestr+"\n");
            			te.append("학번: "+list.get(index-1).stdidstr+"\n");
            			te.append("이메일: "+ list.get(index-1).emailidstr+"\n");
            			te.append("자바점수: "+list.get(index-1).java+"\n");
            			te.append("html점수: "+list.get(index-1).html+"\n");
            			te.append("데이터베이스점수: "+list.get(index-1).database+"\n");
            			te.append("─────────────────────────────────────\n");
                    }
                	
                	//System.out.println(index);
                	
                }
              

			}
		});
		
		
		
		
		
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //완료버튼
				
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
