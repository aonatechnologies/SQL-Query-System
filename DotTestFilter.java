package initialClasses;


import java.io.File;
import java.io.FilenameFilter;


public class DotTestFilter implements FilenameFilter{
	@Override
	public boolean accept(File dir, String name) {
		return dir.getName().endsWith(".test");
	}

}
