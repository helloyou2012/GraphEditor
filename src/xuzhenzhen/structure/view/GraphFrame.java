package xuzhenzhen.structure.view;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import xuzhenzhen.structure.dealer.GraphFactory;
import xuzhenzhen.structure.dealer.SaveGraph;
import xuzhenzhen.structure.dialog.SetSptDialog;
import xuzhenzhen.structure.menu.EditMenu;
import xuzhenzhen.structure.menu.FileMenu;
import xuzhenzhen.structure.menu.PopMenuListener;
import xuzhenzhen.structure.menu.RunMenu;
import xuzhenzhen.structure.menu.SettingMenu;
import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.GraphList;

public class GraphFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5719632002280750546L;
	private GraphTabPanel panel;
	private Graph graph;
	private JMenuBar bar;
	private EditMenu editMenu;
	private FileMenu fileMenu;
	private SettingMenu settingMenu;
	private RunMenu runMenu;
	public GraphFrame(){
		init();
		setSize(800, 640);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	public void init(){
		setTitle("图论软件Version-1.0");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				dealQuit();
			}
		});
		bar=new JMenuBar();
		fileMenu=new FileMenu();
		fileMenu.addListener(this);
		editMenu=new EditMenu();
		settingMenu=new SettingMenu();
		settingMenu.addListener(this);
		runMenu=new RunMenu();
		runMenu.addListener(this);
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(settingMenu);
		bar.add(runMenu);
		setJMenuBar(bar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		if(event.equals("打开"))	dealOpen();
		if(event.equals("新建"))	dealReBuild();
		if(event.equals("保存"))	dealSave();
		if(event.equals("导出"))	dealExport();
		if(event.equals("退出"))	dealQuit();
		if(event.equals("设置最短路径算法"))dealSetSPT();
		if(event.equals("运行最短路径算法"))dealRunSpt();
	}
	public void dealOpen(){
		if(graph==null){
			loadGraph();
		}
		else{
			int result=JOptionPane.showConfirmDialog(null, "是否保存当前的设计？", "提示",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result==JOptionPane.YES_OPTION)
				dealSave();
			else
				loadGraph();
		}
	}
	public void dealReBuild(){
		if(graph!=null){
			int result=JOptionPane.showConfirmDialog(null, "是否保存当前的设计？", "提示",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result==JOptionPane.YES_OPTION){
				dealSave();
			}
		}
		graph=new GraphList();
		panel=new GraphTabPanel(graph);
		setContentPane(panel);
		editMenu.addListener(new PopMenuListener(graph));
		validate();
	}
	public void dealSave(){
		SaveGraph save=new SaveGraph(graph);
		Thread thread=new Thread(save);
		thread.start();
	}
	public void dealExport(){
		//有待解决
	}
	public void dealQuit(){
		int result=JOptionPane.showConfirmDialog(null, "是否退出软件？", "提示",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if(result==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	public void dealSetSPT(){
		if(graph!=null&&panel!=null){
			SetSptDialog dialog=new SetSptDialog(panel.getShortPathType());
			panel.setShortPathType(dialog.getPathType());
		}
	}
	public void dealRunSpt(){
		if(panel!=null)
			panel.runSPT();//运行SPT算法
	}
	public void loadGraph(){
		GraphFactory factory=new GraphFactory();
		graph=factory.getGraph();
		if(graph!=null){
			panel=new GraphTabPanel(graph);
			setContentPane(panel);
			editMenu.addListener(new PopMenuListener(graph));
			validate();
		}
	}
}
