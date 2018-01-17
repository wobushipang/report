package com.bqjr.report.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.DownloadFileRequest;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 姚云哲 on 2018/1/12.
 */
public class AliyunossUtils {

  private static String endpoint = "oss-cn-shenzhen-internal.aliyuncs.com";
  private static String accessKeyId = "LTAIVBVVq6ZXHDF2";
  private static String accessKeySecret = "gDgBWSWAK7eIU2u9LyuBeBk5d7Z09v";
  private static String bucketName = "erp-report001";

  private OSSClient client;

  public AliyunossUtils() {
    this.client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
  }

  /**
   * 上传文件
   */
  public boolean uploadByKeyPrefix(String keyPrefix, String fileName, File file) {
    String key = keyPrefix + fileName;
    client.putObject(new PutObjectRequest(bucketName, key, file));
    return client.doesObjectExist(bucketName, key);
  }

  /**
   * 获取指定keyPrefix开头的文件key列表
   */
  public List<String> listByKeyPrefix(String keyPrefix) {
    List<String> results = new ArrayList<String>();

    // 从bucketName存储空间获取指定keyPrefix开头的文件
    ObjectListing objectListing = client
        .listObjects(new ListObjectsRequest(bucketName).withPrefix(keyPrefix).withMaxKeys(1000));
    List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
    for (OSSObjectSummary s : sums) {
      results.add(s.getKey());
    }
    return results;
  }

  /**
   * 获取指定key的文件的输入流
   */
  public InputStream getInputStream(String key) {
    OSSObject object = client.getObject(new GetObjectRequest(bucketName, key));
    return object.getObjectContent();
  }

  /**
   * 获取指定key的文件的输入流
   */
  public boolean download(String key, String targetFile) throws Throwable {
    DownloadFileRequest downloadFileRequest = new DownloadFileRequest(bucketName, key);
    // 设置本地文件
    downloadFileRequest.setDownloadFile(targetFile);
    // 设置并发下载数，默认1
    downloadFileRequest.setTaskNum(5);
    // 设置分片大小，默认100KB
    downloadFileRequest.setPartSize(1024 * 1024 * 1);
    // 开启断点续传，默认关闭
    downloadFileRequest.setEnableCheckpoint(true);
    // 下载
    client.downloadFile(downloadFileRequest);

    return true;
  }

  public boolean removeByKeyPrefix(String keyPrefix) {
    List<String> keys = listByKeyPrefix(keyPrefix);
    if(null == keys || keys.isEmpty()){
      return true;
    }
    DeleteObjectsResult deleteObjectsResult = client.deleteObjects(
        new DeleteObjectsRequest(bucketName).withKeys(keys));
    List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
    return deletedObjects.containsAll(keys);
  }
}
