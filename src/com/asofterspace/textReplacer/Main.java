/**
 * Unlicensed code created by A Softer Space, 2019
 * www.asofterspace.com/licenses/unlicense.txt
 */
package com.asofterspace.textReplacer;

import com.asofterspace.toolbox.io.Directory;
import com.asofterspace.toolbox.io.BinaryFile;
import com.asofterspace.toolbox.io.File;
import com.asofterspace.toolbox.Utils;

import java.util.List;


public class Main {

	public final static String PROGRAM_TITLE = "TextReplacer";
	public final static String VERSION_NUMBER = "0.0.0.1(" + Utils.TOOLBOX_VERSION_NUMBER + ")";
	public final static String VERSION_DATE = "25. February 2019";

	public static void main(String[] args) {

		// let the Utils know in what program it is being used
		Utils.setProgramTitle(PROGRAM_TITLE);
		Utils.setVersionNumber(VERSION_NUMBER);
		Utils.setVersionDate(VERSION_DATE);

		if (args.length < 3) {
			System.out.println("You only called the text replacer with " +
				args.length + "arguments.\n" +
				"You should call it with 3 arguments, namely:\n" +
				"directory\n" +
				"searchFor\n" +
				"replaceWith");
			return;
		}

		// gather inputs
		Directory dir = new Directory(args[0]);
		String searchFor = args[1];
		String replaceWith = args[2];

		replace(dir, searchFor, replaceWith);
	}

	public static void replace(Directory dir, String searchFor, String replaceWith) {

		// recursively get all the files
		List<File> files = dir.getAllFiles(true);

		for (File file : files) {

			BinaryFile bin = new BinaryFile(file);

			String content = bin.loadContentStr();

			if (content.contains(searchFor)) {

				content = content.replace(searchFor, replaceWith);

				bin.saveContentStr(content);
			}
		}
	}
}
