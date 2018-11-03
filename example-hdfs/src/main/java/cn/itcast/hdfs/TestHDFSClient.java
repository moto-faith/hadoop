package cn.itcast.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;

public class TestHDFSClient {

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        conf.set("fs.defaultFS", "hdfs://node-1:9000");

        System.setProperty("HADOOP_USER_NAME", "root");

        FileSystem fs = FileSystem.get(conf);

//        创建目录
//        fs.create(new Path("/hdfsByjava"));

//        下载文件
//        fs.copyToLocalFile(false,new Path("/abc.txt"),new Path("e://"),true);

        //使用Stream的形式 操作HDFS 更底层的方式
        FSDataOutputStream outputStream = fs.create(new Path("/1.txt"), true);

        FileInputStream inputStream = new FileInputStream("e:\\aaa.txt");

        IOUtils.copy(inputStream, outputStream);

        fs.close();

    }
}
