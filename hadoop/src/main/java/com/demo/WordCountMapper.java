package com.demo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : avloger
 * @date : 2021/11/20 21:52
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //拿到一行数据转换为string
        String line = value.toString();
        //将这一行切分出各个单词
        String[] words = line.split(" ");
        //遍历数组，输出<单词，1>
        for(String word:words){
            context.write(new Text(word), new IntWritable(1));
        }

    }
}
