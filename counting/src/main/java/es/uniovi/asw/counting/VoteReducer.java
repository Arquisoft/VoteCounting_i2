package es.uniovi.asw.counting;

import es.uniovi.asw.resultsdb.business.ResultsService;
import es.uniovi.asw.resultsdb.infrastructure.ServicesFactory;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class VoteReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    private static final ResultsService db =
            ServicesFactory.createResultsService();

    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        context.write(key, new IntWritable(sum));
        db.createResultEntry(key.toString(), "", sum);
    }
}