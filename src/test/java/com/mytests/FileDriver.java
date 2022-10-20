package com.mytests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class FileDriver.
 * 
 * @author Priyesh.Shrivastava
 */
public class FileDriver {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(FileDriver.class);

	/** The Constant ARCHIVE. */
	private static final String ARCHIVE = "Archive";

	/**
	 * Instantiates a new file driver.
	 */
	private FileDriver() {
		throw new IllegalStateException("Utility Class");
	}

	/**
	 * Checks if is folder exists.
	 *
	 * @param folderName the folder name
	 * @return the boolean
	 */
	public static Boolean isFolderExists(String folderName) {
		try {
			File folder = FileUtils.getFile(folderName);
			if (folder.exists()) {
				return folder.isDirectory();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Creates the folder.
	 *
	 * @param folderName the folder name
	 */
	public static void createFolder(String folderName) {
		try {
			File folder = FileUtils.getFile(folderName);
			if (folder.mkdir())
				log.info("Folder is created - {}", folderName);
		} catch (Exception e) {
			log.error("Exception occured while create folder - {} : {}", folderName, e.getMessage());
		}
	}

	/**
	 * Delete folder.
	 *
	 * @param folderName the folder name
	 */
	public static void deleteFolder(String folderName) {
		try {
			FileUtils.deleteDirectory(new File(folderName));
			log.info("Folder is deleted - {}", folderName);
		} catch (Exception e) {
			log.error("Exception occured while delete folder - {} : {}", folderName, e.getMessage());
		}
	}

	/**
	 * Creates the file.
	 *
	 * @param folderName the folder name
	 * @param prefix     the prefix
	 */
	public static void createFile(String folderName, String prefix) {
		String fileName = null;
		try {
			fileName = createFileName(prefix);
			folderName = StringUtils.isNotEmpty(folderName) ? (folderName + File.separator) : folderName;
			String filePath = folderName + fileName;
			File file = FileUtils.getFile(filePath);
			if (file.createNewFile())
				log.info("File is created at - {}", filePath);
		} catch (IOException e) {
			log.error("Exception occured while create file - {} : {}", fileName, e.getMessage());
		}
	}

	/**
	 * Gets the formatted date.
	 *
	 * @param date    the date
	 * @param pattern the pattern
	 * @return the formatted date
	 */
	public static String getFormattedDate(Date date, String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.format(date);
		} catch (Exception e) {
			log.error("Exception occured while generate formatted date - {} : {}", pattern, e.getMessage());
			throw (e);
		}
	}

	/**
	 * Move to archive.
	 *
	 * @param folderName the folder name
	 */
	public static void moveToArchive(String folderName) {
		try {
			if (!isFolderExists(folderName))
				createFolder(folderName);
			String archiveFolder = folderName + File.separator + ARCHIVE;
			if (!isFolderExists(archiveFolder))
				createFolder(archiveFolder);
			String destFolderName = archiveFolder + File.separator + getFormattedDate(new Date(), "dd-MMMM-yyyy");
			File folder = FileUtils.getFile(folderName);

			FilenameFilter filter = new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {
					if (name.equals(ARCHIVE))
						return false;
					return true;
				}
			};

			for (File sourceFile : folder.listFiles(filter)) {
				if (sourceFile != null) {
					if (!sourceFile.isDirectory())
						FileUtils.moveToDirectory(sourceFile, new File(destFolderName),
								!isFolderExists(destFolderName));
					else {
						String destSubFolder = destFolderName + File.separator + sourceFile.getName();
						for (File subFolder : sourceFile.listFiles()) {
							FileUtils.moveToDirectory(subFolder, new File(destSubFolder),
									!isFolderExists(destSubFolder));
						}
					}
				}
			}

		} catch (IOException e) {
			log.error("Exception occured while moving file to Archive : {}", e.getMessage());
		}
	}

	/**
	 * Creates the file name.
	 *
	 * @param prefix the prefix
	 * @return the string
	 */
	public static String createFileName(String prefix) {
		String fileName = null;
		try {
			String date = getFormattedDate(new Date(), "dd_MMMM_yyyy_HH_mm_ss");
			fileName = prefix + date + ".html";
			return fileName;
		} catch (Exception e) {
			log.error("Exception while creating file - {} : {}", fileName, e.getMessage());
			throw (e);
		}
	}

	/**
	 * Creates the zip.
	 *
	 * @param folderName the folder name
	 * @param zipName    the zip name
	 */
	public static void createZip(String folderName, String zipName) {
		ZipOutputStream zip = null;
		FileOutputStream fileOutput = null;
		try {
			fileOutput = new FileOutputStream(zipName);
			zip = new ZipOutputStream(fileOutput);
			addFolderToZip("", folderName, zip);
			zip.flush();
			zip.close();
			fileOutput.close();
		} catch (FileNotFoundException e) {
			log.error("File Not Found Exception - {} : {}", zipName, e.getMessage());
		} catch (IOException e) {
			log.error("IO Exception - {} : {}", zipName, e.getMessage());
		}
	}

	/**
	 * Adds the folder to zip.
	 *
	 * @param path       the path
	 * @param folderName the folder name
	 * @param zip        the zip
	 */
	private static void addFolderToZip(String path, String folderName, ZipOutputStream zip) {
		File folder = FileUtils.getFile(folderName);

		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
//				if (name.equals(ARCHIVE) || name.equals(ExtentManager.REPORTZIPNAME))
//					return false;
				return true;
			}
		};

		for (File sourceFile : folder.listFiles(filter)) {
			if (path.equals(""))
				addFileToZip(folder.getName(), folder.getName() + File.separator + sourceFile.getName(), zip);
			else
				addFileToZip(path + File.separator + folder.getName(),
						path + File.separator + folder.getName() + File.separator + sourceFile.getName(), zip);
		}
	}

	/**
	 * Adds the file to zip.
	 *
	 * @param path       the path
	 * @param folderName the folder name
	 * @param zip        the zip
	 */
	private static void addFileToZip(String path, String folderName, ZipOutputStream zip) {
		File folder = FileUtils.getFile(folderName);
		FileInputStream fileInput = null;
		if (folder.isDirectory()) {
			addFolderToZip(path, folderName, zip);
		} else {
			byte[] buf = new byte[1024];
			int len = 0;
			try {
				fileInput = new FileInputStream(folder);
				zip.putNextEntry(new ZipEntry(path + File.separator + folder.getName()));
				while ((len = fileInput.read(buf)) > 0) {
					zip.write(buf, 0, len);
				}
				fileInput.close();
			} catch (FileNotFoundException e) {
				log.error("File Not Found Exception - {} : {}", folderName, e.getMessage());
			} catch (IOException e) {
				log.error("IO Exception - {} : {}", folderName, e.getMessage());
			}
		}
	}

}
