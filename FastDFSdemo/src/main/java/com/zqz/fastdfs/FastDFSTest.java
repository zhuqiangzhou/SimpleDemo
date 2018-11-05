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
		//1.���������ļ��������ļ������ݾ���tracker����ĵ�ַ
		ClientGlobal.init("D:\\06-Ʒ�Ź�\\workspace\\FastDFSdemo\\FastDFSdemo\\src\\main\\resources\\fdfs_client.conf");
		
		//2.����һ��TrackerClient����
		TrackerClient trackerClient = new TrackerClient();
		
		//3.ʹ��TrackerClient���󴴽����ӣ����һ��TrackerServer����
		TrackerServer trackerServer = trackerClient.getConnection();
		
		//4.����һ��StorageServer 
		StorageServer storageServer = null;
		
		//5.����һ��StorageClient������Ҫ���������� TrackerServer ����StorageServer ������
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		
		//6.ʹ��storageClient�ϴ�ͼƬ
		String[] strings = storageClient.upload_file("D:/picture/timg.jpg", "jpg",null);

		// 7���������顣����������ͼƬ��·����
		for (String string : strings) {
			System.out.println(string);
		}

	}
}
