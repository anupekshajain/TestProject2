package com.mytests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Listing_directory {

	public static List<String> getFilesPath(String path, String extension) {
		File baseFolder = new File(path);
		List<String> fileNames = new ArrayList<String>();

		File listOfFiles[] = baseFolder.listFiles();
		try {
			for (int i = 0; i < listOfFiles.length; i++) {
				String fileName = listOfFiles[i].getName();
				if (listOfFiles[i].isFile()) {
					if (fileName.endsWith(extension)) {
						fileNames.add(path + "\\" + fileName);
					}
				}
				else
				{
					fileNames.addAll(	getFilesPath(path+File.separator+fileName, extension));
				}
			}
		} catch (Exception ex) {
			System.out.println(String.format("Invalid Folder Name - %s", path));
			return null;
		}
		return fileNames;

	}

	public static List<String> getSubFoldersPath(String path) {
		File baseFolder = new File(path);
		List<String> subFolders = new ArrayList<String>();

		File listOfFiles[] = baseFolder.listFiles();
		try {
			for (int i = 0; i < listOfFiles.length; i++) {
				String fileName = listOfFiles[i].getName();
				if (listOfFiles[i].isDirectory()) {
					subFolders.add(path + "\\" + fileName);
				}

			}
		} catch (Exception ex) {
			System.out.println(String.format("Invalid Folder Name - %s", path));
			return null;
		}
		return subFolders;
	}

	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData";
		String extension = ".json";

		List<String> files = getFilesPath(path, extension);
		List<String> folders = getSubFoldersPath(path);

		if (files == null) {
			System.out.println("Null");
		} else {
			for (String s : files) {
				System.out.println(s);
			}
		}
//		if (folders != null) {
//			for(int i=0;i<folders.size();i++) {
//				files.addAll(getFilesPath(folders[i], extension));
//			}
//		}

//		if (folders == null) {
//			System.out.println("Null");
//		} else {
//			for (String s : folders) {
//				System.out.println(s);
//			}
//		}

	}

}
