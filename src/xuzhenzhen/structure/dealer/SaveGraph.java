package xuzhenzhen.structure.dealer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import xuzhenzhen.structure.dialog.ProgressDialog;
import xuzhenzhen.structure.model.Graph;

public class SaveGraph implements Runnable{
	private Graph graph;
	public SaveGraph(Graph graph) {
		this.graph = graph;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		OpenFile openfile=new OpenFile("保存");
		File file=openfile.openFile();
		if(file!=null&&graph!=null){
			File newFile=new File(file.toString()+".graph");
			ProgressDialog dialog=new ProgressDialog(0, 100);
			dialog.setProgressValue(50);
			try {
				FileOutputStream stream=new FileOutputStream(newFile);
				ObjectOutputStream objOut=new ObjectOutputStream(stream);
				objOut.writeObject(graph);
				objOut.flush();
				objOut.close();
				stream.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.dispose();
		}
	}

}
