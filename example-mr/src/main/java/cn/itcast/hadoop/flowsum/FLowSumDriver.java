package cn.itcast.hadoop.flowsum;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.log4j.BasicConfigurator;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2018-11-04
 * Time: 9:48
 */
public class FLowSumDriver {
    public static void main(String[] args)throws Exception {
        Configuration conf = new Configuration();
        BasicConfigurator.configure();
        Job job = Job.getInstance(conf);

        job.setJarByClass(FLowSumDriver.class);

        job.setMapperClass(FlowSumMapper.class);
        job.setReducerClass(FlowSumReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

//        job.setNumReduceTasks(3);

        FileInputFormat.setInputPaths(job,"E:\\hadoop\\input");
        FileOutputFormat.setOutputPath(job,new Path("E:\\hadoop\\output"));

        boolean b = job.waitForCompletion(true);
        System.exit(b?0:1);
    }
}
