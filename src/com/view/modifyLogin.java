package com.view;
import java.awt.*;

import javax.swing.*;

import com.model.employeeModel;
import com.model.loginModel;

import java.awt.event.*;
public class modifyLogin extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JPanel jp1,jp2,jp3;
	loginModel log=null;
	public modifyLogin(Frame ower,String title,boolean model,loginModel login,int row){
		super(ower,title,model);
		
		log=new loginModel();
		
		jl1=new JLabel("员工号",jl1.CENTER);
		jl2=new JLabel("姓名",jl2.CENTER);
		jl3=new JLabel("职位",jl3.CENTER);
		jl4=new JLabel("密码",jl4.CENTER);
		
		jtf1=new JTextField(20);
		jtf1.setEditable(false);
		jtf1.setText((String) login.getValueAt(row, 0));
		jtf2=new JTextField(20);
		jtf2.setEditable(false);
		jtf2.setText((String) login.getValueAt(row, 1));
		jtf3=new JTextField(20);
		jtf3.setEditable(false);
		jtf3.setText((String) login.getValueAt(row, 2));
		jtf4=new JTextField(20);
		jtf4.setText((String) login.getValueAt(row,3));
		
		jp1=new JPanel(new GridLayout(4, 1));
		jp2=new JPanel(new GridLayout(4, 1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		
		jp3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb1=new JButton("修改");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.EAST);
		this.add(jp3,BorderLayout.SOUTH);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150,h/2-150);
		this.setSize(400,300);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			String id=jtf1.getText().trim();
			String password=jtf4.getText().trim();
//			id,password name,post
			String arg[]={password,id};
			String sql="update login set passwd=? where empid =?";
			log=new loginModel();
			
//			if(!log.call_procedure(arg))
			if(log.executeUpdate(sql, arg))
			{
				JOptionPane.showMessageDialog(this, "修改成功");
			}else{
				JOptionPane.showMessageDialog(this, "修改失败");
			}
		}else if(e.getSource()==jb2){
			this.dispose();
		}
	}

}
