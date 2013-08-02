package xuzhenzhen.structure.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

public class RowHeaderRenderer implements TableCellRenderer{
	private JLabel label=new JLabel();
	private static Font font=(Font)UIManager.get("TableHeader.font");
	private static Color fgc=(Color)UIManager.get("TableHeader.foreground");
	private static Color bgc=(Color)UIManager.get("TableHeader.background");
	@Override
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int col){
		label.setFont(font);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(value.toString());
		label.setOpaque(true);
		label.setForeground(fgc);
		label.setBackground(bgc);
		return label;
	}
}
