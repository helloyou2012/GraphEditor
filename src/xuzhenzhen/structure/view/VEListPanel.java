package xuzhenzhen.structure.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import xuzhenzhen.structure.control.EListController;
import xuzhenzhen.structure.control.VListController;
import xuzhenzhen.structure.model.Graph;

public class VEListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5808148676646796902L;
	private Graph graph;
	private JPanel defaultPanel;
	private VListPanel vPanel;
	private EListPanel ePanel;
	public VEListPanel(Graph graph) {
		this.graph = graph;
		init();
	}
	public void init(){
		defaultPanel=new JPanel(new BorderLayout());
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BorderLayout());
		vPanel=new VListPanel(graph);
		ePanel=new EListPanel(graph);
		VListController vc=new VListController(vPanel, graph);
		EListController ec=new EListController(ePanel, graph);
		vPanel.addItemListener(vc);
		vPanel.addFocusListeners(vc);
		ePanel.addItemListener(ec);
		ePanel.addFocusListeners(ec);
		graph.addListener(vc);
		graph.addListener(ec);
		defaultPanel.add(ePanel,BorderLayout.NORTH);
		JPanel voidPanel=new JPanel();
		voidPanel.setBackground(Color.lightGray);
		defaultPanel.add(voidPanel,BorderLayout.CENTER);
		add(vPanel,BorderLayout.NORTH);
		add(defaultPanel,BorderLayout.CENTER);
	}
}
