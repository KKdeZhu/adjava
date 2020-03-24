package Lab2;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountFile {
	    
	   //将Map按Value从大到小排序
		private static List<Entry<String,Integer>> sort(Map<String,Integer> record) {
			List<Entry<String,Integer>> list = new ArrayList<Entry<String,Integer>>(record.entrySet());
			Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
				//Collections的比较方法，大顶堆
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        });
			return list;
		}
		
		//按照FileReader读取文件，并将单词储存在Map里
		private static Map<String,Integer> readByFileReader(String filename) throws Exception {
			Map<String,Integer> map = new HashMap<>();
			Reader reader = null;
			String essay = "";
			try {
				StringBuffer buf = new StringBuffer();
				char[] chars = new char[1024];
				reader = new FileReader(filename);
				int readed = reader.read(chars);
				while (readed != -1) {
					buf.append(chars, 0, readed);
					readed = reader.read(chars);
				}
				essay = buf.toString();
			} 
			//抛出异常
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				close(reader);
			}
			//把单词分开
			StringTokenizer temp = new StringTokenizer(essay.toString()," .,!?:\\\"\\\"''\\n#");
			while(temp.hasMoreElements()) {
				String str = temp.nextToken().toLowerCase(); 
				//如果已有该单词,value+1
				if(map.containsKey(str)) {
					Integer ex = map.get(str)+1;
					map.put(str, ex);
				}
				//没有该单词，放入map
				else {
					map.put(str,1);
				}
			}	
			return map;
		}
		
		//关闭流
		private static void close(Closeable inout) {
			if (inout != null) {
				try {
					inout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		//按照InputStream读取文件，并将单词储存在Map里
		private static Map<String,Integer> readByInputStream(String filename) throws Exception {
			Map<String,Integer> map = new HashMap<>();
			File inputFile = new File(filename);
			InputStream iso = new FileInputStream(inputFile);
			StringBuffer temp = new StringBuffer();
			try {
			    int ex = 0;
			    do {
				    ex = iso.read();
				    if(ex!=-1) {
					    temp.append((char)ex);
				    }
			    }while(ex!=-1);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally {
			    iso.close();
			}
			//把单词分开
			StringTokenizer Ror = new StringTokenizer(temp.toString()," .,!?:\\\"\\\"''\\n#");
			while( Ror.hasMoreElements()) {
				String str =  Ror.nextToken().toLowerCase(); 
				//如果已有该单词,value+1
				if(map.containsKey(str)) {
					Integer now = map.get(str)+1;
					map.put(str, now);
				}
				//没有该单词，放入map
				else {
					map.put(str,1);
				}
			}	
			return map;
		}
		
		//按照BufferedReader读取文件，并将单词储存在Map里
		private static Map<String,Integer> readbyBufferReader(String filename) throws Exception {
			Map<String,Integer> map = new HashMap<>();
			File inputFile = new File(filename);
			BufferedReader buf = new BufferedReader(new FileReader(inputFile));
			String essay = null;
			try {
			    while((essay=buf.readLine())!= null) {
				    //把单词分开
				    StringTokenizer temp = new StringTokenizer(essay," .,!?:\\\"\\\"''\\n#");
				    while(temp.hasMoreElements()) {
					    String str = temp.nextToken().toLowerCase(); 
					    //如果已有该单词,value+1
					    if(map.containsKey(str)) {
						    Integer now = map.get(str)+1;
						    map.put(str,now);
					    }
					    //没有该单词，放入map
					    else {
						    map.put(str,1);
					    }
				    }
			    }
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				buf.close();
			}
			return map;
		}
		
		//输出文件
		private static void output(List<Entry<String,Integer>> list, String filename) throws IOException {	
			File outputFile = new File(filename);
			if(!outputFile.exists()) {
				outputFile.createNewFile();
			}
			OutputStream os = new FileOutputStream(outputFile);
			StringBuffer temp = new StringBuffer();
			for (Entry<String, Integer> e: list) {
				temp.append(e.getKey() + " " + e.getValue()+"\n");
			}
			byte data[] = temp.toString().getBytes();
			os.write(data);
			os.close();
		}
		public static void main(String args[]) throws Exception {
			Map<String, Integer> record = new HashMap<>();
			Map<String, Integer> record2 = new HashMap<>();
			Map<String, Integer> record3 = new HashMap<>();
			String pass = "/Users/zhumingxuan/Desktop/了不起的盖茨比英文.txt";
			String to = "/Users/zhumingxuan/Desktop/结果.txt";
			String to2 = "/Users/zhumingxuan/Desktop/结果2.txt";
			String to3 = "/Users/zhumingxuan/Desktop/结果3.txt";
			//用FileReader读入
			record =  readByFileReader(pass);
			List<Entry<String,Integer>> list = sort(record);
			output(list,to);
			//用InputStream读入
			record2 =  readByInputStream(pass);
			List<Entry<String,Integer>> list2 = sort(record2);
			output(list2,to2);
			//用BufferReader读入
			record3 =  readbyBufferReader(pass);
			List<Entry<String,Integer>> list3 = sort(record3);
			output(list3,to3);
		}
}