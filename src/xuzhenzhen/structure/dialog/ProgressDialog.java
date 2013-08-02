package xuzhenzhen.structure.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressDialog extends JDialog implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6616750812277679436L;
	private JProgressBar progress;
	public ProgressDialog(int min,int max) {
		super(new JDialog(),true);
		setUndecorated(true);//启用此 dialog 的装饰
		setLayout(new BorderLayout());
		progress=new JProgressBar(min, max);
		progress.setOrientation(JProgressBar.HORIZONTAL);
        progress.setValue(0);
        progress.setStringPainted(true);
        progress.setPreferredSize(new Dimension(200,15));
        JLabel label=new JLabel("正在处理,请稍后……", JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.lightGray);
        add(label,BorderLayout.CENTER);
		add(progress,BorderLayout.SOUTH);
		JPanel panel=new JPanel();
		panel.setBackground(Color.lightGray);
		add(panel,BorderLayout.NORTH);
		setSize(200, 80);
        setResizable(false);
        setLocationRelativeTo(null);//居中显示
        Thread thread=new Thread(this);
        thread.start();
	}
	public void setProgressValue(int value){
		progress.setValue(value);
	}
	@Override
	public void run() {//在线程里面解决显示问题，不影响后面代码的运行
		// TODO Auto-generated method stub
		setVisible(true);
	}
}
