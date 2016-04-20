package es.uniovi.asw.counting;

import es.uniovi.asw.votingdb.infrastructure.ServicesFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.File;

public class VoteCount {

    public static void main(String[] args) throws Exception {
        Path inputPath = new Path(args[0]);
        new File(inputPath.toString()).mkdir();
        new VoteReader(ServicesFactory.createVoteService(),
                inputPath+"/votes").readVotes();

        Configuration conf = new Configuration();

        Job job = new Job(conf, "votecount");

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(VoteMapper.class);
        job.setReducerClass(VoteReducer.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, inputPath);
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);
    }

}
