package xuzhenzhen.structure.dealer;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import xuzhenzhen.structure.model.Graph;
import xuzhenzhen.structure.model.GraphList;

public class GraphFactory {
	public Graph getGraph(){
		Graph graph=null;
		OpenFile open=new OpenFile("打开");
		File file=open.openFile();
		if(file!=null){
			try {
				FileInputStream stream=new FileInputStream(file);
				ObjectInputStream objIn=new ObjectInputStream(stream);
				graph=(GraphList)objIn.readObject();
				objIn.close();
				stream.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "文件格式错误错误！","警告", JOptionPane.ERROR_MESSAGE);
			}
		}
		return graph;
	}
}
