package xuzhenzhen.structure.menu;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class GraphFileFilter extends FileFilter{
	private String ext;

	public GraphFileFilter(String ext) {
		super();
		this.ext = ext;
	}

	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory())
			return true;
		String fileName=file.getName();
		int index=fileName.lastIndexOf('.');
		if(index>0&&index<fileName.length()-1){
			String extension=fileName.substring(index+1).toLowerCase();
			if(extension.equals(ext))
				return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		if(ext.equals("graph"))
			return "图结构(*.graph)";
		return "";
	}
}
