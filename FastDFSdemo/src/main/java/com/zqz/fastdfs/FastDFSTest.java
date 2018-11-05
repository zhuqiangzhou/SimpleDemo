package com.zqz.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSTest {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		//1.加载配置文件，配置文件的内容就是tracker服务的地址
		ClientGlobal.init("D:\\06-品优购\\workspace\\FastDFSdemo\\FastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
		
		//2.创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		
		//3.使用TrackerClient对象创建连接，获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		
		//4.创建一个StorageServer 
		StorageServer storageServer = null;
		
		//5.创建一个StorageClient对象，需要两个参数， TrackerServer 对象、StorageServer 的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		
		//6.使用storageClient上传图片
		String[] strings = storageClient.upload_file("D:/picture/timg.jpg", "jpg",null);

		// 7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}

	}
}
