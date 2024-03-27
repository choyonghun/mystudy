package bitcamp.myapp.service.impl;

import bitcamp.myapp.service.StorageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class NcpStorageService implements StorageService {

  private static Log log = LogFactory.getLog(NcpStorageService.class);

  final String endPoint = "https://kr.object.ncloudstorage.com";
  final String regionName = "kr-standard";

  final String secretKey;

  public NcpStorageService(
      @Value("${ncp.endpoint}") String endPoint,
      @Value("${ncp.regional}") String regionName,
      @Value("${ncp.accessory}") String accessKey,
      @Value("${ncp.secretKey}") String secretKey) {
    this.endpoint = endPoint;
    this.regionname = regionName;
    this.accessKey = accessKey;
    this.secretKey = secretKey;
  }

  @Override
  public String upload(MultipartFile multipartFile) throws Exception {
    return null;
  }
}
