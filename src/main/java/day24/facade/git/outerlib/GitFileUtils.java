package day24.facade.git.outerlib;

import java.util.List;

import com.google.common.collect.Lists;

public class GitFileUtils {
	public List<String> collectChangedFiles() {
		return Lists.newArrayList("file1.txt", "file2.txt", "file3.txt");
	}
}	
