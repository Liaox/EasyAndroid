package com.egojit.easyandroid.comm;

import org.json.JSONObject;

/**
 * 文件帮助类
 * 
 * @author Egojit
 * 
 */
public class FileHelper {
	// 文件分割上传
	public void cutFileUpload(String fileType, String fileName, String filePath) {
		try {
			FileAccessI fileAccessI = new FileAccessI(filePath, 0);
			Long nStartPos = 0l;
			Long length = fileAccessI.getFileLength();
			int mBufferSize = 1024 * 100; // 每次处理1024 * 100字节
			byte[] buffer = new byte[mBufferSize];
			FileAccessI.Detail detail;
			long nRead = 0l;
			// String vedioFileName = fileName; //分配一个文件名
			long nStart = nStartPos;
			int i = 0;
			while (nStart < length) {
				detail = fileAccessI.getContent(nStart);
				nRead = detail.length;
				buffer = detail.b;
				JSONObject mInDataJson = new JSONObject();
				mInDataJson.put("a", "282");
				mInDataJson.put("FileName", fileName);
				mInDataJson.put("start", nStart); // 服务端获取开始文章进行写文件
				mInDataJson.put("filetype", fileType);
				nStart += nRead;
				nStartPos = nStart;
				// String url =
				// UsualA.f_getXmlSOAUrl(UsualA.mServiceFastByteUrl,
				// "n.uploadvedio", mInDataJson.toString(),
				// "282");

			}
		} catch (Exception e) {
		}
	}
}
