package ru.spbstu.j24.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Main {

	private final static int NUMBER_OF_EXPERIMENTS = 4;

	public static void main(String[] args) {

		Path sourceFile = Paths.get("source", "heavy.mkv");
		long time = 0;
		for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
			Path dstFile = Paths.get("sink", String.format("test%d.mkv", i));
			try {
				Files.createFile(dstFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			long start = System.currentTimeMillis();
//			copyFileIO(sourceFile.toFile(), dstFile.toFile());
			copyFileNIO(sourceFile, dstFile);
//			copyFileNIO2(sourceFile, dstFile);
			long end =System.currentTimeMillis();
			System.out.print(" "+(end-start));
			time+=end-start;
		}
		System.out.println("");
		System.out.println("Average: " + (1.0*time/NUMBER_OF_EXPERIMENTS));
	}

	public static void copyFileIO(File from, File to) {
		try(FileInputStream fis = new FileInputStream(from); FileOutputStream fos = new FileOutputStream(to)) {
//			FileInputStream fis = new FileInputStream(from);
//			FileOutputStream fos = new FileOutputStream(to);
			byte[] buffer = new byte[1024];
			int len = 0;
			while(true) {
				len = fis.read(buffer);
				if (len<=0) {
					break;
				}
				fos.write(buffer,0,len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFileNIO(Path from, Path to) {
		try (FileChannel srcFileChannel = FileChannel.open(from, StandardOpenOption.READ);
				FileChannel dstFileChannel = FileChannel.open(to, StandardOpenOption.WRITE)) {
			long count = srcFileChannel.size();
			while (count > 0) {
				long transferred = srcFileChannel.transferTo(srcFileChannel.position(), count, dstFileChannel);
				srcFileChannel.position(srcFileChannel.position() + transferred);
				count -= transferred;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copyFileNIO2(Path from, Path to) {
		try {
			Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
