package org.samples.hive.training;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class udf extends UDF {
private Text result = new Text();

public Text evaluate(Text Name)
{
	if (Name == null) {
		return null;
	}
	
	String res = Name.toString().toUpperCase();
	
	result = new Text(res);
	
	return result;
}
}
